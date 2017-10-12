<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SBB</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
</head>

<body>

<div id="trainsContainer" class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <table id="trainsTable" class="table table-striped table-bordered table-hover">
                <thead id="trainsTableHead">
                <tr>
                    <th>Route Code
                    <th>Train name</th>
                    <th>Station name</th>
                    <th>Departure Time</th>
                    <th>Arrival Time</th>
                    <th>Seats Count</th>
                    <th></th>
                </tr>
                </thead>

                <tbody>

                <c:forEach items="${waypoints}" var="waypoint">
                    <tr class id="trainsTableBody">
                        <td>${waypoint.code}</td>
                        <td>${waypoint.stationName}</td>
                        <td>${waypoint.arrivalTime}</td>
                        <td>${waypoint.departureTime}</td>
                        <td>${waypoint.trainName}</td>
                        <td>${waypoint.seatsCount}</td>
                        <td>
                            <button class="btn-info btn-md">Purchase</button>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="col-1"></div>
    </div>
</div>

</body>
</html>
