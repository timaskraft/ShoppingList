<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Регистрация</title>
        <!-- Подключение Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
    <div class="container mt-5">
        <h2>Регистрация</h2>
          <div class="card p-4 shadow">
            <form id="registrationForm" action="/registration" method="post">
                <div class="form-group">
                <label for="username">Имя пользователя:</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirm_password">Подтвердите пароль:</label>
                <input type="password" class="form-control" id="confirm_password" name="confirm_password" required>
            </div>
            <button type="submit" class="btn btn-primary">Зарегистрироваться</button>
            </form>
          </div>
    </div>

<!-- Подключение Bootstrap JS и зависимостей -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<!-- JavaScript для проверки паролей -->
<script>
    document.getElementById('registrationForm').addEventListener('submit', function(event) {
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirm_password').value;

    if (password !== confirmPassword) {
        event.preventDefault();
        alert('Пароли не совпадают. Пожалуйста, проверьте и попробуйте снова.');
    }
    });
</script>
</body>
</html>