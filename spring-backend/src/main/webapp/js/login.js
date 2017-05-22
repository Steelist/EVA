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
            console.log(data);
        }.bind(this),
        error: function(xhr, status, err) {
            console.log('error');
        }.bind(this)
        });
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit} name="myform">
            UserName:
        <input type="text" name="username" defaultValue="UserName"/>
            
            Password:
        <input type="text" name="password" defaultValue="Password"/>
           
            <input type="submit" value="Login" />
            <a href="register.html">Register</a>
            </form>
    );
    }
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
    document.getElementById('root')
);
