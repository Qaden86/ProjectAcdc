<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добро пожаловать в приключение!</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<h1>Добро пожаловать в захватывающее приключение!</h1>
<p>Почувствуйте древний запах таинственности, окружающий вас, когда вы открываете глаза в темнице, утопающей во мраке.
    Здесь, в этом месте забытых снов, начинается ваше приключение - путешествие, которое будет испытанием вашего
    мужества, интеллекта и воли.</p>
<p>Впереди вас ждут неизведанные тайны и опасности, поджидающие на каждом шагу. Но не отступайте - ведь именно сейчас вы
    можете стать героем собственной саги, воплотив в жизнь самые дерзкие мечты и желания.</p>
<p>Вы готовы к вызову? Введя имя своего персонажа ниже, вы начнете ваше путешествие к свободе и славе. Не бойтесь
    собственной силы - внутри вас живет истинный герой!</p>
<form action="${pageContext.request.contextPath}/stageOne" method="post">
    <label for="characterName">Введите имя своего персонажа:</label>
    <input type="text" id="characterName" name="characterName" required><br><br>
    <button type="submit">Начать приключение</button>
</form>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>
<img src="https://sotni.ru/wp-content/uploads/2023/08/temnitsa-zeidan-2.webp" alt="Темница" class="center-image">
</body>
</html>
