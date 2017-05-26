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
Handles logout.
 */
class LoginState extends React.Component {
    constructor(props) {
        super(props);

    }
    componentDidMount(){
    }

    /*
    Logs out the user.
     */
    logout(){
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "name=Not logged in";
        document.cookie = "cart=";
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        location.reload();
    }

    /*
    Renders the element.
     */
    render() {
        var x = getCookie("name");
        if(x==="Not logged in"){
             return (
                 <div>
                 </div>
             );
        }else{
            return (
                <div>
         
                <p>{x}<button id="checkoutbutton" type="button" onClick={this.logout}>Logout</button></p>
               
                </div>
            );
        }
    }

}

/*
 Renders content and attaches it to an element with an id of loggedIn.
 */
ReactDOM.render(
<LoginState/>,
    document.getElementById('loggedIn')
);