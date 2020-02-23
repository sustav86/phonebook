<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html xmlns:c="http://java.sun.com/jsf/composite">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1><@security.authentication property="principal.username"/></h1>
</header>
<form method="post" action="${springMacroRequestContext.contextPath}/upload" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Select a file to upload</td>
            <td><input type="file" name="file"/></td>
            <td><input type="submit" value="Upload"/></td>
        </tr>
    </table>
</form>
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
    <#list users as user>
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
            <td>
                <form action="${springMacroRequestContext.contextPath}/manager/users/${user.id}" method="get">
                    <button type="submit">update</button>
                </form>
            </td>
            <td>
                <form action="${springMacroRequestContext.contextPath}/manager/users/${user.id}" method="post">
                    <input type="hidden" name="_method" value="delete"/>
                    <input type="hidden" name="userName" value="${user.username}"/>
                    <button type="submit">delete</button>
                </form>
            </td>
        </tr>
    </#list>
</table>
<form method="get" action="${springMacroRequestContext.contextPath}/download/pdf">
    <input type="submit" value="Download"/></td>
</form>
<h4><a href="${springMacroRequestContext.contextPath}/">Home</a></h4>
</footer>
<div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>