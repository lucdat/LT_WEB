<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="container">
<h2 class="text-center">Manage Feedback Product </h2>
<div class="row d-flex justify-content-center">
	<img width="10%" height="10%" src="data:image/jpeg;base64,${product.image}">
	<span class="text-center">${product.name }</span>
</div>

  <div class="row">
    <div class="col-12">
      <table class="table table-bordered">
        <thead class="text-center">
          <tr>
            <th scope="col">STT</th>
            <th scope="col" class="text-center" >Name</th>
            <th scope="col" class="text-center" >Image</th>
            <th scope="col" class="text-center" >Date</th>
            <th scope="col" class="text-center" >Content</th>
            <th scope="col" class="text-center" >Action</th>
          </tr>
        </thead>
        <tbody>
        	<c:forEach var="fb" items="${feedbacks}" varStatus="loop">
        		<tr>
		            <th scope="row">${loop.index +1}</th>
		            <td>${fb.getUser().getName()}</td>
		            <td><img width="30%" height="30%" src="data:image/jpeg;base64,${fb.getUser().getImage()}"></td>
		            <td>${fb.date}</td>
		            <td>${fb.content}</td>
		            <td class="text-center">
		               <a href="<c:url value="/manager-feeback/delete/${fb.id }" />" class="btn btn-danger" role="button"><i class="far fa-trash-alt"></i></a>
		            </td>
          		</tr>
        	</c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>