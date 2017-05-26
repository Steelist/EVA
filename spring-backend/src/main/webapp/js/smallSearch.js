/*
Handles clicks and state changes.
 */
class SearchForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};
        this.state = {data: ["asd"]}
        this.handleChange = this.handleChange.bind(this);
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    /*
    Changes the state to the event target's value.

    @param event Event for changing target value.
     */
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    /*
    Sets the response as the data variable's value.

    @param response Response data.
     */
    showResult(response) {
        this.setState({
            data: response
        });
    }

    /*
    Gets data from the server.
     */
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

    /*
    Handles submit event.

    @param event Event for clicking submit.
     */
    handleSubmit(event) {
        event.preventDefault();
        this.getDataFromServer();
    }

    /*
    Render the element.
     */
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
 Renders content and attaches it to an element with an id of search.
 */
ReactDOM.render(
<SearchForm/>,
    document.getElementById('search')
);