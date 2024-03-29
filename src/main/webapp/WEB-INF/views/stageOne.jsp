<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Приключение: Темница</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
<div class="container">
    <h1 style="text-align: center;">Приключение начинается, ${characterName}!</h1>
    <h2 style="text-align: center;">Вы оказались в темнице, давайте выбираться отсюда.</h2>
    <img src="https://pictures.pibig.info/uploads/posts/2023-04/thumbs/1681159316_pictures-pibig-info-p-temnitsa-narisovannaya-instagram-6.jpg"
         alt="Темница" class="center-image">
    <div class="row justify-content-center">
        <div class="col-md-4 text-center">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Исследовать темницу</h5>
                    <p class="card-text">Попробовать найти что-то полезное</p>
                    <a href="${pageContext.request.contextPath}/stageTwo" class="btn btn-primary">Выбрать</a>
                </div>
            </div>
        </div>
        <div class="col-md-4 text-center">
            <div class="card mb-4 shadow-sm">
                <div class="card-body">
                    <h5 class="card-title">Попытаться проснуться</h5>
                    <p class="card-text">Это всего лишь дурной сон</p>
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
                К сожалению это не сон!
            </div>
        </div>
    </div>
</div>

<script>
    function showPopupAndRedirect() {
        $('#myModal').modal('show');
        setTimeout(function () {
            window.location.href = "${pageContext.request.contextPath}/lost";
        }, 3000);
    }
</script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
