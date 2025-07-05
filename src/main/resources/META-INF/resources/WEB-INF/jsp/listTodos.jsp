		<%@ include file="common/header.jspf" %>
		<%@ include file="common/navigation.jspf" %>
		
    	<div class="container">
    	    <h1 class="pt-5">Your Todos</h1>                
	        <table class="table">
	        	<thead>
	        		<tr>	        		
	        			<th>Description</th>
	        			<th>Target Date</th>
	        			<th>Is Done</th>
	        			<th></th>
	        			<th></th>
	        		</tr>
	        	</thead>
	        	
	        	<tbody>
	        		<c:forEach items="${todos}" var="todo">
	        			<tr>	        			
	        				<td>${todo.description}</td>
	        				<td>${todo.targetDate}</td>
	        				<td>${todo.done}</td>
	        				<td><a class="btn btn-warning" href="delete-todo?id=${todo.id}">Delete</a></td>
	        				<td><a class="btn btn-success" href="update-todo?id=${todo.id}">Update</a></td>
	        			</tr>
	        		</c:forEach>
	        	</tbody>
	        </table>
	        
	        <a href="add-todo" class="btn btn-success">Add Todo</a>
       	</div>
		<%@ include file="common/footer.jspf" %>