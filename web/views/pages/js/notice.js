$(document).ready(function(){
    getCount();
    loadTable(pageSize,1);
    setPage(1,"simpleoapage_notice");
    $("#up").attr("disabled","disabled");
});

function getCount(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/notice/getCount.do",
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
        url:simpleUrl+"/notice/noticeList.do?number=Math.random()",
        dataType:"json",
        async: false,
        data:{"pageSize":pageSize,"pageNum":pageNum},
        success:function (data) {
            $(".table-striped tbody").html("");
            for(var i=0;i<data.noticeList.length;i++){
                var notice=data.noticeList[i];
                var num=i+1;
                var istop=(notice.istop==1)?"是":"否";
                var oper="<a href='javascript:void(0);' onclick='getNotice("+notice.id+")' class='btn btn-small simpleoa-padding8667'><i class='icon-edit simpleoa-fontsize16'></i> </a> "+
                        "<a href='javascript:void(0);' onclick='delNotice("+notice.id+")' class='btn btn-small simpleoa-padding8968'><i class='icon-trash simpleoa-fontsize16'></i> </a> "
                var tr="<tr><td style='text-align: center;'>"
                    + num
                    + " </td> <td style='text-align: center;' title='"
                    + notice.title+"'>"
                    + notice.title
                    + " </td> <td style='text-align: center;' title='"
                    + notice.content+"'>"
                    + notice.content
                    + " </td> <td style='text-align: center;' title='"
                    + istop+"'>"
                    + istop
                    + " </td> <td style='text-align: center;' title='"
                    + notice.CREATE_TIME+"'>"
                    + notice.CREATE_TIME
                    + " </td> <td style='text-align: center;' title='"
                    + notice.CREATE_USER+"'>"
                    + notice.CREATE_USER
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
    $("#istop").attr("checked", false);
})

$("#sub").click(function(){
    var title=$("#title").val();
    var ncontent=$("#ncontent").val();
    var istop=$("input[name='istop']:checked").val();

    if(istop==""||istop==null){
        istop=2;
    }

    var notice={
        "title":title,
        "content":ncontent,
        "istop":istop,
    };
    if(title!=null&&title!=""){
        window.wxc.xcConfirm("确定要添加公告吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/notice/addNotice.do",
                dataType:"json",
                data:notice,
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("公告添加成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#noticeid").val("");
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