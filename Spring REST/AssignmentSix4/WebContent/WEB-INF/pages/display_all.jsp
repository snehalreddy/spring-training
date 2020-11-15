<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	<h1 style="text-align: center;">Library Application</h1>
	<h2 style="text-align: center;">Books available:</h2>

	<center>
		<table style="border: 1px solid black; border-collapse: collapse;">
			<tr>
				<th style="border: 1px solid black; padding: 15px 50px;">Book Name</th>
				<th style="border: 1px solid black; padding: 15px 50px;">Author Name</th>
			</tr>
			<c:forEach items="${library}" var="festival">
				<tr>
					<td style="border: 1px solid black; padding: 15px 50px;">${festival.getValue().getBookName()}</td>
					<td style="border: 1px solid black; padding: 15px 50px;">${festival.getValue().getAuthor()}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <br>

		<form action="allOps" action="get">
			<input type="submit" value="Home" />
		</form>
	</center>
</body>
</html>

