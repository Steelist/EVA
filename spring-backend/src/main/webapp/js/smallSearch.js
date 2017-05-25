class SearchForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};
        this.state = {data: ["asd"]}
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    showResult(response) {
        this.setState({
            data: response
        });
    }


    getDataFromServer(){
        var frm = $(document.myform);
        var data = getFormData(frm);
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "search="+JSON.stringify(data);
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        window.location.replace("search.html");

    }

    handleSubmit(event) {
        event.preventDefault();
        this.getDataFromServer();
    }

    render() {
        return (
            <div>
            <form onSubmit={this.handleSubmit} name="myform">
           
            <input id="app2" type="text" name="tags" placeholder="Search items..."></input>
            </form>

    </div>
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
<SearchForm/>,
    document.getElementById('search')
);