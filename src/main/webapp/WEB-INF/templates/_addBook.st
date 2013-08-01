<div class = "createBook">
    <form name="bookForm" action="/save" method="post" class="form-horizontal well" onsubmit="return(validate())">
       <div class="form-group">
           <label for="bookName" class="col-lg-2 control-label">Book name:</label>
           <div class="col-lg-4">
             <input type="text" class="form-control" id="bookName" />
           </div>
       </div>
       <div class="form-group">
          <label for="authorName" class="col-lg-2 control-label">Author name:</label>
          <div class="col-lg-4">
             <input type="text" class="form-control" id="authorName" />
          </div>
       </div>
       <div class="form-group">
            <label for="category" class="col-lg-2 control-label">Category:</label>
            <div class="col-lg-4">
               <input type="text" class="form-control" id="category" />
            </div>
       </div>
       <div class="form-group">
                   <label for="edition" class="col-lg-2 control-label">Edition:</label>
                   <div class="col-lg-4">
                      <input type="text" class="form-control" id="edition" />
                   </div>
              </div>
       <div class="form-group">
                   <label for="price" class="col-lg-2 control-label">Price:</label>
                   <div class="col-lg-4">
                      <input type="text" class="form-control" id="price" />
                   </div>
              </div>
       <div class="form-group">
                   <label for="date" class="col-lg-2 control-label">Date of purchase:</label>
                   <div class="col-lg-4">
                      <input type="text" class="form-control" id="date" />
                   </div>
              </div>
       <div class="form-group">
                   <label for="vendor" class="col-lg-2 control-label">Vendor:</label>
                   <div class="col-lg-4">
                      <input type="text" class="form-control" id="vendor" />
                   </div>
              </div>
       <div class="form-group">
                          <div class="col-lg-2"></div>
                          <div class="col-lg-4">
                <button type="submit" class="btn btn-primary">save book</button>
                          </div>
                     </div>

    </form>

</div>