var CheckButton = React.createClass({

    checkout:function(){

        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "cart=";
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        location.reload();
    },
    render:function(){
        return(
            <div>
                <button onClick={this.checkout}>Checkout shoppingcart</button>
            </div>
        );
    }
});

ReactDOM.render(<CheckButton />, document.getElementById('checkout'));