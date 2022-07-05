<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
            integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
            crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <title>Авторизация</title>
</head>
<body>
<div class="container">
    <div class="row">
        <c:if test="${not empty errorMessage}">
            <div style="color:red; font-weight: bold; margin: 30px 0;">
                    ${errorMessage}
            </div>
        </c:if>
    </div>
</div>
<div class="container pt-2">
    <div class="row">
        <div class="card" style="width: 40%">
            <div class="card-header" style="font-weight: bold; font-size: larger">
                Авторизация
            </div>
            <div class="card-body">
                <form name='login' action="<c:url value='/login'/>" method='POST'>
                    <div class="form-group">
                        <label for="username" style="font-weight: bold">Username:</label>
                        <input type="text" class="form-control" name="username" id="username" placeholder="Введите ваш логин...">
                    </div>
                    <div class="form-group">
                        <label for="password" style="font-weight: bold">Password:</label>
                        <input type="text" class="form-control" name="password" id="password" placeholder="Введите ваш пароль...">
                    </div>
                    <div class="row">
                        <input name="submit" type="submit" class="btn btn-primary" value="Войти"/>
                        <div class="text-right" style="font-weight: bold">
                            <a class="nav-link" href="<c:url value="/reg"/>">Регистрация</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
