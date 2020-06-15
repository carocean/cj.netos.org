package cj.netos.org.ports;

import cj.netos.org.model.WorkGroup;
import cj.netos.org.model.WorkInst;
import cj.netos.org.model.Workflow;
import cj.netos.org.result.WorkGroupRecipients;
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
    WorkItem createWorkInstance(ISecuritySession securitySession,
                                @CjOpenportParameter(usage = "工作流标识", name = "workflow") String workflow,
                                @CjOpenportParameter(usage = "工作数据", name = "data") String data
    ) throws CircuitException;

    @CjOpenport(usage = "更新工作流数据。")
    void updateWorkInstData(ISecuritySession securitySession,
                            @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
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


    @CjOpenport(usage = "分页获取我的在指定工作流上的工作项列表")
    List<WorkItem> pageMyWorkItemOnWorkflow(ISecuritySession securitySession,
                                            @CjOpenportParameter(usage = "工作流标识", name = "workflow") String workflow,
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
    boolean doMyWorkItem(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                         @CjOpenportParameter(usage = "发生的操作。如已审批｜已发申请等，由程序定义每一step是什么操作，下一步需要根据前边的操作做什么", name = "operated") String operated,
                         @CjOpenportParameter(usage = "是否结束流程实例", name = "doneWorkInst") boolean doneWorkInst
    ) throws CircuitException;

    @CjOpenport(usage = "发送")
    void sendMyWorkItem(ISecuritySession securitySession,
                        @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                        @CjOpenportParameter(usage = "收件人列表，多个收件人以;号隔开。如果以$g.开头表示工作组作为收件人。", name = "recipients") String recipients/*多个收件人以;号隔开*/,
                        @CjOpenportParameter(usage = "事件代码，即步骤的英文名，在一个实例中唯一，它也用来标记实例的结束", name = "eventCode") String eventCode,
                        @CjOpenportParameter(usage = "频骤名", name = "stepName") String stepName
    ) throws CircuitException;

    @CjOpenport(usage = "完成当前工作事件并发送")
    boolean doWorkItemAndSend(ISecuritySession securitySession,
                              @CjOpenportParameter(usage = "工作实例标识", name = "workinst") String workinst,
                              @CjOpenportParameter(usage = "发生的操作。如已审批｜已发申请等，由程序定义每一step是什么操作，下一步需要根据前边的操作做什么", name = "operated") String operated,
                              @CjOpenportParameter(usage = "收件人列表，多个收件人以;号隔开。如果以$g.开头表示工作组作为收件人。", name = "recipients") String recipients/*多个收件人以;号隔开*/,
                              @CjOpenportParameter(usage = "事件代码，即步骤的英文名，在一个实例中唯一，它也用来标记实例的结束", name = "eventCode") String eventCode,
                              @CjOpenportParameter(usage = "频骤名", name = "stepName") String stepName
    ) throws CircuitException;

    @CjOpenport(usage = "添加工作组。一个工作组下有一到多个收件人成员。\n" +
            "目的是为了在工作流发送时指定工作组作为收件人，工作组名在逻辑上等同于绑定到了工作事件")
    void addWorkGroup(ISecuritySession securitySession,
                      @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "code") String code,
                      @CjOpenportParameter(usage = "中文名", name = "name") String name,
                      @CjOpenportParameter(usage = "备注", name = "note") String note
    ) throws CircuitException;

    @CjOpenport(usage = "获取工作组")
    WorkGroup getWorkGroup(ISecuritySession securitySession,
                           @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "code") String workgroup
    ) throws CircuitException;

    @CjOpenport(usage = "移除工作组")
    void removeWorkGroup(ISecuritySession securitySession,
                         @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "code") String workgroup
    ) throws CircuitException;

    @CjOpenport(usage = "分页工作组")
    List<WorkGroup> pageWorkGroup(ISecuritySession securitySession,
                                  @CjOpenportParameter(usage = "分页大小", name = "limit") int limit,
                                  @CjOpenportParameter(usage = "偏移", name = "offset") long offset
    ) throws CircuitException;

    @CjOpenport(usage = "添加工作组成员（成员会被用作收件人")
    void addWorkRecipient(ISecuritySession securitySession,
                          @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "workgroup") String workgroup,
                          @CjOpenportParameter(usage = "公号", name = "person") String person,
                          @CjOpenportParameter(usage = "顺序，会被用作接收事件的优先级", name = "sort") int sort
    ) throws CircuitException;

    @CjOpenport(usage = "移除工作组成员")
    void removeWorkRecipient(ISecuritySession securitySession,
                             @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "code") String workgroup,
                             @CjOpenportParameter(usage = "公号", name = "person") String person
    ) throws CircuitException;

    @CjOpenport(usage = "获取工作组的成员")
    WorkGroupRecipients getWorkGroupRecipients(ISecuritySession securitySession,
                                               @CjOpenportParameter(usage = "工作组代码，有语义的收件人集合名称", name = "code") String workgroup
    ) throws CircuitException;
}
