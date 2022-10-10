package oefa.gob.pe.infraestructure_cross_cuting.config_properties;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@ConfigurationPropertiesScan
@Component
@Validated
@ConfigurationProperties(prefix = "oefa")
public class Oefa {
	@NonNull Sso sso;
	@NonNull Alfresco alfresco;
	@NonNull Siged siged;
	@NonNull Siia siia;
}
