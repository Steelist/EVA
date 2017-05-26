/*
Creates the TV form.
 */
class TVForm extends React.Component {
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
        alert('A TV was submitted: ');
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);

        fetch('http://localhost:8080/tv', {
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
        <input type="text" name="name" defaultValue="JättiTV666"/>
            <br/>
            Price tag:<br/>
        <input type="number" name="price" defaultValue="99.99"/>
            <br/>
            Resolution:<br/>
        <input type="text" name="resolution" defaultValue="1920x1080"/>
            <br/>
            Refreshrate:<br/>
        <input type="number" name="refreshRate" defaultValue="144"/>
            <br/>
            Size:<br/>
        <input type="text" name="size" defaultValue="100x60x20"/>
            <br/>
            Type:<br/>
        <input type="text" name="type" defaultValue="Led"/>
            <br/>
            Aspect Ratio:<br/>
        <input type="text" name="aspectRatio" defaultValue="16:9"/>
            <br/>
            Connections:<br/>
        <input type="text" name="connections" defaultValue="2xhdmi, 3xdp, 6xusb3.1, 2xGigabitEthernet"/>
            <br/>
            Weight:<br/>
        <input type="number" name="weight" defaultValue="15.65"/>
            <br/>
            Quantity:<br/>
        <input type="number" name="quantity" defaultValue="10"/>
            <br/>
            Picture:<br/>
        <input type="text" name="picture" defaultValue="https://images.jimms.fi/product/1/4/141015-p174303.jpg"/>
            <br/>
            Tags:<br/>
        <input type="text" name="tags" defaultValue="JättiTV666 144hz gaming television 99,99€ full hd 16:9 led tv"/>
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
<TVForm/>,
    document.getElementById('root')
);