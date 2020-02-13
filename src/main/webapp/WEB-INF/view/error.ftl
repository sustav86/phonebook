<html>
<head>
    <title>Error Page</title>
</head>
<body>
<h3>This is default exception page</h3>
<p>Exception: <b>${exception}</b></p>
<form method="get" action="${springMacroRequestContext.contextPath}/" target="_self">
    <button type="submit">Home</button>
</form>
</body>
</html>
