package oefa.gob.pe.infraestructure_data.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TMapArchivoAlfrescoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TMapArchivoAlfrescoExample() {
        oredCriteria = new ArrayList<>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        return new Criteria();
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdArchivoIsNull() {
            addCriterion("ID_ARCHIVO is null");
            return (Criteria) this;
        }

        public Criteria andIdArchivoIsNotNull() {
            addCriterion("ID_ARCHIVO is not null");
            return (Criteria) this;
        }

        public Criteria andIdArchivoEqualTo(BigDecimal value) {
            addCriterion("ID_ARCHIVO =", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoNotEqualTo(BigDecimal value) {
            addCriterion("ID_ARCHIVO <>", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoGreaterThan(BigDecimal value) {
            addCriterion("ID_ARCHIVO >", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID_ARCHIVO >=", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoLessThan(BigDecimal value) {
            addCriterion("ID_ARCHIVO <", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID_ARCHIVO <=", value, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoIn(List<BigDecimal> values) {
            addCriterion("ID_ARCHIVO in", values, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoNotIn(List<BigDecimal> values) {
            addCriterion("ID_ARCHIVO not in", values, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID_ARCHIVO between", value1, value2, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andIdArchivoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID_ARCHIVO not between", value1, value2, "idArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoIsNull() {
            addCriterion("TX_NOMBRE_ARCHIVO is null");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoIsNotNull() {
            addCriterion("TX_NOMBRE_ARCHIVO is not null");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO =", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoNotEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO <>", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoGreaterThan(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO >", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoGreaterThanOrEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO >=", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoLessThan(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO <", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoLessThanOrEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO <=", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoLike(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO like", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoNotLike(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO not like", value, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoIn(List<String> values) {
            addCriterion("TX_NOMBRE_ARCHIVO in", values, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoNotIn(List<String> values) {
            addCriterion("TX_NOMBRE_ARCHIVO not in", values, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoBetween(String value1, String value2) {
            addCriterion("TX_NOMBRE_ARCHIVO between", value1, value2, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoNotBetween(String value1, String value2) {
            addCriterion("TX_NOMBRE_ARCHIVO not between", value1, value2, "txNombreArchivo");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoIsNull() {
            addCriterion("TX_RUTA_ALFRESCO is null");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoIsNotNull() {
            addCriterion("TX_RUTA_ALFRESCO is not null");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoEqualTo(String value) {
            addCriterion("TX_RUTA_ALFRESCO =", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoNotEqualTo(String value) {
            addCriterion("TX_RUTA_ALFRESCO <>", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoGreaterThan(String value) {
            addCriterion("TX_RUTA_ALFRESCO >", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoGreaterThanOrEqualTo(String value) {
            addCriterion("TX_RUTA_ALFRESCO >=", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoLessThan(String value) {
            addCriterion("TX_RUTA_ALFRESCO <", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoLessThanOrEqualTo(String value) {
            addCriterion("TX_RUTA_ALFRESCO <=", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoLike(String value) {
            addCriterion("TX_RUTA_ALFRESCO like", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoNotLike(String value) {
            addCriterion("TX_RUTA_ALFRESCO not like", value, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoIn(List<String> values) {
            addCriterion("TX_RUTA_ALFRESCO in", values, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoNotIn(List<String> values) {
            addCriterion("TX_RUTA_ALFRESCO not in", values, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoBetween(String value1, String value2) {
            addCriterion("TX_RUTA_ALFRESCO between", value1, value2, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxRutaAlfrescoNotBetween(String value1, String value2) {
            addCriterion("TX_RUTA_ALFRESCO not between", value1, value2, "txRutaAlfresco");
            return (Criteria) this;
        }

        public Criteria andTxUiidIsNull() {
            addCriterion("TX_UIID is null");
            return (Criteria) this;
        }

        public Criteria andTxUiidIsNotNull() {
            addCriterion("TX_UIID is not null");
            return (Criteria) this;
        }

        public Criteria andTxUiidEqualTo(String value) {
            addCriterion("TX_UIID =", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidNotEqualTo(String value) {
            addCriterion("TX_UIID <>", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidGreaterThan(String value) {
            addCriterion("TX_UIID >", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidGreaterThanOrEqualTo(String value) {
            addCriterion("TX_UIID >=", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidLessThan(String value) {
            addCriterion("TX_UIID <", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidLessThanOrEqualTo(String value) {
            addCriterion("TX_UIID <=", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidLike(String value) {
            addCriterion("TX_UIID like", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidNotLike(String value) {
            addCriterion("TX_UIID not like", value, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidIn(List<String> values) {
            addCriterion("TX_UIID in", values, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidNotIn(List<String> values) {
            addCriterion("TX_UIID not in", values, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidBetween(String value1, String value2) {
            addCriterion("TX_UIID between", value1, value2, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxUiidNotBetween(String value1, String value2) {
            addCriterion("TX_UIID not between", value1, value2, "txUiid");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalIsNull() {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL is null");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalIsNotNull() {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL is not null");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL =", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalNotEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL <>", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalGreaterThan(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL >", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalGreaterThanOrEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL >=", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalLessThan(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL <", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalLessThanOrEqualTo(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL <=", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalLike(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL like", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalNotLike(String value) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL not like", value, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalIn(List<String> values) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL in", values, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalNotIn(List<String> values) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL not in", values, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalBetween(String value1, String value2) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL between", value1, value2, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andTxNombreArchivoOriginalNotBetween(String value1, String value2) {
            addCriterion("TX_NOMBRE_ARCHIVO_ORIGINAL not between", value1, value2, "txNombreArchivoOriginal");
            return (Criteria) this;
        }

        public Criteria andFgSitregIsNull() {
            addCriterion("FG_SITREG is null");
            return (Criteria) this;
        }

        public Criteria andFgSitregIsNotNull() {
            addCriterion("FG_SITREG is not null");
            return (Criteria) this;
        }

        public Criteria andFgSitregEqualTo(String value) {
            addCriterion("FG_SITREG =", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregNotEqualTo(String value) {
            addCriterion("FG_SITREG <>", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregGreaterThan(String value) {
            addCriterion("FG_SITREG >", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregGreaterThanOrEqualTo(String value) {
            addCriterion("FG_SITREG >=", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregLessThan(String value) {
            addCriterion("FG_SITREG <", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregLessThanOrEqualTo(String value) {
            addCriterion("FG_SITREG <=", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregLike(String value) {
            addCriterion("FG_SITREG like", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregNotLike(String value) {
            addCriterion("FG_SITREG not like", value, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregIn(List<String> values) {
            addCriterion("FG_SITREG in", values, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregNotIn(List<String> values) {
            addCriterion("FG_SITREG not in", values, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregBetween(String value1, String value2) {
            addCriterion("FG_SITREG between", value1, value2, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andFgSitregNotBetween(String value1, String value2) {
            addCriterion("FG_SITREG not between", value1, value2, "fgSitreg");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorIsNull() {
            addCriterion("AUD_CREADO_POR is null");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorIsNotNull() {
            addCriterion("AUD_CREADO_POR is not null");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorEqualTo(String value) {
            addCriterion("AUD_CREADO_POR =", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorNotEqualTo(String value) {
            addCriterion("AUD_CREADO_POR <>", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorGreaterThan(String value) {
            addCriterion("AUD_CREADO_POR >", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorGreaterThanOrEqualTo(String value) {
            addCriterion("AUD_CREADO_POR >=", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorLessThan(String value) {
            addCriterion("AUD_CREADO_POR <", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorLessThanOrEqualTo(String value) {
            addCriterion("AUD_CREADO_POR <=", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorLike(String value) {
            addCriterion("AUD_CREADO_POR like", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorNotLike(String value) {
            addCriterion("AUD_CREADO_POR not like", value, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorIn(List<String> values) {
            addCriterion("AUD_CREADO_POR in", values, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorNotIn(List<String> values) {
            addCriterion("AUD_CREADO_POR not in", values, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorBetween(String value1, String value2) {
            addCriterion("AUD_CREADO_POR between", value1, value2, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudCreadoPorNotBetween(String value1, String value2) {
            addCriterion("AUD_CREADO_POR not between", value1, value2, "audCreadoPor");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionIsNull() {
            addCriterion("AUD_FECHA_CREACION is null");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionIsNotNull() {
            addCriterion("AUD_FECHA_CREACION is not null");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionEqualTo(Date value) {
            addCriterion("AUD_FECHA_CREACION =", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionNotEqualTo(Date value) {
            addCriterion("AUD_FECHA_CREACION <>", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionGreaterThan(Date value) {
            addCriterion("AUD_FECHA_CREACION >", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionGreaterThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_CREACION >=", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionLessThan(Date value) {
            addCriterion("AUD_FECHA_CREACION <", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionLessThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_CREACION <=", value, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionIn(List<Date> values) {
            addCriterion("AUD_FECHA_CREACION in", values, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionNotIn(List<Date> values) {
            addCriterion("AUD_FECHA_CREACION not in", values, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_CREACION between", value1, value2, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaCreacionNotBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_CREACION not between", value1, value2, "audFechaCreacion");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorIsNull() {
            addCriterion("AUD_MODIFICADO_POR is null");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorIsNotNull() {
            addCriterion("AUD_MODIFICADO_POR is not null");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorEqualTo(String value) {
            addCriterion("AUD_MODIFICADO_POR =", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorNotEqualTo(String value) {
            addCriterion("AUD_MODIFICADO_POR <>", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorGreaterThan(String value) {
            addCriterion("AUD_MODIFICADO_POR >", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorGreaterThanOrEqualTo(String value) {
            addCriterion("AUD_MODIFICADO_POR >=", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorLessThan(String value) {
            addCriterion("AUD_MODIFICADO_POR <", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorLessThanOrEqualTo(String value) {
            addCriterion("AUD_MODIFICADO_POR <=", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorLike(String value) {
            addCriterion("AUD_MODIFICADO_POR like", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorNotLike(String value) {
            addCriterion("AUD_MODIFICADO_POR not like", value, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorIn(List<String> values) {
            addCriterion("AUD_MODIFICADO_POR in", values, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorNotIn(List<String> values) {
            addCriterion("AUD_MODIFICADO_POR not in", values, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorBetween(String value1, String value2) {
            addCriterion("AUD_MODIFICADO_POR between", value1, value2, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudModificadoPorNotBetween(String value1, String value2) {
            addCriterion("AUD_MODIFICADO_POR not between", value1, value2, "audModificadoPor");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionIsNull() {
            addCriterion("AUD_FECHA_MODIFICACION is null");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionIsNotNull() {
            addCriterion("AUD_FECHA_MODIFICACION is not null");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionEqualTo(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION =", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionNotEqualTo(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION <>", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionGreaterThan(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION >", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionGreaterThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION >=", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionLessThan(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION <", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionLessThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_MODIFICACION <=", value, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionIn(List<Date> values) {
            addCriterion("AUD_FECHA_MODIFICACION in", values, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionNotIn(List<Date> values) {
            addCriterion("AUD_FECHA_MODIFICACION not in", values, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_MODIFICACION between", value1, value2, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaModificacionNotBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_MODIFICACION not between", value1, value2, "audFechaModificacion");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorIsNull() {
            addCriterion("AUD_ELIMINADO_POR is null");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorIsNotNull() {
            addCriterion("AUD_ELIMINADO_POR is not null");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorEqualTo(String value) {
            addCriterion("AUD_ELIMINADO_POR =", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorNotEqualTo(String value) {
            addCriterion("AUD_ELIMINADO_POR <>", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorGreaterThan(String value) {
            addCriterion("AUD_ELIMINADO_POR >", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorGreaterThanOrEqualTo(String value) {
            addCriterion("AUD_ELIMINADO_POR >=", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorLessThan(String value) {
            addCriterion("AUD_ELIMINADO_POR <", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorLessThanOrEqualTo(String value) {
            addCriterion("AUD_ELIMINADO_POR <=", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorLike(String value) {
            addCriterion("AUD_ELIMINADO_POR like", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorNotLike(String value) {
            addCriterion("AUD_ELIMINADO_POR not like", value, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorIn(List<String> values) {
            addCriterion("AUD_ELIMINADO_POR in", values, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorNotIn(List<String> values) {
            addCriterion("AUD_ELIMINADO_POR not in", values, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorBetween(String value1, String value2) {
            addCriterion("AUD_ELIMINADO_POR between", value1, value2, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudEliminadoPorNotBetween(String value1, String value2) {
            addCriterion("AUD_ELIMINADO_POR not between", value1, value2, "audEliminadoPor");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionIsNull() {
            addCriterion("AUD_FECHA_ELIMINACION is null");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionIsNotNull() {
            addCriterion("AUD_FECHA_ELIMINACION is not null");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionEqualTo(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION =", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionNotEqualTo(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION <>", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionGreaterThan(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION >", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionGreaterThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION >=", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionLessThan(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION <", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionLessThanOrEqualTo(Date value) {
            addCriterion("AUD_FECHA_ELIMINACION <=", value, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionIn(List<Date> values) {
            addCriterion("AUD_FECHA_ELIMINACION in", values, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionNotIn(List<Date> values) {
            addCriterion("AUD_FECHA_ELIMINACION not in", values, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_ELIMINACION between", value1, value2, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andAudFechaEliminacionNotBetween(Date value1, Date value2) {
            addCriterion("AUD_FECHA_ELIMINACION not between", value1, value2, "audFechaEliminacion");
            return (Criteria) this;
        }

        public Criteria andNuFoliosIsNull() {
            addCriterion("NU_FOLIOS is null");
            return (Criteria) this;
        }

        public Criteria andNuFoliosIsNotNull() {
            addCriterion("NU_FOLIOS is not null");
            return (Criteria) this;
        }

        public Criteria andNuFoliosEqualTo(BigDecimal value) {
            addCriterion("NU_FOLIOS =", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosNotEqualTo(BigDecimal value) {
            addCriterion("NU_FOLIOS <>", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosGreaterThan(BigDecimal value) {
            addCriterion("NU_FOLIOS >", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NU_FOLIOS >=", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosLessThan(BigDecimal value) {
            addCriterion("NU_FOLIOS <", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NU_FOLIOS <=", value, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosIn(List<BigDecimal> values) {
            addCriterion("NU_FOLIOS in", values, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosNotIn(List<BigDecimal> values) {
            addCriterion("NU_FOLIOS not in", values, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NU_FOLIOS between", value1, value2, "nuFolios");
            return (Criteria) this;
        }

        public Criteria andNuFoliosNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NU_FOLIOS not between", value1, value2, "nuFolios");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}