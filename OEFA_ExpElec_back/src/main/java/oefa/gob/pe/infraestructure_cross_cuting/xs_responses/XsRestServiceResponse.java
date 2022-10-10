package oefa.gob.pe.infraestructure_cross_cuting.xs_responses;

import io.sentry.Sentry;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import java.util.Arrays;

@ToString
@Setter
@Getter
public class XsRestServiceResponse<T> {
    private String mensajeError;
    private Boolean estado;
    private T content;

    public XsRestServiceResponse() {
        estado = true;
    }

    public XsRestServiceResponse(String mensajeError, Boolean estado, T content) {
        this.mensajeError = mensajeError;
        this.estado = estado;
        this.content = content;
    }

    public static XsRestServiceResponse<Void> devolverExcepcionSegura(Exception ex) {
        return new XsRestServiceResponse<>(ex.getMessage(), false, null);
    }

    private String getMensajeDeError(Exception ex) {
        return "%nMensaje: %s%n%s".formatted(ex.getMessage(), Arrays.toString(ex.getStackTrace()));
    }

    public void SetException(Exception ex) {
        estado = false;
        mensajeError = getMensajeDeError(ex);
        Sentry.captureException(ex);
    }

    @NotNull
    public static <T> XsRestServiceResponse<T> fromContent(T content) {
        var respuesta = new XsRestServiceResponse<T>();
        respuesta.setContent(content);
        return respuesta;
    }

    @NotNull
    public static <T> XsRestServiceResponse<T> fromException(Exception exception) {
        var respuesta = new XsRestServiceResponse<T>();
        respuesta.SetException(exception);
        return respuesta;
    }
}