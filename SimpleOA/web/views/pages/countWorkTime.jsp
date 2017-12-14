<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/countWorkTime.js"></script>

<h1 class="page-title">
    <i class="icon-pushpin"></i>
    工时统计
</h1>

<div class="widget widget-table" id="worktimelist">

    <div class="widget-header">
        <i class="icon-pushpin"></i>
        <h3>工时统计</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">
        <table class="table table-striped table-bordered simpleoa-table" style="border-top: 1px solid #DDDDDD">
            <thead>
            <tr>
                <th width="5%" style="text-align: center;">编号</th>
                <th width="15%"  style="text-align: center;">姓名</th>
                <th width="20%"  style="text-align: center;">项目名称</th>
                <th width="15%"  style="text-align: center;">项目状态</th>
                <th width="15%"  style="text-align: center;">本月工时</th>
                <th width="15%"  style="text-align: center;">本周工时</th>
                <th width="15%"  style="text-align: center;">总计工时</th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>

        <div class="pagination pagination-centered">
            <ul  id="simpleoapage_wtl">
            </ul>
        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->

