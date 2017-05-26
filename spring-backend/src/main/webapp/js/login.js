/*
Handles the login.
 */
class LoginForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    /*
    Sets the state to the event target's value.

    @param event Event for changing values.
     */
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    /*
    Handles the submit click.

    @param event Event for clicking submit button.
     */
    handleSubmit(event) {
        event.preventDefault();
        var frm = $(document.myform2);
        var data = getFormData(frm);
        $.ajax({
        url: 'http://koti.tamk.fi/~c4vstenm/Login3.php',
        type:"POST",
        dataType: "json",
        data: JSON.stringify(data),
        success: function(data) {
            if(data.success){
               
                 var now = new Date();
                 now.setMonth( now.getMonth() + 1 );
                 document.cookie = "name="+data.name;
                 document.cookie = "expires="+now.toUTCString();
                 document.cookie = "path=/";
                 location.reload();
            }else{
                alert("Wrong login credentials");
            }

        }.bind(this),
        error: function(xhr, status, err) {
            var x = document.cookie;
        }.bind(this)
        });
    }

    /*
    Renders the login element.
     */
    render() {
        if(getCookie("name")==="Not logged in"){
            return (

                    <form onSubmit={this.handleSubmit} name="myform2">
                    UserName:

                <input id="username" type="text" name="username" placeholder="UserName"/>

                    Password:
                <input id="password" type="password" name="password" placeholder="Password"/>

                    <input id="loginbutton" type="submit" value="Login" />
                    <a href="register.html">Register</a>
                    </form>

            );
        }else{
            return (<div></div>);
        }

    }
}

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
 Creates JavaScript array of objects ready to be encoded as a JSON string.

 @param $form Form element.
 */
function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

/*
 Renders content and attaches it to an element with an id of login.
 */
ReactDOM.render(
<LoginForm/>,
    document.getElementById('login')
);
