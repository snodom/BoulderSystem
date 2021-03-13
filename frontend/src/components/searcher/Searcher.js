import React from "react";
import './Searcher.css';


class Searcher extends React.Component {

  constructor(props) {
    super(props);
    this.state =   {
       search: props.name,
    };
    console.log(this.state)

  }


   handleChange = (e) =>{
    this.props.handleChange(e.target.value)

  }

  render() {
    return (
      <div className="searcherWrapper">
        <input className="searcher" type="text" placeholder={this.state.search === 'name' ? 'Nazwa' : 'Wycena'} onChange={this.handleChange} />
      </div>
    );
  }
}

export default Searcher;
