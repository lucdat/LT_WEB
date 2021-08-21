<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>index</title>
</head>
<body>
  <form:form method="POST" action="uploadFile" enctype="multipart/form-data" modelAttribute="myFile">
    File: <input type="file" name="multipartFile" /> <br /> <br/>
    Description: <form:input path="description"/> <br />
    <input type="submit" value="Submit" />
  </form:form>
</body>
</html>