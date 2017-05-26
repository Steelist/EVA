/*
Sets localstorage's variable true and reloads the view.
 */
if(!localStorage["alertdisplayed"]) {
    var now = new Date();
    now.setMonth( now.getMonth() + 1 );
    document.cookie = "name=Not logged in";
    document.cookie = "expires="+now.toUTCString();
    document.cookie = "path=/";
    location.reload();
    localStorage["alertdisplayed"] = true
}

/*
Wraps the whole element.
 */
var MainBox  = React.createClass({

    render:function(){
        return(
            <App/>
        );
    }
});

/*
Functions as the main view.
 */
var App = React.createClass({
    //setting up initial state
    getInitialState:function(){
        return{
            data:[]
        };
    },

    /*
    One of the component's lifecycle methods. Decides which views to show depending on user clicks.
     */
    componentDidMount(){
             var path = window.location.pathname;
    if(path.includes("/audiodevice.html")){
        this.getDataFromServer('http://localhost:8080/audio');
    }else if (path.includes("/computers.html")){
        this.getDataFromServer('http://localhost:8080/computer');
    }else if (path.includes("/consoles.html")){
        this.getDataFromServer('http://localhost:8080/console');
    }else if (path.includes("/keyboards.html")){
        this.getDataFromServer('http://localhost:8080/keyboard');
    }else if (path.includes("/mice.html")){
        this.getDataFromServer('http://localhost:8080/mouse');
    }else if (path.includes("/screens.html")){
        this.getDataFromServer('http://localhost:8080/screen');
    }else if (path.includes("/tvs.html")){
        this.getDataFromServer('http://localhost:8080/tv');
    }else{
        this.getDataFromServer('http://localhost:8080/items');
    }
    },
    /*
    Method to set data.

    @param response Result data.
     */
    showResult: function(response) {
        this.setState({
            data: response
        });
    },
    /*
    Makes ajax call to get data from server.

    @param URL Url to get the data from.
     */
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

/*
Works as the result template.
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
Gets cookie's name.

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
Handles the submits and clicks and renders the item.
 */
class ResultItem extends React.Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    /*
    Handles click on the item's title.

    @param event Event for clicking an item's title.
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
    Renders the element.
     */
    render(){
        var camper = this.props.user;
        var link = "http://localhost:8080/items/"+camper.id;
        const divStyle = {
            padding: 20 + 'px',
        };
        const imageWrapper = {
            width: 200 + 'px',
            height: 200 + 'px',
        }
        return(
           <div className="col-sm-4 col-lg-4 col-md-4">
                        <div className="thumbnail" style={divStyle}>
                <div style={imageWrapper}>
                        <img src={camper.picture} alt="Item image"></img></div>
                            <div className="caption">
                                <h4 className="pull-right">{camper.price.toFixed(2)} €</h4>
                                <br></br>
                                <h4><a href="#" onClick={this.handleClick}>{camper.name}</a>
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

    /*
    Handles the submit click.

    @param event Event for clicking submit button.
     */
    handleSubmit(event){
        event.preventDefault();
        caller();
        var data = this.props.user.id;
        var x = getCookie("cart");
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "cart="+x+","+data;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
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

/*
If admin is logged in shows this section that allows adding items.
 */
class AdminStuff extends React.Component{
    render(){
        if(getCookie("name")==="admin"){
            return(
                <div>
                    <form action="addTV.html">
                        <input type="submit" value="Add television" />
                    </form>
                    <br/>
                    <form action="addScreen.html">
                        <input type="submit" value="Add screen" />
                    </form>
                    <br/>
                    <form action="addComputer.html">
                        <input type="submit" value="Add computer" />
                    </form>
                    <br/>
                    <form action="addAudio.html">
                        <input type="submit" value="Add audio" />
                    </form>
                    <br/>
                    <form action="addKeyboard.html">
                        <input type="submit" value="Add keyboard" />
                    </form>
                    <br/>
                    <form action="addMouse.html">
                        <input type="submit" value="Add mouse" />
                    </form>
                    <br/>
                    <form action="addConsole.html">
                        <input type="submit" value="Add console" />
                    </form>
                </div>
            );
        }else{
            return(
                <div></div>
            );
        }

    }
}

/*
Renders main view adding to element by the id of app.
 */
ReactDOM.render(<MainBox />, document.getElementById('app'));

/*
 Renders admin view adding to element by the id of admin.
 */
ReactDOM.render(<AdminStuff />, document.getElementById('admin'));