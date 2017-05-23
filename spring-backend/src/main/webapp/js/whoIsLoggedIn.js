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


class LoginState extends React.Component {
    constructor(props) {
        super(props);

    }
    componentDidMount(){
        console.log(decodeURIComponent(document.cookie));
    }

    logout(){
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "name=Not logged in";
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        location.reload();
    }

    render() {
        var x = getCookie("name");
        if(x==="Not logged in"){
        return(<div><h2>You are not logged in!</h2></div>);
        }else{
            return (
                <div>
                <h2>{x}</h2>
                <button type="button" onClick={this.logout}>Logout</button>
                </div>
            );
        }
    }

}

ReactDOM.render(
<LoginState/>,
    document.getElementById('loggedIn')
);