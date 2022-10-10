package oefa.gob.pe.application_dto.siged;

import java.util.List;

public class DTOPersonaNatural {
    public int tipoPersona;
    public int pnTipoDocumento;
    public String pnNumerodocumento;
    public String pnNombres;
    public String pnApellidopaterno;
    public String pnApellidomaterno;
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