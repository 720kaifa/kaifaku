<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<link href="<%=base + path %>/views/css/simpleoa.css" rel="stylesheet" />

<script>
    $(document).ready(function(){
        $("#errorPaasword").html("");
        $("#sub").attr('disabled',false);
    });

    $('#sub').click(function () {
        var oldpassword=$("#password").val();
        var newpassword=$("#password2").val();
        if((oldpassword!=null&&newpassword!=null)&&(oldpassword!=""&&newpassword!="")){
            $("#errorPaasword").html("");
            $.ajax({
                type:"post",
                url:"<%=base + path %>/user/changePassword.do",
                dataType:"json",
                data:{"password":newpassword},
                success:function (data) {
                    if(data.result=="success"){
                        alert("修改成功！");
                        changeClass($("#personinf"),'<%=base+path%>/views/pages/account.jsp');
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
            $("#sub").attr('disabled',false);
        }
    });

    $('#password').blur(function(){
        var password=$("#password").val();
        if(password!="${simpleoa_user.getPassword()}"){
            $("#errorPaasword1").html("旧密码输入有误，请重新输入！");
            $("#sub").attr('disabled',true);
        }else{
            $("#errorPaasword1").html("");
            $("#sub").attr('disabled',false);
        }
    });

    $('#password2').blur(function(){
        var password=$("#password").val();
        var password2=$("#password2").val();
        if(password==password2){
            $("#errorPaasword").html("两次密码输入不能相同，请重新输入！");
            $("#sub").attr('disabled',true);
        }else{
            $("#errorPaasword").html("");
            $("#sub").attr('disabled',false);
        }
    });
</script>

<h1 class="page-title">
    <i class="icon-lock"></i>
    修改密码
</h1>
<style>
    .div-hidden{
        overflow:hidden;
    }
    .div-left{
        float:left;
    }
    .div-width{
        width: 145px;
        margin-right: 20px;
        text-align:right;
        line-height: 28px;
    }
</style>
<div class="row">
    <div class="span9">
        <div class="widget">
            <div class="widget-content">
                <div class="tabbable">
                    <div class="tab-content">
                        <div class="tab-pane active">
                            <form id="edit-profile" class="form-horizontal" action="<%=base + path %>/user/register.do" method="post"/>
                            <fieldset>
                                <div class="control-group div-hidden">
                                    <label class="control-label div-left div-width" for="password">旧密码</label>
                                    <div class="controls div-left">
                                        <input type="password" class="input-medium" id="password" name="password" />
                                        <p class="help-block" id="errorPaasword1" style="font-size: 10px!important;color: red!important;"></p>
                                    </div> <!-- /controls -->
                                </div> <!-- /control-group -->

                                <div class="control-group">
                                    <label class="control-label div-left div-width" for="password2">新密码</label>
                                    <div class="controls div-left">
                                        <input type="password" class="input-medium" id="password2" name="password2"/>
                                        <p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>
                                    </div> <!-- /controls -->
                                </div> <!-- /control-group -->

                                <br />

                                <div class="form-actions">
                                    <button type="button" class="btn btn-primary" id="sub" style="margin-left: 150px">保存</button>
                                    <button type="button" class="btn" id="cel">关闭</button>
                                </div> <!-- /form-actions -->
                            </fieldset>
                            </form>
                        </div>

                    </div>

                </div>

            </div> <!-- /widget-content -->

        </div> <!-- /widget -->

    </div> <!-- /span9 -->

</div> <!-- /row -->