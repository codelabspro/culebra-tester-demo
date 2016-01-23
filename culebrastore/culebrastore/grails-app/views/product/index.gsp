<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
		<crumbs:resources/>
	</head>
	<body>
		<a href="#list-product" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/admin')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-product" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>

						<g:sortableColumn property="name" title="${message(code: 'product.name.label', default: 'Name')}" />

						<g:sortableColumn property="description" title="${message(code: 'product.description.label', default: 'Description')}" />

						<g:sortableColumn property="price" title="${message(code: 'product.price.label', default: 'Price')}" />

						<g:sortableColumn property="status" title="${message(code: 'product.status.label', default: 'Status')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${productInstanceList}" status="i" var="productInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${productInstance.id}">${fieldValue(bean: productInstance, field: "name")}</g:link></td>

						<td>${fieldValue(bean: productInstance, field: "description")}</td>

						<td>${fieldValue(bean: productInstance, field: "price")}</td>

						<td>${fieldValue(bean: productInstance, field: "status")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${productInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
