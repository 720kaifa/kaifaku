<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<h1 class="page-title">
    <i class="icon-th-list"></i>
    工作日志
</h1>

<div class="widget widget-table">

    <div class="widget-header">
        <i class="icon-th-list"></i>
        <h3>本月工作日志</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">

        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th>#</th>
                <th>姓名</th>
                <th>日期</th>
                <th>工作内容</th>
                <th>工作时长</th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>
            <tr>
                <td>1</td>
                <td>Michael</td>
                <td>Jordan</td>
                <td>@mjordan</td>
                <td>Chicago Bulls</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>Magic</td>
                <td>Johnson</td>
                <td>@mjohnson</td>
                <td>Los Angeles Lakers</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>3</td>
                <td>Charles</td>
                <td>Barkley</td>
                <td>@cbarkley</td>
                <td>Phoenix Suns</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>4</td>
                <td>Karl</td>
                <td>Malone</td>
                <td>@kmalone</td>
                <td>Utah Jazz</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>5</td>
                <td>David</td>
                <td>Robinson</td>
                <td>@drobinson</td>
                <td>San Antonio Spurs</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>6</td>
                <td>Reggie</td>
                <td>Miller</td>
                <td>@rmiller</td>
                <td>Indiana Pacers</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>7</td>
                <td>Clyde</td>
                <td>Drexler</td>
                <td>@cdrexler</td>
                <td>Portland Trail Blazers</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            <tr>
                <td>8</td>
                <td>Hakeem</td>
                <td>Olajuwon</td>
                <td>@holajuwon</td>
                <td>Houston Rockets</td>
                <td class="action-td">
                    <a href="javascript:;" class="btn btn-small btn-warning">
                        <i class="icon-ok"></i>
                    </a>
                    <a href="javascript:;" class="btn btn-small">
                        <i class="icon-remove"></i>
                    </a>
                </td>
            </tr>
            </tbody>
        </table>

    </div> <!-- /widget-content -->

</div> <!-- /widget -->
