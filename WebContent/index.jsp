<!DOCTYPE html>
<html>

 <head>
  <link rel="stylesheet" href="css/bootstrap.css">
  <script type="text/javascript" src="js/jquery.js"></script>
  <script type="text/javascript" src="js/bootstrap.js"></script>
  <%@ taglib  uri="/struts-tags" prefix="s" %>
 </head>
 <body>
  <div class="container">
    <div class="col-sm-offset-1 col-sm-10">
      <div class="jumbotron">
     <h3>Cadastro de Cliente</h3>
      </div>
     </div>
  </div>
  <div class="row">
    <s:form id="form1"    theme="simple"     action="cliente.cadastrar" 
            cssClass="bs-example form-horizontal"   method="post">
          <br/><br/>  
      <div class="col-sm-offset-1 col-sm-6">
        <label for="nome">Nome:</label>
        <input type="text" name="cliente.nome" id="nome" value="" required
              placeholder="Entre Com nome" title="Nome no Padrao" 
              class="form-control" />
         <label for="email">Email:</label>
         <input type="email" name="cliente.email" id="email" value="" required
              placeholder="Entre Com Email" title="Email no Padrao" 
               class="form-control" />
    
          <label for="sexo">Sexo:</label>
          <input type="radio" name="cliente.sexo" id="sexo" value="m" 
             autofocus="autofocus" checked="checked" />Masculino 


         <input type="radio" name="cliente.sexo"  value="f"
               />Feminino<br/>
               <br/><br/>
           <s:submit value="Enviar"  cssClass="btn btn-Primary"/>     
          <br/><br/>
          ${msg}
        </div>
    </s:form>
  
  
  
  </div>
  
 
 </body>
 



</html>
