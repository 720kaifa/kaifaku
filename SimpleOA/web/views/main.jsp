<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% String path = request.getContextPath(); %>
<% String base = "http://" + request.getServerName()+":"+request.getServerPort(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="pages/common/head.jsp"></jsp:include>
    <title>SimpleOA</title>
</head>
<body>
<jsp:include page="pages/common/header.jsp"></jsp:include>

<div id="content">

    <div class="container">

        <div class="row">

                <jsp:include page="pages/common/menu.jsp"></jsp:include>

                <div class="span9" id="span9">
                    <jsp:include page="pages/dashbo.jsp"></jsp:include>
                </div> <!-- /span9 -->

        </div> <!-- /row -->

    </div> <!-- /container -->

</div> <!-- /content -->

<jsp:include page="pages/common/footer.jsp"></jsp:include>
</body>
</html>
