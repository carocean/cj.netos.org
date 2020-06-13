package cj.netos.org.mapper;

import cj.netos.org.model.ReceivingBank;
import cj.netos.org.model.ReceivingBankExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReceivingBankMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(ReceivingBankExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(ReceivingBankExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(ReceivingBank record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(ReceivingBank record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<ReceivingBank> selectByExample(ReceivingBankExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    ReceivingBank selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") ReceivingBank record, @Param("example") ReceivingBankExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") ReceivingBank record, @Param("example") ReceivingBankExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(ReceivingBank record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(ReceivingBank record);
}