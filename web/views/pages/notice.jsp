<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/notice.js"></script>

<h1 class="page-title">
    <i class="icon-gift"></i>
    公告管理
</h1>

<div class="widget widget-table" id="noticelist">

    <div class="widget-header">
        <i class="icon-gift"></i>
        <h3>公告列表</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">

        <table class="table table-striped table-bordered simpleoa-table">
            <thead>
            <tr>
                <th width="5%" style="text-align: center;">编号</th>
                <th width="15%" style="text-align: center;">公告题目</th>
                <th width="25%" style="text-align: center;">公告内容</th>
                <th width="10%" style="text-align: center;">是否置顶</th>
                <th width="15%" style="text-align: center;">创建时间</th>
                <th width="15%" style="text-align: center;">创建人</th>
                <th width="15%" style="text-align: center;">操作</th>
            </tr>
            </thead>

            <tbody>
            </tbody>
        </table>
        <div class="pagination pagination-centered">
            <ul  id="simpleoapage_notice">
            </ul>
        </div>
    </div> <!-- /widget-content -->

</div> <!-- /widget -->

<div class="widget widget-table" id="addNotice">

    <div class="widget-header">
        <i class="icon-edit"></i>
        <h3 id="editnotice">添加公告</h3>
    </div> <!-- /widget-header -->

    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="" method="post"/>
                    <fieldset>
                        <input type="hidden" id="noticeid" name="noticeid">
                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="title">公告标题</label>
                            <div class="controls div-left">
                                <input type="text" class="input-medium" id="title" name="title" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="ncontent">新闻内容</label>
                            <div class="controls div-left">
                                <textarea class="input-medium" id="ncontent" name="ncontent"  style="width: 330px;height: 100px"></textarea>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->


                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="istop">是否置顶</label>
                            <div class="controls div-left">
                                <label class="checkbox">
                                    <input type="checkbox" name="istop" value="1" id="istop" />
                                </label>
                            </div>
                        </div>

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

