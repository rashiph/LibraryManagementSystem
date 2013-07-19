function doAjaxPostForProduct(){
    var vendorId = document.getElementById('vendor').value;

    $.ajax({
        type: "GET",
        url: "/newOrder/"+vendorId,
        success: function(response){


            alert('success:' );
        },
        error: function(e){
            alert('Error: '+ e);
        }
    });

}
