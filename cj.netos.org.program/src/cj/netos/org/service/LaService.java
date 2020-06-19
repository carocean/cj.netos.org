package cj.netos.org.service;

import cj.netos.org.ILaService;
import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.mapper.OrgLaMapper;
import cj.netos.org.model.OrgLa;
import cj.netos.org.model.OrgLaExample;
import cj.netos.org.util.IdWorker;
import cj.netos.org.util.OrgUtils;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.orm.mybatis.annotation.CjTransaction;

import java.util.List;

@CjBridge(aspects = "@transaction")
@CjService(name = "laService")
public class LaService implements ILaService {
    @CjServiceRef(refByName = "mybatis.cj.netos.org.mapper.OrgLaMapper")
    OrgLaMapper orgLaMapper;

    @CjTransaction
    @Override
    public void doRegisterIsp(String principal, LaApplyBO bo) {
        OrgLa la = new OrgLa();
        la.setTime(OrgUtils.dateTimeToMicroSecond(System.currentTimeMillis()));
        la.setId(new IdWorker().nextId());
        la.setMasterPhone(bo.getMasterPhone());
        la.setMasterRealName(bo.getMasterRealName());
        la.setMasterPerson(bo.getMasterPerson());
        la.setLicenceSrc(bo.getLicenceSrc());
        la.setCorpName(bo.getCropName());
        la.setCorpLogo(bo.getCropLogo());
        la.setCorpCode(bo.getCropCode());
        la.setIsp(bo.getIsp());
        orgLaMapper.insert(la);

        bo.setOrgan(la.getId());
        bo.setPriviliegeLevel(0);
    }

    @CjTransaction
    @Override
    public OrgLa getLa(String laid) {
        return orgLaMapper.selectByPrimaryKey(laid);
    }

    @CjTransaction
    @Override
    public List<OrgLa> pageLa(int limit, long offset) {
        return orgLaMapper.pageLa(limit, offset);
    }

    @CjTransaction
    @Override
    public List<OrgLa> pageLaOfIsp(String ispid, int limit, long offset) {
        return orgLaMapper.pageLaOfIsp(ispid, limit, offset);
    }

    @CjTransaction
    @Override
    public void updateIsp(String laid, String ispid) {
        orgLaMapper.updateIsp(laid, ispid);
    }

    @CjTransaction
    @Override
    public List<OrgLa> listLaOfMasters(List<String> masters) {
        OrgLaExample example = new OrgLaExample();
        example.createCriteria().andMasterPersonIn(masters);
        return orgLaMapper.selectByExample(example);
    }
}
