<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<h1 class="page-title">
    <i class="icon-cog"></i>
    首页设置
</h1>

<div class="row" style="height: 580px;">
    <div class="span5">
        <div class="widget">
            <div class="widget-header">
                <h3>通知</h3>
            </div> <!-- /widget-header -->
            <div class="widget-content">
                <p>今天的任务是洗脚2017-12-30</p>
            </div> <!-- /widget-content -->
        </div> <!-- /widget -->
    </div> <!-- /span5 -->
    <div class="span4">
        <div class="widget">
            <div class="widget-header">
                <h3>新闻</h3>
            </div> <!-- /widget-header -->
            <div class="widget-content">
                <p>今天的任务是洗脚2017-12-30</p>
            </div> <!-- /widget-content -->
        </div> <!-- /widget -->
    </div> <!-- /span4 -->
</div> <!-- /row -->
