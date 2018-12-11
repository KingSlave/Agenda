<%@ page contentType="text/html; charset=UTF-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>

<html>
    <head>
        <title>Agregar contactos</title>
        <link rel="stylesheet" href="../res/css/bootstrap.min.css"/>
    </head>
    <body>
        
        <hr style="margin-top: 2%">
        
        <form action="guardarContacto">
            <div class="form-group">
                <label>Nombre: </label>
                <input type="text" class="form-control" name="nombre">
            </div>
            <div class="form-group">
                <label>Email: </label>
                <input type="text" class="form-control" name="email">
            </div>
            <div class="form-group">
                <label>Telefono de casa: </label>
                <input type="text" class="form-control" name="telCasa">
            </div>
            <div class="form-group">
                <label>Telefono celular: </label>
                <input type="text" class="form-control" name="telCel">
            </div>
            <div class="form-group">
                <label>Nota: </label>
                <input type="text" class="form-control" name="nota">
            </div>
            <button class="btn btn-primary" type="submit">Enviar</button>                
        </form>
        
    </body>
</html>

