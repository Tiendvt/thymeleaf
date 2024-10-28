<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<h2>${category.isEdit ? 'Edit Category' :'Add New Category' }</h2>
<form action="/admin/categories/save" method="post">
	<input type="hidden" value="${category.isEdit}" name="isEdit">
	<input type="hidden" value="${category.id}" name="id">
	<div>
	<label>Category name</label><br>
	<input type="text" name="name" value="${category.name}">
	</div>
	
	<div>
	<label>Image</label><br>
	<input type="text" name="images" value="${category.images}">
	</div>
	
	<div>
	<label>Status</label><br>
	<input type="text" name="status" value="${category.status}">
	</div>
	
	<c:if test="${category.isEdit}">
	<input type="submit" value="Update">
	</c:if>
	
	<c:if test="${!category.isEdit}">
	<input type="submit" value="Insert">
	</c:if>
</form>