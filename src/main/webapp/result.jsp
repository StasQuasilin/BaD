<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: szpt-user045
  Date: 26.01.21
  Time: 11:03
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>${test}</title>
</head>
<body>
<div style="display: flex; flex-direction: row">
    <fmt:formatDate value="${begin}" pattern="dd.mm.yyyy HH:MM:ss"/>
    <br>
    <fmt:formatDate value="${end}" pattern="dd.mm.yyyy HH:MM:ss"/>
    <br>
    ${length}
    <c:if test="${valid gt 0}">
        <div>
            <table>
                <tr>
                    <td>
                        Max
                    </td>
                    <td>
                            ${result.max}
                    </td>
                </tr>
                <tr>
                    <td>
                        Min
                    </td>
                    <td>
                            ${result.min}
                    </td>
                </tr>
                <tr>
                    <td>
                        Med
                    </td>
                    <td>
                            ${result.med}
                    </td>
                </tr>
                <tr>
                    <td>
                        Avg
                    </td>
                    <td>
                            ${result.avg}
                    </td>
                </tr>
                <tr>
                    <td>
                        Inc
                    </td>
                    <td>
                            ${result.inc}
                    </td>
                </tr>
                <tr>
                    <td>
                        Dec
                    </td>
                    <td>
                            ${result.dec}
                    </td>
                </tr>
            </table>
        </div>
    </c:if>
    <div>
        Rows count: ${rows}<br>
        Valid rows: ${valid}<br>
        Bad rows:<br>
        <c:forEach items="${wrongs}" var="wrong">
            <div>
                ${wrong}
            </div>
        </c:forEach>
    </div>
</div>


</body>
</html>
