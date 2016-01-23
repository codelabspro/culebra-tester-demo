<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pizza Store</title>
    <blueprint:resources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
<section class="container">
    <!-- Section 1 -->
    <section class="leftcontainer">
        <g:render template="productCard" collection="${filteredproducts}" var="filteredproduct"/>
        <div>
        <p>${filteredproduct.name}</p>

            <p>${filteredproduct.description}</p>

            <p>${filteredproduct.price}</p>
        </div>
    </section>
    <!-- Section 2 -->
    <section class="rightcontainer">
        <dt>Show</dt>
        <dd>
            <ul>
                <g:each in="${tags}" var="tag">
                    <li><g:link controller="product" action="listfiltered">${tag.name}</g:link></li>
                </g:each>
            </ul>
        </dd>
    </dl>
    </section>
</section>
</body>
</html>

