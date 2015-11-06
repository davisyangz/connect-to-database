
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Summoners" %>
<% Summoners monster=(Summoners) request.getAttribute("monster"); %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styleD.css"/>
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update a monster's record</h1>
        
        <form name="updateForm" action="updateMonster" method="get">
            <label>Monster ID:</label>
            <input type="text" name="name" value="<%=monster.getMonsterID() %>" />
            <br>
            <label>Monster Name:</label>
            <input type="text" name="name" value="<%=monster.getMonsterName() %>" />
            <br>
            <label>Property:</label>
            <input type="text" name="property" value="<%=monster.getProperty() %>" />
            <br>
            <label>Level:</label>
            <input type="text" name="level" value="<%=monster.getMLevel() %>" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
