import { Route, Switch } from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import AvailableFlights from "./pages/AvailableFlights";
import { useEffect, useState } from "react";
import Login from "./pages/Login";

function App() {
  const[availableFlights, setAvailableFlights]= useState()

  const addFlights=flights=>{
    setAvailableFlights(flights)
  }

  useEffect(()=>{
    console.log(availableFlights)
  })

  return (
   <Layout>
     <Switch>
        <Route path="/" exact>
          <Home addFlights={addFlights} />
        </Route>
        {availableFlights &&  <Route path="/AvailableFlights">
          <AvailableFlights flights={availableFlights}/>
        </Route>}
        <Route path="/login">
          <Login />
        </Route>
      </Switch>
   </Layout>
  );
}

export default App;