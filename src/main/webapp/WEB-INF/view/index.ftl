<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>${message}</h2>
  <form method="POST" action="/phonebooks/uploadFile" enctype="multipart/form-data">
    <table>
      <tr>
        <td>Select a file to upload</td>
        <td><input type="file" name="file" /></td>
      </tr>
      <tr>
        <td><input type="submit" value="Submit" /></td>
      </tr>
    </table>
    </form>
  </body>
</html>
