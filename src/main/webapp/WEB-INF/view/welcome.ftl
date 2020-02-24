<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <@security.authorize access="isAuthenticated()">
        <h1>HI, <@security.authentication property="principal.username"/></h1>
    </@security.authorize>
    <@security.authorize access="!isAuthenticated()">
        <h1>HI, <@security.authentication property="principal"/></h1>
    </@security.authorize>
</header>
<@security.authorize access="!isAuthenticated()">
    <h4><a href="${springMacroRequestContext.contextPath}/login">Login</a></h4>
    <h4><a href="${springMacroRequestContext.contextPath}/register">Signup</a></h4>
</@security.authorize>
<@security.authorize access="isAuthenticated()">
    <h4><a href="${springMacroRequestContext.contextPath}/user/<@security.authentication property="principal.username"/>">User details</a></h4>
    <@security.authorize access="hasRole('BOOKING_MANAGER')">
        <h4><a href="${springMacroRequestContext.contextPath}/manager/users">Admin panel</a></h4>
    </@security.authorize>
    <h4><a href="${springMacroRequestContext.contextPath}/logout">Logout</a></h4>
</@security.authorize>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>