function customAlert(msg,duration)
{
 var styler = document.createElement("div");
  styler.setAttribute("style","border: solid 5px Red;top:50%;left:40%;background-color:#444;color:Silver;");
 styler.innerHTML = "<p>"+msg+"</p>";
 setTimeout(function()
 {
   styler.parentNode.removeChild(styler);
 },duration);
 document.getElementById("alert").appendChild(styler);
}
  function caller()
  {
    customAlert("Product added to shopping cart","2000");
  }