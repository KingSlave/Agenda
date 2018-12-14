<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Consulta de contactos</title>
        <link rel="stylesheet" href="../res/css/bootstrap.min.css"/>
    </head>
    <body>        
        <hr style="margin-top: 2%">
        <div class="container">
            <table class="table table-bordered table-hover table-striped">
                <thead>
                    <tr>
                        <th>Nombre</th>
                        <th>Email</th>
                        <th>Telefono Casa</th>
                        <th>Telefono Celular</th>
                        <th>Nota</th>
                    </tr>
                </thead>
                <tbody>                    
                        <s:iterator value="contactos">
                            <tr>
                                <td>${nombre}</td>
                                <td>${email}</td>
                                <td>${telCasa}</td>
                                <td>${telCel}</td>
                                <td>${nota}</td>
                            </tr>        
                        </s:iterator>                     
                </tbody>
            </table>
        </div>
    </body>
</html>

