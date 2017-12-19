$(document).ready(function(){
    $("#sub").attr('disabled',false);
});

$("#account").blur(function(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/user/checkAccount.do",
        dataType:"json",    //data传递的是一个json类型的值，而不是字符串，且必须标明dataType的类型，否则会出现400错误或者其他错误。
        data:{"account":$("#account").val()},
        success:function (data) {
            if(data.result=="accounterror"){
                $("#errorMessage").html("该用户名已被注册，请重新输入！");
                $("#sub").attr('disabled',true);
            }else{
                $("#errorMessage").html("");
                $("#sub").attr('disabled',false);
            }
        },
        error:function () {
            window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
        }
    });
});

$("#account").focus(function(){
    $("#errorMessage").html("");
});

$("#sub").click(function () {
    var account=$("#account").val();
    var relname=$("#relname").val();
    var role=$('input[name="role"]:checked ').val();

    if(account!=null&&account!=""){
        window.wxc.xcConfirm("确定要添加用户吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/user/addUser.do",
                dataType:"json",
                data:{"account":account, "relname":relname,"role":role},
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("添加用户成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#account").val("");
                        $("#relname").val("");
                    }else{
                        window.wxc.xcConfirm("添加用户失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                    }
                },
                error:function () {
                    window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                }
            });
        }});
    }else{
        $("#errorMessage").html("系统登录名不能为空！");
        $("#sub").attr('disabled',true);
    }
});
