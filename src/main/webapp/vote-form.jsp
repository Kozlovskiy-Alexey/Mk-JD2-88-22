<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>Vote page</title>
</head>
<body>
<h1>Прими участие в голосовании!</h1>
<hr>
<form accept-charset="UTF-8" method="post" action="${pageContext.request.contextPath}/vote_page">

    <h2>Выберите лучшего исполнителя:</h2>
    <hr>

    <h3><label><input type="radio" name="artist" value="${requestScope.artists[0]}"/><c:out
            value="${requestScope.artists[0]}"/></label></h3>
    <h3><label><input type="radio" name="artist" value="${requestScope.artists[1]}"/><c:out
            value="${requestScope.artists[1]}"/></label></h3>
    <h3><label><input type="radio" name="artist" value="${requestScope.artists[2]}"/><c:out
            value="${requestScope.artists[2]}"/></label></h3>
    <h3><label><input type="radio" name="artist" value="${requestScope.artists[3]}"/><c:out
            value="${requestScope.artists[3]}"/></label></h3>
    <hr>

    <h2>Выберите 3-5 лучших жанра музыки:</h2>
    <hr>

    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[0]}"><c:out
            value="${requestScope.genres[0]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[1]}"><c:out
            value="${requestScope.genres[1]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[2]}"><c:out
            value="${requestScope.genres[2]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[3]}"><c:out
            value="${requestScope.genres[3]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[4]}"><c:out
            value="${requestScope.genres[4]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[5]}"><c:out
            value="${requestScope.genres[5]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[6]}"><c:out
            value="${requestScope.genres[6]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[7]}"><c:out
            value="${requestScope.genres[8]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[8]}"><c:out
            value="${requestScope.genres[8]}"/> </label></h3>
    <h3><label><input type="checkbox" name="genre" value="${requestScope.genres[9]}"><c:out
            value="${requestScope.genres[9]}"/> </label></h3>

    <input type="submit" name="vote" value="голосовать">

</form>
</body>
</html>
