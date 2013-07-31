function validate()
{
   if(document.bookForm.name.value=="" )
   {
     alert( "Please provide your name !" );


     return false;
   }
   var author = document.bookForm.author.value;
   if(isNaN(author)==false || author== "")
   {
     alert( "Please enter valid author name !" );

     return false;
   }
   var category = document.bookForm.category.value;
   if(isNaN(category)==false || category== "")
   {
     alert( "Please enter valid category !" );

     return false;
   }
    var edition= document.bookForm.edition.value;
   if(isNaN(edition)==true ||edition=="")
   {
        alert( "Please enter valid edition !" );

        return false;
    }
   var price = document.bookForm.price.value;
   if(isNaN(price)==true || price== "")
   {
     alert( "Please enter valid price of book !" );

     return false;
   }


}

 $(function() {
$( "#date" ).datepicker();
});

