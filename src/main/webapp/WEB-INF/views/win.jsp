<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Игра окончена</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container win-container">
    <div class="message">
        <h1>Поздравляем, ${characterName}, вы победили!</h1>
        <img src="https://www.alwaysonpurpose.com/wp-content/uploads/2019/11/happypeople-1024x679.jpg"
             alt="Happy person" class="center-image img-win">
        <p><a href="${pageContext.request.contextPath}/home" class="btn">Начать заново</a></p>
    </div>
</div>
</body>
</html>