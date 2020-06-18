package cj.netos.org;

import cj.netos.org.bo.IspApplyBO;
import cj.netos.org.model.OrgIsp;
import cj.netos.org.model.OrgLicence;
import cj.netos.org.result.OrgLicenceResult;

import java.util.List;

public interface IIspService {
    OrgIsp getIsp(String ispid);

    List<OrgIsp> pageIsp(int limit, long offset);

    OrgLicenceResult getLicence(String ispid);

    void doRegisterIsp(String principal, IspApplyBO ispApplyBO);


    List<OrgLicenceResult> pageIspWithLicence(int limit, long offset);

}
