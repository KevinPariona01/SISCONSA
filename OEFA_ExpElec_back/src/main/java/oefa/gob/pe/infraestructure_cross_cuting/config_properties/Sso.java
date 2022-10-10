package oefa.gob.pe.infraestructure_cross_cuting.config_properties;

import lombok.Data;
import lombok.NonNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@ConfigurationPropertiesScan
@Component
@Validated
@ConfigurationProperties(prefix = "oefa.sso")
public class Sso {
	@NonNull Persona persona;
	@NonNull Seguridad seguridad;
	@NonNull PersonaExtranjera persona_extranjera;
	@NotNull String id_aplicacion;
	@NotEmpty String key_token;
	@NotEmpty String dni_autorizado;
	@NotEmpty String usuario_rest;
	@NotEmpty String clave_rest;
	@NotEmpty String id_perfil_usuario_principal;
	@NotEmpty String id_perfil_usuario_secundario;
}
