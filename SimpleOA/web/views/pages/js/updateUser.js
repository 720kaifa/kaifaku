$(document).ready(function(){
    getUser();
    $("#cel").attr("disabled","disabled");
    $("#sub").attr("disabled","disabled");
    $(".controls input").attr("disabled","disabled");
});

$("#cel").click(function(){
    $("#cha").removeAttr("disabled");
    $("#cel").attr("disabled","disabled");
    $("#sub").attr("disabled","disabled");
    $(".controls input").attr("disabled","disabled");
});

$("#cha").click(function(){
    $(".controls input").removeAttr("disabled");
    $("#sub").removeAttr("disabled");
    $("#cel").removeAttr("disabled");
    $("#cha").attr("disabled","disabled");
    $("#account").attr("disabled","disabled");
    $("#relname").attr("disabled","disabled");
});

$("#sub").click(function() {
    var user={
        "account":$("#account").val(),
        "relname":$("#relname").val(),
        "gender":$("input[name='gender']:checked").val(),
        "birthday":$("#birthday").val(),
        "address":$("#address").val(),
        "email":$("#email").val(),
        mphone:$("#mphone").val(),
        "qq":$("#qq").val(),
        "wx":$("#wx").val(),
        "interest":$("#interest").val()
    };
    $.ajax({
        type:"post",
        url:simpleUrl+"/user/updateUser.do",
        dataType:"json",
        data:user,
        success:function (data) {
            if(data.result=="success"){
                getUser();
                $("#cha").removeAttr("disabled");
                $("#cel").attr("disabled","disabled");
                $("#sub").attr("disabled","disabled");
                $(".controls input").attr("disabled","disabled");
                alert("保存成功！");
            }else{
                alert("保存失败！");
            }
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
});

function getUser(){
    $.ajax({
        type:"post",
        url:simpleUrl+"/user/getUser.do",
        dataType:"json",
        success:function (data) {
            var user=data.user;
            $("#account").val(user.account);
            $("#relname").val(user.relname);
            $("input[name='gender'][value="+user.gender+"]").attr("checked",true);
            $("#birthday").val(user.birthday);
            $("#address").val(user.address);
            $("#email").val(user.email);
            $("#mphone").val(user.mphone);
            $("#qq").val(user.qq);
            $("#wx").val(user.wx);
            $("#interest").val(user.interest);
        },
        error:function () {
            alert("发生未知错误，请联系管理员！");
        }
    });
}
