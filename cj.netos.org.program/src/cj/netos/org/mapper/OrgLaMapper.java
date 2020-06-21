package cj.netos.org.mapper;

import cj.netos.org.model.OrgLa;
import cj.netos.org.model.OrgLaExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrgLaMapper {

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    long countByExample(OrgLaExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByExample(OrgLaExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int deleteByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insert(OrgLa record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int insertSelective(OrgLa record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    List<OrgLa> selectByExample(OrgLaExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    OrgLa selectByPrimaryKey(String id);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExampleSelective(@Param("record") OrgLa record, @Param("example") OrgLaExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByExample(@Param("record") OrgLa record, @Param("example") OrgLaExample example);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKeySelective(OrgLa record);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    int updateByPrimaryKey(OrgLa record);

    List<OrgLa> pageLa(@Param(value = "limit") int limit, @Param(value = "offset") long offset);

    List<OrgLa> pageLaOfIsp(@Param(value = "isp") String isp, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

    void updateIsp(@Param(value = "id") String id, @Param(value = "isp") String isp);

    List<OrgLa> pageLaOfIspList(@Param(value = "ispList") String ispList, @Param(value = "limit") int limit, @Param(value = "offset") long offset);

}