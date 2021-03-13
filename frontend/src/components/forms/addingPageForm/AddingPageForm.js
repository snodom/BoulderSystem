import React from "react";
import "./AddingPageForm.css";
import boulderApi from '../../../api/boulderApi.js';
import { toast } from 'react-toastify';
import Spinner from "../../spinner/Spinner";
import Hold from "../../hold/Hold";

class AddingPageForm extends React.Component {
    state = {
        data: {
            boulder: '',
            grade: '',
            author: '',
            xYString: '',
            
        },
        checked: false,
        loading: false,
        selected: [],
    }


    onChange = event => {
 
        this.setState({
            data: { ...this.state.data, [event.target.name]: event.target.value },
        });
    }


    add = async () => {
        try {
            await boulderApi.savePocket(this.state.data); //todo laczenie z api
            this.setState({ loading: false }) 
            toast.success('Adding boulder succesfull');
        } catch (error) {
            console.log(error)
            this.setState({ loading: false })
            toast.error('Adding boulder unsuccesfull');
        }
    }

    onSubmit = event => {

       this.setState((prevState) => ({ loading: true }))
        event.preventDefault();
        this.selectedToString()
        this.add();
        this.setState({
            data: {
                boulder: '',
                grade: '',
                author: '',
                holds: '',
                xYString: '',
            },
            checked: false,
            selected: [],
        });
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

        let xy ="";
        this.state.selected.forEach((hold) => xy = xy.concat("", hold.x + "-" + hold.y + "-"))
        xy = xy.slice(0, -1);
        this.state.data.xYString = xy;
       
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
            this.state.loading ? <Spinner style={{position: "fixed", left: "50%", top: "50%", transform: "translate(-50%, -50%"}}/> :
            <div>
                <div className="grid-container">
                    {holds}
                </div>
                <div className="wrapper">
                    <div className="form-wrapper">
                        <form onSubmit={this.onSubmit}>
                            <div className="input">
                                <label htmlFor="name"></label>
                                <input
                                    type="text"
                                    name="boulder"
                                    placeholder="Nazwa"
                                    value={this.state.data.boulder}
                                    onChange={this.onChange}
                                />
                            </div>
                            <div className="grade">
                                <label htmlFor="grade"></label>
                                <input
                                    type="number"
                                    name="grade"
                                    placeholder="Wycena"
                                    value={this.state.data.grade}
                                    onChange={this.onChange}
                                />
                            </div>
                            <div className="Author">
                                <label htmlFor="author"></label>
                                <input
                                    type="text"
                                    name="author"
                                    placeholder="Autor"
                                    value={this.state.data.author}
                                    onChange={this.onChange}
                                />
                            </div>

                            <div className="addTab">
                                <button type="submit">Dodaj</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}

export default AddingPageForm;
