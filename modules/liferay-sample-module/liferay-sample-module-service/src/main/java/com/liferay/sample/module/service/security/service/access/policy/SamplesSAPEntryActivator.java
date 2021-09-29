package com.liferay.sample.module.service.security.service.access.policy;

import com.liferay.petra.string.StringBundler;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.instance.lifecycle.BasePortalInstanceLifecycleListener;
import com.liferay.portal.instance.lifecycle.PortalInstanceLifecycleListener;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.security.service.access.policy.model.SAPEntry;
import com.liferay.portal.security.service.access.policy.service.SAPEntryLocalService;

import com.liferay.sample.module.web.rest.SampleApplication;
import liferay.openapi.rest.builder.internal.resource.v1_0.SampleResourceImpl;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import com.liferay.portal.kernel.service.UserLocalService;


import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Component(
    immediate = true, service = {}
)
public class SamplesSAPEntryActivator {

    @Activate
    protected void activate(BundleContext bundleContext) {
        _serviceRegistration = bundleContext.registerService(
            PortalInstanceLifecycleListener.class,
            new SamplesPortalInstanceLifecycleListener(),
            null
        );
    }

    protected void addSAPEntry(long companyId) throws PortalException {
        SAPEntry sapEntry = _sapEntryLocalService.fetchSAPEntry(companyId, _SAP_ENTRY_NAME);
        if (sapEntry != null) {
            return;
        }

        //Here we can add more methods to be available to Guests
        String allowedServiceSignatures = StringBundler.concat(
            SampleApplication.class.getName(), "#getSamples",
            StringPool.NEW_LINE,
            SampleResourceImpl.class.getName(), "#getAllSamples"
        );

        Map<Locale, String> titleMap = new HashMap<>();

        titleMap.put(Locale.getDefault(), "Grant all users access to sample list routes");

        _sapEntryLocalService.addSAPEntry(
            _userLocalService.getDefaultUserId(companyId),
            allowedServiceSignatures,
            true,
            true,
            _SAP_ENTRY_NAME,
            titleMap,
            new ServiceContext()
        );

    }

    @Deactivate
    protected void deactivate() {
        if (_serviceRegistration != null) {
            _serviceRegistration.unregister();
        }
    }

    private static final String _SAP_ENTRY_NAME = "SITE_API_GUEST_ACCESS";

    @Reference
    private SAPEntryLocalService _sapEntryLocalService;

    @Reference
    private UserLocalService _userLocalService;

    private ServiceRegistration<PortalInstanceLifecycleListener> _serviceRegistration;

    private static final Log _log = LogFactoryUtil.getLog(SamplesSAPEntryActivator.class);

    private class SamplesPortalInstanceLifecycleListener
        extends BasePortalInstanceLifecycleListener {
            public void portalInstanceRegistered(Company company) throws Exception{
                try {
                    addSAPEntry(company.getCompanyId());
                } catch (PortalException portalException) {
                    _log.error("Unable to add service access policy entry for Company " +
                        company.getCompanyId(),
                        portalException);
                }
            }
    }
}
