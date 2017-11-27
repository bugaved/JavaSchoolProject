<%--
  Created by IntelliJ IDEA.
  User: bugav
  Date: 08.10.2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Trains list</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/sbb.css"/>
</head>

<body>

<jsp:include page="header.jsp"></jsp:include>

<div id="trainLogo">Trains</div>

<div id="trains" class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <table id="trainsTable" class="table table-striped table-bordered table-hover">
            <thead id="trainsTableHead">
            <tr>
                <th>Route Code</th>
                <th>Departure Station</th>
                <th>Arrival Station</th>
                <th>Departure Time</th>
                <th>Arrival Time</th>
                <th>Distance</th>
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
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${train.departureTime}"></fmt:formatDate></td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${train.arrivalTime}"></fmt:formatDate></td>
                    <td>${train.distanсe}</td>
                    <td>${train.seatsCount}</td>
                    <td>
                        <button type="submit" class="btn-danger"
                                onclick="window.location.href='/purchase?code=${train.code}&stationFrom=${train.stationFrom}&stationTo=${train.stationTo}&departureTime=<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${train.departureTime}"></fmt:formatDate>&arrivalTime=<fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${train.arrivalTime}"></fmt:formatDate>'">
                            Purchase
                        </button>
                    </td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="col-2"></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
<script src="${pageContext.request.contextPath}/resources/scripts/trains.js"></script>
</body>
</html>
