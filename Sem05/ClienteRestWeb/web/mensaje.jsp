<!DOCTYPE html>
<html>
  <head>
    <jsp:include page="comun.jsp"/>
  </head>
  <body>

    <div>REST CLIENT</div>

    <button id="btnLeer" >Leer REST</button>
    <div id="divAlgo"></div>

    <script>

      $("#btnLeer").click(fnProcesar);

      function fnProcesar() {

        $.getJSON('http://localhost:8080/WSRest/rest/wszany', function (respuesta) {
          $("#divAlgo").html(respuesta.texto);
          console.log(respuesta);
          alert(respuesta.texto);
        });

      }


    </script>

  </body>
</html>
