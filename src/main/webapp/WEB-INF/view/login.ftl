<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>Login to account</h1>
</header>
<@security.authorize access="isAuthenticated()">
    response.sendRedirect("/")
</@security.authorize>
<#--TODO-->
<#--<form method="POST" action="${springMacroRequestContext.contextPath}/login">-->
<form method="POST" action="/phonebooks/login">
    <table>
        <tr>
            <td>Login</td>
            <td><input name="username" type="text" placeholder="Username" autofocus="true"/></td>
            <td><input name="password" type="password" placeholder="Password"/></td>
            <td><input type="submit" value="Login"/></td>
        </tr>
    </table>
</form>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>