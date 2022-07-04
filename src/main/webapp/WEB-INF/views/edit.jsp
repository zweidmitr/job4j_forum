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
    <title>Создание темы</title>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand"><h4> Форум job4j</h4></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
                <a class="nav-item nav-link " href='<c:url value="/"/>'>Главная страница</a>
                <%--                <a class="nav-item nav-link " href='<c:url value="/create"/>'>Добавить инцидент</a>--%>
            </div>
        </div>
    </nav>
    <div class="container-fluid">
        <div class="card mb-4">
            <form action="<c:url value="/save"/> " method="post">
                <c:if test="${not empty post}">
                    <input type="hidden" name="id" value="${post.id}">
                </c:if>
                <div class="card-header">
                    <div class="card-body">
                        <p><input type="text" class="form-control" name="name" value="${post.name}"></p>
                        <p><textarea class="form-control" name="description" rows="5" >${post.description}</textarea></p>
                    </div>
                </div>
                <div class="card-footer">
                    <div class="px-4 pt-3 text-right">
                        <button type="submit" class="btn btn-primary">
                            <i class="ion ion-md-create"></i>
                            Сохранить
                        </button>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>


</body>
</html>
