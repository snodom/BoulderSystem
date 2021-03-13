import React from "react";
import "./SmallBoard.css";
import SmallHold from "../../components/smallHold/SmallHold";
import {withRouter} from "react-router-dom";

class SmallBoard extends React.Component {

    constructor(props) {
        super(props);
        this.state =   {
            name: props.name,
            id: props.id,
            grade: props.grade,
            holds: props.holds,
            author: props.author,
        };

      }

      onClickOnBoulder = (id) => {
            this.props.history.push(
            {
                pathname:  `/boulder/${this.state.id}`,
                state:  this.state
            }
            )
    }

    isSelected = (x,y) => {
        return this.state.holds.filter(hold => hold.x == x && hold.y == y).length > 0;
    }


    render() {

        let holds = [];    

        for (let x = 0; x < 8; x++) {
            for (let y = 0; y < 8; y++) {
                if (this.isSelected(x,y)) {
                    holds.push(<SmallHold x={x} y={y} className = "smallHold_clicked"/>)
                }
                else {
                    holds.push(<SmallHold x={x} y={y} className = "smallHold"/>)
                }
            }
        }

        return (
            <div className="cont1" onClick= {this.onClickOnBoulder}>
                <h1 className="small-title"> 
                    Nazwa: {this.state.name} Wycena: {this.state.grade}
                </h1>
                <div className="small-grid-container">
                    {holds}
                </div>
            </div>
        );
    };
}

export default withRouter(SmallBoard);