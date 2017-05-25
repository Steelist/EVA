class LoginForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);
        
        console.log(JSON.stringify(data));
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
                 console.log(document.cookie);
                 console.log(data);
                 location.reload();
            }else{
                console.log(document.cookie);
                console.log(data);
                alert("Wrong login credentials");
            }

        }.bind(this),
        error: function(xhr, status, err) {
            console.log('error');
            var x = document.cookie;
            console.log(x);
        }.bind(this)
        });
    }

    render() {
        if(getCookie("name")==="Not logged in"){
            return (

                    <form onSubmit={this.handleSubmit} name="myform">
                    UserName:

                <input id="username" type="text" name="username" placeholder="UserName"/>

                    Password:
                <input id="password" type="text" name="password" placeholder="Password"/>

                    <input id="loginbutton" type="submit" value="Login" />
                    <a href="register.html">Register</a>
                    </form>

            );
        }else{
            return (<div></div>);
        }

    }
}

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

function getFormData($form){
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};

    $.map(unindexed_array, function(n, i){
        indexed_array[n['name']] = n['value'];
    });

    return indexed_array;
}

ReactDOM.render(
<LoginForm/>,
    document.getElementById('login')
);
