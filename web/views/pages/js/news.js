$(document).ready(function(){
    //getCount();
    //loadTable(pageSize,1);
    setPage(1,"simpleoapage_news");
    $("#up").attr("disabled","disabled");
});

function getCount(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/news/getCount.do",
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
        url:simpleUrl+"/news/newsList.do?number=Math.random()",
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
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}

$("#cel").click(function(){
    $("#noticeid").val("");
    $("#title").val("");
    $("#ncontent").val("");
    $("#istop").val("");
});

$("#cel").click(function(){
    $("#newsid").val("");
    $("#title").val("");
    $("#ncontent").val("");
    $("#istop").attr("checked", false);
})

$("#sub").click(function(){
    var title=$("#title").val();
    var ncontent=$("#ncontent").val();
    var istop=$("input[name='istop']:checked").val();

    if(istop==""||istop==null){
        istop=2;
    }
    var news={
        "title":title,
        "content":ncontent,
        "istop":istop,
    };
    if(title!=null&&title!=""){
        window.wxc.xcConfirm("确定要添加公告吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/news/addNews.do",
                dataType:"json",
                data:news,
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("公告添加成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#newsid").val("");
                        $("#title").val("");
                        $("#ncontent").val("");
                        $("#istop").attr("checked", false);
                        //loadTable(7,1);
                    }else{
                        window.wxc.xcConfirm("公告添加失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                    }
                },
                error:function () {
                    window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                }
            });
        }});
    }else{
        window.wxc.xcConfirm("公告标题不能为空！！！", window.wxc.xcConfirm.typeEnum.info);
    }
});
