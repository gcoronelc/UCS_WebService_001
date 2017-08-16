<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="comun.jsp"/>
  </head>
  <body>
    <h1>RETIRO</h1>
    <form id="form1">
      
      
      
      <fieldset>
        <legend>Datos del retiro</legend>
        
        <label>Cuenta: </label>
        <input type="text" name="cuenta" /> <br/>
        
        <label>Importe: </label>
        <input type="text" name="importe" /> <br/>
        
        <label>Clave: </label>
        <input type="password" name="clave" /> <br/>
        
        <input type="button" value="Procesar" id="btnProcesar"/>
        
      </fieldset>
      <input type="hidden" name="codemp" value="0001" />
      
    </form>
    
    <script>
      
      $("#btnProcesar").click( function() { 

        var data = $("#form1").serialize();
        var recurso = "http://localhost:8080/WSRest/rest/wszany/regmov";
        
        $.post(recurso, data, function( objeto ){
          
          alert( objeto.texto );
          
        });
  
      });
      
    </script>
  </body>
</html>
