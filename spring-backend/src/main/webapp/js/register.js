class RegisterForm extends React.Component {
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
        caller();
        $.ajax({
        url: 'http://koti.tamk.fi/~c4vstenm/Register3.php',
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
            Name:<br/>
        <input type="text" name="name"  placeholder="Name"/>
            <br/>
            UserName:<br/>
        <input type="text" name="username"  placeholder="UserName"/>
            <br/>

            Password:<br/>
        <input type="text" name="password" placeholder="Password"/>
            <br/>
            <br/>
            <input type="submit" value="Register" />
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
<RegisterForm/>,
    document.getElementById('register')
);