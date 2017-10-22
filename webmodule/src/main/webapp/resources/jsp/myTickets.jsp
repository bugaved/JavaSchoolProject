<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>MyTickets</title>
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

<div id="trains" class="row">
    <div class="col-2"></div>
    <div class="col-8">
        <table id="trainsTable" class="table table-striped table-bordered table-hover">
            <thead id="trainsTableHead">
            <tr>
                <th>Name</th>
                <th>Lastname</th>
                <th>Date of birth</th>
                <th>Train Number</th>
            </tr>
            </thead>

            <tbody>

            <c:forEach items="${tickets}" var="ticket">
                <tr class id="trainsTableBody">
                    <td>${ticket.user.name}</td>
                    <td>${ticket.user.lastName}</td>
                    <td><fmt:formatDate pattern="dd.MM.yyyy" value="${ticket.user.birthDate}"></fmt:formatDate></td>
                    <td>${ticket.route.code}</td>
                </tr>
            </c:forEach>

            </tbody>
        </table>
    </div>
    <div class="col-2"></div>
</div>

<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>
