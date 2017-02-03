<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>

<%@include file="init.jsp"%>

<table class="user-table">
    <tr>
        <th>Name</th>
        <th>Email</th>
    </tr>
    <%--@elvariable id="userList" type="java.util.List"--%>
    <c:forEach items="${userList}" var="userList">
        <tr>
            <td>${userList.name}</td>
            <td>${userList.email}</td>
        </tr>
    </c:forEach>
</table>
