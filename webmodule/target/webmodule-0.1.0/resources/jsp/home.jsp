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

<div class="container">

    <div class="row" id="loginForm">
        <div class="col-xs-4">
            <form action="/validateForm">
                <div class="form-group">
                    <label for="name">Name</label>
                    <input id="name" type="text" class="form-control" name="name" placeholder="Enter name">
                </div>
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input id="lastName" type="text" class="form-control" name="lastName" placeholder="Enter Last Name">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" name="password" placeholder="Enter password">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
    </div>
</div>


</body>
</html>
