package cj.netos.org.mapper;

import cj.netos.org.model.Workflow;
import cj.netos.org.model.WorkflowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkflowMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WorkflowExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WorkflowExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(Workflow record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(Workflow record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<Workflow> selectByExample(WorkflowExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    Workflow selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") Workflow record, @Param("example") WorkflowExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") Workflow record, @Param("example") WorkflowExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(Workflow record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(Workflow record);

    List<Workflow> page(@Param(value = "limit") int limit, @Param(value = "offset") long offset);
}