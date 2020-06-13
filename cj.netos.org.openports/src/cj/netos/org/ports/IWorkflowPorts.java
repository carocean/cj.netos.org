package cj.netos.org.ports;

import cj.netos.org.model.WorkInst;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkItem;
import cj.studio.ecm.net.CircuitException;
import cj.studio.openport.IOpenportService;
import cj.studio.openport.ISecuritySession;
import cj.studio.openport.annotations.CjOpenport;
import cj.studio.openport.annotations.CjOpenportParameter;
import cj.studio.openport.annotations.CjOpenports;

import java.util.List;

@CjOpenports(usage = "工作流程信息管理服务")
public interface IWorkflowPorts extends IOpenportService {
    @CjOpenport(usage = "创建工作流")
    Workflow createWorkflow(
            ISecuritySession securitySession,
            @CjOpenportParameter(usage = "流程名", name = "name") String name,
            @CjOpenportParameter(usage = "流程图标", name = "icon") String icon,
            @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "获取工作流")
    Workflow getWorkflow(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "工作流标识", name = "workflow") String workflow
    ) throws CircuitException;

    @CjOpenport(usage = "分页工作流")
    List<Workflow> pageWorkflow(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;


    @CjOpenport(usage = "创建工作流实例")
    WorkInst createWorkInstance(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "工作流标识", name = "workflow") String workflow,
                                @CjOpenportParameter(usage = "在指定的事件代码时结束实例，非空", name = "ondoneEventCode")   String ondoneEventCode,
                                @CjOpenportParameter(usage = "工作数据", name = "data") String data
    ) throws CircuitException;

    @CjOpenport(usage = "获取工作流实例。")
    WorkInst getWorkInstance(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst
    ) throws CircuitException;

    @CjOpenport(usage = "分页工作实例")
    List<WorkInst> pageWorkInst(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
                                @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取所有工作项的事件")
    List<WorkItem> getAllWorkitem(ISecuritySession securitySession,
                                  @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst
    ) throws CircuitException;


    @CjOpenport(usage = "分页获取我的工作项列表")
    List<WorkItem> pageMyWorkItem(ISecuritySession securitySession,
                                  @CjOpenportParameter(usage = "工作项过滤条件：0为未完成；1为已完成；2为所有", name = "filter") int filter,
                                  @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
                                  @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "获取我在工作流实例上的最后工作项，如果没有则返回空")
    public WorkItem getMyLastWorkItemOnInstance(ISecuritySession securitySession,
                                                @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst
    ) throws CircuitException;

    @CjOpenport(usage = "获取我在工作流实例上的第一个工作项，如果没有则返回空")
    public WorkItem getMyFirstWorkItemOnInstance(ISecuritySession securitySession,
                                                 @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst
    ) throws CircuitException;

    @CjOpenport(usage = "处理当前工作项。必须是收件人才有权限处理")
    void doMyWorkItem(ISecuritySession securitySession,
                      @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                      @CjOpenportParameter(usage = "发生的操作。如已审批｜已发申请等，由程序定义每一step是什么操作，下一步需要根据前边的操作做什么", name = "operated") String operated
    ) throws CircuitException;

    @CjOpenport(usage = "发送")
    void sendMyWorkItem(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                        @CjOpenportParameter(usage = "多个收件人以;号隔开", name = "recipients") String recipients/*多个收件人以;号隔开*/,
                        @CjOpenportParameter(usage = "事件代码，即步骤的英文名，在一个实例中唯一，它也用来标记实例的结束", name = "eventCode") String eventCode,
                        @CjOpenportParameter(usage = "频骤名", name = "stepName") String stepName
    ) throws CircuitException;

    @CjOpenport(usage = "完成当前工作事件并发送")
    void doWorkItemAndSend(ISecuritySession securitySession,
                           @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                           @CjOpenportParameter(usage = "发生的操作。如已审批｜已发申请等，由程序定义每一step是什么操作，下一步需要根据前边的操作做什么", name = "operated") String operated,
                           @CjOpenportParameter(usage = "多个收件人以;号隔开", name = "recipients") String recipients/*多个收件人以;号隔开*/,
                           @CjOpenportParameter(usage = "事件代码，即步骤的英文名，在一个实例中唯一，它也用来标记实例的结束", name = "eventCode") String eventCode,
                           @CjOpenportParameter(usage = "频骤名", name = "stepName") String stepName
    ) throws CircuitException;
}
