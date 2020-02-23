<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>HI, <@security.authentication property="principal"/></h1>
</header>
<#--<section>-->
<#--    <h1>Message : ${message}</h1>-->
<#--</section>-->
<@security.authorize access="!isAuthenticated()">
<#--    <@security.authentication property="principal"/>-->
<#--    <@security.authentication property="principal.username"/>-->
<#--    TODO-->
<#--    <h4><a href="/login">Login</a></h4>-->
    <h4><a href="${springMacroRequestContext.contextPath}/login">Login</a></h4>
    <h4><a href="${springMacroRequestContext.contextPath}/registration">Signup</a></h4>
</@security.authorize>
<@security.authorize access="isAuthenticated()">
<#--    <@security.authentication property="principal.username"/>-->
    <h4><a href="${springMacroRequestContext.contextPath}/user/<@security.authentication property="principal.username"/>">Personal details</a></h4>
    <@security.authorize access="hasRole('ADMIN')">
        <h4><a href="${springMacroRequestContext.contextPath}/manager">Admin panel</a></h4>
    </@security.authorize>
    <h4><a href="${springMacroRequestContext.contextPath}/logout">Logout</a></h4>
</@security.authorize>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>