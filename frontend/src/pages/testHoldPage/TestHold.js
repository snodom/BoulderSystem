import React from "react";
import "./TestHold.css";
import Hold from "../../components/hold/Hold";
class TestHold extends React.Component {

    constructor(props) {
        super(props);
        this.state =   {
           selected: [],
        };
      }

    clickedHandler = (x,y,selected) => {

        if(selected == false && !this.arrayIncludesHold(x,y)) {
            this.state.selected.push({x: x, y: y});       
        }
        else {
            this.state.selected = this.state.selected.filter(el => (el.x != x || el.y != y)) 
        }

    }

    selectedToString = () => {
        //todo
    }

    arrayIncludesHold(x,y) {
        return this.state.selected.filter(el => el.x == x && el.y == y).length > 0;
    }

    render() {
        let holds = [];

        for (let x = 0; x < 8; x++) {
            for (let y = 0; y < 8; y++) {
                holds.push(<Hold clickedHandler={this.clickedHandler} x={x} y={y} />)
            }
        }

        return (
            <div className="grid-container">
                {holds}
            </div>
          
        );
    };
}

export default TestHold;