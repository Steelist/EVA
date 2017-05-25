class ConsoleForm extends React.Component {
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
        alert('A console was submitted: ');
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);
        console.log(data);

        fetch('http://localhost:8080/console', {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify(data),
            mode: "cors"
        })

        console.log(JSON.stringify(data).length);
    }

    render() {
        return (
            <form onSubmit={this.handleSubmit} name="myform">
            Name:<br/>
        <input type="text" name="name" defaultValue="Playstation 4"/>
            <br/>
            Price tag:<br/>
        <input type="number" name="price" defaultValue="350"/>
            <br/>
            Weight (kg):<br/>
        <input type="number" name="weight" defaultValue="15"/>
            <br/>
            Memory (GB):<br/>
        <input type="number" name="memory" defaultValue="1000"/>
            <br/>
            Quantity:<br/>
        <input type="number" name="quantity" defaultValue="10"/>
            <br/>
            Picture:<br/>
        <input type="text" name="picture" defaultValue="http://www.novelupdates.com/img/noimagefound.jpg"/>
            <br/>
            Tags:<br/>
        <input type="text" name="tags" defaultValue="PS4 Playstation 4 pleikkari 350€ 15kg 1000gb"/>
            <br/>
            <input type="submit" value="Submit" />
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
<ConsoleForm/>,
    document.getElementById('root')
);
