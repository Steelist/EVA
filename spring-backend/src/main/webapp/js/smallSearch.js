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
           
            <input id="app2" type="text" name="tags" placeholder="Search items..."></input>
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