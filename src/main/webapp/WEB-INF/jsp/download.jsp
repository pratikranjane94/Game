<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
			Game Name:<input type=text name="gameName" size="100" value="${gameName}"> <br/>
			</br>
			Package name:<input type=text name="packageName" size="100" value="${packageName}"> <br/>
			 <br/>
			Download Link:<input type=text name="downloadLink" size="100" value="${link}">  <br/>
			Click to Download  <br/>
			<a href="${link}"><input type="submit" value="download" ></a>
			<h1>${msg}</h1>
	</center>
</body>
</html>