$(document).ready(function(){
    getCount();
    loadTable(pageSize,1);
    setPage(1,"simpleoapage_project");
    $("#up").attr("disabled","disabled");
    if(simpleUser.role=="OrdinaryUser"){
        $("#addproject").hide();
        $("#projectlist").css("height", "560");
        $(".table-striped  tr :last-child").remove();
    }
});

function getCount(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getCount.do",
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
        url:simpleUrl+"/project/projectList.do?number=Math.random()",
        dataType:"json",
        async: false,
        data:{"pageSize":pageSize,"pageNum":pageNum},
        success:function (data) {
            $(".table-striped tbody").html("");
            for(var i=0;i<data.projectList.length;i++){
                var project=data.projectList[i];
                var num=i+1;
                var projectstatus=(project.projectstatus==1)?"进行中":"已结束";
                var endtime=(project.endtime==null)?"":project.endtime;
                var oper;
                if(project.projectstatus==1){
                    oper="<a href='javascript:void(0);' onclick='getProject("+project.id+")' class='btn btn-small simpleoa-padding8667'><i class='icon-edit simpleoa-fontsize16'></i> </a> "+
                        "<a href='javascript:void(0);' onclick='stopProject("+project.id+")' class='btn btn-small simpleoa-padding8867'><i class='icon-stop simpleoa-fontsize16'></i> </a> "+
                        "<a href='javascript:void(0);' onclick='delProject("+project.id+","+project.projectstatus+")' class='btn btn-small simpleoa-padding8968'><i class='icon-trash simpleoa-fontsize16'></i> </a> "
                }else{
                    oper= "<a href='javascript:void(0);' onclick='getProject("+project.id+")' class='btn btn-small simpleoa-padding8667'><i class='icon-edit simpleoa-fontsize16'></i> </a> "+
                        "<a href='javascript:void(0);' onclick='startProject("+project.id+")' class='btn btn-small simpleoa-padding8867'><i class='icon-play simpleoa-fontsize16'></i> </a> "+
                        "<a href='javascript:void(0);' onclick='delProject("+project.id+","+project.projectstatus+")' class='btn btn-small simpleoa-padding8968'><i class='icon-trash simpleoa-fontsize16'></i> </a> "
                }
                var tr="<tr><td style='text-align: center;'>"
                    + num
                    + " </td> <td style='text-align: center;' title='"
                    + project.projectname+"'>"
                    + project.projectname
                    + " </td> <td style='text-align: center;' title='"
                    + project.projectdec+"'>"
                    + project.projectdec
                    + " </td> <td style='text-align: center;' title='"
                    + project.starttime+"'>"
                    + project.starttime
                    + " </td> <td style='text-align: center;' title='"
                    + project.estimated+"'>"
                    + project.estimated
                    + " </td> <td style='text-align: center;' title='"
                    + projectstatus+"'>"
                    + projectstatus
                    + " </td> <td style='text-align: center;' title='"
                    + endtime+"'>"
                    + endtime
                    + " </td><td class='action-td' style='padding: 2px 2px 2px 6px;'>"
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

function startProject(id){
    if(confirm("确定要重启项目吗？")){
        $.ajax({
            type:"post",
            url:simpleUrl+"/project/startProject.do",
            dataType:"json",
            data:{"id":id},
            success:function (data) {
                if(data.result=="success"){
                    alert("项目重启成功！");
                    getCount();
                    loadTable(pageSize,1);
                }else{
                    alert("项目重启失败！");
                }
            },
            error:function () {
                alert("发生未知错误，请联系管理员！");
            }
        });
    }
}

function stopProject(id){
    if(confirm("确定要终止项目吗？")){
        $.ajax({
            type:"post",
            url:simpleUrl+"/project/stopProject.do",
            dataType:"json",
            data:{"id":id},
            success:function (data) {
                if(data.result=="success"){
                    alert("终止成功！");
                    getCount();
                    loadTable(pageSize,1);
                }else{
                    alert("终止失败！");
                }
            },
            error:function () {
                alert("发生未知错误，请联系管理员！");
            }
        });
    }
}

function delProject(id,status){
    if(status==1){
        alert("项目还没有终止，无法删除项目！");
    }else{
        if(confirm("确定要删除项目吗？")){
            $.ajax({
                type:"post",
                url:simpleUrl+"/project/delProject.do",
                dataType:"json",
                data:{"id":id},
                success:function (data) {
                    if(data.result=="success"){
                        alert("删除成功！");
                        getCount();
                        loadTable(pageSize,1);
                    }else{
                        alert("删除失败！");
                    }
                },
                error:function () {
                    alert("发生未知错误，请联系管理员！");
                }
            });
        }
    }
}

$("#cel").click(function(){
    $("#proid").val("");
    $("#projectname").val("");
    $("#projectdec").val("");
    $("#starttime").val("");
    $("#estimated").val("");
    $("#up").attr("disabled","disabled");
    $("#sub").removeAttr("disabled");
})

function getProject(id) {
    $.ajax({
        type:"post",
        url:simpleUrl+"/project/getProject.do",
        dataType:"json",
        data:{"id":id},
        success:function (data) {
            var project=data.project;
            $("#editproject").html("修改项目");
            $("#up").removeAttr("disabled");
            $("#sub").attr("disabled","disabled");
            $("#proid").val(project.id);
            $("#projectname").val(project.projectname);
            $("#projectdec").val(project.projectdec);
            $("#starttime").val(project.starttime);
            $("#estimated").val(project.estimated);
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
}

//update
$("#up").click(function(){
    var id=$("#proid").val();
    var projectname=$("#projectname").val();
    var projectdec=$("#projectdec").val();
    var starttime=$("#starttime").val();
    var estimated=$("#estimated").val();

    var project={
        "id":id,
        "projectname":projectname,
        "projectdec":projectdec,
        "starttime":starttime,
        "estimated":estimated,
    };
    if(projectname!=null&&projectname!=""){
        $.ajax({
            type:"post",
            url:simpleUrl+"/project/updateProject.do",
            dataType:"json",
            data:project,
            success:function (data) {
                if(data.result=="success"){
                    alert("修改项目成功！");
                    $("#up").attr("disabled","disabled");
                    $("#sub").removeAttr("disabled");
                    $("#projectname").val("");
                    $("#projectdec").val("");
                    $("#starttime").val("");
                    $("#estimated").val("");
                    loadTable(7,1);
                    $("#up").hide();
                }else{
                    alert("修改项目失败，请检查你的输入！");
                }
            },
            error:function () {
                alert("修改项目时发生未知错误，请联系管理员！");
            }
        });
    }else{
        alert("项目名称不能为空！");
    }
});

$("#sub").click(function(){
    var projectname=$("#projectname").val();
    var projectdec=$("#projectdec").val();
    var starttime=$("#starttime").val();
    var estimated=$("#estimated").val();

    var project={
        "projectname":projectname,
        "projectdec":projectdec,
        "starttime":starttime,
        "estimated":estimated,
    };
    if(projectname!=null&&projectname!=""){
        $.ajax({
            type:"post",
            url:simpleUrl+"/project/addProject.do",
            dataType:"json",
            data:project,
            success:function (data) {
                if(data.result=="success"){
                    alert("添加项目成功！");
                    $("#projectname").val("");
                    $("#projectdec").val("");
                    $("#starttime").val("");
                    $("#estimated").val("");
                    loadTable(7,1);
                }else{
                    alert("添加项目失败，请检查你的输入！");
                }
            },
            error:function () {
                alert("添加项目时发生未知错误，请联系管理员！");
            }
        });
    }else{
        alert("项目名称不能为空！");
    }
});
