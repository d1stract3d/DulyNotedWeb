
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/jsp/common/header.jspf"%>
<%@ include file="/WEB-INF/jsp/common/navigation.jspf"%>

<div class="container">
	<h3 class="text-success">Note List</h3>
	<br>

	<table class="table table-bordered table-sm table-dark">
		<c:forEach var="note" items="${list}">
			<thead>
				<tr>
					<th scope="col" class="col-xs-1 text-center">#</th>
					<th scope="col" class="col-xs-1 text-center">Title</th>
					<th scope="col" class="col-xs-1 text-center">Content</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row" class="col-xs-1 text-center">${note.id}</th>
					<td colspan="1" class="col-xs-1 text-center">${note.title}</td>
					<td colspan="2" class="col-xs-1 text-center">${note.content}</td>
					<td colspan="1" class="col-xs-1 text-center"><a
						class="btn btn-warning text-white" href="editnote/${note.id}">Edit</a></td>
					<td colspan="1" class="col-xs-1 text-center"><a
						href="deletenote/${note.id}" class="btn btn-danger text-white">Delete</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

	<br /> <a href="noteform" class="btn btn-success text-white">Add
		Note</a>

</div>
<%@ include file="/WEB-INF/jsp/common/footer.jspf"%>
