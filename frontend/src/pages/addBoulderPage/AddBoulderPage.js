import React from "react";
import AddingPageForm from '../../components/forms/addingPageForm/AddingPageForm';
import "./AddBoulderPage.css";

class AddBoulderPage extends React.Component {
    render() {
        return (
            <div>
                <h1>Wybierz chwyty</h1>
                <AddingPageForm />
            </div>
        );
    };

} 

export default AddBoulderPage;
