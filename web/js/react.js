class ComputerForm extends React.Component {
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
    alert('A computer was submitted: ');
    var frm = $(document.myform);
    var data = JSON.stringify(frm.serializeArray());
    console.log(data);
    event.preventDefault();
  }

  render() {
    return (
      <form onSubmit={this.handleSubmit} name="myform">
          Name:<br/>
          <input type="text" name="name" value="Tehomylly404"/>
          <br/>
          Price tag:<br/>
          <input type="number" name="price" value="99.99"/>
          <br/>
          Resolution:<br/>
          <input type="text" name="resolution" value="1920x1080"/>
          <br/>
          Refreshrate:<br/>
          <input type="text" name="refreshRate" value="144hz"/>
          <br/>
          Size:<br/>
          <input type="text" name="size" value="100x60x20"/>
          <br/>
          Type:<br/>
          <input type="text" name="type" value="Led"/>
          <br/>
          Aspect Ratio:<br/>
          <input type="text" name="aspectRatio" value="16:9"/>
          <br/>
          Connections:<br/>
          <input type="text" name="connections" value="2xhdmi, 3xdp, 6xusb3.1, 2xGigabitEthernet"/>
          <br/>
          Weight:<br/>
          <input type="number" name="weight" value="15.65"/>
          <br/>
          Picture:<br/>
          <input type="text" name="picture" value="http://pic-url-here.jpg"/>
          <br/>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

ReactDOM.render(
            <ComputerForm/>,
            document.getElementById('root')
        );