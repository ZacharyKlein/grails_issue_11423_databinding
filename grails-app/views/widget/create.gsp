<%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 11/25/19
  Time: 6:12 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<h1>Save Widget</h1>
<g:form action="save">

    <label for="productionDate">Production Date</label>
    <input type="text" id="productionDate" name="productionDate" />

    <g:submitButton name="submit" />
</g:form>

</body>
</html>