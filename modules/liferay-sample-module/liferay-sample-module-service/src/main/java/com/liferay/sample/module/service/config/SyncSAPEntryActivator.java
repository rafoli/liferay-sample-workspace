package com.liferay.sample.module.service.config;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.security.service.access.policy.model.SAPEntry;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true)
public class SyncSAPEntryActivator {

    // Define the policies
    public static final Object[][] SAP_ENTRY_OBJECT_ARRAYS = new Object[][] {
        {
            "SYNC_DEFAULT",
            "com.liferay.sample.module.web.rest.SampleApplication#getSamples",
            true
        },
        {
        	"SYNC_TOKEN", 
        	"liferay.openapi.rest.builder.internal.resource.v1_0.SampleResourceImpl#getAllSamples", 
        	true
    	}
    };

    // Create the policies
    protected void addSAPEntry(long companyId) throws PortalException {
        for (Object[] sapEntryObjectArray : SAP_ENTRY_OBJECT_ARRAYS) {

            String name = String.valueOf(sapEntryObjectArray[0]);
            String allowedServiceSignatures = String.valueOf(sapEntryObjectArray[1]);
            boolean defaultSAPEntry = GetterUtil.getBoolean(sapEntryObjectArray[2]);

            SAPEntry sapEntry = _sapEntryLocalService.fetchSAPEntry(companyId, name);

            if (sapEntry != null) {
                continue;
            }

            Map<Locale, String> map = new HashMap<>();

            map.put(LocaleUtil.getDefault(), name);

            _sapEntryLocalService.addSAPEntry(
                _userLocalService.getDefaultUserId(companyId),
                allowedServiceSignatures, defaultSAPEntry, true, name, map,
                new ServiceContext());
        }
    }


    @Reference
    private SAPEntryLocalService _sapEntryLocalService;

    @Reference
    private UserLocalService _userLocalService;
}