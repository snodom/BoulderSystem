import React from 'react';
import { withRouter } from 'react-router-dom';
import './Hold.css';


class Hold extends React.Component {

    constructor(props) {
        super(props);
        this.state =   {
            clicked: false,
            disabled: props.disabled,
            xCoordinate: props.x,
            yCoordinate: props.y,
            className: props.clicked == undefined ? "hold" : "hold_clicked"
        };
    }

    onClick = (props) => {
        if (this.state.disabled != true){
            if (this.state.clicked){
                this.setState({
                    className: "hold",
                    clicked: false
                  });
            } else {
                this.setState({
                    className: "hold_clicked",
                    clicked: true
                  });
            }
            this.props.clickedHandler(this.state.xCoordinate, this.state.yCoordinate, this.state.clicked);
        }
      
    }

    render() {
        return (
            <div onClick={this.onClick}
                className={this.state.className} 
            >
            </div>
        )
    }
}

export default withRouter(Hold);
