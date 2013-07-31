<div class = "createBook">
<form name="bookForm" action="/save" method="post" onsubmit="return(validate())" >
<div class ="book"> BOOKS
<div class="add-book">

   Name:    <input type="text" name="name" placeholder="name"/>   <br>
   author:    <input type="text" name="author" placeholder="author"  />  <br>
   category:    <input type="text" name="category" placeholder="category"  />  <br>
   edition:    <input type="text" name="edition"  placeholder="edition" />    <br>
   price:    <input type="text" name="price" placeholder="price"  />     <br>
   dateOfPurchase:    <input type="text" name="dateOfPurchase" placeholder="mm/dd/yyyy" id="date"/>   <br>
   vendor:    <input type="text" name="vendor"  placeholder="vendor" />                 <br>
</div>
  </div>
<button type="submit" style = "height: 25px;width: 100px"><b><u>save book</u></b> </button>
</form>

</div>