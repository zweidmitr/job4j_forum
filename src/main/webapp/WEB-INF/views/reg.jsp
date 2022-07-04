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
<div class="row pt-3">
    <div class="col-sm"></div>
    <div class="col-sm">
        <div class="w-100 card">
            <div class="card-body">
                <div class="alert text center" role="alert">Регистрация</div>
                <form name="reg" action="<c:url value="/reg"/> " method="post">
                    <table>
                        <tr>
                            <td>Логин:</td>
                            <td><input class="form-control" type="text" name="username"></td>
                        </tr>
                        <tr>
                            <td>Пароль:</td>
                            <td><input class="form-control" type="text" name="password"></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td colsapan="2"><input name="submit" type="submit" value="Зарегистрироваться"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="col-sm"></div>
        </div>
    </div>
    <div class="col-sm"></div>
</div>
</body>
</html>

