<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<script>
    $(document).ready(function(){
        if("${simpleoa_user.getRole()}"!="Administrator"){
            $("#sysz").hide();
        }
    });

    function changeClass(a,url){
        $("#span9").load(url);
        $(a).parent().siblings().removeClass("active");
        $(a).parent().attr("class", "active");
    }
</script>
<div class="span3">
<div class="account-container">

    <div class="account-avatar">
        <img src="<%=base+path%>/views/img/headshot.png" alt="" class="thumbnail" />
    </div> <!-- /account-avatar -->

    <div class="account-details">
        <span class="account-name">${simpleoa_user.getRelname()}</span>
        <span class="account-role">${simpleoa_user.getRole()}</span>
        <span class="account-actions"><a href="#" onclick="changeClass($('#personinf'),'<%=base+path%>/views/pages/account.jsp')">个人信息</a> | <a href="javascript:;">设置</a></span>
    </div> <!-- /account-details -->
</div> <!-- /account-container -->

<hr />

<ul id="main-nav" class="nav nav-tabs nav-stacked">

    <li class="active">
        <a href="#" onclick="changeClass(this,'<%=base+path%>/views/pages/dashbo.jsp')">
            <i class="icon-home"></i>
            主页
        </a>
    </li>

    <li>
        <a href="#" onclick="changeClass(this,'<%=base+path%>/views/pages/workLog.jsp')">
            <i class="icon-th-list"></i>
            工作日志
        </a>
    </li>

    <li>
        <a href="#" id="personinf"onclick="changeClass(this,'<%=base+path%>/views/pages/account.jsp')">
            <i class="icon-user"></i>
            个人信息
        </a>
    </li>


    <li id="sysz">
        <a href="#" onclick="changeClass(this,'<%=base+path%>/views/pages/mainSetting.jsp')">
            <i class="icon-pushpin"></i>
            首页设置
        </a>
    </li>
</ul>

</div> <!-- /span3 -->