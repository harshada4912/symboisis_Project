<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     
     <form action="/insert1" method="post"> 


 Book Id :<input type="number" name="bookId"/>
        Book Title :<input type="text" name="bookTitle"/>
        
      Book Author Name :<input type="text" name="autherName"/>
      
         Book Selling Price :<input type="number" name="sellingPrice"/>
         
            Book Category :<input type="text" name="bookCatagory"/>
            
            Click here <a href="/showAll"> List of Books </a> to see all Available Books.
            
            <input type="submit" >
            </form>

</body>
</html>