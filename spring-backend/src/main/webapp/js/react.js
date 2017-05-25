if(!localStorage["alertdisplayed"]) {
    var now = new Date();
    now.setMonth( now.getMonth() + 1 );
    document.cookie = "name=Not logged in";
    document.cookie = "expires="+now.toUTCString();
    document.cookie = "path=/";
    location.reload();
    localStorage["alertdisplayed"] = true
}

var MainBox  = React.createClass({

    render:function(){
        return(
            <App/>
        );
    }
});

var App = React.createClass({
    //setting up initial state
    getInitialState:function(){
        return{
            data:[]
        };
    },
    componentDidMount(){
        this.getDataFromServer('http://localhost:8080/items');
    },
    //showResult Method
    showResult: function(response) {

        this.setState({
            data: response
        });
    },
    //making ajax call to get data from server
    getDataFromServer:function(URL){
        $.ajax({
            type:"GET",
            dataType:"json",
            url: URL,
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
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

class ResultItem extends React.Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
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
                                <h4><a onClick={this.handleClick}>{camper.name}</a>
                                </h4>
                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                            <div classname="cartButton">
                                <button id="checkoutbutton" onClick={this.handleSubmit}>Add to shopping cart</button>
                            </div>
                        </div>
                    </div>
    );
    }
    handleSubmit(event){
        event.preventDefault();
        caller();
        console.log(this.props.user.id);
        var data = this.props.user.id;
        var x = getCookie("cart");
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "cart="+x+","+data;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        console.log(document.cookie);
        /*
        var URL = 'http://localhost:8080/updateCart';
        $.ajax({
            type:"POST",
            dataType:"json",
            headers: {
                'content-type': 'application/json',
            },
            url: URL,
            data: JSON.stringify(data)
        });*/
    }
}

ReactDOM.render(<MainBox />, document.getElementById('app'));