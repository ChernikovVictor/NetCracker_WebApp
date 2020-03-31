<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Information</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/view/style.css">
</head>

<body>

    <form action="${pageContext.request.contextPath}/update?id=${requestScope.id}" method="post">
        <p>${requestScope.id}</p>
        <p>Откуда: <input type="text" name="newDeparture" value=${requestScope.departure} /></p>
        <p>Куда: <input type="text" name="newDestination" value=${requestScope.destination} /></p>
        <p>Время отправления: <input type="text" name="newDepartureTime" value=${requestScope.departureTime} /></p>
        <p>Время прибытия: <input type="text" name="newArrivalTime" value=${requestScope.arrivalTime} /></p>
        <p>Транспорт: <input type="text" name="newTransportKind" value=${requestScope.transportKind} /></p>

        <p><input type="submit" value="Сохранить изменения"></p>
    </form>

</body>
</html>
