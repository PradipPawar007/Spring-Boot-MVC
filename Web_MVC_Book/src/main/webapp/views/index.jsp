<html>
<head>
</head>
<body>
<form action="book">  <!--when we click search it will call getBookById bcz we have provided path we are passing on Action-->
  
  Book Id: <input type = "text" name ="id"/> </br>
  <input type ="Submit" value ="Search" />
  <p>-------------------------------------------------------</p>
  </br>
  Book Price:  ${book.id} </br>
  </br>
  Book Name:  ${book.name} </br>
  </br>
  Book Price:  ${book.price}
</form>
</body>
<html>