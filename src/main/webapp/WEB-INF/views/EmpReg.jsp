<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.myerrr{
	color: red;
}
</style>
</head>
<body>
<a href="?lang=en">English</a>
<a href="?lang=hi">Hindi</a>
<a href="?lang=te">Telugu</a>
<a href="?lang=kn">Kannada</a>
<h2><spring:message code="title"/> </h2>
<form:form action="save" method="post" modelAttribute="employee">
<pre>
<spring:message code="ename"/>   : 
<form:input path="empName"/>
<form:errors path="empName" cssClass="myerrr"/>

<spring:message code="egen"/>   : 
<form:radiobutton path="empGen" value="MALE"/> Male
<form:radiobutton path="empGen" value="FEMALE"/> Female
<form:errors path="empGen" cssClass="myerrr"/>

<spring:message code="edept"/>   : 
 <form:select path="empDept">
 	<form:option value="">-SELECT-</form:option>
 	<form:option value="DEV">Dev</form:option>
 	<form:option value="QA">QA</form:option>
 	<form:option value="BA">BA</form:option>
 </form:select>  
<form:errors path="empDept" cssClass="myerrr"/>

<spring:message code="eaddr"/>   : 
<form:textarea path="empAddr"/>
<form:errors path="empAddr" cssClass="myerrr"/>

<spring:message code="elang"/>   : 
<form:checkbox path="empLangs" value="ENG"/>ENG 
<form:checkbox path="empLangs" value="HIN"/>HIN 
<form:checkbox path="empLangs" value="TEL"/>TEL 
<form:checkbox path="empLangs" value="TAM"/>TAM
<form:errors path="empLangs" cssClass="myerrr"/>

	<input type="submit" value="Register"/> 
</pre>
</form:form>

</body>
</html>



