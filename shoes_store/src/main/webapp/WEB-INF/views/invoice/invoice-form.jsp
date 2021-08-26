<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
    <div class="row">
      <div class="offset-lg-2 col-lg-8 col-sm-8 col-8 border rounded main-section">
        <h3 class="text-center text-inverse">Add New Invoice</h3>
        <hr>
        <form:form action="${url }" method="post" modelAttribute="invoice" enctype="multipart/form-data">
        	<div class="row">
            <div class="col-lg-6 col-sm-6 col-12 text-center">
               <div class="form-group text-center">
                <label class="text-inverse" for="validationCustom01">Description</label>
                <form:input path="description" name="description" class="form-control" id="validationCustom01" placeholder="Description"/>
         
                <div class="invalid-feedback">
                  Please provide a valid code.
                </div>
              </div>
            </div>
                      		    
          </div>
          <div class="row">
            <div class="col-lg-12 col-sm-12 col-12 text-center">
                <button class="btn btn-info" type="submit">Submit form</button>
            </div>
          </div>  
       </form:form> 
      </div>
    </div>
    
</div>   
<script src="<%=request.getContextPath() %>/resources/js/products/validate-form.js"></script>
        