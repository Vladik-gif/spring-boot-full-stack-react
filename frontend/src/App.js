import React, { Component } from 'react';
import Home from './components/home/Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ClientList from './components/client/ClientList';
import ClientEdit from "./components/client/ClientEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/clients' exact={true} component={ClientList}/>
            <Route path='/clients/:id' component={ClientEdit}/>
          </Switch>
        </Router>
    )
  }
}

export default App;