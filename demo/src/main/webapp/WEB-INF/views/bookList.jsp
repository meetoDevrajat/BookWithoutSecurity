<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

</head>
<body>


<table border="2">
  <thead>
  		
  
  
  
        <td>Book Id</td>
        <td>Title</td>
      </thead>
   <c:forEach var ="tempbook" items = "${books}">
   
   <c:url var= "updateLink" value="/book/updateForm">
  		<c:param name="bookId" value="${tempbook.id}"></c:param>
  	</c:url>
  
  <c:url var = "deleteLink" value="/book/deleteForm">
  
  <c:param name="bookId" value="${tempbook.id}"></c:param>
  
  </c:url>
   
   
   
   <tr>
   <td>${tempbook.id}</td>
    <td>${tempbook.title}</td>
   <td>
   <a href="${updateLink}">Update</a>
     <a href="${deleteLink}">Delete</a>
    
   </td>
   
   </tr>
   </c:forEach>
      </table>
      <a href="showForm"><input type="button" value="Add Book" /></a>
         
  <!--  onclick="window.location.href='showForm'-->
</body>
</html>