<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Печальное поражение</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container lost-container">
    <h1>Увы, ${characterName}, вы побеждены!</h1>
    <img src="https://png.pngtree.com/png-vector/20221014/ourlarge/pngtree-frustrated-sad-person-hanging-on-tree-png-image_6280502.png"
         alt="Sad person" class="image img-lost">
    <p>Но не отчаивайтесь! <a href="${pageContext.request.contextPath}/home" class="btn">Начать заново</a></p>
</div>
</body>
</html>