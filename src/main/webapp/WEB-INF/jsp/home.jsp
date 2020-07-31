<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.java.dto.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<% 
Account a1 = (Account) request.getAttribute("account1");
Account a2 = (Account) request.getAttribute("account2");%>
</head>
<body>
<table border="1">
	<tr>
		<td width="50px">ID</td>
		<td width="50px">Balance</td>
	</tr>
	<tr>
		<td><%=a1.getAccountNumber() %></td>
		<td><%=a1.getBalance() %></td>
	</tr>
	<tr>
		<td><%=a2.getAccountNumber() %></td>
		<td><%=a2.getBalance() %></td>
	</tr>
</table>	
<h2>----------------</h2>
Transfer Money
<form action="transfer" method="post">
Account from: <input type="number" name="accFrom"/>
Account To: <input type="number" name="accTo"/>
Money <input type="number" name="value"/>
<input type="submit" value=transfer />
</form>
<h2>----------------</h2>
WithDrow Money
<form action="withdraw" method="post">
Account from: <input type="number" name="accFrom"/>
Money <input type="number" name="value"/>
<input type="submit" value=withdrow />
</form>
<h2>----------------</h2>
Deposit Money
<form action="deposit" method="post">
Account from: <input type="number" name="accFrom"/>
Money <input type="number" name="value"/>
<input type="submit" value=deposit />
</form>
</body>
</html>