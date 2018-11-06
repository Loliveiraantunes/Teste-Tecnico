<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SumOne - Gestão de Biblioteca</title>
         <link rel="stylesheet" href="assets/css/layout.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
        <link rel="shortcut icon" href="assets/img/logo.png" type="image/x-icon"/>
         <script>
            if (window.location.href === "http://localhost:8080/OrdenacaoBiblioteca/") {
                window.location.href = "/OrdenacaoBiblioteca/app?c=acervos";
            }
        </script>
    </head>
    <body>
        <div class="top">
            <h1>Gestão Biblioteca</h1>
        </div>
        <div class="nav">

        </div>
        <div class="container">
          <h2>Lista de Acervos da SumOne:</h2>
           <form class="filtro" action="app?c=filter" method="post">
                    <div class="item_form">
                        <select name="title_filter">
                            <option value="">-- Título --</option>
                            <option value="asc">Ascendente</option>
                            <option value="desc">Decrescente</option>
                        </select>
                    </div>
                      <div class="item_form">
                        <select name="autor_filter">
                            <option value="">-- Autor --</option>
                            <option value="asc">Ascendente</option>
                            <option value="desc">Decrescente</option>
                        </select>
                    </div>
                     <div class="item_form">
                        <select name="edicao_filter">
                            <option value="">-- Edição --</option>
                            <option value="asc">Ascendente</option>
                            <option value="desc">Decrescente</option>
                        </select>
                    </div>
                    <div class="item_form_btn">
                        <input type="submit" value="Pesquisar">
                    </div>
              </form>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Título</th>
                        <th>Autor</th>
                        <th>Edição</th>
                    </tr>
                </thead>
                <tbody>
                    <c:if test="${empty acervos}">
                            <tr>
                                <td>-- --</td>
                                <td>-- --</td>
                                <td>-- --</td>
                            </tr>
                    </c:if>  
                    
                    <c:if test="${!empty acervos}">
                        <c:forEach items="${acervos}" var="livro">
                            <tr>
                                <td>${livro.titulo}</td>
                                <td>${livro.autor}</td>
                                <td>${livro.edicao}</td>
                            </tr>
                        </c:forEach>
                    </c:if>  
                </tbody>
            </table>
        </div>

        <div class="rodape">

        </div>
    </body>
</html>
