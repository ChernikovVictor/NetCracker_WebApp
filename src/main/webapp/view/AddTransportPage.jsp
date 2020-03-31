<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/view/style.css">
    <title>Add Transport</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/addTransport" method="get">
    <b>Введите информацию о рейсе</b><br>

    <p>
        Откуда:
        <input type="text" name="departure" />
    </p>

    <p>
        Куда:
        <input type="text" name="destination" />
    </p>

    <p>
        Время отправления:
        <input type="text" name="departure_time" />
    </p>

    <p>
        Время прибытия:
        <input type="text" name="arrival_time" />
    </p>

    <p>
        Вид транспорта:
        <input type="text" name="transport_kind" />
    </p>

    <p>
        <input type="submit" name="addToBaseBtn" value="Добавить в базу" />
    </p>

</form>

</body>
</html>
