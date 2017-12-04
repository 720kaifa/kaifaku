<%@ page language="java" pageEncoding="UTF-8"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>

<link href="<%=base + path %>/views/css/simpleoa.css" rel="stylesheet" />

<h1 class="page-title">
    <i class="icon-th-large"></i>
    个人信息
</h1>
<div class="widget">
    <div class="widget-content">
        <div class="tabbable">
            <div class="tab-content">
                <div class="tab-pane active">
                    <form id="edit-profile" class="form-horizontal" action="<%=base + path %>/user/register.do" method="post"/>
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
                                <input type="text" class="input-large" id="relname" name="relname" placeholder="您的真实姓名"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="gender">性别</label>
                            <div class="controls div-left">
                                <label class="radio">
                                    <input type="radio" name="gender" value="1" checked="checked" id="gender" />
                                    男
                                </label>
                                <label class="radio">
                                    <input type="radio" name="gender" value="2" />
                                    女
                                </label>
                            </div>
                        </div>

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="birthday">生日</label>
                            <div class="controls div-left">
                                <input type="date" class="input-medium" id="birthday" name="birthday"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="address">住址</label>
                            <div class="controls div-left">
                                <input type="text" class="input-large" id="address" name="address"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="email">电子邮箱</label>
                            <div class="controls div-left">
                                <input type="email" class="input-large" id="email" name="email"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="mphone">移动号码</label>
                            <div class="controls div-left">
                                <input type="text" class="input-large" id="mphone" name="mphone"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="qq">QQ号</label>
                            <div class="controls div-left">
                                <input type="text" class="input-large" id="qq" name="qq"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="wx">微信</label>
                            <div class="controls div-left">
                                <input type="text" class="input-large" id="wx" name="wx"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="interest">爱好</label>
                            <div class="controls div-left">
                                <input type="text" class="input-large" id="interest" name="interest"/>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <br /><br />

                        <div class="control-group div-hidden">
                            <label class="control-label div-left div-width" for="password">密码</label>
                            <div class="controls div-left">
                                <input type="password" class="input-medium" id="password" name="password" />
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

                        <div class="control-group div-hidden">
                            <label class="control-label  div-left div-width" for="password2">确认密码</label>
                            <div class="controls div-left">
                                <input type="password" class="input-medium" id="password2" name="password2"/>
                                <p class="help-block" id="errorPaasword" style="font-size: 10px!important;color: red!important;"></p>
                            </div> <!-- /controls -->
                        </div> <!-- /control-group -->

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
