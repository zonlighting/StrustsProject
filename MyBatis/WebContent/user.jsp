<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Welcome Page</title>
</head>
<body onload="myFunction()">
	<div id="wrapper">
		<s:include value="home.jsp" />
		<div id="content-wrapper" class="d-flex flex-column">
			<div class="container">
				<s:form action="user">
					<table class="table table-hover">
						<thead>
							<tr>
								<th scope="col">ID</th>
								<th scope="col">USERNAME</th>
								<th scope="col">PASSWORD</th>
							</tr>
						</thead>
						<tbody>
							<s:iterator value="users">
								<tr>
									<th scope="row"><s:property value="id" /></th>
									<td><s:property value="username" /></td>
									<td><s:property value="password" /></td>
							</s:iterator>
						</tbody>
					</table>
					<s:textfield type="text" name="page" style="visibility: hidden"
						id="page" />
					<s:textfield type="text" name="totalPage" id="totalPage"
						style="visibility: hidden" />
					<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><s:submit value="Previous"
								method="previous" id="previous" /></li>
						<li class="page-item"><s:submit value="Next" method="next"
								id="next" /></li>
					</ul>
					</nav>
				</s:form>
			</div>

		</div>
	</div>

	<script type="text/javascript">
		function myFunction() {
			var page = document.getElementById("page").value;
			var totalPage = document.getElementById("totalPage").value;
			console.log(page);
			console.log(totalPage);
			if (page == totalPage) {
				document.getElementById("next").style.disabled = true;
			} else {
				document.getElementById("next").style.disabled = false;
			}
			if (page == 0) {
				document.getElementById("previous").style.disabled = true;
				console.log(page);
			} else {
				document.getElementById("previous").style.disabled = false;
			}
		}
	</script>
</body>
</html>