<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="container">
    <div class="row">
      <div class="offset-lg-2 col-lg-8 col-sm-8 col-8 border rounded main-section">
        <h3 class="text-center text-inverse">Add New Category</h3>
        <hr>

        <form class="container" id="needs-validation" novalidate method="post" action="${url }"  >
          <div class="row">
            <div class="col-lg-12 col-sm-12 col-12">
              <div class="form-group">
                <label class="text-inverse" for="validationCustom02">Name</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="name" name="name" value="<c:if test="${nameEdit != ''}">${nameEdit }</c:if>" required>
                <div class="invalid-feedback">
                  Please provide a valid name.
                </div>
              </div>  
            </div>
          </div>
          <hr>
          <div class="row">
            <div class="col-lg-12 col-sm-12 col-12 text-center">
                <button class="btn btn-info" type="submit">Submit form</button>
            </div>
          </div>  
        </form>
      </div>
    </div>  
</div>
<script src="<%=request.getContextPath() %>/resources/js/products/validate-form.js"></script>
        