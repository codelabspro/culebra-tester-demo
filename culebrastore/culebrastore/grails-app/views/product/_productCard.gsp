

<div class="product">
    <div><h3><g:link action="showdetail" id="${product.id}">${product.name}</g:link></h3> </div>
    <h4>${product.name}</h4>
    <p>${product.description}</p>
    <div class="price">Price : "${product.price}"</div>


    <g:remoteLink controller="product" action="ajaxdetail"
                  update="detailContent">Get Detail</g:remoteLink><br/>

    <div id="detailContent" style='float: right; width: 80%; min-height: 10px; background-color: #c0ffc0;'>
        <p>This is the main content</p>
    </div>

</div>
