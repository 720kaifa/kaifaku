<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/uploadfile.js"></script>

<h1 class="page-title">
    <i class="icon-user"></i>
    修改头像
</h1>
<div class="widget" style="height:560px;">
    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="<%=base + path %>/user/register.do" method="post" enctype="multipart/form-data"/>
                    <fieldset>
                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="headscu">头像</label>
                            <div class="controls div-left">
                                <input type="file" class="input-large" id="headscu" name="headscu"/>
                                <p class="help-block" id="errorMessage" style="font-size: 10px!important;color: red!important;"></p>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <br />

                        <div class="form-actions">
                            <button type="button" class="btn btn-primary" id="sub" style="margin-left: 150px" button>修改</button>
                            <button type="button" class="btn" id="cel">取消</button>
                        </div> <!-- /form-actions -->
                    </fieldset>
                    </form>
                </div>

            </div>

        </div>

    </div> <!-- /widget-content -->

</div> <!-- /widget -->
