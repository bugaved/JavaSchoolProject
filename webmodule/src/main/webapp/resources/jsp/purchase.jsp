<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

<jsp:include page="header.jsp"></jsp:include>

<div class="row" id="purchaseTitleRow">
    <div class="col-lg-5"></div>
    <div class="col-lg-2">
        <h2 id="purchaseTitle"> Passenger Info</h2>
    </div>
    <div class="col-lg-5"></div>
</div>

<div class="row" id="purchaseForm">
    <div class="col-lg-5"></div>
    <div class="col-lg-2">

        <form>
            <div class="form-group">
                <label for="name">Name</label>
                <input class="form-control" required id="name" name="name" type="text"/>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <input class="form-control" required id="lastName" name="lastName" type="text"/>
            </div>
            <div class="form-group">
                <label for="birthDate">Birth date</label>
                <input class="form-control" required id="birthDate" name="birthDate" type="date"/>
            </div>
            <div class="form-group">
                <label for="route">Train number</label>
                <input class="form-control" id="route" name="route" type="text" readonly value="${code}"/>
            </div>
            <div class="form-group">
                <label for="stationFrom">Departure station</label>
                <input class="form-control" id="stationFrom" name="stationFrom" type="text" readonly
                       value="${stationFrom}"/>
            </div>
            <div class="form-group">
                <label for="stationTo">Arrival station</label>
                <input class="form-control" id="stationTo" name="stationTo" type="text" readonly value="${stationTo}"/>
            </div>
            <div class="form-group">
                <label for="departureDate">Departure date</label>
                <input class="form-control" id="departureDate" name="departureDate" type="text" readonly
                       value="${departureTime}"/>
            </div>
            <div class="form-group">
                <label for="arrivalDate">Arrival date</label>
                <input class="form-control" id="arrivalDate" name="arrivalDate" type="text" readonly
                       value="${arrivalTime}"/>
            </div>
            <div class="form-group">
                <label for="price">Price</label>
                <input class="form-control" id="price" name="price" type="text" readonly value="${price} RUB"/>
            </div>
            <div class="form-group">
                <button type="button" class="btn btn-danger btn-lg" onclick="buyTicket()">Buy</button>
            </div>
        </form>
    </div>
    <div class="col-lg-5"></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
