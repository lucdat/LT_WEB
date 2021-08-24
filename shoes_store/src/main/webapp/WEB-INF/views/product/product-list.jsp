<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="container">
<div class="row">
	<a href="<c:url value="/product/add" />" class="btn btn-info mx-auto" role="button">Add New Product</a>
</div>
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead class="text-center">
          <tr>
            <th scope="col">STT</th>
            <th scope="col" class="text-center" >Code</th>
            <th scope="col" class="text-center" >Product Name</th>
            <th scope="col" class="text-center" >Image</th>
            <th scope="col" class="text-center" >Price</th>
            <th scope="col" class="text-center" >Quantity</th>
            <th scope="col" class="text-center" >Category Name</th>
            <th scope="col" class="text-center" >Action</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="product" items="${list}" varStatus="loop">
        		<tr>
		            <th scope="row">${loop.index +1}</th>
		            <td>${product.code}</td>
		            <td>${product.name}</td>
		            <td><img width="30%" height="30%" src="data:image/jpeg;base64,${product.image}"></td>
		            <td>${product.price}</td>
		            <td>${product.quantity}</td>
		            <td>${product.getCategory().getName()}</td>
		            
		            
		            <td class="text-center">
		            
		              <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
		              <a href="<c:url value="/product/edit/${product.id }" />" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
		               <a href="<c:url value="/product/delete/${product.id }" />" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
		          
		            </td>
          		</tr>
        	</c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>