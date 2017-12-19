$(document).ready(function(){
    getCount();
    loadTable(pageSize,1);
    setPage(1,"simpleoapage_wlog");
    setProject();
    $("#up").attr("disabled","disabled");
});

function getCount(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/workLog/getCount.do",
        dataType:"json",
        async: false,
        success:function (data) {
            listCount=data.conut;
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}

function  loadTable(pageSize,pageNum){
    $.ajax({
        type:"post",
        url:simpleUrl+"/workLog/workLogList.do?number=Math.random()",
        dataType:"json",
        data:{"pageSize":pageSize,"pageNum":pageNum},
        success:function (data) {
            $(".table-striped tbody").html("");
            for(var i=0;i<data.workLogList.length;i++){
                var workLog=data.workLogList[i];
                var num=i+1;
                var oper="<a href='javascript:void(0);' onclick='getWorklog("+workLog.id+")' class='btn btn-small simpleoa-padding8667'><i class='icon-edit simpleoa-fontsize16'></i> </a> "+
                    "<a href='javascript:void(0);' onclick='delWorklog("+workLog.id+","+workLog.projectstatus+")' class='btn btn-small simpleoa-padding8968'><i class='icon-trash simpleoa-fontsize16'></i> </a> "
                var tr="<tr><td style='text-align: center;'>"
                    + num
                    + " </td><td style='text-align: center;' title='"
                    + workLog.relname+"'>"
                    + workLog.relname
                    + " </td><td style='text-align: center;' title='"
                    + workLog.workdate+"'>"
                    + workLog.workdate
                    + " </td><td style='text-align: center;' title='"
                    + workLog.jcontent+"'>"
                    + workLog.jcontent
                    + " </td><td style='text-align: center;' title='"
                    + workLog.projectname+"'>"
                    + workLog.projectname
                    + " </td><td style='text-align: center;' title='"
                    + workLog.worktime+"小时'>"
                    + workLog.worktime
                    + "小时</td><td class='action-td' style='padding: 2px 2px 2px 6px;'>"
                    + oper
                    +"</td>";

                $(".table-striped").append(tr);
            }
            $(".table-striped td").attr("class", "simpleoa-wrap");
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}

function getWorklog(id) {
    $.ajax({
        type:"post",
        url:simpleUrl+"/workLog/getWorklog.do",
        dataType:"json",
        data:{"id":id},
        success:function (data) {
            var workLog=data.workLog;
            $("#workid").val(workLog.id);
            $("#jcontent").val(workLog.jcontent);
            $("#cdescribe").val(workLog.cdescribe);
            $("#worktime").val(workLog.worktime);
            $("#summary").val(workLog.summary);
            $("#projectid").find("option:contains('"+workLog.projectname+"')").attr("selected",true);
            $("#workdate").val(workLog.workdate);
            $("#workdate").attr("disabled","disabled");
            $("#worktime").attr("disabled","disabled");
            $("#editworklog").html("修改工作日志");
            $("#up").removeAttr("disabled");
            $("#sub").attr("disabled","disabled");
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}

function delWorklog(id) {
    window.wxc.xcConfirm("确定要删除日志吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
        $.ajax({
            type:"post",
            url:simpleUrl+"/workLog/delWorklog.do",
            dataType:"json",
            data:{"id":id},
            success:function (data) {
                if(data.result=="success"){
                    window.wxc.xcConfirm("日志删除成功！！！", window.wxc.xcConfirm.typeEnum.success);
                    getCount();
                    loadTable(pageSize,1);
                }else{
                    window.wxc.xcConfirm("日志删除失败！！！", window.wxc.xcConfirm.typeEnum.error);
                }
            },
            error:function () {
                window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
            }
        });
    }});
}

$("#cel").click(function(){
    $("#workid").val("");
    $("#jcontent").val("");
    $("#cdescribe").val("");
    $("#worktime").val("");
    $("#summary").val("");
    $("#projectid").val("");
    $("#workdate").val("");
    $("#workdate").removeAttr("disabled");
    $("#worktime").removeAttr("disabled");
    $("#up").attr("disabled","disabled");
    $("#sub").removeAttr("disabled");
})

//update
$("#up").click(function(){
    var id=$("#workid").val();
    var jcontent=$("#jcontent").val();
    var cdescribe=$("#cdescribe").val();
    var worktime=$("#worktime").val();
    var summary=$("#summary").val();
    var projectid=$("#projectid option:selected").val();
    var projectname=$("#projectid option:selected").text();
    var workdate=$("#workdate").val();

    var workLog={
        "id":id,
        "jcontent":jcontent,
        "cdescribe":cdescribe,
        "worktime":worktime,
        "summary":summary,
        "projectid":projectid,
        "projectname":projectname,
        "workdate":workdate
    };

    if(workdate!=null&&workdate!=""){
        if(projectid!=0){
            if(jcontent!=null&&jcontent!=""){
                window.wxc.xcConfirm("确定要修改日志吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
                    $.ajax({
                        type:"post",
                        url:simpleUrl+"/workLog/updateWorklog.do",
                        dataType:"json",
                        data:workLog,
                        success:function (data) {
                            if(data.result=="success"){
                                window.wxc.xcConfirm("修改日志成功！！！", window.wxc.xcConfirm.typeEnum.success);
                                $("#workid").val("");
                                $("#jcontent").val("");
                                $("#cdescribe").val("");
                                $("#worktime").val("");
                                $("#summary").val("");
                                $("#projectid").val("");
                                $("#workdate").val("");
                                loadTable(7,1);
                                $("#up").attr("disabled","disabled");
                                $("#sub").removeAttr("disabled");
                                $("#worktime").removeAttr("disabled");
                                $("#workdate").removeAttr("disabled");
                            }else{
                                window.wxc.xcConfirm("修改日志失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                            }
                        },
                        error:function () {
                            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                        }
                    });
                }});
            }else{
                window.wxc.xcConfirm("工作内容不能为空！！！", window.wxc.xcConfirm.typeEnum.info);
            }
        }else{
            window.wxc.xcConfirm("请选择项目！！！", window.wxc.xcConfirm.typeEnum.info);
        }
    }else{
        window.wxc.xcConfirm("请选择工作日期！！！", window.wxc.xcConfirm.typeEnum.info);
    }

});

$("#sub").click(function(){
    var jcontent=$("#jcontent").val();
    var cdescribe=$("#cdescribe").val();
    var worktime=$("#worktime").val();
    var summary=$("#summary").val();
    var projectid=$("#projectid option:selected").val();
    var projectname=$("#projectid option:selected").text();
    var workdate=$("#workdate").val();

    var workLog={
        "jcontent":jcontent,
        "cdescribe":cdescribe,
        "worktime":worktime,
        "summary":summary,
        "projectid":projectid,
        "projectname":projectname,
        "workdate":workdate
    };

    if(workdate!=null&&workdate!=""){
        if(projectid!=0){
            if(jcontent!=null&&jcontent!=""){
                window.wxc.xcConfirm("确定要添加日志吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
                    $.ajax({
                        type:"post",
                        url:simpleUrl+"/workLog/addWorklog.do",
                        dataType:"json",
                        data:workLog,
                        success:function (data) {
                            if(data.result=="success"){
                                window.wxc.xcConfirm("添加日志成功！！！", window.wxc.xcConfirm.typeEnum.success);
                                $("#jcontent").val("");
                                $("#cdescribe").val("");
                                $("#worktime").val("");
                                $("#summary").val("");
                                $("#projectid").val("");
                                $("#workdate").val("");
                                loadTable(7,1);
                            }else{
                                window.wxc.xcConfirm("添加日志失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                            }
                        },
                        error:function () {
                            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                        }
                    });
                }});
            }else{
                window.wxc.xcConfirm("工作内容不能为空！！", window.wxc.xcConfirm.typeEnum.info);
            }
        }else{
            window.wxc.xcConfirm("请选择项！！！", window.wxc.xcConfirm.typeEnum.info);
        }
    }else{
        window.wxc.xcConfirm("请选择日期！！！", window.wxc.xcConfirm.typeEnum.info);
    }

});

function setProject(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getProjects.do",
        dataType:"json",
        success:function (data) {
            var projectList=data.projectList;
            var sel=$("#projectid");
            sel.append("<option value='0'>请选择！</option>");
            for(var i=0;i<projectList.length;i++){
                sel.append("<option value='"+projectList[i].id+"'>"+projectList[i].projectname+"</option>");
            }
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}