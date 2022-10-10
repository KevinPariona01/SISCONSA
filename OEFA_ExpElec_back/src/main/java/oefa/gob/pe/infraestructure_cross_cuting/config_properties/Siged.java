package oefa.gob.pe.infraestructure_cross_cuting.config_properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;

@Data
@ConfigurationPropertiesScan
@Component
@ConfigurationProperties(prefix = "oefa.siged")
@Validated
public class Siged {
	@NotEmpty String user;
	@NotEmpty String password;
	@NotEmpty String login_url;
	@NotEmpty String consulta_url;
}
