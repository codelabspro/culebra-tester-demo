<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Pizza Store</title>
    <g:javascript library="jquery"/>
    <blueprint:resources/>
    <link href="${resource(dir: 'css', file: 'app.css')}" type="text/css" rel="stylesheet">
</head>
<body>
<section class="container">
    <!-- Section 1 -->
    <section class="leftcontainer">
        <g:render template="productCard" collection="${products}" var="product"/>
        <div>
            <h4>Title : ${hello}</h4>

            <p>Description</p>

            <p>Price</p>
        </div>
    </section>
    <!-- Section 2 -->
    <section class="rightcontainer">
        <dt>Show</dt>
        <dd>
            <ul>
            <li><g:link controller="product" action="list">All</g:link> </li>
                <g:each in="${tags}" var="tag">
                    <li><g:link controller="product" action="listfiltered">${tag.name}</g:link></li>
                </g:each>
            </ul>
        </dd>
    </dl>
    </section>
    <!-- Section 3 -->
    <section class="bottomcontainer">
        <g:render template="shoppingCart" collection="${suborders}" var="suborder"/>
        <h4>Shopping Cart for customer</h4>
        <div>
            <h4>Title</h4>

            <p>Description</p>

            <p>Price</p>
        </div>
    </section>
</section>
</body>
</html>

