<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <a class="brand" href="./">SimpleOA System</a>
            <div class="nav-collapse">
                <ul class="nav pull-right">
                    <!--
                    <li>
                        <a href="#"><span class="badge badge-warning">7</span></a>
                    </li>
                    -->
                    <li class="divider-vertical"></li>
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle " href="#">${simpleoa_user.getRelname()}<b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#" onclick="changeClass($('#personinf a'),'<%=base+path%>/views/pages/updateUser.jsp')"><i class="icon-user"></i>个人信息</a>
                            </li>
                            <li>
                                <a href="#" onclick="changeClass($('#personinf a '),'<%=base+path%>/views/pages/changePassword.jsp')"><i class="icon-lock"></i> 修改密码</a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="<%=path %>/user/logout.do"><i class="icon-off"></i> 退出登录</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div> <!-- /nav-collapse -->
        </div> <!-- /container -->
    </div> <!-- /navbar-inner -->
</div>
