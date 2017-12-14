$(document).ready(function(){
    getCount();
    loadTable(pageSize,1);
    setPage(1,"simpleoapage_wlog");
    setProject();
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
            alert("发生未知错误，请联系管理员！");
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
                var  oper= "<a href='javascript:void(0);' onclick='editWorklog("+workLog.id+")' class='btn btn-small'><i class='icon-edit' style='font-size: 15px'></i> </a> "+
                    "<a href='javascript:void(0);' onclick='delWorklog("+workLog.id+")' class='btn btn-small'><i class='icon-trash' style='font-size: 18px'></i> </a> ";
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
                    + "小时</td><td class='action-td'>"
                    + oper
                    +"</td>";

                $(".table-striped").append(tr);
            }
            $(".table-striped td").attr("class", "simpleoa-wrap");
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
}

function editWorklog() {
    
}

function delWorklog() {
    
}

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
                $.ajax({
                    type:"post",
                    url:simpleUrl+"/workLog/addWorklog.do",
                    dataType:"json",
                    data:workLog,
                    success:function (data) {
                        if(data.result=="success"){
                            alert("添加日志成功！");
                            $("#jcontent").val("");
                            $("#cdescribe").val("");
                            $("#worktime").val("");
                            $("#summary").val("");
                            $("#projectid").val("");
                            $("#workdate").val("");
                            loadTable(7,1);
                        }else{
                            alert("添加日志失败，请检查你的输入！");
                        }
                    },
                    error:function () {
                        alert("添加日志时发生未知错误，请联系管理员！");
                    }
                });
            }else{
                alert("工作内容不能为空！");
            }
        }else{
            alert("请选择项目！");
        }
    }else{
        alert("请选择日期！");
    }

});

function setProject(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getProject.do",
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
            alert("项目列表获取失败！");
        }
    });
}