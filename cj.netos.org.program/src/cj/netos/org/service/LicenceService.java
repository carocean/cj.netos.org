package cj.netos.org.service;

import cj.netos.org.ILicenceService;
import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.mapper.OrgLicenceMapper;
import cj.netos.org.model.OrgLicence;
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

@CjBridge(aspects = "@transaction")
@CjService(name = "licenceService")
public class LicenceService implements ILicenceService {
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.OrgLicenceMapper")
    OrgLicenceMapper orgLicenceMapper;

    @CjTransaction
    @Override
    public void publishLicence(IspApplyBO ispApplyBO) {
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
}
