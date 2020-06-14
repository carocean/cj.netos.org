package cj.netos.org.mapper;

import cj.netos.org.model.WorkGroup;
import cj.netos.org.model.WorkGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkGroupMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WorkGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WorkGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String code);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WorkGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WorkGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WorkGroup> selectByExample(WorkGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WorkGroup selectByPrimaryKey(String code);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WorkGroup record, @Param("example") WorkGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WorkGroup record, @Param("example") WorkGroupExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WorkGroup record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WorkGroup record);

    List<WorkGroup> page(@Param(value = "limit") int limit, @Param(value = "offset") long offset);
}