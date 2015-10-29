<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a new monster</title>
        <link rel="stylesheet" type="text/css" href="styleD.css"/>
    </head>
    <body>
        <h1>Add a new monster</h1>
        
        <form name="addForm" action="addMonster" method="get">
            
            <label>Monster Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Property:</label>
            <input type="text" name="property" value="" />
            <br>
            <label>Level:</label>
            <input type="text" name="level" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
            
            
    </body>
</html>
