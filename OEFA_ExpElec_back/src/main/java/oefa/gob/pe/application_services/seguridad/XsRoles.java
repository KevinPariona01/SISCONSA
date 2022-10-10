package oefa.gob.pe.application_services.seguridad;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
class XsRoles implements Serializable {

    @Serial
    private static final long serialVersionUID = 1129233535961481563L;
    @JsonProperty("PK_eIdPerfil")
    private Long idPerfil;
    @JsonProperty("uNombrePerfil")
    private String uNombrePerfil;

    @Override
    public String toString() {
        return uNombrePerfil;
    }
}


