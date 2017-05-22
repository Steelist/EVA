class StampForm extends React.Component {
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


    getDataFromServer(URL){
        var frm = $(document.myform);
        var data = getFormData(frm);

        $.ajax({
            type:"POST",
            dataType:"json",
            headers: {
                'content-type': 'application/json',
            },
            url: URL,
            data: JSON.stringify(data),
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        this.getDataFromServer('http://localhost:8080/itemsSearch');
        var frm = $(document.myform);
        var data = getFormData(frm);
    }

    render() {
        return (
            <div>
            <form onSubmit={this.handleSubmit} name="myform">
            <br/>
            <input type="text" name="tags" placeholder="Press enter to search..."></input>
            </form>

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
            <div className="row">
            {result}
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
                <div className="col-xs-6 col-sm-4 col-md-3">
                <div className="item">
                <div className="col-xs-12"><h3>{camper.name}</h3></div>
            <div className="col-xs-12"><img src={camper.picture} /></div>
            <div className="col-xs-12"><p>Hinta:&nbsp;{camper.price}</p></div>
            <div className="col-xs-12"><p>Paino:&nbsp;{camper.weight}</p></div>
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
    document.getElementById('app2')
);