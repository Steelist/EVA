/*
 Gets the name in the cookie.

 @param cname Cookie's name.
 */
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

/*
Handles the checkouts.
 */
class CheckButton extends React.Component{
    constructor(props) {
        super(props);
        this.checkout = this.checkout.bind(this);
        this.checked = this.checked.bind(this);
    }

    /*
    Calls the data fetching method with the correct url.
     */
    checked(){
        this.getDataFromServer('http://localhost:8080/checkOutItems/'+getCookie("cart"));
    }

    /*
    Gets the needed data.

    @param URL Url for getting the data from.
     */
    getDataFromServer(URL){
        $.ajax({
            type:"GET",
            dataType:"json",
            url: URL,
            success: function(response) {
            }.bind(this)
        });
    }

    /*
    Checks out a cart.

    @param event Event for clicking checkout button.
     */
    checkout(event){
        event.preventDefault();
        this.checked();
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "cart=";
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        alert("Thank you for your purchase! Your items will be on their way as soon as possible.")
        location.reload();
    }

    /*
    Renders the element.
     */
    render(){
        return(
            <div>
                <button id="checkoutbutton" onClick={this.checkout}>Checkout shoppingcart</button>
            </div>
        );
    }
}

/*
 Renders content and attaches it to an element with an id of checkout.
 */
ReactDOM.render(<CheckButton />, document.getElementById('checkout'));