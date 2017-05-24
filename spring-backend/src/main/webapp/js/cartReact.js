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
        console.log(decodeURIComponent(document.cookie));
    },
    //showResult Method
    showResult: function(response) {
        this.setState({
            data: response
        });
    },
    //making ajax call to get data from server
    getDataFromServer:function(URL){
        console.log(getCookie("cart").substring(1));
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
            <div className="row">
            {result}
            </div>
            </div>
        );
    }
});
class ResultItem extends React.Component{
    constructor(props){
        super(props);

    }

    render(){
        var camper = this.props.user;
        return(
            <div className="col-xs-6 col-sm-4 col-md-3">
            <div className="item">
            <div className="col-xs-12"><h3>{camper.name}</h3></div>
        <div className="col-xs-12"><img src={camper.picture} /></div>
        <div className="col-xs-12"><p>Hinta:&nbsp;{camper.price}</p></div>
        <div className="col-xs-12"><p>Paino:&nbsp;{camper.weight}</p></div>
        </div>
        </div>
    );
    }
}

ReactDOM.render(<MainBox />, document.getElementById('app'));