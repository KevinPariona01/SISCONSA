package oefa.gob.pe.application_dto.sso;

public class DTOSso {
    private String eIdUsuario;
	private String uCodUsuario;
	private String uNombreCompleto;
	private String token;
	private String tipoPersona;
	private String numDocumento;
	private String idSesion;
    
    public String geteIdUsuario() {
        return eIdUsuario;
    }
    public void seteIdUsuario(String eIdUsuario) {
        this.eIdUsuario = eIdUsuario;
    }
    public String getuCodUsuario() {
        return uCodUsuario;
    }
    public void setuCodUsuario(String uCodUsuario) {
        this.uCodUsuario = uCodUsuario;
    }
    public String getuNombreCompleto() {
        return uNombreCompleto;
    }
    public void setuNombreCompleto(String uNombreCompleto) {
        this.uNombreCompleto = uNombreCompleto;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    public String getNumDocumento() {
        return numDocumento;
    }
    public void setNumDocumento(String numDocumento) {
        this.numDocumento = numDocumento;
    }
    public String getIdSesion() {
        return idSesion;
    }
    public void setIdSesion(String idSesion) {
        this.idSesion = idSesion;
    }

    
}
