<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<link href="<%=base + path %>/views/css/pages/plans.css" rel="stylesheet" />
<link href="<%=base + path %>/views/css/pages/dashboard.css" rel="stylesheet" />

<script src="<%=base + path %>/views/pages/js/dashbo.js"></script>
<h1 class="page-title">
    <i class="icon-home"></i>
    主页
</h1>

<div class="widget">
    <div class="widget-header">
        <h3>最近项目状况</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">

        <div class="pricing-plans plans-3">


        </div> <!-- /pricing-plans -->

    </div> <!-- /widget-content -->

</div> <!-- /widget -->




<div class="row">

    <div class="span5">

        <div class="widget">

            <div class="widget-header">
                <h3>最新通知</h3>
            </div> <!-- /widget-header -->

            <div class="widget-content" id="notice">

            </div> <!-- /widget-content -->

        </div> <!-- /widget -->

    </div> <!-- /span5 -->

    <div class="span4">

        <div class="widget">

            <div class="widget-header" id="news">
                <h3>最新新闻</h3>
            </div> <!-- /widget-header -->
            <div class="widget-content">

            </div> <!-- /widget-content -->

        </div> <!-- /widget -->
    </div> <!-- /span4 -->

</div> <!-- /row -->

