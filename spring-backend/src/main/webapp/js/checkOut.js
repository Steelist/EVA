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

class CheckButton extends React.Component{
    constructor(props) {
        super(props);
        this.checkout = this.checkout.bind(this);
        this.checked = this.checked.bind(this);
    }
    checked(){
        this.getDataFromServer('http://localhost:8080/checkOutItems/'+getCookie("cart"));
    }
    getDataFromServer(URL){
        $.ajax({
            type:"GET",
            dataType:"json",
            url: URL,
            success: function(response) {
                console.log(response);
            }.bind(this)
        });
    }

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
    render(){
        return(
            <div>
                <button id="checkoutbutton" onClick={this.checkout}>Checkout shoppingcart</button>
            </div>
        );
    }
}

ReactDOM.render(<CheckButton />, document.getElementById('checkout'));