var MainBox  = React.createClass({
    render:function(){
        return(
            <App/>
        );
    }
});

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

var App = React.createClass({
    //setting up initial state
    getInitialState:function(){
        return{
            data:[]
        };
    },
    componentDidMount(){
        this.getDataFromServer('http://localhost:8080/showShoppingCartWithItems/'+getCookie("cart").substring(1));
    },
    //showResult Method
    showResult: function(response) {
        this.setState({
            data: response
        });
    },
    //making ajax call to get data from server
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
class ResultItem extends React.Component{
    constructor(props){
        super(props);
        this.removeFromCart = this.removeFromCart.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(event){
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "item="+this.props.user.id;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        window.location.replace("showitem.html");
    }
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

    render(){
        var camper = this.props.user;
        var link = "http://localhost:8080/items/"+camper.id;
        return(
           <div className="col-sm-4 col-lg-4 col-md-4">
                        <div className="thumbnail">
                        <img src={camper.picture} alt=""></img>
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

ReactDOM.render(<MainBox />, document.getElementById('app'));