package cj.netos.org.mapper;

import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgIspExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgIspMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(OrgIspExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(OrgIspExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(OrgIsp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(OrgIsp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<OrgIsp> selectByExample(OrgIspExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    OrgIsp selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") OrgIsp record, @Param("example") OrgIspExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") OrgIsp record, @Param("example") OrgIspExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(OrgIsp record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(OrgIsp record);
}