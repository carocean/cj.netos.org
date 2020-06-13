package cj.netos.org.mapper;

import cj.netos.org.model.OrgLicence;
import cj.netos.org.model.OrgLicenceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgLicenceMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(OrgLicenceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(OrgLicenceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(OrgLicence record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(OrgLicence record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<OrgLicence> selectByExample(OrgLicenceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    OrgLicence selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") OrgLicence record, @Param("example") OrgLicenceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") OrgLicence record, @Param("example") OrgLicenceExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(OrgLicence record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(OrgLicence record);
}