package cj.netos.org;

import cj.netos.org.bo.LaApplyBO;
import cj.netos.org.model.OrgLa;

import java.util.List;

public interface ILaService {
    void doRegisterIsp(String principal, LaApplyBO bo);

    OrgLa getLa(String laid);

    List<OrgLa> pageLa(int limit, long offset);

    List<OrgLa> pageLaOfIsp(String ispid, int limit, long offset);

    void updateIsp(String laid,String ispid);

}
