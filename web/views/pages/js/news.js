$(document).ready(function(){
    getCount();
    loadTable(pageSize,1);
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
            for(var i=0;i<data.newsList.length;i++){
                var news=data.newsList[i];
                var num=i+1;
                var istop=(news.istop==1)?"是":"否";
                var oper="<a href='javascript:void(0);' onclick='getNews("+news.id+")' class='btn btn-small simpleoa-padding8667'><i class='icon-edit simpleoa-fontsize16'></i> </a> "+
                    "<a href='javascript:void(0);' onclick='delNews("+news.id+")' class='btn btn-small simpleoa-padding8968'><i class='icon-trash simpleoa-fontsize16'></i> </a> "
                var tr="<tr><td style='text-align: center;'>"
                    + num
                    + " </td> <td style='text-align: center;' title='"
                    + news.title+"'>"
                    + news.title
                    + " </td> <td style='text-align: center;' title='"
                    + news.content+"'>"
                    + news.content
                    + " </td> <td style='text-align: center;' title='"
                    + istop+"'>"
                    + istop
                    + " </td> <td style='text-align: center;' title='"
                    + news.CREATE_TIME+"'>"
                    + news.CREATE_TIME
                    + " </td> <td style='text-align: center;' title='"
                    + news.CREATE_USER+"'>"
                    + news.CREATE_USER
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

function delNews(id) {
    window.wxc.xcConfirm("确定要删除新闻吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
        $.ajax({
            type:"post",
            url:simpleUrl+"/news/delNews.do",
            dataType:"json",
            data:{"id":id},
            success:function (data) {
                if(data.result){
                    window.wxc.xcConfirm("新闻删除成功！！！", window.wxc.xcConfirm.typeEnum.success);
                    getCount();
                    loadTable(pageSize,1);
                }else{
                    window.wxc.xcConfirm("新闻删除失败！！！", window.wxc.xcConfirm.typeEnum.error);
                }
            },
            error:function () {
                window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
            }
        });
    }});
}

function getNews(id) {
    $.ajax({
        type:"post",
        url:simpleUrl+"/news/getNews.do",
        dataType:"json",
        data:{"id":id},
        success:function (data) {
            var news=data.news;
            $("#editnews").html("修改新闻");
            $("#up").removeAttr("disabled");
            $("#sub").attr("disabled","disabled");
            $("#newsid").val(news.id);
            $("#title").val(news.title);
            $("#ncontent").val(news.content);
            $("input:checkbox[value='"+news.istop+"']").attr('checked','true');
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
}

$("#cel").click(function(){
    $("#newsid").val("");
    $("#title").val("");
    $("#ncontent").val("");
    $("#istop").attr("checked", false);
})

//update
$("#up").click(function(){
    var id=$("#newsid").val();
    var title=$("#title").val();
    var ncontent=$("#ncontent").val();
    var istop=$("input[name='istop']:checked").val();

    var notice={
        "id":id,
        "title":title,
        "content":ncontent,
        "istop":istop,
    };
    if(title!=null&&title!=""){
        window.wxc.xcConfirm("确定要修改新闻吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/news/updateNews.do",
                dataType:"json",
                data:notice,
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("新闻修改成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#up").attr("disabled","disabled");
                        $("#sub").removeAttr("disabled");
                        $("#newsid").val("");
                        $("#title").val("");
                        $("#ncontent").val("");
                        $("#istop").attr("checked", false);
                        loadTable(7,1);
                    }else{
                        window.wxc.xcConfirm("新闻修改失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                    }
                },
                error:function () {
                    window.wxc.xcConfirm("新闻未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                }
            });
        }});

    }else{
        window.wxc.xcConfirm("新闻标题不能为空！！！", window.wxc.xcConfirm.typeEnum.info);
    }
});

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
        window.wxc.xcConfirm("确定要添加新闻吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/news/addNews.do",
                dataType:"json",
                data:news,
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("新闻添加成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#newsid").val("");
                        $("#title").val("");
                        $("#ncontent").val("");
                        $("#istop").attr("checked", false);
                        loadTable(7,1);
                    }else{
                        window.wxc.xcConfirm("新闻添加失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
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
