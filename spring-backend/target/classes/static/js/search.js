/*
Gets cookie's name.

@param cname Cookie's name.
 */
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}

/*
Handles the state changes.
 */
class SearchForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};
        this.state = {data: ["asd"]}
        this.handleChange = this.handleChange.bind(this);
    }

    /*
    Changes the state to the modified event target's value.

    @param event Event for changing the target value.
     */
    handleChange(event) {
        this.setState({value: event.target.value});
    }

    /*
    Shows the response data.

    @param response Response data.
     */
    showResult(response) {
        this.setState({
            data: response
        });
    }

    /*
    Gets data from the server.

    @param URL Url to get the data from.
     */
    getDataFromServer(URL){
        var frm = $(document.myform);
        var data = getFormData(frm);
        var x = getCookie("search");
        $.ajax({
            type:"POST",
            dataType:"json",
            headers: {
                'content-type': 'application/json',
            },
            url: URL,
            data: x,
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    /*
    One of the component's lifecycles methods. Handles initialization methods.
     */
    componentDidMount() {
        event.preventDefault();
        this.getDataFromServer('http://localhost:8080/itemsSearch');
        var frm = $(document.myform);
        var data = getFormData(frm);
    }

    /*
    Renders the element.
     */
    render() {
        return (
            <div>
            <Result result={this.state.data}/>
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
Works as the result template.
 */
var Result = React.createClass({
    render:function(){
        var result = this.props.result.map(function(result,index){
            return <ResultItem key={index} user={ result } />
        });
        return(
            <div className="container">
            <div className="col-md-9">
            <div className="row">
            {result}
            </div>
            </div>
            </div>
        );
    }
});

/*
Handles the submit and clicks and renders the item.
 */
class ResultItem extends React.Component{
    constructor(props){
        super(props);
        this.handleSubmit = this.handleSubmit.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    /*
    Shows the clicked item.

    @param event Event for clicking item title.
     */
    handleClick(event){
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "item="+this.props.user.id;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
        window.location.replace("showitem.html");
    }

    /*
    Handles submit clicking.

    @param event Event for clicking submit button.
     */
    handleSubmit(event){
        event.preventDefault();
        caller();
        var data = this.props.user.id;
        var x = getCookie("cart");
        var now = new Date();
        now.setMonth( now.getMonth() + 1 );
        document.cookie = "cart="+x+","+data;
        document.cookie = "expires="+now.toUTCString();
        document.cookie = "path=/";
    }

    /*
    Renders the item.
     */
    render() {
        var camper = this.props.user;
        const divStyle = {
            padding: 20 + 'px',
        };
        const imageWrapper = {
            width: 200 + 'px',
            height: 200 + 'px',
        }

        if (camper.name){
            return(
                      <div className="col-sm-4 col-lg-4 col-md-4">
                        <div className="thumbnail" style={divStyle}>
                        <div style={imageWrapper}><img src={camper.picture} alt=""></img></div>
                            <div className="caption">
                                <h4 className="pull-right">{camper.price} €</h4>
                                
                                
                                <br></br>
                                <h4><a href="#" onClick={this.handleClick}>{camper.name}</a>
                                </h4>
                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>
                            <div classname="cartButton">
                                <button id="checkoutbutton" onClick={this.handleSubmit}>Add to shopping cart</button>
                            </div>

                        </div>
                    </div>


        );
        }else{
            return <div></div>
        }
    }
}

/*
 Renders content and attaches it to an element with an id of searchResult.
 */
ReactDOM.render(
<SearchForm/>,
    document.getElementById('searchResult')
);