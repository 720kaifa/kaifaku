<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<script src="<%=base + path %>/views/pages/js/addUser.js"></script>

<h1 class="page-title">
    <i class="icon-plus"></i>
    添加用户
</h1>
<div class="widget" style="margin-bottom:310px">
    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action= method="post"/>
                        <fieldset>
                            <div class="control-group div-hidden">
                                <label class="control-label div-left div-width" for="account">用户名</label>
                                <div class="controls div-left">
                                    <input type="text" class="input-large" id="account"  name="account" placeholder="系统登录账号"/>
                                    <p class="help-block" id="errorMessage" style="font-size: 10px!important;color: red!important;"></p>
                                </div> <!-- /controls -->
                            </div> <!-- /control-group -->

                            <div class="control-group div-hidden">
                                <label class="control-label div-left div-width" for="relname">真实姓名</label>
                                <div class="controls div-left">
                                    <input type="text" class="input-large" id="relname" name="relname" placeholder="真实姓名"/>
                                </div> <!-- /controls -->
                            </div> <!-- /control-group -->

                            <div class="control-group div-hidden">
                                <label class="control-label div-left div-width" for="role">角色</label>
                                <div class="controls  div-left">
                                    <label class="radio">
                                        <input type="radio" name="role" value="AdminUser" id="role" />
                                        管理员
                                    </label>
                                    <label class="radio">
                                        <input type="radio" name="role" value="OrdinaryUser" checked="checked"/>
                                        普通用户
                                    </label>
                                </div>
                            </div>

                            <br />

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