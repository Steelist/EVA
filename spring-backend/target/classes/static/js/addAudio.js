/*
 Creates the Audio form.
 */
class AudioForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};

        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    /*
    Sets current state to match the event target's value.

    @param event Event of changing form data.
     */
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    /*
    Handles the event of submitting the inserted data by sending a post request with stringified form data.

    @param event Event of clicking submit button.
     */
    handleSubmit(event) {
        alert('An audio was submitted: ');
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);

        fetch('http://localhost:8080/audio', {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify(data),
            mode: "cors"
        })

    }

    /*
    Renders the form.
     */
    render() {
        return (
            <form onSubmit={this.handleSubmit} name="myform">
            Name:<br/>
        <input type="text" name="name" defaultValue="Sony audio"/>
            <br/>
            Price tag:<br/>
        <input type="number" name="price" defaultValue="60"/>
            <br/>
            Power (W):<br/>
        <input type="number" name="power" defaultValue="80"/>
            <br/>
            Subwoofer power (W):<br/>
        <input type="number" name="subwooferPower" defaultValue="40"/>
            <br/>
            Channels:<br/>
        <input type="number" name="channels" defaultValue="6"/>
            <br/>
            Quantity:<br/>
        <input type="number" name="quantity" defaultValue="10"/>
            <br/>
            Picture:<br/>
        <input type="text" name="picture" defaultValue="http://www.novelupdates.com/img/noimagefound.jpg"/>
            <br/>
            Tags:<br/>
        <input type="text" name="tags" defaultValue="Sony audio 6channel 80W 60€"/>
            <br/>
            <input type="submit" value="Submit" />
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
 Renders form and attaches it to an element with an id of root.
 */
ReactDOM.render(
<AudioForm/>,
    document.getElementById('root')
);
