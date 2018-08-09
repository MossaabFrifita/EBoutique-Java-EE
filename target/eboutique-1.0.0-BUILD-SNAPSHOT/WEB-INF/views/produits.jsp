<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<html>
<head>

<title>E-commerce</title>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/styleProd.css"></link>

</head>
<body>
<a href='<c:url value="j_spring_security_logout" />'>Logout</a>
	<div id="form" class="cadre">
		<f:form action="saveProd" modelAttribute="produit" method="POST"   enctype="multipart/form-data">
			<table>
				<tr>
					<td> ID PRODUIT</td>
					<td><f:input path="idProduit"  /></td>
					<td><f:errors path="idProduit" cssClass="errors" /></td>
				</tr>
				<tr>
					<td> DESGINATION</td>
					<td><f:input path="designation" /></td>
					<td><f:errors path="designation" cssClass="errors" /></td>
				</tr>
				<tr>
					<td> CATEGORIE</td>
					<td><f:select items="${categories}"  itemLabel="nomCategorie" itemValue="idCategorie" path="categorie.idCategorie" ></f:select></td>
				</tr>
				<tr>
					<td> Description</td>
					<td><f:textarea path="description" /></td>
					<td><f:errors path="description" cssClass="errors" /></td>
				</tr>
				<tr>
					<td> Prix</td>
					<td><f:input path="prix" /></td>
					<td><f:errors path="prix" cssClass="errors" /></td>
				</tr>
				<tr>
					<td> Quantite</td>
					<td><f:input path="quantite" /></td>
					<td><f:errors path="quantite" cssClass="errors" /></td>
				</tr>
				<tr>
					<td> Selectionner</td>
					<td><f:checkbox path="selected"></f:checkbox> </td>
					<td><f:errors path="quantite" cssClass="errors" /></td>
				</tr>
					<tr>
					<td>PHOTO</td>
					<c:if test="${produit.idProduit!=null}">
				    <td><img src="ProdPhoto?idProd=${produit.idProduit}"/></td>
					</c:if>			
					<td><input type="file" name="file" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Valider" /></td>
					<!--td><a href="editCategValide"><input type="button" value="Editer" /></a></td-->
				</tr>
			</table>
		</f:form>
	</div>
	
	
	<div id="table" class="cadre">
	<table class="tab2">
		<tr>
			<th>ID</th><th>Designation</th><th>DESCRIPTION</th><th>catégorie</th>
			<th>Prix</th><th>Quantite</th><th>Selected</th><th>photo</th><th colspan="2">GESTION</th>
		</tr>
			<c:forEach items="${produits}" var="produit"> 
				<tr>
				 <td>${produit.idProduit}</td>
				 <td>${produit.designation}</td>
				 <td>${produit.description}</td>
				 <td>${produit.categorie.nomCategorie}</td>
				 <td>${produit.prix}</td>
				 <td>${produit.quantite}</td>
				 <td>${produit.selected}</td>
				 <td><img src="ProdPhoto?idProd=${produit.idProduit}"/></td>
				 <td><a href="deleteProd?idProd=${produit.idProduit}">Supprimer</a></td>
				  <td><a href="editProd?idProd=${produit.idProduit}">Modifier</a></td>
				</tr>
		</c:forEach>
	</table>
	
	</div>

</body>
</html>