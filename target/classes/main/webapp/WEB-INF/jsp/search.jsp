<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Rechercher</title>
<jsp:include page="head.jsp" />

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		var handle = $("#custom-handle");
		$("#slider").slider({
			step: 10,
			value: 10,
			min: 10,
			max: 500,
			create : function() {
				handle.text($(this).slider("value"));
			},
			slide : function(event, ui) {
				handle.text(ui.value);
				$("#distance").val(ui.value);
			}
		});
	});
</script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
#slider{
	display:inline-block;
	width:150px;
}
#custom-handle {
	width: 2em;
	height: 1.6em;
	top: 50%;
	margin-top: -.8em;
	text-align: center;
	line-height: 1.6em;
}
</style>
</head>

<body>
	<jsp:include page="navbar.jsp" />



	<div class="w3-container w3-center w3-round-large w3-border w3-border-blue w3-card w3-color-light-gray" style="width:500px; margin:auto; margin-top:150px; padding:0">
		
		<!-- Form header -->
		<h2 class="w3-blue" style="margin:0; margin-bottom:15px">Rechercher des essais cliniques</h2>
		
		<form method="GET" action="/results" class="form-horizontal">

			<!-- Condition field -->
			<!-- Add condition localisation dropdown -->
			<div class="form-group">
			<label for="condition">Pathologie :</label> 
			<input type="text" id="condition" name="condition" /> 
			</div>
			<br /> 
			
			
			<!-- Gender dropdown -->
			<div class="form-group">
			<label for="gender">Sexe :</label>
			<select id="gender" name="gender">
				<option value="M">Homme</option>
				<option value="F">Femme</option>
				<option value="Other">Autre</option>
			</select> 
			</div>
			<br /> 
			
			
			<!-- Age field -->
			<div class="form-group">
			<label for="age">Âge :</label> 
			<input type="number" id="age" name="age" value="18" style="width:50px;"/> 
			</div>
			<br />


			<!-- City field -->
			<!-- add geolocalisation -->
			<div class="form-group">
			<label for="city">Ville :</label> 
			<select id="city" name="city">
				<option value="Tours">Tours</option>
				<option value="Orleans">Orleans</option>
				<option value="Paris">Paris</option>
			</select> 
			</div>
			<br />
			
			
			<!-- Recruiting checkbox -->
			<div class="form-group">
			<label for="recruiting">Uniquement en cours de recrutement :</label> 
			<input type="checkbox" id="recruiting" name="recruiting" /> 
			</div>
			<br />
			

			<!-- Distance Slider -->
			<div class="form-group">
			<label for="distance">Distance(km) :</label>
			<br/>
			<div id="slider">
				<div id="custom-handle" class="ui-slider-handle"></div>
			</div>
			<input type="hidden" id="distance" name="distance" value="10" /> 
			</div>
			<br />


			<!-- Submit button -->
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit"
						class="w3-button w3-blue w3-padding-large w3-large w3-margin-top">Rechercher</button>
				</div>
			</div>
			<br/>
		</form>
	</div>

</body>
</html>