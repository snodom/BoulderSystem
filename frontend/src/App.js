import React, { Component } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import Navbar from './components/navbar/Navbar';
import HomePage from './pages/homePage/HomePage'

import Footer from './components/footer/Footer';

import './App.css';

import { ToastContainer } from 'react-toastify'
import 'react-toastify/dist/ReactToastify.css'
import withAuth from './hoc/withAuth';
import AddBoulderPage from './pages/addBoulderPage/AddBoulderPage';
import BoulderListPage from './pages/boulderListPage/BoulderListPage';
import DisplayBoulderPage from './pages/displayBoulderPage/DisplayBoulderPage';

class App extends Component {
  render() {
    return (
      <BrowserRouter>
        <Navbar authenticated={this.props.authenticated} />
        <>
          <Switch>
            <Route path="/" component={HomePage} exact />
            <Route path="/add" component={AddBoulderPage} {...this.props} />
            <Route path="/boulderList" component={BoulderListPage} exact />
            <Route path="/boulder/:id" component={DisplayBoulderPage} />
          </Switch>
          <ToastContainer autoClose={3000} hideProgressBar />
        </>
        <Footer />
      </BrowserRouter>
    );
  }
}

export default withAuth(App);
