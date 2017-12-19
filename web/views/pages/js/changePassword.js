$(document).ready(function(){
    $("#errorPaasword").html("");
    $("#sub").attr('disabled','disabled');
});

$('#sub').click(function () {
    var oldpassword=$("#password").val();
    var newpassword=$("#password2").val();
    if((oldpassword!=null&&newpassword!=null)&&(oldpassword!=""&&newpassword!="")){
        $("#errorPaasword").html("");
        window.wxc.xcConfirm("确定要修改密码吗？", window.wxc.xcConfirm.typeEnum.confirm,{onOk:function(){
            $.ajax({
                type:"post",
                url:simpleUrl+"/user/changePassword.do",
                dataType:"json",
                data:{"password":newpassword},
                success:function (data) {
                    if(data.result=="success"){
                        window.wxc.xcConfirm("密码修改成功！！！", window.wxc.xcConfirm.typeEnum.success);
                        $("#password").val("");
                        $("#password2").val("");
                    }else{
                        window.wxc.xcConfirm("密码修改失败，请检查你的输入！！！", window.wxc.xcConfirm.typeEnum.error);
                    }
                },
                error:function () {
                    window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                }
            });
        }});
    }else{
        $("#errorPaasword").html("输入不能为空！");
        $("#sub").attr('disabled','disabled');
    }
});

$('#password').blur(function(){
    var password=$("#password").val();
    var password2=$("#password2").val();
    if(password!=simpleUser.passWord){
        $("#errorPaasword1").html("旧密码输入有误，请重新输入！");
        $("#sub").attr('disabled','disabled');
    }else{
        $("#errorPaasword1").html("");
        if(password2!=""&&password2!=null){
            $("#sub").removeAttr("disabled");
        }else{
            $("#sub").attr('disabled','disabled');
        }
    }
});

$('#password2').blur(function(){
    var password=$("#password").val();
    var password2=$("#password2").val();
    if(password==password2){
        $("#errorPaasword").html("两次密码输入不能相同，请重新输入！");
        $("#sub").attr('disabled','disabled');
    }else{
        $("#errorPaasword").html("");
        $("#sub").removeAttr("disabled");
    }
});