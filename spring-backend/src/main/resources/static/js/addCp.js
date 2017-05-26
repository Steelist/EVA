/*
 Creates the Computer form.
 */
class ComputerForm extends React.Component {
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
        alert('A computer was submitted: ');
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);

        fetch('http://localhost:8080/computer', {
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
        <input type="text" name="name" defaultValue="CasualGamer v0.5"/>
            <br/>
            Price tag:<br/>
        <input type="number" name="price" defaultValue="1999.99"/>
            <br/>
            CPU:<br/>
        <input type="text" name="cpu" defaultValue="Intel i7-7700K"/>
            <br/>
            GPU:<br/>
        <input type="text" name="gpu" defaultValue="Asus Strix 1080ti OC"/>
            <br/>
            PSU:<br/>
        <input type="text" name="psu" defaultValue="Crucial 750W modular"/>
            <br/>
            RAM:<br/>
        <input type="text" name="ram" defaultValue="Ballistix 2x8gb 2666mhz"/>
            <br/>
            HDD:<br/>
        <input type="text" name="hdd" defaultValue="Western Digital 1tb 7600rpm"/>
            <br/>
            Motherboard:<br/>
        <input type="text" name="motherBoard" defaultValue=" ASROG Maximus Hero VIII"/>
            <br/>
            Weight:<br/>
        <input type="number" name="weight" defaultValue="20.55"/>
            <br/>
            Operating System:<br/>
        <input type="text" name="os" defaultValue="Windows 10 pro"/>
            <br/>
            Picture:<br/>
        <input type="text" name="picture" defaultValue="https://images.jimms.fi/product/6/4/153965-b339765_300x300.jpg"/>
            <br/>
            Quantity:<br/>
        <input type="number" name="quantity" defaultValue="10"/>
            <br/>
            Tags:<br/>
        <input type="text" name="tags" defaultValue="CasualGamer v0.5 tehomylly Intel i7-7700K 1080ti OC Windows 10 16gb RAM 750W psu"/>
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
<ComputerForm/>,
    document.getElementById('root')
);