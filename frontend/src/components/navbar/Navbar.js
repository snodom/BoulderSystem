import React from 'react';
import { NavLink } from 'react-router-dom';
import './Navbar.css';
import Logo from '../../assets/img/logo.png';

export default class Navbar extends React.Component {

  render() {
    return (
      <nav className="nav-bar">
        <div className="icon">
          <img src={Logo} alt="" />
        </div>
        <ul >
          <li><NavLink exact to="/">Home</NavLink></li>
          <li><NavLink exact to="/add">Dodaj problem</NavLink></li>
          <li><NavLink exact to="/boulderList">Lista problemów</NavLink></li>
        </ul>
      </nav>
    );
  }
}