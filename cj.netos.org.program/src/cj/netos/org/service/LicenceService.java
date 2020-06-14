package cj.netos.org.service;

import cj.netos.org.ILicenceService;
import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.mapper.OrgLicenceMapper;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.model.OrgLicenceExample;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.CJSystem;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.openport.util.Encript;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "licenceService")
public class LicenceService implements ILicenceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.OrgLicenceMapper")
    OrgLicenceMapper orgLicenceMapper;

    @CjTransaction
    @Override
    public void publishLaLicence(LaApplyBO laApplyBO) {
        OrgLicence licence = new OrgLicence();
        licence.setBussinessAreaCode(laApplyBO.getBussinessAreaCode());
        licence.setBussinessAreaTitle(laApplyBO.getBussinessAreaTitle());
        licence.setBussinessScop(laApplyBO.getBussinessScop());
        licence.setFee(laApplyBO.getFee());
        licence.setId(new IdWorker().nextId());
        licence.setOperatePeriod(laApplyBO.getOperatePeriod());
        licence.setOrgan(laApplyBO.getOrgan());
        licence.setPrivilegeLevel(laApplyBO.getPriviliegeLevel());
        licence.setPubTime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        licence.setState(0);
        licence.setTitle(laApplyBO.getCropName());
        licence.setPayEvidence(laApplyBO.getPayEvidence());
        Date endDate = null;
        try {
            endDate = OrgUtils.getNewDate(new Date(System.currentTimeMillis()), licence.getOperatePeriod());
        } catch (ParseException e) {
            CJSystem.logging().warn(getClass(), e);
        }
        licence.setEndTime(OrgUtils.dateTimeToMicroSecond(endDate.getTime()));
        String encriptText = String.format("%s%s%s%s%s%s%s%s",
                licence.getId(),
                licence.getBussinessAreaCode(),
                licence.getOperatePeriod(),
                licence.getFee(),
                licence.getBussinessScop(),
                licence.getOrgan(),
                licence.getPubTime(),
                licence.getPayEvidence()
        );
        String signText = Encript.md5(encriptText);
        licence.setSignText(signText);
        orgLicenceMapper.insert(licence);
    }

    @CjTransaction
    @Override
    public void publishIspLicence(IspApplyBO ispApplyBO) {
        OrgLicence licence = new OrgLicence();
        licence.setBussinessAreaCode(ispApplyBO.getBussinessAreaCode());
        licence.setBussinessAreaTitle(ispApplyBO.getBussinessAreaTitle());
        licence.setBussinessScop(ispApplyBO.getBussinessScop());
        licence.setFee(ispApplyBO.getFee());
        licence.setId(new IdWorker().nextId());
        licence.setOperatePeriod(ispApplyBO.getOperatePeriod());
        licence.setOrgan(ispApplyBO.getOrgan());
        licence.setPrivilegeLevel(ispApplyBO.getPriviliegeLevel());
        licence.setPubTime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        licence.setState(0);
        licence.setTitle(ispApplyBO.getCropName());
        licence.setPayEvidence(ispApplyBO.getPayEvidence());
        Date endDate = null;
        try {
            endDate = OrgUtils.getNewDate(new Date(System.currentTimeMillis()), licence.getOperatePeriod());
        } catch (ParseException e) {
            CJSystem.logging().warn(getClass(), e);
        }
        licence.setEndTime(OrgUtils.dateTimeToMicroSecond(endDate.getTime()));
        String encriptText = String.format("%s%s%s%s%s%s%s%s",
                licence.getId(),
                licence.getBussinessAreaCode(),
                licence.getOperatePeriod(),
                licence.getFee(),
                licence.getBussinessScop(),
                licence.getOrgan(),
                licence.getPubTime(),
                licence.getPayEvidence()
        );
        String signText = Encript.md5(encriptText);
        licence.setSignText(signText);
        orgLicenceMapper.insert(licence);
    }

    @CjTransaction
    @Override
    public OrgLicence getLicence(String ispid, int i) {
        OrgLicenceExample example = new OrgLicenceExample();
        example.createCriteria().andOrganEqualTo(ispid).andPrivilegeLevelEqualTo(i);
        List<OrgLicence> licenceList = orgLicenceMapper.selectByExample(example);
        if (licenceList.isEmpty()) {
            return null;
        }
        return licenceList.get(0);
    }

    @CjTransaction
    @Override
    public void revoke(String organ, int privilegeLevel) {
        orgLicenceMapper.revokeWhere(organ, privilegeLevel);
    }

    @CjTransaction
    @Override
    public void revokeById(String licenceid) {
        orgLicenceMapper.revokeById(licenceid);
    }

    @CjTransaction
    @Override
    public List<OrgLicence> pageLicence(int limit, long offset) {
        return orgLicenceMapper.page(limit,offset);
    }
    @CjTransaction
    @Override
    public List<OrgLicence> pageLicenceByIsp(String isp, int limit, long offset) {
        return orgLicenceMapper.pageByIsp(isp,limit,offset);
    }

    @CjTransaction
    @Override
    public OrgLicence getlicenceByID(String licenceid) {
        return orgLicenceMapper.selectByPrimaryKey(licenceid);
    }
}
