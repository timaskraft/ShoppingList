<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Product Management</title>
        <!-- Подключение Bootstrap CSS -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    </head>
<body>
    <div class="container mt-5">
        <h2>Управление продуктами</h2>
            <div class="card p-4 shadow">
                <form action="/secure/products" method="post">
                    <div class="form-group">
                        <label for="name">Название продукта:</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                <div class="form-group">
                    <label for="imageUrl">Изображение:</label>
                    <input type="text" class="form-control" id="imageUrl" name="imageUrl" required>
                </div>
            <button type="submit" class="btn btn-primary">Добавить продукт</button>
            </form>
    </div>

    <h3 class="mt-5">Список продуктов</h3>
    <table class="table table-striped mt-3">
        <thead>
            <tr>
                <th>ID</th>
                <th>Название</th>
                <th>URL изображения</th>
                <th>Действия</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${requestScope.userProducts}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td><img src="${product.imageUrl}" class="img-fluid" style="max-width: 100px; height: auto;"/></td>
                <td>
                    <form action="/secure/products" method="post" style="display:inline;">
                        <input type="hidden" name="_method" value="DELETE"/>
                        <input type="hidden" name="productId" value="${product.id}">
                        <button type="submit" name="action" value="delete" class="btn btn-danger btn-sm">Удалить</button>
                    </form>
                </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<!-- Подключение Bootstrap JS и зависимостей -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>