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
<section>
    <h1>Registration</h1>
</section>
<@security.authorize access="isAuthenticated()">
    response.sendRedirect("/")
</@security.authorize>
<@spring.bind "user"/>
<@spring.bind "phoneNumbers"/>
<#--TODO contextPath-->
<form action="/phonebooks/registration" method="POST">
    Username:<br>
    <@spring.formInput "user.username"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Password:<br>
    <@spring.formInput fieldType="password" path="user.password"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Confirm password:<br>
    <@spring.formInput fieldType="password" path="user.passwordConfirm"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Surname:<br>
    <@spring.formInput "user.surname"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Details:<br>
    <#list phoneNumbers as phone>
        Country code <input type="number" name="phoneNumbers[${phone_index}].countryCode" value="${phone.countryCode}"/>
        Number <input type="number" name="phoneNumbers[${phone_index}].number" value="${phone.number}"/>
        Phone company <input type="text" name="phoneNumbers[${phone_index}].phoneCompany.name"/>
        <br><br>
    </#list>
    <input type="submit" value="Submit">
</form>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>