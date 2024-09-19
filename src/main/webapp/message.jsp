<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:useBean id="valueBean" class="beans.ValueBean" scope="session" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Set and Get Value</title>
    <link rel="stylesheet" type="text/css" href="css/welcome.css">
</head>
<body>
<div class="container">
    <header>
        <h1>Set and Get Value</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Home</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="set-value-form">
            <h2>Set a New Value</h2>
            <form method="post" action="value.jsp">
                <label for="value">Enter value:</label>
                <input type="text" id="value" name="value" value="${valueBean.value}" required />
                <input type="submit" value="Submit" />
            </form>
        </section>

        <section class="current-value">
            <h3>Current Value:</h3>
            <p>${valueBean.value}</p>
        </section>

        <%
            String newValue = request.getParameter("value");
            if (newValue != null && !newValue.isEmpty()) {
                valueBean.setValue(newValue);
            }
        %>

    </main>

    <footer>
        <p>&copy; 2024 Jakarta EE Application. All rights reserved.</p>
    </footer>
</div>
</body>
</html>
