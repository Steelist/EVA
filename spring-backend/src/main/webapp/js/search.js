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

class StampForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {value: ''};
        this.state = {data: ["asd"]}
        this.handleChange = this.handleChange.bind(this);
    }

    handleChange(event) {
        this.setState({value: event.target.value});
    }

    showResult(response) {
        this.setState({
            data: response
        });
    }


    getDataFromServer(URL){
        var frm = $(document.myform);
        var data = getFormData(frm);
        var x = getCookie("search");
        console.log(document.cookie);
        console.log(x);
        console.log(getCookie("search"));
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

    componentDidMount() {
        event.preventDefault();
        this.getDataFromServer('http://localhost:8080/itemsSearch');
        var frm = $(document.myform);
        var data = getFormData(frm);
    }

    render() {
        return (
            <div>
            <Result result={this.state.data}/>
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

var ResultItem = React.createClass({
    render:function(){
        var camper = this.props.user;

        if (camper.name){
            return(
                      <div className="col-sm-4 col-lg-4 col-md-4">
                        <div className="thumbnail">
                        <img src={camper.picture} alt=""></img>
                            <div className="caption">
                                <h4 className="pull-right">{camper.price} €</h4>
                                <br></br>
                                <h4><a href="">{camper.name}</a>
                                </h4>
                                <p>This is a short description. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                            </div>

                        </div>
                    </div>


        );
        }else{
            return <div></div>
        }
    }
});

ReactDOM.render(
<StampForm/>,
    document.getElementById('search')
);