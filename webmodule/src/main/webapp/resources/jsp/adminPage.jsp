<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.12.4.js"></script>
    <script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-grid.css"/>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap-reboot.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/admin.css"/>
    <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/resources/scripts/sbb.js"></script>
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
                <li><a href="#fragment-5"><span>View Routes</span></a></li>
            </ul>
            <div id="fragment-1">

                <div class="row">
                    <div class="col-lg-2">
                        <form action="/createStation" method="post">
                            <div class="form-group" align="left">
                                <label for="stationName">Station Name</label>
                                <input id="stationName" type="text" class="form-control" name="stationName"
                                       placeholder="Enter Station Name">
                            </div>
                            <div class="form-group" align="left">
                                <label for="lattitude">Lattitude</label>
                                <input id="lattitude" type="text" class="form-control" name="lattitude"
                                       placeholder="Enter Lattitude">
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
                    <div class="col-lg-2"></div>
                    <div class="col-lg-9"></div>
                </div>
            </div>
            <div id="fragment-2">
                <div class="row">
                    <div class="col-lg-2">
                        <form action="/createTrain" method="post">
                            <div class="form-group" align="left">
                                <label for="trainName">Train Name</label>
                                <input id="trainName" type="text" class="form-control" name="trainName"
                                       placeholder="Enter Train Name">
                            </div>
                            <div class="form-group" align="left">
                                <label for="trainNumber">Train Number</label>
                                <input id="trainNumber" type="text" class="form-control" name="trainNumber"
                                       placeholder="Enter Train Number">
                            </div>

                            <div class="form-group" align="left">
                                <label for="seatsCount">Seats Count</label>
                                <input id="seatsCount" type="text" class="form-control" name="seatsCount"
                                       placeholder="Enter Seats Count">
                            </div>

                            <div class="form-group" align="left">
                                <button type="submit" class="btn btn-dark">Add Train</button>
                            </div>

                        </form>
                    </div>
                    <div class="col-lg-2"></div>
                    <div class="col-lg-9"></div>
                </div>
            </div>
            <div id="fragment-3">
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
            </div>
            <div id="fragment-4">
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
                Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut
                laoreet
                dolore magna aliquam erat volutpat.
            </div>
        </div>

        <script>
            $("#tabs").tabs();
        </script>
        <jsp:include page="footer.jsp"></jsp:include>
    </c:when>
    <c:otherwise>
        <jsp:include page="header.jsp"></jsp:include>
        <h1>Not Admin</h1>
        <jsp:include page="footer.jsp"></jsp:include>
    </c:otherwise>
</c:choose>

</body>
</html>