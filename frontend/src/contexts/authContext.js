import React from 'react';

const authContext = React.createContext({
  authenticated: false,
  change: () => {}
})

export default authContext;