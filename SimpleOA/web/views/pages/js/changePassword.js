
$(document).ready(function(){
    $("#errorPaasword").html("");
    $("#sub").attr('disabled','disabled');
});

$('#sub').click(function () {
    var oldpassword=$("#password").val();
    var newpassword=$("#password2").val();
    if((oldpassword!=null&&newpassword!=null)&&(oldpassword!=""&&newpassword!="")){
        $("#errorPaasword").html("");
        $.ajax({
            type:"post",
            url:simpleUrl+"/user/changePassword.do",
            dataType:"json",
            data:{"password":newpassword},
            success:function (data) {
                if(data.result=="success"){
                    alert("修改成功！");
                    $("#password").val("");
                    $("#password2").val("");
                }else{
                    alert("修改失败，请检查你的输入！");
                }
            },
            error:function () {
                alert("修改密码时发生未知错误，请联系管理员！");
            }
        });
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