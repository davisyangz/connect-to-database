
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="styleD.css"/>
    </head>
    
    <% String table=(String) request.getAttribute("table"); %>
    
    <body>
        <div class="wrap">
            <%@include file="includes/header.jsp" %>
            <%@include file="includes/menu.jsp" %>
            <div class="main">
        <h1>Yang's monster</h1>
        
        <table>
            <tr>
                <th>ID</th>
                <th>MonsterName</th>
                <th>Property</th>
                <th>Level</th>
                <th>Delete</th>
            </tr>
        </table>
        <%=table %>
        
        <br><br>
        
        <a href ="add">Add a new monster</a>
        <br><br>
        <a href="search.jsp">Search Monsters</a>
        </div>
          <%@include file="includes/footer.jsp" %>
</div>
        
    </body>
</html>
