
<div class = "createOrder">
<form name="orderForm" method="GET">
<div class ="vendor"> VENDORS
<div class="vendor-list">
                <select id="vendor" name="vendor" onchange="doAjaxPostForProduct()">
                    $VENDORS:{
                    <option value=$attr.vendorId$>$attr.vendorName$</option>
                    }$
                </select>
</div>

<div class="product-list">
                <select id="product" name="product">
                    $PRODUCTS:{
                    <option value=$attr.productId$>$attr.productName$</option>
                    }$
                </select>
</div>
<input type="submit" name="save" method=GET action= />
</form>
</div>
