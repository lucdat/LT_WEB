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
		            
		            	<a href="<c:url value="/manager-feeback/${product.id }" />" class="btn btn-primary" role="button"><i class="far fa-eye"></i></a>
		              <a href="<c:url value="/product/edit/${product.id }" />" class="btn btn-success" role="button"><i class="fas fa-edit"></i></a>
		               <a href="<c:url value="/product/delete/${product.id }" />" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
		          
		            </td>
          		</tr>
        	</c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <div class="row justify-content-center">
  	<nav aria-label="Page navigation example justify-content-center">
	  <ul class="pagination justify-content-center">
	  <c:choose>
		    <c:when test="${paging.indexPage >1}">
		        <li class="page-item ">
	      			<a class="page-link" href="<c:url value="/product/list/${paging.indexPage-1 }" />" tabindex="-1">Previous</a>
	    		</li> 
		    </c:when>    
		    <c:otherwise>
		        <li class="page-item disabled ">
	      			<a class="page-link" href="#" tabindex="-1">Previous</a>
	    		</li> 
		    </c:otherwise>
		</c:choose>
	  
	    <c:forEach var = "i" begin = "1" end ="${paging.getTotalPages() }">
         <c:choose>
		    <c:when test="${paging.indexPage== i}">
		        <li class="page-item active disabled"><a class="page-link active" href="<c:url value="/product/list/${i }" />">${i }</a></li>
		    </c:when>    
		    <c:otherwise>
		        <li class="page-item"><a class="page-link" href="<c:url value="/product/list/${i }" />">${i }</a></li>
		    </c:otherwise>
		</c:choose>
         
      </c:forEach>
      <c:choose>
		    <c:when test="${paging.indexPage <paging.getTotalPages()}">
		        <li class="page-item ">
	      			<a class="page-link" href="<c:url value="/product/list/${paging.indexPage +1}" />">Next</a>
	    		</li> 
		    </c:when>    
		    <c:otherwise>
		        <li class="page-item disabled ">
	      			<a class="page-link" href="#">Next</a>
	    		</li> 
		    </c:otherwise>
		</c:choose>
	  </ul>
	</nav>
  </div>
</div>