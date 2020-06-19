package cj.netos.org.service;

import cj.netos.org.IIspService;
import cj.netos.org.ILicenceService;
import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.mapper.OrgIspMapper;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgIspExample;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.result.OrgLicenceResult;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.ArrayList;
import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "ispService")
public class IspService implements IIspService {

    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.OrgIspMapper")
    OrgIspMapper orgIspMapper;
    @CjServiceRef
    ILicenceService licenceService;

    @CjTransaction
    @Override
    public OrgIsp getIsp(String ispid) {
        return orgIspMapper.selectByPrimaryKey(ispid);
    }

    @CjTransaction
    @Override
    public List<OrgIsp> pageIsp(int limit, long offset) {
        return orgIspMapper.page(limit, offset);
    }
    @CjTransaction
    @Override
    public List<OrgIsp> listIspOfMasters(List<String> masters) {
        OrgIspExample example = new OrgIspExample();
        example.createCriteria().andMasterPersonIn(masters);
        return orgIspMapper.selectByExample(example);
    }

    @CjTransaction
    @Override
    public List<OrgLicenceResult> pageIspWithLicence(int limit, long offset) {
        List<OrgIsp> ispList=pageIsp(limit,offset);
        List<OrgLicenceResult> list = new ArrayList<>();
        for (OrgIsp isp : ispList) {
            OrgLicence licence=licenceService.getLicence(isp.getId(),2);
            list.add(new OrgLicenceResult(isp, licence));
        }
        return list;
    }

    @CjTransaction
    @Override
    public OrgLicenceResult getLicence(String ispid) {
        OrgIsp isp = getIsp(ispid);
        OrgLicence licence = licenceService.getLicence(ispid, 2);
        return new OrgLicenceResult(isp, licence);
    }

    @CjTransaction
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
        isp.setCorpSimple(bo.getSimpleName());
        orgIspMapper.insert(isp);

        bo.setOrgan(isp.getId());
        bo.setPriviliegeLevel(2);
    }


}
