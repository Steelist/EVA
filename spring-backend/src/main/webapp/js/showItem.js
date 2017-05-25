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
        this.getDataFromServer('http://localhost:8080/items/'+getCookie("item"));
    },
    showResult(response) {

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
        return(

            <Item user={ this.props.result } />

        );
    }
});

class Item extends React.Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    render(){
        var camper = this.props.user;
        var price= parseFloat(camper.price).toFixed(2);
        return(
                
                <div className="thumbnail">
                <img className="img-responsive" src={camper.picture} alt=""></img>
                    <div className="caption-full">
                        <h3 className="pull-right">{price} €</h3>
                       
                        <h4><h3 >{camper.name}</h3>
                            
                        </h4>
                        <div classname="cartButton">
                                <button id="checkoutbuttonItem" onClick={this.handleSubmit}>Add to shopping cart</button>
                            </div>
                       
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum</p>
                       
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

ReactDOM.render(<MainBox />, document.getElementById('item'));