<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>${user.username}</h1>
</header>
<table>
    <thead>
    <th>ID</th>
    <th>UserName</th>
    <th>First name</th>
    <th>Last name</th>
    <th>Phones</th>
    <th>Phone companies</th>
    <th>Roles</th>
    </thead>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.person.firstName}</td>
            <td>${user.person.lastName}</td>
            <td>
                <#list user.person.phoneNumbers as phone>${phone.countryCode}${phone.number}; </#list>
            </td>
            <td>
                <#list user.person.phoneNumbers as phone>${phone.phoneCompany.name}; </#list>
            </td>
            <td>
                <#list user.roles as role>${role.name}; </#list>
            </td>
        </tr>
</table>
<footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>