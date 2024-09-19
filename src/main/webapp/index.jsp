<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="dateBean" class="beans.DateBean" scope="page" />
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Welcome to Jakarta EE</title>
  <link rel="stylesheet" type="text/css" href="css/welcome.css">
</head>
<body>
<div class="container">
  <header>
    <h1>Welcome to Jakarta EE Application</h1>
    <nav>
      <ul>
        <li><a href="setAndGetValue.jsp">Set and Get Value</a></li>
        <li><a href="home.jsp">Home</a></li>
      </ul>
    </nav>
  </header>

  <main>
    <section class="date-time">
      <h2>Current Date and Time in Kyiv:</h2>
      <p>${dateBean.formattedDate}</p>
    </section>

    <section class="description">
      <h3>About this Application</h3>
      <p>This is a simple Jakarta EE application that demonstrates working with JavaBeans and JSPs. You can see the current date and time in Kyiv, or go to the next page to set and retrieve a custom value using a JavaBean.</p>
    </section>
  </main>

  <footer>
    <p>&copy; 2024 Jakarta EE Application. All rights reserved.</p>
  </footer>
</div>
</body>
</html>
