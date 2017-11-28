<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <title>User page</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src=" http://code.jquery.com/jquery-1.8.3.min.js"></script>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/resources/scripts/ajaxQuery.js"></script>
</head>
<body>
<div id="schedule" class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-2">
<form method="get">
    <div class="form-group">
        <input id="name" required type="text"
               placeholder="Name">
    </div>
    <div class="form-group">
        <input id="lastName" required type="text"
               placeholder="LastName">
    </div>

    <button type="button" onclick="ajaxRequest()" class="btn btn-dark">Submit</button>
    </div>
    <div class="col-lg-8">
        <table id="personDataTable" class="table table-striped table-bordered table-hover">
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
        </tr>

    </table>
    </div>
    <div class="col-lg-1"></div>
</div>

</form>
</body>
</html>