import React from 'react';
import { withRouter } from 'react-router-dom';
import './SmallHold.css';


class SmallHold extends React.Component {

    constructor(props) {
        super(props);
        this.state =   {
            clicked: false,
            disabled: false,
            xCoordinate: props.x,
            yCoordinate: props.y,
            className: props.className
        };  
    }

    render() {
        return (
            <div 
                className={this.state.className} 
            >
            </div>
        )
    }
}

export default withRouter(SmallHold);
