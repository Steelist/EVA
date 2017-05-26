/*
Handles the submit and value changes.
 */
class RegisterForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    /*
    Sets the state to the state of the event target's value.

    @param event Event for changing the target value.
     */
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    /*
    Handles submit click event.

    @param event Event for clicking submit button.
     */
    handleSubmit(event) {
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);
        //caller();
        $.ajax({
        url: 'http://koti.tamk.fi/~c4vstenm/Register3.php',
        type:"POST",
        dataType: "json",
        data: JSON.stringify(data),
        success: function(data) {
            if(data.success===true){
                alert("User succesfully registered!");
            }else{
                alert("Username already in use!");
            }

        }.bind(this),
        error: function(xhr, status, err) {
            console.log('error');
        }.bind(this)
        });
    }

    /*
    Renders the element.
     */
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
        <input type="password" name="password" placeholder="Password"/>
            <br/>
            <br/>
            <input type="submit" value="Register" />
            </form>
    );
    }
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
 Renders view adding to element by the id of register.
 */
ReactDOM.render(
<RegisterForm/>,
    document.getElementById('register')
);