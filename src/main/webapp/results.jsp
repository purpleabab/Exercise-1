<%@include file="head.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html><body>

<%--TODO Pretty up the results!--%>
<div class="container-fluid">


    <h2>Search Results: </h2>
   <!--${users} -->
    <br/>
    <br/>
    <table border="1" cellpadding="2">
        <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th colspan="2">Birthdate</th>
        <th>&nbsp;</th>
        <th>Age</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td colspan="2">${user.dateOfBirth}</td>
         <td>&nbsp;</td>
            <td>${user.age}</td>
        </tr>
       </c:forEach>
    </table>
</div>
<div>
    <h1>My Search Results:</h1>
       <!-- ${userSearched}
        <br/>firstname [0] should be here: ${userSearched[0].firstName}
        <br/>lastname [0] should be here: ${userSearched[1].lastName}-->
        <table border="1" cellpadding="2">
        <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Birthdate</th>
            <th>Age</th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td>${userSearched[0].firstName}</td>
                <td>${userSearched[0].lastName}</td>
                <td>${userSearched[0].dateOfBirth}</td>
                <td>${userSearched[0].age}</td>
            </tr>
        </tbody>
    </table>
</div>

</body>
</html>
