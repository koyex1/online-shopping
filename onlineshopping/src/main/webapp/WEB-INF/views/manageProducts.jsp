<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<div class="container">

<div class="row">
<c:if test="${not empty message}">
<div class="col-xs-12">

<div class="alert alert-sucess alert-dismissible">

<button type="button" class="close" data-dismiss="alert">&times;</button>

${message}


</div>

</div>
</c:if>
<div class="col-md-offset-2 col-md-8">
<div class="panel panel-primary">
<div class="panel-heading">

<h4>Product Management</h4>

</div>
<div class="panel-body">
<!-- FORM ELEMENT -->
<sf:form class="form-horizontal" modelAttribute="product"
action="${contexRoot}/manage/products"
method="POST">

<div class="form-group">
<label class="control-label col-md-4" for="name">Enter Product Name</label>
<div class="col-md-8">

<sf:input type="text" path="name" id="name" placeholder="Product Name (E.g Samsung S10)" class="form-control"/>

<em class="help-block">Field Important</em>

</div>
</div>


<div class="form-group">
<label class="control-label col-md-4" for="brand">Enter Brand Name</label>
<div class="col-md-8">

<sf:input type="text" path="brand" id="brand" placeholder="Brand Name (E.g Samung)" class="form-control"/>

<em class="help-block">Field Important</em>

</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="description">Product Description</label>
<div class="col-md-8">
<!-- placeholder is cut -->
<sf:textarea path="description" id="description" rows="4" placeholder="Write a description" class="form-control"/>

<em class="help-block">Field Important</em>

</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="unitPrice">Enter Unit Price</label>
<div class="col-md-8">
<!-- placeholder cut -->
<sf:input type="number" path="unitPrice" id="unitPrice" placeholder="Unit Price is &#8377" class="form-control"/>

<em class="help-block">Field Important</em>

</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="quantity">Quantiy Available</label>
<div class="col-md-8">

<sf:input type="number" path="quantity" id="quantity" placeholder="Quantity Available" class="form-control"/>

<em class="help-block">Field Important</em>

</div>
</div>

<div class="form-group">
<label class="control-label col-md-4" for="categoryId">Select Category</label>
<div class="col-md-8">

<sf:select path="categoryId" id="categoryId" class="form-control" 
items="${categories }"
itemLabel="name"
itemValue="id"
/>
<em class="help-block">Field Important</em>
</div>
</div>

<div class="form-group">
<div class="col-md-offset-4 col-md-8">

<input type="submit" name="submit" id="submit" value="Submit" class="btn btn-primary"/>
<!-- hidden fields -->
<sf:hidden path="id"/>
<sf:hidden path="code"/>
<sf:hidden path="supplierId"/>
<sf:hidden path="active"/>
<sf:hidden path="purchases"/>
<sf:hidden path="views"/>

</div>
</div>


</sf:form>

</div>

</div>

</div>

</div>
</div>