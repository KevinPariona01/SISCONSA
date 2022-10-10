package oefa.gob.pe.application_dto.sso;

import java.util.List;

public class DTOSsoRespuesta {
    public Boolean estado;
    public String mensaje;
    public List<DTOSso> listaSso;
    public List<DTORuc> listaRuc;
    public DTONvalidaUsuario usuario;
    public List<DTOUsuarioRuc> usuarioRuc;
    public DTOSso sso;
    public String opciones;
	public String IdAdministrador;
	public String IdSupervisor;
	public String IdUsuarioPrincipal;
	public String IdUsuarioSecundario;
}
