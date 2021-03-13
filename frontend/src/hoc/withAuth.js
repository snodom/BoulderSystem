import React, { Component } from 'react';
import session from '../session';
import AuthContext from '../contexts/authContext';

const withAuth = WrappedComponent => {
  return class extends Component {
    state = {
      authenticated: false
    }

    componentWillMount() {
      const authenticated = session.isLogged();
      console.log("didMount: ", authenticated)
      this.setState({ authenticated });
    }

    componentDidUpdate(prevProps, prevState) {
      console.log("didUpdate")
    }

    setAuthenticated = (authenticated) => {
      console.log(authenticated)
      this.setState({ authenticated });
    }

    render() {
      const { authenticated } = this.state;
      const newProps = {
        ...this.props,
        authenticated
      }
      console.log("render")
      return (
        <AuthContext.Provider value={{ authenticated, change: this.setAuthenticated }}>
          <WrappedComponent {...newProps} />
        </AuthContext.Provider>
      )
    }
  }
}

export default withAuth;