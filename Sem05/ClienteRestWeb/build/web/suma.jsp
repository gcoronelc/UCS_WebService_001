<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="comun.jsp"/>
  </head>
  <body>
    <h1>SUMA</h1>
    <form id="form1">
      <fieldset>
        <legend>DATOS</legend>
      
        <label>Número 1:</label>
        <input type="text" name="n1" /> <br/>

        <label>Número 2:</label>
        <input type="text" name="n2" /> <br/>
        
        <input type="button" value="Procesar" id="btnProcesar" />
        
      </fieldset>
    </form>
    
    <div id="divResultado"></div>
    
    <script>
      
      $("#btnProcesar").click(function(){
        
        var data = $("#form1").serialize();
        var recurso = "http://localhost:8080/WSRest/rest/wszany/sumar";
        
        $.get(recurso, data, function(objeto){
          
          $("#divResultado").html(objeto.texto)
          
        });
        
      });
      
      
    </script>
  </body>
</html>