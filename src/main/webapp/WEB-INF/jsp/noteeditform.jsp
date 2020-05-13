<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/common/header.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container">
	<h3 class="text-success">Edit Note</h3>
	<form:form method="POST" action="/dulynoted/editsave">
		<form:hidden path="id" />
		<div class="form-group">
			<label class="text-success">Title</label><br>
			<form:input path="title" />
		</div>
		<div class="form-group">
			<label class="text-success">Content</label><br>
			<form:input path="content" />
		</div>
		<button type="submit" class="btn btn-success">Save</button>
	</form:form>
</div>
<%@ include file="/WEB-INF/jsp/common/footer.jspf"%>
