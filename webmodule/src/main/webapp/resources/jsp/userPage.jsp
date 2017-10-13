<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

<div class="container">

    <div class="row">
        <div class="col-xs-3">
            <form action="/findTrains">
                <div class="form-group">
                    <input id="stationFrom" type="text" class="form-control" name="stationFrom"
                           placeholder="Enter Departure Station">
                </div>
                <div class="form-group">
                    <input id="stationTo" type="text" class="form-control" name="stationTo"
                           placeholder="Enter Arrival Station">
                </div>
                <div class="form-group">
                    <input id="travelDate" type="date" class="form-control" name="travelDate"
                           placeholder="Enter Travel Date">
                </div>
                <button type="submit" class="btn btn-info">Submit</button>
            </form>
        </div>
    </div>

    <div class="row">
        <div class="col-xs-3">
            <form action="/findStationWaypoints">
                <div class="form-group">
                    <input id="stationName" type="text" class="form-control" name="stationName"
                           placeholder="Enter Station">
                </div>
                <div class="form-group">
                    <input id="waypointDate" type="date" class="form-control" name="waypointDate"
                           placeholder="Enter Date">
                </div>
                <button type="submit" class="btn btn-info">Submit</button>
            </form>
        </div>
    </div>

</div>

</body>
</html>
