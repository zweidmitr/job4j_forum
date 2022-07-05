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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <title>Описание</title>
</head>
<body>

<div class="container pt-3">
    <div class="card" style="width: 75%">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" ><h4> Форум job4j</h4></a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <%--                <a class="nav-item nav-link active" href="<c:url value="/"/>">Все инциденты</a>--%>
                    <a class="nav-item nav-link " href='<c:url value="/"/>'>Главная страница</a>
                </div>
            </div>
        </nav>
        <div class="container-fluid">
            <div class="card mb-4">
                <div class="card-header">
                    <div class="media-body ml-3">
                        <a>userName</a>
                        <c:set var="dt" value="${post.date}"/>
                        <div class="text-muted small">
                            <c:out value="${dt.year}-${dt.monthValue}-${dt.dayOfMonth}   ${dt.hour}:${dt.minute}"/>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <p><h5>${post.name}</h5></p>
                    <p>${post.description}</p>
                </div>
                <div class="card-footer d-flex flex-wrap justify-content-between align-items-center px-0 pt-0 pb-3">
                    <div>

                    </div>
                    <div class="px-4 pt-3 text-right">

                        <%--                    условие на пользователя--%>
                        <a href="<c:url value="/update/${post.id}"/>" class="btn btn-warning pull-left"
                           role="button">Редактировать</a>
                    </div>
                </div>
            </div>
        </div>


        <button id="1">Ответить</button>
        <divAnswer>
            <div class="card-body">
                <form action="<c:url value="/saveAnswer/${post.id}"/> " method="post">
                    <p><textarea class="form-control" name="text" rows="5"></textarea></p>
                    <button type="submit" class="btn btn-success">
                        <i class="ion ion-md-create"></i>
                        Ответить
                    </button>
                </form>
            </div>
        </divAnswer>
        <script>
            $("divAnswer").toggle()
            $("#1").click(function () {
                $("divAnswer").slideToggle("fast");
            });
        </script>


        <c:forEach var="answ" items="${post.answers}">
        <div class="card mb-4">
            <div class="card-header">
                <div class="media-body ml-3">
                    <a>userName</a>
                    <a>timeFromAnswer</a>
                </div>
            </div>
            <div class="card-body">
                <p>${answ.text}</p>
            </div>
        </div>
    </c:forEach>
    </div>

</div>
</body>
</html>
