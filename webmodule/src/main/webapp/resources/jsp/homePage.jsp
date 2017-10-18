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

<c:set var="user" scope="session" value="${user}"/>
<c:set var="stationList" scope="session" value="${stations}"/>

<datalist id="stationList">
    <c:forEach items="${sessionScope.stationList}" var="station">
        <option>${station.stationName}</option>
    </c:forEach>
</datalist>

<jsp:include page="header.jsp"></jsp:include>


<div class="container-fluid" id="trainScheduleFormContainer">
    <div class="row">
        <div class="col-lg-1"></div>
        <div class="col-lg-3">
            <form action="/findTrains" method="post">
                <div class="form-group">
                    <input id="stationFrom" type="text" class="form-control" name="stationFrom" list="stationList"
                           placeholder="Enter Departure Station">
                </div>
                <div class="form-group">
                    <input id="stationTo" type="text" class="form-control" name="stationTo" list="stationList"
                           placeholder="Enter Arrival Station">
                </div>
                <div class="form-group">
                    <input id="travelDate" type="date" class="form-control" name="travelDate"
                           placeholder="Enter Travel Date">
                </div>
                <button type="submit" class="btn btn-dark">Submit</button>
                <button type="button" class="btn btn-dark" onclick="goToSchedule()">Schedule</button>
                <c:choose>
                    <c:when test="${user.admin}">
                        <button id="adminButton" type="button" class="btn btn-dark" onclick="goToAdminPage()">Admin Menu</button>
                    </c:when>
                </c:choose>
            </form>
        </div>
        <div class="col-lg-8"></div>
    </div>

</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
