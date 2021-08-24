<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<div class="container">
    <div class="row">
      <div class="offset-lg-2 col-lg-8 col-sm-8 col-8 border rounded main-section">
        <h3 class="text-center text-inverse">Add New Products</h3>
        <hr>
        <form class="container" id="needs-validation" novalidate method="post" action="add" enctype="multipart/form-data">
          <div class="row">
            <div class="col-lg-6 col-sm-6 col-12">
               <div class="form-group">
                <label class="text-inverse" for="validationCustom01">CODE</label>
                <input type="text" class="form-control" id="validationCustom01" placeholder="CODE" name="code" required>
                <div class="invalid-feedback">
                  Please provide a valid code.
                </div>
              </div>
            </div>
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                <label class="text-inverse" for="validationCustom02">Name</label>
                <input type="text" class="form-control" id="validationCustom02" placeholder="name" name="name" required>
                <div class="invalid-feedback">
                  Please provide a valid name.
                </div>
              </div>  
            </div>
          </div>
          <div class="row">
            <div class="col-md-6 col-sm-12 col-12">
              <div class="form-group">
                <label class="text-inverse" for="inputEmail4">Price</label>
                <input type="number" class="form-control" placeholder="price" required name="price">
                <div class="invalid-feedback">
                  Please provide a valid price.
                </div>
              </div>  
            </div>
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                <label class="text-inverse" for="inputpassword">Quantity</label>
                <input type="number" class="form-control"  placeholder="quantity" required name="quantity">
                <div class="invalid-feedback">
                  Please provide a valid quantity.
                </div>
              </div>  
            </div>
          </div>
          <div class="row">
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                <label class="text-inverse" for="validationCustom03">Sale</label>
                <input type="text" class="form-control" id="validationCustom03" placeholder="sale" required name="sale">
                <div class="invalid-feedback">
                  Please provide a valid sale.
                </div>
              </div>  
            </div>
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                <label class="text-inverse" for="select-menu">Select any category</label>
                <select class="custom-select d-block form-control" id="image" required name="category">
                  <option value="">Open this select menu</option>
                  <option value="1">One</option>
                  <option value="2">Two</option>
                  <option value="3">Three</option>
                </select>
                <div class="invalid-feedback">
                  Please selected any option.
                </div>
              </div>  
            </div>
          </div>
          <div class="row">
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                <label class="custom-file">
                  <input type="file" id="file" class="form-control custom-file-input" required name="image">
                  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-camera" viewBox="0 0 16 16">
  <path d="M15 12a1 1 0 0 1-1 1H2a1 1 0 0 1-1-1V6a1 1 0 0 1 1-1h1.172a3 3 0 0 0 2.12-.879l.83-.828A1 1 0 0 1 6.827 3h2.344a1 1 0 0 1 .707.293l.828.828A3 3 0 0 0 12.828 5H14a1 1 0 0 1 1 1v6zM2 4a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2h-1.172a2 2 0 0 1-1.414-.586l-.828-.828A2 2 0 0 0 9.172 2H6.828a2 2 0 0 0-1.414.586l-.828.828A2 2 0 0 1 3.172 4H2z"/>
  <path d="M8 11a2.5 2.5 0 1 1 0-5 2.5 2.5 0 0 1 0 5zm0 1a3.5 3.5 0 1 0 0-7 3.5 3.5 0 0 0 0 7zM3 6.5a.5.5 0 1 1-1 0 .5.5 0 0 1 1 0z"/>
</svg>
                  <span class="custom-file-control"> Please selected image product</span>
                  <div class="invalid-feedback">
                    Please selected any File.
                  </div>
                </label>
              </div>  
            </div>
            <div class="col-lg-6 col-sm-6 col-12">
              <div class="form-group">
                  <span class="custom-control-description">Description</span>
                  <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" required name="description"></textarea>
                  <div class="invalid-feedback">
                  Please provide a valid quantity.
                </div>
                </label>
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
        