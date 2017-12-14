<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/changePassword.js"></script>

<h1 class="page-title">
    <i class="icon-lock"></i>
    修改密码
</h1>
<div class="widget" style="margin-bottom:310px">
    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="" method="post"/>
                    <fieldset>
                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="password">旧密码</label>
                            <div class="controls div-left">
                                <input type="password" class="input-medium" id="password" name="password" />
                                <p class="help-block" id="errorPaasword1" style="font-size: 10px!important;color: red!important;"></p>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group">
                            <label class="control-label div-left div-width" for="password2">新密码</label>
                            <div class="controls div-left">
                                <input type="password" class="input-medium" id="password2" name="password2"/>
                                <p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <br /><br /><br />

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