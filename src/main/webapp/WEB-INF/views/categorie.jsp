<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>E-commerce</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/style.css"></link>
</head>
<body>
<a href='<c:url value="j_spring_security_logout" />'>Logout</a>
<div id="exception" class="errors">${exception}</div>
<div id="form" class="cadre">
		<f:form modelAttribute="categorie"  action="saveCat" method="post" enctype="multipart/form-data">
				
			<table id="table1" class="tab1">
				<tr>
					<td>ID CATEGORIE</td>
					<td><f:input path="idCategorie" /></td>
					<td><f:errors path="idCategorie" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>NOM CATEGORIE</td>
					<td><f:input path="nomCategorie"/></td>
					<td><f:errors path="nomCategorie" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>DESCRPTION CAT</td>
					<td><f:textarea path="description"/></td>
					<td><f:errors path="description" cssClass="errors"></f:errors></td>
				</tr>
				<tr>
					<td>PHOTO CAT</td>
					<c:if test="${categorie.idCategorie!=null}">
				    <td><img src="CatPhoto?idCat=${categorie.idCategorie}"/></td>
					</c:if>			
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Valider" /></td>

				</tr>
			</table>
		</f:form>
	</div>
	
	<div id="table" class="cadre">
	<table class="tab2">
		<tr>
			<th>ID</th><th>NOM CAT</th><th>DESCRIPTION</th><th>PHOTO</th><th colspan="2">GESTION</th>
		</tr>
			<c:forEach items="${categories}" var="categorie"> 
				<tr>
				 <td>${categorie.idCategorie}</td>
				 <td>${categorie.nomCategorie}</td>
				 <td>${categorie.description}</td>
				 <td><img src="CatPhoto?idCat=${categorie.idCategorie}"/></td>
				 <td><a href="deleteCat?idCat=${categorie.idCategorie}">Supprimer</a></td>
				 <td><a href="updateCat?idCat=${categorie.idCategorie}">Modifier</a></td>
				</tr>
		</c:forEach>
	</table>
	
	</div>
</body>
</html>