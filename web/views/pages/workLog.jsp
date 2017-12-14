<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/workLog.js"></script>

<h1 class="page-title">
    <i class="icon-list-alt"></i>
    工作日志
</h1>

<div class="widget widget-table">

    <div class="widget-header">
        <i class="icon-list-alt"></i>
        <h3>工作日志</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">

        <table class="table table-striped table-bordered simpleoa-table">
            <thead>
            <tr>
                <th width="5%" style="text-align: center;">编号</th>
                <th width="10%" style="text-align: center;">姓名</th>
                <th width="10%" style="text-align: center;">工作日期</th>
                <th width="25%" style="text-align: center;">工作内容</th>
                <th width="25%" style="text-align: center;">项目名称</th>
                <th width="10%" style="text-align: center;">工作时长</th>
                <th width="10%" style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
        <div class="pagination pagination-centered">
            <ul  id="simpleoapage_wlog">
            </ul>
        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->

<div class="widget widget-table">

    <div class="widget-header">
        <i class="icon-edit"></i>
        <h3>添加工作日志</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="" method="post"/>
                    <fieldset>
                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="jcontent">工作内容</label>
                            <div class="controls div-left">
                                <input type="text" class="input-medium" id="jcontent" name="jcontent" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="projectid">项目名称</label>
                            <div class="controls div-left">
                                <select class="input-medium" id="projectid" name="projectid" >
                                </select>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="workdate">工作日期</label>
                            <div class="controls div-left">
                                <input type="date" class="input-medium" id="workdate" name="workdate" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="cdescribe">内容描述</label>
                            <div class="controls div-left">
                                <textarea type="text" class="input-medium" id="cdescribe" name="cdescribe" style="width: 330px;height: 100px;"></textarea>
                                <!--<p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>-->
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="worktime">工作时间</label>
                            <div class="controls div-left">
                                <input type="number" class="input-medium" id="worktime" name="worktime" min="0" max="24" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="summary">小结</label>
                            <div class="controls div-left">
                                <textarea type="text" class="input-medium" id="summary" name="summary" style="width: 330px;height: 100px;"></textarea>
                                <p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <br /><br />

                        <div class="form-actions">
                            <button type="button" class="btn btn-primary" id="sub" style="margin-left: 150px">保存</button>
                            <button type="button" class="btn" id="cel">取消</button>
                        </div> <!-- /form-actions -->
                    </fieldset>
                    </form>
                </div>

            </div>

        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->
