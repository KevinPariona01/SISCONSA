package oefa.gob.pe.application_dto.informe_monitoreo;


import java.util.Date;

public class DTOInformeMonitoreo {
	public int idInformeMonitoreo;
	public int idInstrumento;
	public String idSubsector;
	public String codigoUfi;
	public String nombreUfi;
	public String rucAdministrado;
	public String idUfi;
	public String idAdministrado;
	public String nombreInformeMonitoreo;
	public Date fechaInicial;
	public Date fechaFinal;
	public String fechaInicialText;
	public String fechaFinalText;
	public Date fechaPresentacion;
	public String fechaPresentacionText;
	public String audCreadoPor;
	public Date audFechaCreacion;
	public String audModificadoPor;
	public Date audFechaModificacion;
	public String usuario;
	public String nombreInstrumento;
	public int idFrecuenciaMonitoreo;
	public String textFrecuenciaMonitoreo;
	public String nombreAdministrado;

	public String idEtapa;
	public String txEtapa;
	public String idFrecuenciaReporte;
	public String txFrecuenciaReporte;
	public String idPeriodo;
	public String txPeriodo;

	public int tipoConsulta;
	public int estado;
	public String txEstado;

	public int[] listaInstrumentos;
	public String txInstrumentos;
	public int respuesta;

	public String txToolTip;
	public String unidadFiscalizable, direccion;
	public String direccion_uf;

	public int idCadenaCustodia, idLineaBase;
	public String tipo, tipoMonitoreo;

	public boolean copiarInforme;

	public String txFechaRegistro;

	public Date fechaRegistroInicial, fechaRegistroFinal;

	public int idExpediente;
	public String nroExpediente;
	public String txExpediente, idDocumento, descripcionSiged;

	public String idUsuarioLogin;

	public String tipoReporte;
	public int idIga;
	
	public String tokenSso, correo;
}