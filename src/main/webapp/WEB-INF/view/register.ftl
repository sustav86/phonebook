<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<#import "/spring.ftl" as spring/>
<html xmlns:form="http://www.w3.org/1999/html" xmlns:Username="http://java.sun.com/jsf/composite">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>Registration</h1>
</header>
<@security.authorize access="isAuthenticated()">
    response.sendRedirect("/")
</@security.authorize>
<form action="${springMacroRequestContext.contextPath}/register" method="post">
    Username:<br>
    <@spring.formInput "userForm.username"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password:<br>
    <@spring.formInput fieldType="password" path="userForm.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Confirm password:<br>
    <@spring.formInput fieldType="password" path="userForm.passwordConfirm"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Manager:<br>
    <@spring.formCheckbox path="userForm.manager"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Details:<br><br>
    First name:<br>
    <@spring.formInput "userForm.firstName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Last name:<br>
    <@spring.formInput "userForm.lastName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <#list userForm.phones as phone>
        Country code <input type="number" name="phones[${phone_index}].countryCode" value="${phone.countryCode}"/>
        Number <input type="number" name="phones[${phone_index}].number" value="${phone.number}"/>
        Phone company <input type="text" name="phones[${phone_index}].phoneCompany.name"/>
        <br><br>
    </#list>
    <input type="submit" value="Register">
</form>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>