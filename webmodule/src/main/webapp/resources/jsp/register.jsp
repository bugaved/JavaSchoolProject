<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
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

<jsp:include page="header.jsp"></jsp:include>

<div class="container" id="regForm">
    <div class="jumbotron-fluid">
        <div class="row">
            <div class="col-lg-4"></div>

            <div class="col-lg-3">

                <form action="/registerUser" method="post">
                    <div class="form-group" align="left">
                        <label for="name">Name</label>
                        <input id="name" required type="text" class="form-control" name="name" placeholder="Enter Name">
                    </div>

                    <div class="form-group" align="left">
                        <label for="name">Last Name</label>
                        <input id="lastname" required type="text" class="form-control" name="lastname"
                               placeholder="Enter Last Name">
                    </div>

                    <div class="form-group" align="left">
                        <label for="birthdate">Birth Date</label>
                        <input id="birthdate" required type="date" class="form-control" name="birthdate"
                               placeholder="Enter bithdate">
                    </div>

                    <div class="form-group" align="left">
                        <label for="email">Email</label>
                        <input id="email" required type="email" class="form-control" name="email" placeholder="Enter email">
                    </div>

                    <div class="form-group" align="left">
                        <label for="password">Password</label>
                        <input id="password" required type="password" class="form-control" name="password"
                               placeholder="Enter password">
                    </div>

                    <div class="row">
                        <div class="col-lg-3">
                            <div align="left">
                                <button type="submit" class="btn btn-dark">Register</button>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-4"></div>
        </div>
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
