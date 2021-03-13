import React from "react";
import "./DisplayBoulderPage.css";
import Hold from "../../components/hold/Hold";
import { toast } from 'react-toastify';
import boulderApi from '../../api/boulderApi.js';

class DisplayBoulderPage extends React.Component {
    state = {
        data: {
            name: '',
            grade: '',
            author: '',
            
        },
    }

       isSelected = (x,y) => {
        return this.props.location.state.holds.filter(hold => hold.x == x && hold.y == y).length > 0;
    }

    display = async () => {
        try {
            await boulderApi.displayBoulder(this.props.location.state.id); //todo laczenie z api
           
            toast.success('Display boulder succesfull');
        } catch (error) {

            toast.error('Display boulder unsuccesfull');
        }
    }

    onSubmit = () => {
        this.display();
    }

    render() {



        let holds = [];    

        for (let x = 0; x < 8; x++) {
            for (let y = 0; y < 8; y++) {
                if (this.isSelected(x,y)) {
                    holds.push(<Hold x={x} y={y} disabled = {true} clicked = {true} />)
                }
                else {
                    holds.push(<Hold x={x} y={y} disabled = {true} className = "smallHold"/>)
                }
            }
        }

        return (
            <div>
                <h1>Wybrany boulder</h1>
                <div className="my-p">Nazwa: {this.props.location.state.name}</div>
                <div className="my-p">Wycena: {this.props.location.state.grade}</div>
                <div className="my-p">Autor:  {this.props.location.state.author}</div>
                <div className="grid-container">
                    {holds}
                </div>
                <div className="wrapper">
                    <div className="form-wrapper">
                        <div className="addTab">
                            <button type="submit" onClick={this.onSubmit} >Wyświetl</button>
                        </div>
                    </div>
                </div>
            </div>
        );
    };

} 

export default DisplayBoulderPage;
