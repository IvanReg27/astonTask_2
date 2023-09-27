<%--
  Created by IntelliJ IDEA.
  User: Ivan
  Date: 27.09.2023
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Management Application</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: tomato">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> User Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Users</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${user != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${user == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${user != null}">
                                Edit User
                            </c:if>
                            <c:if test="${user == null}">
                                Add New User
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="employeeId" value="<c:out value='${user.employeeId}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>FirstName</label> <input type="text"
                                                        value="<c:out value='${user.firstName}' />" class="form-control"
                                                        name="firstName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>LastName</label> <input type="text"
                                                         value="<c:out value='${user.lastName}' />" class="form-control"
                                                         name="lastName">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label> <input type="text"
                                                           value="<c:out value='${user.email}' />" class="form-control"
                                                           name="email">
                    </fieldset>

                        <fieldset class="form-group">
                            <label>PhoneNumber</label> <input type="text"
                                                        value="<c:out value='${user.phoneNumber}' />" class="form-control"
                                                        name="phoneNumber">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>HireDate</label> <input type="text"
                                                               value="<c:out value='${user.hireDate}' />" class="form-control"
                                                               name="hireDate">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>JobId</label> <input type="text"
                                                            value="<c:out value='${user.jobId}' />" class="form-control"
                                                            name="jobId">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Salary</label> <input type="text"
                                                         value="<c:out value='${user.salary}' />" class="form-control"
                                                         name="salary">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>CommissionPct</label> <input type="text"
                                                         value="<c:out value='${user.commissionPct}' />" class="form-control"
                                                         name="commissionPct">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>ManagerId</label> <input type="text"
                                                                value="<c:out value='${user.managerId}' />" class="form-control"
                                                                name="managerId">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>DepartmentId</label> <input type="text"
                                                             value="<c:out value='${user.departmentId}' />" class="form-control"
                                                             name="departmentId">
                        </fieldset>


                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
