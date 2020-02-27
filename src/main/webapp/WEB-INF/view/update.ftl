<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<#import "/spring.ftl" as spring/>
<html xmlns:form="http://www.w3.org/1999/html" xmlns:Username="http://java.sun.com/jsf/composite">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>Update</h1>
</header>
<@security.authorize access="!isAuthenticated()">
    response.sendRedirect("/")
</@security.authorize>
<form action="${springMacroRequestContext.contextPath}/manager/users/${user.id}" method="post">
    <input type="hidden" name="_method" value="put"/>
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
    Manager:<br>
    <@spring.formCheckbox path="user.manager"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Details:<br><br>
    First name:<br>
    <@spring.formInput "user.firstName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    Last name:<br>
    <@spring.formInput "user.lastName"/>
    <@spring.showErrors "<br>"/>
    <br><br>
    <#list user.phones as phone>
        Country code <input type="number" name="phones[${phone_index}].countryCode" value="${phone.countryCode}"/>
        Number <input type="number" name="phones[${phone_index}].number" value="${phone.number}"/>
        Phone company <input type="text" name="phones[${phone_index}].phoneCompany.name" value="${phone.phoneCompany.name}"/>
        Price <input type="text" name="phones[${phone_index}].phoneCompany.price" value="${phone.phoneCompany.price}"/>
        User account amount <input type="number" name="phones[${phone_index}].phoneCompany.userAccount.amount" value="${phone.phoneCompany.userAccount.amount}"/>
        <br><br>
    </#list>
    <input type="submit" value="Update">
</form>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>