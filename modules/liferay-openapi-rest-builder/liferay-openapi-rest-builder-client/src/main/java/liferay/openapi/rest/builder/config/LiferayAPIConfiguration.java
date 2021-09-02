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
        name = "api-jax-url",
        required = false
    )
    public String apiJaxUrl();

    @Meta.AD(
        deflt="/",
        name = "api-open-url",
        required = false
    )
    public String apiOpenUrl();

    @Meta.AD(
        deflt = "jax",
        name = "default-api-url",
        optionLabels = {"JaxUrl", "OpenApiUrl"},
        optionValues = {"jax", "open"},
        required = false
    )
    public String defaultApi();
}
