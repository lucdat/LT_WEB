<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
      <div class="offset-lg-2 col-lg-8 col-sm-8 col-8 border rounded main-section">
        <h3 class="text-center text-inverse">Import Invoice Product </h3>
        <hr>
        <form:form action="${url }" method="post" modelAttribute="import" enctype="multipart/form-data">
        	<div class="row">
            	<div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">CODE</label>
                		<form:input path="product.code" class="form-control" id="validationCustom01" placeholder="code" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid code.
                		</div>
              		</div>
           		</div>
                <div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">Name</label>
                		<form:input path="product.name" class="form-control" id="validationCustom01" placeholder="name" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid name.
                		</div>
              		</div>
           		</div>      		    
          </div>
          <div class="row">
            	<div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">Color</label>
                		<form:input path="color" class="form-control" id="validationCustom01" placeholder="color" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid color.
                		</div>
              		</div>
           		</div>
                <div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">Size</label>
                		<form:input type="number" path="size" class="form-control" id="validationCustom01" placeholder="size" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid size.
                		</div>
              		</div>
           		</div>      		    
          </div>
          <div class="row">
            	<div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">Quantity</label>
                		<form:input type="number" path="quantity" class="form-control" id="validationCustom01" placeholder="quantity" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid quantity.
                		</div>
              		</div>
           		</div>
                <div class="col-lg-6 col-sm-6 col-12">
               		<div class="form-group">
                		<label class="text-inverse" for="validationCustom01">Price</label>
                		<form:input type="number" path="price" class="form-control" id="validationCustom01" placeholder="price" />
         
                		<div class="invalid-feedback">
                  			Please provide a valid price.
                		</div>
              		</div>
           		</div>      		    
          </div>
          <div class="row">
            <div class="col-lg-12 col-sm-12 col-12 text-center">
                <button class="btn btn-info" type="submit">Add</button>
                <a href="<c:url value="/invoice/list/1" />" class="btn btn-success" role="button">Back</a>
            </div>
          </div>
          
       </form:form> 
      </div>
    <div class="row">
    	<br><br>
    </div>
    </div>
    <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead class="text-center">
          <tr>
            <th scope="col">STT</th>
            <th scope="col" class="text-center" >Name Product</th>
            <th scope="col" class="text-center" >Image</th>
            <th scope="col" class="text-center" >Color</th>
            <th scope="col" class="text-center" >Size</th>
            <th scope="col" class="text-center" >Quantity</th>
            <th scope="col" class="text-center" >Price</th>
            <th scope="col" class="text-center" >Action</th>
          </tr>
        </thead>
        <tbody>
        
        	<c:forEach var="im" items="${listImport}" varStatus="loop">
        		<tr>
		            <th scope="row">${loop.index + 1}</th>
		            <td>${im.product.name }</td>
		            <td><img width="200px" height="150px" src="data:image/jpeg;base64,${im.product.image}"></td>
		            <td>${im.color}</td>
		            <td>${im.size}</td>
		            <td class="text-center">${im.quantity} 
		            	<a href="<c:url value="/invoice/editimportup/${im.id }" />" class="btn btn-success" role="button">+</a>
		            	<a href="<c:url value="/invoice/editimportdown/${im.id }" />" class="btn btn-success" role="button">-</a>
		            	
		            </td>
		            <td><f:formatNumber value="${im.price}" type="currency"/></td>
		            <td class="text-center">
		                <a href="<c:url value="/invoice/deleteimport/${im.id }" />" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
		          
		            </td>
          		</tr>
        	</c:forEach>
        </tbody>
        
      </table>
    </div>
  </div>
  
    
</div>   
<script src="<%=request.getContextPath() %>/resources/js/products/validate-form.js"></script>
        