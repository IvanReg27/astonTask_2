<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 01.10.2023
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <title>Person Management Application</title>
  <link rel="stylesheet"
        href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
</head>
<body>

<header>
  <nav class="navbar navbar-expand-md navbar-dark"
       style="background-color: #7d7d79">
    <div>
      <a href="https://github.com/IvanReg27" class="navbar-brand"> Java Rest API (Servlet+JDBC+MySQL) </a>
    </div>

    <ul class="navbar-nav">
      <li><a href="<%=request.getContextPath()%>/list"
             class="nav-link">Users</a></li>
    </ul>
  </nav>
</header>
<br>

<div class="row">

  <div class="container">
    <h3 class="text-center">List of Persons</h3>
    <hr>
    <br>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>User_Id</th>
        <th>City_Id</th>
      </tr>
      </thead>
      <tbody>

      <c:forEach var="person" items="${listPerson}">

      <tr>
        <td><c:out value="${person.id}" /></td>
        <td><c:out value="${person.user_id}" /></td>
        <td><c:out value="${person.city_id}" /></td>
        </c:forEach>

      </tbody>

    </table>
  </div>
</div>
</body>
</html>