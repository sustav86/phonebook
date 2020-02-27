<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<#import "/spring.ftl" as spring/>
<html xmlns:form="http://www.w3.org/1999/html" xmlns:Username="http://java.sun.com/jsf/composite">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>Change Mobile Company</h1>
</header>
<@security.authorize access="!isAuthenticated()">
    response.sendRedirect("/")
</@security.authorize>
<#if notEnoughMoney??>
    <font color="red">${notEnoughMoney}</font>
    <br><br>
</#if>
<#list user.phones as phone>
    <form action="${springMacroRequestContext.contextPath}/mobiles" method="post">
        Mobile number ${phone.countryCode} ${phone.number}
        Mobile company <input type="text" name="name" value="${phone.phoneCompany.name}"/>
        <input type="hidden" name="id" value="${phone.phoneCompany.id}"/>
        <input type="submit" value="Update">
        <br><br>
    </form>
</#list>
<h4><a href="${springMacroRequestContext.contextPath}/">Home</a></h4>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>