package oefa.gob.pe.application_dto.siged;

import java.util.List;

public class DTOPersonaJuridica {
    public int tipoPersona;
    public String pjNumeroruc;
    public String pjRazonsocial;
    public int pjTipoDocumento;
    public String pjNumerodocumento;
    public String pjNombres;
    public String pjApellidopaterno;
    public String pjApellidomaterno;
    public String pcTelefono;
    public String pcCorreo;
    public int idAreaOrigen;
    public int idAreaDestino;
    public int idProceso;
    public int plazo;
    public int idTipodias;
    public String titulo;
    public String expedienteOrigen;
    public List<DTODocumento> documentos;
    public List<DTODestinoCopia> destinoCopia;
}