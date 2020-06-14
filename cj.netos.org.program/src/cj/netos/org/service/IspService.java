package cj.netos.org.service;

import cj.netos.org.IIspService;
import cj.netos.org.ILicenceService;
import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.mapper.OrgIspMapper;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ispService")
public class IspService implements IIspService {

    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.OrgIspMapper")
    OrgIspMapper orgIspMapper;

    @CjTransaction
    @Override
    public OrgIsp getIsp(String ispid) {
        return null;
    }

    @CjTransaction
    @Override
    public List<OrgIsp> pageIsp(int limit, long offset) {
        return null;
    }

    @CjTransaction
    @Override
    public OrgLicence getLicence(String ispid) {
        return null;
    }

    @Override
    public void doRegisterIsp(String principal, IspApplyBO bo) {
        OrgIsp isp = new OrgIsp();
        isp.setCtime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        isp.setId(new IdWorker().nextId());
        isp.setMasterPhone(bo.getMasterPhone());
        isp.setMasterRealName(bo.getMasterRealName());
        isp.setMasterPerson(bo.getMasterPerson());
        isp.setLicenceSrc(bo.getLicenceSrc());
        isp.setCorpName(bo.getCropName());
        isp.setCorpLogo(bo.getCropLogo());
        isp.setCorpCode(bo.getCropCode());
        orgIspMapper.insert(isp);
    }


}
