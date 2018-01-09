<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <link href="<%=base + path %>/views/css/pages/login.css" rel="stylesheet" />
  <jsp:include page="pages/common/head.jsp"></jsp:include>
  <title>登录</title>

  <script>
      $(document).ready(function(){
          $("input").focus(function(){
              $("#errorMessage").html("");
          });

          $("#loginButton").click(function(){
              var account=$("#account").val();
              var password=$("#password").val();
              if((account!=null&&account!="")&&(password!=null&&password!="")){
                  $.ajax({
                      type:"post",
                      url:"<%=base + path %>/user/login.do",
                      dataType:"json",    //data传递的是一个json类型的值，而不是字符串，且必须标明dataType的类型，否则会出现400错误或者其他错误。
                      data:{"account":account,"password":password},
                      success:function (data) {
                          if(data.result=="success"){
                              window.location.href='<%=base + path %>/main/toMain.do';
                          }
                          if(data.result=="passworderror"){
                              $("#errorMessage").html("用户名或密码错误！");
                          }
                          if(data.result=="accounterror"){
                              $("#errorMessage").html("该用户不存在！");
                          }
                      },
                      error:function () {
                          window.wxc.xcConfirm("发生未知错误，请联系管理员！！！", window.wxc.xcConfirm.typeEnum.warning);
                      }
                  });
              }else{
                  if(account==null||account==""){
                      $("#errorMessage").html("用户名不能为空！");
                  }
                  if(password==null||password==""){
                      $("#errorMessage").html("密码不能为空！");
                  }
              }
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


<div id="login-container">
  <div id="login-header">
    <h3>登录</h3>
  </div> <!-- /login-header -->
  <div id="login-content" class="clearfix">
    <fieldset>
      <div class="control-group">
        <label class="control-label" for="account">用户名</label>
        <div class="controls">
          <input type="text" class="" id="account" name="account"/>
        </div>
      </div>
      <div class="control-group">
        <label class="control-label" for="password">密码</label>
        <div class="controls">
          <input type="password" class="" id="password" name="password"/>
        </div>
      </div>
    </fieldset>

    <div id="remember-me" class="pull-left">
      <p class="help-block" id="errorMessage" style="font-size: 10px!important;color: red!important;"></p>
    </div>

    <div class="pull-right">
      <button type="submit" class="btn btn-warning btn-large" id="loginButton">
        登录
      </button>
    </div>
  </div> <!-- /login-content -->
</div> <!-- /login-wrapper -->
<jsp:include page="pages/common/footer.jsp"></jsp:include>
</body>
</html>



