<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>


<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<c:if test="${page=='one' }">
	<title>DoTo!</title>
</c:if>
<c:if test="${page=='add' }">
	<title>DoTo Add!</title>
</c:if>

</head>
<body>
	<div class="container mt-3">
		<h1 class="text-center">The DoTo World</h1>
		<c:if test="${not empty message }">
			<div class="alert alert-success">
				<b> <c:out value="${message }">
					</c:out>
				</b>
			</div>
		</c:if>
		<div class="row mt-5">
			<div class="col-md-2">
				<h3 class="text-center">Options</h3>
				<div class="list-group">
					<button type="button"
						class="list-group-item list-group-item-action active">
						DoTo Menu</button>
					<a href='<c:url value='/add'></c:url>' type="button"
						class="list-group-item list-group-item-action">DoTo Add</a> <a
						href='<c:url value='/one'></c:url>' type="button"
						class="list-group-item list-group-item-action">DoTo View</a>
				</div>
			</div>
			<div class="col-md-10">
				<c:if test="${page=='one' || not empty message}">
					<h3 class="text-center">DoTos</h3>
					<c:forEach items="${dotoList }" var="doto">
						<div class="card">
							<div class="card-body">
								<h3>
									<c:out value="${doto.dotoTitle }"></c:out>
								</h3>
								<p>
									<c:out value="${doto.dotoContent }"></c:out>
								</p>
								<h6>
									<c:out value="${doto.dotoDate }"></c:out>
								</h6>
							</div>
						</div>
					</c:forEach>




				</c:if>
				<c:if test="${page=='add' }">
					<h3 class="text-center">Add DoTo</h3>
					<br>
					<form:form action="save" method="post" modelAttribute="doto">
						<div class="form-group">
							<form:input path="dotoTitle" cssClass="form-control"
								placeholder="Enter your DoTo Title" />
						</div>
						<div class="form-group">
							<form:textarea path="dotoContent" cssClass="form-control"
								placeholder="Enter your DoTo Content" cssStyle="height:250px;" />
						</div>

						<div class="container text-center">
							<button class="btn btn-outline-success">Add DoTo</button>
						</div>

					</form:form>
				</c:if>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>
