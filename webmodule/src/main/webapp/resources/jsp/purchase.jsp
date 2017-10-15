<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Purchase</title>
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

<div class="row" id="purchaseTitleRow">
    <div class="col-lg-5"></div>
    <div class="col-lg-2">
        <h2 id="purchaseTitle"> Buy Ticket</h2>
    </div>
    <div class="col-lg-5"></div>
</div>

<div class="row" id="purchaseForm">
    <div class="col-lg-5"></div>
    <div class="col-lg-2">
        <form action="/buyTicket" method="post">
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" id="name" name="name" type="text" value=<c:out
                        value="${sessionScope.user.name}"/>/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input class="form-control" id="lastName" name="lastName" type="text" value=<c:out
                        value="${sessionScope.user.lastName}"/>/>
            </div>
            <div class="form-group">
                <label for="birthDate">Birth date</label>
                <input class="form-control" id="birthDate" name="birthDate" type="text" value=<c:out
                        value="${sessionScope.user.birthDate}"/>/>
            </div>
            <div class="form-group">
                <label for="route">Route code</label>
                <input class="form-control" id="route" name="route" type="text" value="bgg"/>
            </div>
            <div class="form-group">
                <label for="stationFrom">Departure station</label>
                <input class="form-control" id="stationFrom" name="stationFrom" type="text" value="bgg"/>
            </div>
            <div class="form-group">
                <label for="stationTo">Arrival station</label>
                <input class="form-control" id="stationTo" name="stationTo" type="text" value="bgg"/>
            </div>
            <div class="form-group">
                <label for="departureDate">departure date</label>
                <input class="form-control" id="departureDate" name="departureDate" type="text" value="bgg"/>
            </div>
            <div class="form-group">
                <label for="arrivalDate">Arrival date</label>
                <input class="form-control" id="arrivalDate" name="arrivalDate" type="text" value="bgg"/>
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-danger btn-lg">Buy</button>
            </div>
        </form>
    </div>
    <div class="col-lg-5"></div>
</div>

</body>
</html>
