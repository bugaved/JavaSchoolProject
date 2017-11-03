<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Schedule page</title>
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


<div id="scheduleLogo">Station Schedule</div>

<div id="schedule" class="row">
    <div class="col-lg-1"></div>
    <div class="col-lg-2">
        <form action="/findStationSchedule">
            <div class="form-group">
                <input id="stationName" type="text" class="form-control" name="stationName" list="stationList"
                       placeholder="Enter Station">
            </div>
            <div class="form-group">
                <input id="waypointDate" type="date" class="form-control" name="scheduleDate"
                       placeholder="Enter Date">
            </div>
            <div class="form-group">
                <select name="scheduleOption">
                    <option>Departures</option>
                    <option>Arrivals</option>
                </select>
            </div>
            <button type="submit" class="btn btn-dark">Find</button>
        </form>
    </div>
    <div class="col-lg-8">
        <table id="trainsTable" class="table table-striped table-bordered table-hover">
            <thead id="trainsTableHead">
            <tr>
                <th>Route Code
                <th>Station name</th>
                <th>Time</th>
                <th>Direction</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items= "${schedule}" var="schedule">
                <tr class id="trainsTableBody">
                    <td>${schedule.code}</td>
                    <td>${schedule.stationName}</td>
                    <td>${schedule.requestedTime}</td>
                    <td>${schedule.firstStation} - ${schedule.lastStation}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
    <div class="col-lg-1"></div>
</div>

</body>

</html>
