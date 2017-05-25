class ScreenForm extends React.Component {
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
        alert('A screen was submitted: ');
        event.preventDefault();
        var frm = $(document.myform);
        var data = getFormData(frm);

        fetch('http://localhost:8080/screen', {
            method: 'POST',
            headers: {
                'content-type': 'application/json',
            },
            body: JSON.stringify(data),
            mode: "cors"
        })

    }

    render() {
        return (
            <form onSubmit={this.handleSubmit} name="myform">
            Screen Size:<br/>
        <input type="number" name="screenSize" defaultValue="27.50"/>
            <br/>
            Package Size:<br/>
        <input type="text" name="packageSize" defaultValue="100x60x30"/>
            <br/>
            Name:<br/>
        <input type="text" name="name" defaultValue="Benq XK250-H"/>
            <br/>
            Price tag:<br/>
        <input type="number" name="price" defaultValue="399.95"/>
            <br/>
            Resolution:<br/>
        <input type="text" name="resolution" defaultValue="1920x1080"/>
            <br/>
            Refreshrate:<br/>
        <input type="number" name="refreshRate" defaultValue="180"/>
            <br/>
            Wastetime:<br/>
        <input type="number" name="wasteTime" defaultValue="1.00"/>
            <br/>
            Viewing angle:<br/>
        <input type="number" name="viewingAngle" defaultValue="270.00"/>
            <br/>
            Type:<br/>
        <input type="text" name="type" defaultValue="ldc"/>
            <br/>
            Aspect Ratio:<br/>
        <input type="text" name="aspectRatio" defaultValue="16:9"/>
            <br/>
            Connections:<br/>
        <input type="text" name="connections" defaultValue="1xhdmi, 1xdp, 1xdvi, 1xvga"/>
            <br/>
            Weight:<br/>
        <input type="number" name="weight" defaultValue="15.65"/>
            <br/>
            Quantity:<br/>
        <input type="number" name="quantity" defaultValue="10"/>
            <br/>
            Picture:<br/>
        <input type="text" name="picture" defaultValue="https://images.jimms.fi/product/4/1/145548-p441729.jpg"/>
            <br/>
            Tags:<br/>
        <input type="text" name="tags" defaultValue="Benq XK250-H 180hz gaming monitor 270 degree 388,95€ full hd 16:9 1ms waste"/>
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
<ScreenForm/>,
    document.getElementById('root')
);