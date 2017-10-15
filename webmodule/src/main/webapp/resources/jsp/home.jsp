<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SBB</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
</head>
<body>


<div class="container" id="loginForm">
    <div class="jumbotron-fluid">
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-3">
                <form action="/validateLoginForm" method="post">
                    <div class="form-group" align="left">
                        <label for="email">Email</label>
                        <input id="email" type="email" class="form-control" name="email" placeholder="Enter email">
                    </div>
                    <div class="form-group" align="left">
                        <label for="password">Password</label>
                        <input id="password" type="password" class="form-control" name="password"
                               placeholder="Enter password">
                    </div>

                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="col-lg-3">
                            <div align="left">
                                <button type="submit" class="btn btn-primary">Log In</button>
                            </div>
                        </div>

                        <div class="col-lg-1"></div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4"></div>
        </div>
    </div>

</div>

<div class="col-lg-3">
    <div align="right">
        <button type="submit" class="btn btn-dark" onclick="goToRegisterPage()">Register</button>
    </div>
</div>


</body>
</html>
