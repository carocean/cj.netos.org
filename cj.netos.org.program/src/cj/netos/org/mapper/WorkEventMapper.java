package cj.netos.org.mapper;

import cj.netos.org.model.WorkEvent;
import cj.netos.org.model.WorkEventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkEventMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WorkEventExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WorkEventExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WorkEvent record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WorkEvent record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WorkEvent> selectByExample(WorkEventExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WorkEvent selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WorkEvent record, @Param("example") WorkEventExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WorkEvent record, @Param("example") WorkEventExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WorkEvent record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WorkEvent record);

    void done(@Param(value = "id") String id, @Param(value = "operated") String operated, @Param(value = "dtime") String dtime);

    WorkEvent getLastWorkEvent(@Param(value = "recipient") String recipient, @Param(value = "workInst") String workInst);

    List<WorkEvent> pageWithFilter(@Param(value = "recipient") String recipient, @Param(value = "isDone") int isDone, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<WorkEvent> pageWithoutFilter(@Param(value = "recipient") String recipient, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    WorkEvent getFirstWorkEvent(@Param(value = "recipient") String recipient, @Param(value = "workInst") String workInst);

    List<WorkEvent> getAll(@Param(value = "workInst") String workInst);
}