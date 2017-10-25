<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <jsp:include page="/WEB-INF/jspf/header.jsp" />
    </head>
    <body>
        <div class="container">
            <h1 style="color: red;">Se produjo un Error</h1>        
            <p>
                <strong>Error:</strong><br />
                ${pageContext.exception}
            </p>
            <p>
                <strong>URI:</strong><br />
                ${pageContext.errorData.requestURI}
            </p>
            <p>
                <strong>Código:</strong><br />
                ${pageContext.errorData.statusCode}
            </p>
            <p>
                <strong>Mensaje:</strong><br />
                ${pageContext.exception.message}
            </p>
            <p>
                <strong>Traza:</strong><br />
                <c:forEach items="${pageContext.exception.stackTrace}" var="trace">
                    <span>${trace}</span><br />
                </c:forEach>
        </p>
    </div>
</body>
</html>
