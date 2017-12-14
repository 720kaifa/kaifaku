<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/menu.js"></script>

<div class="span3">
<div class="account-container">

    <div class="account-avatar">
        <img src="<%=base+path%>/views/img/headshot.png" alt="" class="thumbnail" />
    </div> <!-- /account-avatar -->

    <div class="account-details">
        <span class="account-name">${simpleoa_user.getRelname()}</span>
        <span class="account-role">${simpleoa_user.getRole()}</span>
        <span class="account-actions"><a href="#" onclick="changeClass($('#personinf a'),'<%=base+path%>/views/pages/updateUser.jsp')">个人信息</a> | <a href="javascript:;">设置</a></span>
    </div> <!-- /account-details -->
</div> <!-- /account-container -->

<hr />

<ul id="main-nav" class="nav nav-tabs nav-stacked">

</ul>

</div> <!-- /span3 -->