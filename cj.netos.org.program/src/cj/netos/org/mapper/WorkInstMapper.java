package cj.netos.org.mapper;

import cj.netos.org.model.WorkInst;
import cj.netos.org.model.WorkInstExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkInstMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WorkInstExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WorkInstExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WorkInst record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WorkInst record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WorkInst> selectByExample(WorkInstExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WorkInst selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WorkInst record, @Param("example") WorkInstExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WorkInst record, @Param("example") WorkInstExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WorkInst record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WorkInst record);

    void done(@Param(value = "id") String id);

    List<WorkInst> page(@Param(value = "limit") int limit, @Param(value = "offset") long offset);

    void updateData(@Param(value = "id") String id,@Param(value = "data") String data);
}