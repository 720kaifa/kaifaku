<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="pages/common/head.jsp"></jsp:include>
    <title>注册</title>
    <script>
        $(document).ready(function(){
            $("#errorPaasword").html("");
            $("#sub").attr('disabled',false);
        });
        $(document).ready(function(){
            $('#cel').click(function () {
                var r=confirm("确认退出注册？")
                if(r==true){
                    window.location.href="<%=base + path %>/views/login.jsp"
                }
            });

            $('#sub').click(function () {
                var account=$("#account").val();
                var relname=$("#relname").val();
                var gender=$("#gender").val();
                var birthday=$("#birthday").val();
                var address=$("#address").val();
                var email=$("#email").val();
                var mphone=$("#mphone").val();
                var qq=$("#qq").val();
                var wx=$("#wx").val();
                var interest=$("#interest").val();
                var password=$("#password").val();
                if(account!=null&&account!=""){
                    var user={
                        "account":account,
                        "relname":relname,
                        "gender":gender,
                        "birthday":birthday,
                        "address":address,
                        "email":email,
                        "mphone":mphone,
                        "qq":qq,
                        "wx":wx,
                        "interest":interest,
                        "password":password
                    }
                    $.ajax({
                        type:"post",
                        url:"<%=base + path %>/user/register.do",
                        dataType:"json",
                        data:user,
                        success:function (data) {
                            if(data.result=="success"){
                                alert("注册成功！");
                                window.location.href="<%=base + path %>/views/login.jsp"
                            }else{
                               alert("注册失败，请检查你的输入！");
                            }
                        },
                        error:function () {
                            alert("注册时发生未知错误，请联系管理员！");
                        }
                    });
                }
            });

            $('#password2').blur(function(){
                var password=$("#password").val();
                var password2=$("#password2").val();
                if(password!=password2){
                    $("#errorPaasword").html("两次密码输入不一致，请重新输入！");
                    $("#sub").attr('disabled',true);
                }else{
                    $("#errorPaasword").html("");
                    $("#sub").attr('disabled',false);
                }
            });

            $('#account').blur(function(){
                $.ajax({
                    type:"post",
                    url:"<%=base + path %>/user/checkAccount.do",
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
                        alert("网络错误！");
                    }
                });
            });

            $("#account").focus(function(){
                $("#errorMessage").html("");
            });
        });
    </script>
</head>
<body>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="">Simple OA System</a>
        </div> <!-- /container -->
    </div> <!-- /navbar-inner -->
</div> <!-- /navbar -->

<div id="content">

    <div class="container">

        <div class="row">

            <div class="span9">

                <h1 class="page-title">
                    <i class="icon-th-large"></i>
                    注册
                </h1>

                <div class="row">
                    <div class="span9">
                        <div class="widget">
                            <div class="widget-header">
                                <h3>个人信息</h3>
                            </div> <!-- /widget-header -->
                            <div class="widget-content">
                                <div class="tabbable">
                                    <ul class="nav nav-tabs">
                                        <li class="active"><a href="#" data-toggle="tab">概况</a></li>
                                    </ul>
                                    <br />
                                    <div class="tab-content">
                                        <div class="tab-pane active">
                                            <form id="edit-profile" class="form-horizontal" action="<%=path %>/user/register.do" method="post"/>
                                            <fieldset>
                                                <div class="control-group">
                                                    <label class="control-label" for="account">用户名</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="account"  name="account" placeholder="系统登录账号"/>
                                                        <p class="help-block" id="errorMessage" style="font-size: 10px!important;color: red!important;"></p>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="relname">真实姓名</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="relname" name="relname" placeholder="您的真实姓名"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="gender">性别</label>
                                                    <div class="controls">
                                                        <label class="radio">
                                                            <input type="radio" name="gender" value="1" checked="checked" id="gender" />
                                                            男
                                                        </label>
                                                        <label class="radio">
                                                            <input type="radio" name="gender" value="2" />
                                                            女
                                                        </label>
                                                    </div>
                                                </div>

                                                <div class="control-group">
                                                    <label class="control-label" for="birthday">生日</label>
                                                    <div class="controls">
                                                        <input type="date" class="input-medium" id="birthday" name="birthday"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="address">住址</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="address" name="address"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="email">电子邮箱</label>
                                                    <div class="controls">
                                                        <input type="email" class="input-large" id="email" name="email"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="mphone">移动号码</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="mphone" name="mphone"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="qq">QQ号</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="qq" name="qq"/>
                                                    </div> <!-- /controls -->

                                                </div> <!-- /control-group -->
                                                <div class="control-group">
                                                    <label class="control-label" for="wx">微信</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="wx" name="wx"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="interest">爱好</label>
                                                    <div class="controls">
                                                        <input type="text" class="input-large" id="interest" name="interest"/>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <br /><br />

                                                <div class="control-group">
                                                    <label class="control-label" for="password">密码</label>
                                                    <div class="controls">
                                                        <input type="password" class="input-medium" id="password" name="password" />
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <div class="control-group">
                                                    <label class="control-label" for="password2">确认密码</label>
                                                    <div class="controls">
                                                        <input type="password" class="input-medium" id="password2" name="password2"/>
                                                        <p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>
                                                    </div> <!-- /controls -->
                                                </div> <!-- /control-group -->

                                                <br />

                                                <div class="form-actions">
                                                    <button type="button" class="btn btn-primary" id="sub">保存</button>
                                                    <button type="button" class="btn" id="cel">取消</button>
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

            </div> <!-- /span9 -->

        </div> <!-- /row -->

    </div> <!-- /container -->

</div> <!-- /content -->

<jsp:include page="pages/common/footer.jsp"></jsp:include>

</body>
</html>

