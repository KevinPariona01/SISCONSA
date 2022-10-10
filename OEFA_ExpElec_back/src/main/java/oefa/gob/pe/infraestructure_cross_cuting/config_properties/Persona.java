package oefa.gob.pe.infraestructure_cross_cuting.config_properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

@Data
@ConfigurationPropertiesScan
@Component
@ConfigurationProperties("oefa.sso.persona")
public class Persona {
	@NotNull String uri;
}
