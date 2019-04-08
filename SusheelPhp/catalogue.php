<html>
<body>
<?php
$con = @mysqli_connect("localhost","root","");
if (!$con)
  {
  die('Could not connect: ' . mysqli_error());
  }

mysqli_select_db($con,"trial");

$result = mysqli_query($con,"SELECT * FROM trail");    

echo "<table border='1' width='100%'>
<tr>
<th>Snap shot of Cover Page</th>
<th>Book Name <br>Auther Name<br>Publisher</th>
<th>Price</th>
<th>Add to Cart</th>
</tr>";

while($row = mysqli_fetch_array($result))
  {
  echo "<tr>";
  echo "<td><img src='images/". $row['bookname'] . ".jpg' width=50 height=70></td>";
  echo "<td>Book :" . $row['bookname'] . "<br>Author :" . $row['author'] . "<br>Publication :" . $row['publisher'] . "</td>";
  echo "<td>$" . $row['price'] . "</td>";
  echo "<td><img src='images/cart.jpg' width='105px' height='50px' align='middle'> </td>";
  echo "</tr>";
  }
echo "</table>";

mysqli_close($con);
?>
</body>
</html>