<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/header.css"/>
</head>
<body>
<header>
    <div class="container-fluid" id="containerHeader">
        <div class="row">
            <div class="col-lg-1">
                <div id="homeText" onclick="goToHomePage()">Home</div>
            </div>
            <div class="col-lg-4"></div>
            <div class="col-lg-2">
                <div id="sbbLogo">SBB Project</div>
            </div>
            <div class="col-lg-4"></div>
            <div class="col-lg-1">
                <p id="logout" onclick="logout()">Logout</p>
            </div>
        </div>
    </div>
</header>

<script src="${pageContext.request.contextPath}/resources/scripts/header.js"></script>
</body>
</html>
