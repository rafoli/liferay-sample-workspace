package liferay.openapi.rest.builder.config;

import aQute.bnd.annotation.metatype.Meta;
import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Rennan Prysthon
 */
@ExtendedObjectClassDefinition(
    category = "liferay-api-configuration",
    scope = ExtendedObjectClassDefinition.Scope.SYSTEM
)
@Meta.OCD(
    id="liferay.openapi.rest.builder.config.LiferayAPIConfiguration",
    localization = "content/Language",
    name = "liferay-api"
)
public interface LiferayAPIConfiguration {
    @Meta.AD(
        deflt="/",
        name = "api-mock-url",
        required = false
    )
    public String apiMockUrl();

    @Meta.AD(
        deflt="/",
        name = "api-open-url",
        required = false
    )
    public String apiOpenUrl();

    @Meta.AD(
        deflt = "mock",
        name = "default-api-url",
        optionLabels = {"MockUrl", "OpenApiUrl"},
        optionValues = {"mock", "open"},
        required = false
    )
    public String defaultApi();
}
