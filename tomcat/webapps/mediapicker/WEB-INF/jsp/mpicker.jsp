<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Media (songs:)</h3>
    <c:forEach items="${model.media}" var="med">
      <c:out value="${med.name}"/><br><br>
    </c:forEach>
  </body>
</html>