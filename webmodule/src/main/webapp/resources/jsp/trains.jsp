<%--
  Created by IntelliJ IDEA.
  User: bugav
  Date: 08.10.2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div id="trainsContainer" class="container">
    <div class="row">
        <div class="col-1"></div>
        <div class="col-10">
            <table id="trainsTable" class="table table-striped table-bordered table-hover">
                <thead id="trainsTableHead">
                <tr>
                    <th>Route Code
                    <th>Departure Station</th>
                    <th>Arrival Station</th>
                    <th>Departure Time</th>
                    <th>Arrival Time</th>
                    <th>Seats Count</th>
                    <th></th>
                </tr>
                </thead>

                <tbody>

                <c:forEach items="${trains}" var="train">
                    <tr class id="trainsTableBody">
                        <td>${train.code}</td>
                        <td>${train.stationFrom}</td>
                        <td>${train.stationTo}</td>
                        <td>${train.departureTime}</td>
                        <td>${train.arrivalTime}</td>
                        <td>${train.seatsCount}</td>
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
