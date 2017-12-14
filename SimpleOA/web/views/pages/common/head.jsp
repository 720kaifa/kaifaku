<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="Pragma" CONTENT="no-cache">
<META HTTP-EQUIV="Cache-Control" CONTENT="no-cache">
<META HTTP-EQUIV="Expires" CONTENT="0">

<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="apple-mobile-web-app-capable" content="yes" />

<link href="<%=base + path %>/views/css/bootstrap.min.css" rel="stylesheet" />
<link href="<%=base + path %>/views/css/bootstrap-responsive.min.css" rel="stylesheet" />

<link href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600" rel="stylesheet" />
<link href="<%=base + path %>/views/css/font-awesome.css" rel="stylesheet" />

<link href="<%=base + path %>/views/css/adminia.css" rel="stylesheet" />
<link href="<%=base + path %>/views/css/adminia-responsive.css" rel="stylesheet" />

<script src="<%=base + path %>/views/js/jquery-1.7.2.min.js"></script>
<script src="<%=base + path %>/views/js/bootstrap.js"></script>

<link href="<%=base + path %>/views/css/simpleoa.css" rel="stylesheet" />
<script src="<%=base + path %>/views/pages/js/page.js"></script>
<script>
    var simpleUrl="<%=base + path %>";
    var simpleUser={
        "account":"${simpleoa_user.getAccount()}",
        "relname":"${simpleoa_user.getRelname()}",
        "role":"${simpleoa_user.getRole()}",
        "passWord":"${simpleoa_user.getPassword()}"
    }
</script>
