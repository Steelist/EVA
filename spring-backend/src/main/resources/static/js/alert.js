/*
Creates the alert template element for an added product.

@param msg
@param duration
 */
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

/*
Gets called when the alert is needed and adds the content.
 */
function caller()
{
customAlert("Product added to shopping cart","2000");
}