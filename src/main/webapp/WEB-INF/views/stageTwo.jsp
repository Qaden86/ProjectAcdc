<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Приключение: Темница</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
    <!-- Подключение внешнего файла стилей -->
</head>
<body>
<div class="container">
    <h2 style="text-align: center;">Давайте попробуем исследовать темницу, а вдруг повезет!</h2>
    <img src="https://pictures.pibig.info/uploads/posts/2023-04/thumbs/1681159270_pictures-pibig-info-p-temnitsa-narisovannaya-instagram-16.jpg"
         alt="Темница" class="center-image">
    <div class="row justify-content-center">
        <div class="col-md-4 text-center">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Исследовать пол</h5>
                    <p class="card-text">Вы видите смутные очертания какого-то предмета на полу</p>
                    <a href="${pageContext.request.contextPath}/stageThree" class="btn btn-primary">Выбрать</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 text-center">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Исследовать стену</h5>
                    <p class="card-text">Вам кажется, что есть какой-то лаз в стене</p>
                    <a href="javascript:void(0);" onclick="showPopupAndRedirect();" class="btn btn-primary">Выбрать</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="exampleModalLabel">Не верный ответ!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Ваша рука застряла в узком лазе стены, и вы не можете двигаться. Видимо, это не тот путь, который
                приведет вас к свободе.
            </div>
        </div>
    </div>
</div>

<script>
    function showPopupAndRedirect() {
        $('#myModal').modal('show');
        setTimeout(function () {
            window.location.href = "${pageContext.request.contextPath}/lost";
        }, 4000);
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>