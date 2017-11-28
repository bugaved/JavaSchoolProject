<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin menu</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.12.4.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
</head>
<body>

<c:choose>
    <c:when test="${sessionScope.user.admin}">
        <jsp:include page="header.jsp"></jsp:include>
        <div id="tabs">
            <ul>
                <li><a href="#fragment-1"><span>Add Station</span></a></li>
                <li><a href="#fragment-2"><span>Add Train</span></a></li>
                <li><a href="#fragment-3"><span>Add Waypoint</span></a></li>
                <li><a href="#fragment-4"><span>View Passengers</span></a></li>
                <%--<li><a href="#fragment-5"><span>View Routes</span></a></li>--%>
            </ul>
            <div id="fragment-1">

                <div class="row">
                    <div class="col-lg-3">
                        <form action="/createStation" method="post">
                            <div class="form-group" align="left">
                                <label for="stationName">Station Name</label>
                                <input id="stationName" type="text" class="form-control" name="stationName"
                                       placeholder="Enter Station Name">
                            </div>
                            <div class="form-group" align="left">
                                <label for="latitude">Lattitude</label>
                                <input id="latitude" type="text" class="form-control" name="latitude"
                                       placeholder="Enter Latitude">
                            </div>

                            <div class="form-group" align="left">
                                <label for="longitude">Longitude</label>
                                <input id="longitude" type="text" class="form-control" name="longitude"
                                       placeholder="Enter Longitude">
                            </div>

                            <div class="form-group" align="left">
                                <button type="submit" class="btn btn-dark">Add Station</button>
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-8">
                        <table id="stationTable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Station Name</th>
                                <th>Latitude</th>
                                <th>Longitude</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${actualStations}" var="station">
                                <tr class id="">
                                    <td>${station.stationName}</td>
                                    <td>${station.latitude}</td>
                                    <td>${station.longitude}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="fragment-2">
                <div class="row">
                    <div class="col-lg-3">
                        <form action="/createTrain" method="post">
                            <div class="form-group" align="left">
                                <label for="trainName">Train Name</label>
                                <input id="trainName" required type="text" class="form-control" name="trainName"
                                       placeholder="Enter Train Name">
                            </div>
                            <div class="form-group" align="left">
                                <label for="trainNumber">Train Number</label>
                                <input id="trainNumber" type="text" required class="form-control" name="trainNumber"
                                       placeholder="Enter Train Number">
                            </div>

                            <div class="form-group" align="left">
                                <label for="seatsCount">Seats Count</label>
                                <input id="seatsCount" type="text" required class="form-control" name="seatsCount" placeholder="Enter Seats Count">
                            </div>

                            <div class="form-group" align="left">
                                <button type="submit" class="btn btn-dark">Add Train</button>
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-8">
                        <table id="trainTable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Train Name</th>
                                <th>Train Number</th>
                                <th>Seats count</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${actualTrains}" var="train">
                                <tr class id="">
                                    <td>${train.name}</td>
                                    <td>${train.route.code}</td>
                                    <td>${train.seatsCount}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="fragment-3">
                <div class="row">
                    <div class="col-lg-3">
                        <form action="/createWayPoint" method="post">
                            <div class="form-group" align="left">
                                <label for="wayPointStationName">Station Name</label>
                                <input id="wayPointStationName" required type="text" class="form-control" name="stationName"
                                       placeholder="Enter Station Name">
                            </div>

                            <div class="form-group" align="left">
                                <label for="routeCode">Train Number</label>
                                <input id="routeCode" required type="text" class="form-control" name="routeCode"
                                       placeholder="Enter Train Number">
                            </div>

                            <div class="form-group" align="left">
                                <label for="arrivalTime">Arrival Date</label>
                                <input id="arrivalTime" required type="datetime-local" class="form-control" name="arrivalTime"
                                       placeholder="Enter Arrival Date">
                            </div>

                            <div class="form-group" align="left">
                                <label for="departureTime">Departure Date</label>
                                <input id="departureTime" required type="datetime-local" class="form-control"
                                       name="departureTime" placeholder="Enter Departure Date">
                            </div>

                            <div class="form-group" align="left">
                                <button type="submit" class="btn btn-dark">Add Waypoint</button>
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-8">
                        <table id="waypointTable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Station Name</th>
                                <th>Train Number</th>
                                <th>Arrival time</th>
                                <th>Departure time</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${actualWaypoints}" var="waypoint">
                                <tr class id="">
                                    <td>${waypoint.station.stationName}</td>
                                    <td>${waypoint.route.code}</td>
                                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${waypoint.arrivalTime}"></fmt:formatDate></td>
                                    <td><fmt:formatDate pattern="dd.MM.yyyy HH:mm" value="${waypoint.departureTime}"></fmt:formatDate></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="fragment-4">
                <div class="row">
                    <div class="col-lg-3">
                        <form action="/findPassengersByRoute" method="post">

                            <div class="form-group" align="left">
                                <label for="routeCodeForPassengers">Train Number</label>
                                <input id="routeCodeForPassengers" type="text" class="form-control"
                                       name="routeCodeForPassengers" placeholder="Enter Train Number">
                            </div>

                            <div class="form-group" align="left">
                                <button type="submit" class="btn btn-dark">Find Passengers</button>
                            </div>

                        </form>

                    </div>
                    <div class="col-lg-1"></div>
                    <div class="col-lg-8">
                        <table id="passengerTable" class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>Last Name</th>
                                <th>BirthDate</th>
                                <th>Email</th>
                            </tr>
                            </thead>

                            <tbody>

                            <c:forEach items="${users}" var="user">
                                <tr class id="">
                                    <td>${user.name}</td>
                                    <td>${user.lastName}</td>
                                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${user.birthDate}"></fmt:formatDate></td>
                                    <td>${user.email}</td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <%--<div id="fragment-5">--%>
                <%--<div id="trains" class="row">--%>
                    <%--<div class="col-2"></div>--%>
                    <%--<div class="col-8">--%>
                        <%--<div class="form-group" align="left">--%>
                            <%--<button type="button" class="btn btn-dark" onclick="window.location.href ='/viewRoutes'">--%>
                                <%--Refresh--%>
                            <%--</button>--%>
                        <%--</div>--%>
                        <%--<table id="trainsTable" class="table table-striped table-bordered table-hover">--%>
                            <%--<thead id="trainsTableHead">--%>
                            <%--<tr>--%>
                                <%--<th>Route Code</th>--%>
                                <%--<th>Departure Station</th>--%>
                                <%--<th>Arrival Station</th>--%>
                            <%--</tr>--%>
                            <%--</thead>--%>

                            <%--<tbody>--%>

                            <%--<c:forEach items="${routes}" var="route">--%>
                                <%--<tr class id="trainsTableBody">--%>
                                    <%--<td>${route.code}</td>--%>
                                    <%--<td>${route.stationFrom}</td>--%>
                                    <%--<td>${route.stationTo}</td>--%>
                                <%--</tr>--%>
                            <%--</c:forEach>--%>

                            <%--</tbody>--%>
                        <%--</table>--%>
                    <%--</div>--%>
                    <%--<div class="col-2"></div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>

        <script>
            $("#tabs").tabs();
        </script>
        <jsp:include page="footer.jsp"></jsp:include>
    </c:when>
    <c:otherwise>
        <jsp:include page="header.jsp"></jsp:include>
        <h2>Not Admin</h2>
        <jsp:include page="footer.jsp"></jsp:include>
    </c:otherwise>
</c:choose>

</body>
</html>
