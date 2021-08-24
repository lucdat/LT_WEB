<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="container">
<div class="row">
	<a href="<c:url value="/category/add" />" class="btn btn-info mx-auto" role="button">Add New Category</a>
</div>
  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead class="text-center">
          <tr>
            <th scope="col">STT</th>
            <th scope="col" class="text-center" >Category Name</th>
            <th scope="col" class="text-center" >Action</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="category" items="${listCategory}" varStatus="loop">
        		<tr>
		            <th scope="row">${loop.index +1}</th>
		            <td>${category.name}</td>
		            
		            <td class="text-center">
		            
		              <button type="button" class="btn btn-primary"><i class="far fa-eye"></i></button>
		              <a href="<c:url value="/category/edit/${category.id }" />" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
		               <a href="<c:url value="/category/delete/${category.id }" />" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
		          
		            </td>
          		</tr>
        	</c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>