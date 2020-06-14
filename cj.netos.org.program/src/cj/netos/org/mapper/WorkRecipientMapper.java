package cj.netos.org.mapper;

import cj.netos.org.model.WorkRecipient;
import cj.netos.org.model.WorkRecipientExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkRecipientMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(WorkRecipientExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(WorkRecipientExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(@Param("workgroup") String workgroup, @Param("person") String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(WorkRecipient record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(WorkRecipient record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<WorkRecipient> selectByExample(WorkRecipientExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    WorkRecipient selectByPrimaryKey(@Param("workgroup") String workgroup, @Param("person") String person);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") WorkRecipient record, @Param("example") WorkRecipientExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") WorkRecipient record, @Param("example") WorkRecipientExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(WorkRecipient record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(WorkRecipient record);
}