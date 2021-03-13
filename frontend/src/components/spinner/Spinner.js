import React from "react";
import './Spinner.css';

const Spinner = (props) => (
  <div class="lds-roller" style={props.style}>
    <div></div>
    <div></div><div></div><div></div><div></div><div></div><div></div><div></div>
  </div>
)

export default Spinner;