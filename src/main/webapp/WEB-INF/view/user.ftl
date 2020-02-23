<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1><@security.authentication property="principal.username"/></h1>
</header>
<table>
    <thead>
    <th>ID</th>
    <th>Username</th>
    <th>Manager</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Phones</th>
    <th>Phone companies</th>
    <th>Roles</th>
    </thead>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.manager?c}</td>
        <td>${user.firstName}</td>
        <td>${user.lastName}</td>
        <td>
            <#list user.phones as phone>${phone.countryCode}${phone.number}; </#list>
        </td>
        <td>
            <#list user.phones as phone>${phone.phoneCompany.name}; </#list>
        </td>
        <td>
            <#list user.roles as role>${role.name}; </#list>
        </td>
    </tr>
</table>
<h4><a href="${springMacroRequestContext.contextPath}/">Home</a></h4>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>