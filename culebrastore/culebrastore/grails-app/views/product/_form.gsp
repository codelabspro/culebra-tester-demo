<%@ page import="pizzashop.Product" %>



<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="product.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" required="" value="${productInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'description', 'error')} required">
	<label for="description">
		<g:message code="product.description.label" default="Description" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="description" cols="40" rows="5" maxlength="1000" required="" value="${productInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'price', 'error')} ">
	<label for="price">
		<g:message code="product.price.label" default="Price" />
		
	</label>
	<g:field name="price" value="${fieldValue(bean: productInstance, field: 'price')}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'status', 'error')} required">
	<label for="status">
		<g:message code="product.status.label" default="Status" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="status" from="${productInstance.constraints.status.inList}" required="" value="${productInstance?.status}" valueMessagePrefix="product.status"/>

</div>

<div class="fieldcontain ${hasErrors(bean: productInstance, field: 'tags', 'error')} ">
	<label for="tags">
		<g:message code="product.tags.label" default="Tags" />
		
	</label>
	<g:select name="tags" from="${pizzashop.Tag.list()}" multiple="multiple" optionKey="id" size="5" value="${productInstance?.tags*.id}" class="many-to-many"/>

</div>

