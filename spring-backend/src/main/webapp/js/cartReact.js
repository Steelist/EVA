/*
Returns the finished product.
 */
var MainBox  = React.createClass({
    render:function(){
        return(
            <App/>
        );
    }
});

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
Gets cart items.
 */
var App = React.createClass({
    /*
    Setting up initial state
     */
    getInitialState:function(){
        return{
            data:[]
        };
    },

    /*
     Gets invoked immediately after a component is mounted. One of the component's lifecycle methods.
     */
    componentDidMount(){
        this.getDataFromServer('http://localhost:8080/showShoppingCartWithItems/'+getCookie("cart").substring(1));
    },

    /*
    Method to show results.

    @param response The cart items.
     */
    showResult: function(response) {
        this.setState({
            data: response
        });
    },
    /*
    Making ajax call to get data from server.

    @param URL Url for getting cart items.
     */
    getDataFromServer:function(URL){
        if(getCookie("cart").substring(0,1)===","){
            $.ajax({
                    type:"GET",
                    dataType:"json",
                    //data: getCookie("cart").substring(1),
                    url: URL,
                    success: function(response) {
                        this.showResult(response);
                    }.bind(this),
                    error: function(xhr, status, err) {
                        console.error(this.props.url, status, err.toString());
                    }.bind(this)
                });
        }

    },
    render:function(){
        return(
            <div>
            <Result result={this.state.data}/>
        </div>
        );
    }
});

/*
Wraps the result item.
 */
var Result = React.createClass({
    render:function(){
        var result = this.props.result.map(function(result,index){
            return <ResultItem key={index} user={ result } />
        });
        return(
            <div className="container">
            <div className="col-md-9">
            <div className="row">
            {result}
            </div>
            </div>
            </div>
        );
    }
});

/*
Handles events and renders the item.
 */
class ResultItem extends React.Component{
    constructor(props){
        super(props);
        this.removeFromCart = this.removeFromCart.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    /*
    Shows clicked item.

    @param event Event of clicking the item title.
     */
    handleClick(event){
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "item="+this.props.user.id;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        window.location.replace("showitem.html");
    }

    /*
    Removes an item from the cart and reloads view.

    @param event Event of clicking remove button.
     */
    removeFromCart(event){
        event.preventDefault();
        var x = getCookie("cart");
        if(x.includes(this.props.user.id)){
            x = x.replace(","+this.props.user.id, '');
            var now = new Date();
            now.setMonth( now.getMonth() + 1 );
            document.cookie = "cart="+x;
            document.cookie = "expires="+now.toUTCString();
            document.cookie = "path=/";
            location.reload();
        }

    }

    /*
    Renders the element.
     */
    render(){
        var camper = this.props.user;
        var link = "http://localhost:8080/items/"+camper.id;
        const divStyle = {
            padding: 20 + 'px',
        };
        const mainDiv = {
            marginBottom: 30 + 'px',
        };
        const imageWrapper = {
            width: 200 + 'px',
            height: 200 + 'px',
        };
        return(
           <div className="col-sm-4 col-lg-4 col-md-4" style={mainDiv}>
                        <div className="thumbnail" style={divStyle}>
                <div style={imageWrapper}>
                        <img src={camper.picture} alt=""></img></div>
                            <div className="caption">
                                <h4 className="pull-right">{camper.price} €</h4>
                                <br></br>
                                <h4><a href="#" onClick={this.handleClick}>{camper.name}</a>
                                </h4>
                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                            <button id="checkoutbutton" onClick={this.removeFromCart}>Remove from cart</button>
                        </div>
                    </div>
    );
    }
}

/*
 Renders content and attaches it to an element with an id of app.
 */
ReactDOM.render(<MainBox />, document.getElementById('app'));