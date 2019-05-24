<!doctype html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        rel="stylesheet"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
        crossorigin="anonymous">
  <title>Todo List</title>
</head>
<body>
  <div class="container">
    <h1>Todo List</h1>

    <#list todos as todo>
    <form action="/${todo}/delete" method="post">
      <div class="form-check">
        <label>
          <input class="form-check-input" type="checkbox" onchange="this.form.submit()" />
          ${todo}
        </label>
      </div>
    </form>
    </#list>

    <form method="post">
      <input autofocus type="text" class="form-control" name="todo" />
      <input type="submit" style="display: none" />
    </form>
  </div>
</body>
</html>
