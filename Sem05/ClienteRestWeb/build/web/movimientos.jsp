<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="comun.jsp"/>
  </head>
  <body>
    
    <div>MOVIMIENTOS</div>
    
    <form>
      <label>Cuenta:</label>
      <input type="text" name="cuenta" id="cuenta" />
      <input type="button" value="Consultar" id="btnConsultar" />
    </form>
    
    <table border="2">
      
      <thead>
        <tr>
          <th>CUENTA</th>
          <th>NRO</th>
          <th>FECHA</th>
          <th>TIPO</th>
          <th>ACCION</th>
          <th>IMPORTE</th>
        </tr>
      </thead>
      
      <tbody id="cuerpoTabla">
      </tbody>
      
    </table>
    
    <script>
      
      $("#btnConsultar").click(function(){
        
        $("#cuerpoTabla").empty();
        var cuenta = $("#cuenta").val();
        var recurso = "http://localhost:8080/WSRest/rest/wszany/movimientos/" + cuenta;
        
        $.get(recurso, function( objeto ){
        
          if( objeto === null ){
            alert("No hay datos.");
            return;
          }
    
          $.each(objeto.movimiento, function(index,rec){
            
            var row = "<tr>";
            row += "<td>" + rec.codigo + "</td>";
            row += "<td>" + rec.numeroMovimiento + "</td>";
            row += "<td>" + rec.fecha + "</td>";
            row += "<td>" + rec.tipo + "</td>";
            row += "<td>" + rec.accion + "</td>";
            row += "<td>" + rec.importe + "</td>";
            row += "</tr>";
            
            $("#cuerpoTabla").append( row );
            
          });
          
        });
        
      });
      
      
    </script>
    
    
  </body>
</html>
