<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
s

<form action="saveBook" method="Post" modelAttribute="book">
<h2>Book Information</h2>


  Book id<br>
  <input type="text" name="id" value="${book.id}" required readonly  ><br>

  Title:<br>
  <input type="text" name="title" value="${book.title }" required>
  <br><br>
  <input type="submit"  value="Submit">

</form>
</body>
</html>