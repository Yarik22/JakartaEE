<%@ page import="beans.MessageBean" %>
<html>
<head>
    <title>Message Bean</title>
    <link rel="stylesheet" type="text/css" href="css/welcome.css">
    <link rel="icon" href="https://images.ctfassets.net/l5fkpck1mwg3/1BROzHq9JQEMn7ZukjTfNX/cbd5765243427fd15fd3405e6cf37bc0/BWW_Web_AW5_10FreeBoneless_ProductImage__PromoCode_4000x3000.png">
</head>
<body>
<div class="container">
    <header>
        <header>
            <h1>Message bean</h1>
            <nav>
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                </ul>
            </nav>
        </header>
    </header>

    <jsp:useBean id="messageBean" scope="page" class="beans.MessageBean"/>
    <jsp:setProperty name="messageBean" property="message"/>

    <form method="post">
        <label for="message">Message:</label>
        <input id="message" name="message" type="text" value="<jsp:getProperty name='messageBean' property='message'/>"/>
        <button type="submit">Submit</button>
    </form>

    <div class="message-display">
        <p>Current Message: <jsp:getProperty name="messageBean" property="message" /></p>
    </div>
</div>
</body>
</html>
