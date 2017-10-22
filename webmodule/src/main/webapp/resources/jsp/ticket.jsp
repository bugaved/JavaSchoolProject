<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your ticket</title>
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

<div class="row" id="purchaseForm">
    <div class="col-lg-2"></div>
    <div class="col-lg-8">
        <div id="ticketTitle"><h2>Your Ticket</h2></div>
        <table id="ticketTable" class="table table-striped table-bordered table-hover">
            <thead id="ticketTableHead">
            <tr>
                <th>Name</th>
                <th>Last Name</th>
                <th>Train Number</th>
                <th>Departure Station</th>
                <th>Arrival Station</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
            </tr>
            </thead>
            <tbody>

            <tr class id="ticketTableBody">
                <td>${name}</td>
                <td>${lastName}</td>
                <td>${route}</td>
                <td>${stationFrom}</td>
                <td>${stationTo}</td>
                <td>${departureDate}</td>
                <td>${arrivalDate}</td>
            </tr>

            </tbody>
        </table>
    </div>
    <div class="col-lg-2"></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
