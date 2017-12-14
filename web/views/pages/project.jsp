<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/project.js"></script>

<h1 class="page-title">
    <i class="icon-align-justify"></i>
    工程项目
</h1>

<div class="widget widget-table" id="projectlist">

    <div class="widget-header">
        <i class="icon-align-justify"></i>
        <h3>项目列表</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">

        <table class="table table-striped table-bordered simpleoa-table">
            <thead>
            <tr>
                <th width="5%" style="text-align: center;">编号</th>
                <th width="15%" style="text-align: center;">项目名称</th>
                <th width="20%" style="text-align: center;">项目描述</th>
                <th width="10%" style="text-align: center;">开始时间</th>
                <th width="10%" style="text-align: center;">预计结束</th>
                <th width="15%" style="text-align: center;">项目状态</th>
                <th width="10%" style="text-align: center;">实际结束</th>
                <th width="15%" style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
        <div class="pagination pagination-centered">
            <ul  id="simpleoapage_project">
            </ul>
        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->

<div class="widget widget-table" id="addproject">

    <div class="widget-header">
        <i class="icon-edit"></i>
        <h3 id="editproject">添加项目</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="" method="post"/>
                    <fieldset>
                        <input type="hidden" id="proid" name="proid">
                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="projectname">项目名称</label>
                            <div class="controls div-left">
                                <input type="text" class="input-medium" id="projectname" name="projectname" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="projectdec">项目描述</label>
                            <div class="controls div-left">
                                <textarea class="input-medium" id="projectdec" name="projectdec"  style="width: 330px;height: 100px"></textarea>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="starttime">开始时间</label>
                            <div class="controls div-left">
                                <input type="date" class="input-medium" id="starttime" name="starttime" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="estimated">预计结束时间</label>
                            <div class="controls div-left">
                                <input type="date" class="input-medium" id="estimated" name="estimated" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->


                        <br /><br />

                        <div class="form-actions">
                            <button type="button" class="btn btn-primary" id="sub" style="margin-left: 150px">保存</button>
                            <button type="button" class="btn btn-primary" id="up">修改</button>
                            <button type="button" class="btn" id="cel">取消</button>
                        </div> <!-- /form-actions -->
                    </fieldset>
                    </form>
                </div>

            </div>

        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->
