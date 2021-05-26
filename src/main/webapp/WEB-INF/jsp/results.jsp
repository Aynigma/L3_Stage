<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Résultats</title>
<jsp:include page="head.jsp" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.24/css/jquery.dataTables.css">  
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/plug-ins/1.10.24/i18n/French.json"></script>
<script>
$(document).ready( function () {
    $('#table_id').DataTable({
    	language: {
    		url: '//cdn.datatables.net/plug-ins/1.10.24/i18n/French.json'
    	}
    });
} );
</script>

</head>

<body>
	<jsp:include page="navbar.jsp" />


<div class="w3-container">
<table id="table_id" class="display">
    <thead>
        <tr>
            <th>Titre</th>
            <th>Status</th>
            <th>Début</th>
            <th>Age</th>
            <th>Sexe</th>
            <th>Conditions</th>
            <th>Lieu</th>
            <th>Lien</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${ListTrials}" var="trial" varStatus="loopStatus">
    		<tr>
    			<td><c:out value="${trial.title}"/></td>
    			<td><c:out value="${trial.status}"/></td>
    			<td><c:out value="${trial.start}"/></td>
    			<td><c:out value="${trial.ageRange}"/></td>
    			<td><c:out value="${trial.sexTargeted}"/></td>
    			<td><c:out value="${trial.conditions}"/></td>
    			<td><c:out value="${trial.place}"/></td>
    			<td><a href='<c:out value="${trial.link}"/>'>En savoir plus</a></td>
    		</tr>
    	</c:forEach>
    </tbody>
</table>
</div>



</body>
</html>