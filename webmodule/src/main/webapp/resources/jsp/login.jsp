<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
</head>
<body>

<div id="loginLogo">SBB Project</div>


<div id="loginContainer" class="container">
    <div class="jumbotron-fluid">
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4">
                <form id="loginForm" action="/validateLoginForm" method="post">
                    <div class="form-group" align="left">
                        <label for="email">Email</label>
                        <input id="email" required type="email" class="form-control" name="email" placeholder="Enter email">
                    </div>
                    <div class="form-group" align="left">
                        <label for="password">Password</label>
                        <input id="password" required type="password" class="form-control" name="password"
                               placeholder="Enter password">
                    </div>

                    <div class="form-group" align="left">
                        <button type="submit" class="btn btn-dark">Log In</button>
                        <button type="button" class="btn btn-dark" onclick="goToRegisterPage()">Register</button>
                    </div>

                </form>
            </div>
            <div class="col-lg-4"></div>
        </div>
    </div>

</div>

<div class="col-lg-3">
    <div align="right">

    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
