package oefa.gob.pe.infraestructure_data.mapper;

import oefa.gob.pe.infraestructure_data.model.TMapArchivoAlfresco;
import oefa.gob.pe.infraestructure_data.model.TMapArchivoAlfrescoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface TMapArchivoAlfrescoMapper {
    long countByExample(TMapArchivoAlfrescoExample example);

    int deleteByExample(TMapArchivoAlfrescoExample example);

    /**
     * delete by primary key
     *
     * @param idArchivo primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(BigDecimal idArchivo);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(TMapArchivoAlfresco record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(TMapArchivoAlfresco record);


    void insertReturningId(@Param("dao") TMapArchivoAlfresco dao);

    List<TMapArchivoAlfresco> selectByExample(TMapArchivoAlfrescoExample example);

    /**
     * select by primary key
     *
     * @param idArchivo primary key
     * @return object by primary key
     */
    TMapArchivoAlfresco selectByPrimaryKey(BigDecimal idArchivo);

    int updateByExampleSelective(@Param("record") TMapArchivoAlfresco record, @Param("example") TMapArchivoAlfrescoExample example);

    int updateByExample(@Param("record") TMapArchivoAlfresco record, @Param("example") TMapArchivoAlfrescoExample example);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(TMapArchivoAlfresco record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(TMapArchivoAlfresco record);

    int updateBatch(List<TMapArchivoAlfresco> list);

    int updateBatchSelective(List<TMapArchivoAlfresco> list);
}