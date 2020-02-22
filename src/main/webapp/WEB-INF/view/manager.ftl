<#assign security=JspTaglibs["http://www.springframework.org/security/tags"]/>
<html xmlns:c="http://java.sun.com/jsf/composite">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Phone Book</title>
</head>
<body>
<header>
    <h1>Users</h1>
</header>
<section>
    <h1>Users</h1>
</section>
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
    <th>UserName</th>
    <th>Surname</th>
    <th>Phones</th>
    <th>Phone companies</th>
    <th>Roles</th>
    </thead>
    <#list users as user>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.surname}</td>
            <td>
                <#list user.phones as phone>${phone.countryCode}${phone.number}; </#list>
            </td>
            <td>
                <#list user.phones as phone>${phone.phoneCompany.name}; </#list>
            </td>
            <td>
                <#list user.roles as role>${role.name}; </#list>
            </td>
<#--            <td>-->
<#--                <form action="${pageContext.request.contextPath}/admin" method="post">-->
<#--                    <input type="hidden" name="userId" value="${user.id}"/>-->
<#--                    <input type="hidden" name="action" value="delete"/>-->
<#--                    <button type="submit">Delete</button>-->
<#--                </form>-->
<#--            </td>-->
        </tr>
    </#list>
</table>
<form method="get" action="${springMacroRequestContext.contextPath}/download/pdf">
    <input type="submit" value="Download"/></td>
</form>
</footer>
    <div>Updated by Sustavov Anton</div>
</footer>
</body>
</html>