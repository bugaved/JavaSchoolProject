<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>

<div class="container" id="loginForm">

    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-3">
            <form action="/validateForm">
                <div class="form-group" align="left">
                    <label for="name">Email</label>
                    <input id="name" type="email" class="form-control" name="username" placeholder="Enter email">
                </div>
                <div class="form-group" align="left">
                    <label for="password">Password</label>
                    <input id="password" type="password" class="form-control" name="password"
                           placeholder="Enter password">
                </div>

                <div class="row">
                    <div class="col-lg-1"></div>
                    <div class="col-lg-3">
                        <div align="right">
                            <button type="submit" class="btn btn-dark" onclick="goToRegisterPage()">Register</button>
                        </div>
                    </div>
                    <div class="col-lg-1"></div>
                </div>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>


</div>

</body>
</html>
