<h1>Ajax File Upload With Progress Bar</h1>
<%@ page session="false" %>
<script src="/Game/src/main/webapp/jquery.form.min.js"></script>
<script src="/Game/src/main/webapp/jquery.js"></script>
<script>
var main = function()
{
   $("#uploadFile").on('submit',function(e)
                   {
    e.preventDefault();   
       $(this).ajaxSubmit(
       
           {
            beforeSend:function()
               {
                $("#prog").show();
                $("#prog").attr('value','0');
                   
               },
               uploadProgress:function(event,position,total,percentCompelete)
               {
                  $("#prog").attr('value',percentCompelete); 
                   $("#percent").html(percentCompelete+'%');
               },
               success:function(data)
               {
                   $("#index").html(data);
               }
           });
   });
};

$(document).ready(main);

</script>
<form id="uploadFile" method="POST" enctype="multipart/form-data" action="uploadFile">
<input type="file" name="file" id="file">
    <input type="submit">
</form>
<progress id="prog" max="100" value="0" style="display:none;"></progress>
<div id="percent"></div>

<div id="index"></div>