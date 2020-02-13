<html>
<head>
    <title>Phone Book</title>
</head>
<body>
<h2>Phone Book</h2>
<form method="POST" action="${springMacroRequestContext.contextPath}/uploadFile" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Select a file to upload</td>
            <td><input type="file" name="file"/></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form>
<ul>
    <#list humanDtos as humanDto>
        <li>${humanDto_index + 1}. ${humanDto.name} ${humanDto.surname}
        <#list humanDto.phone as item> country code: ${item.countryCode} number: ${item.number} company: ${item.phoneCompany.name} </#list></li>
    </#list>
</ul>
<form method="GET" action="${springMacroRequestContext.contextPath}/download/pdf">
    <input type="submit" value="Download"/></td>
</form>
</body>
</html>
