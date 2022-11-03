import { Route, Switch } from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import AvailableFlights from "./pages/AvailableFlights";
import { useEffect, useState } from "react";

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
        <Route path="/AvailableFlights">
          <AvailableFlights flights={availableFlights}/>
        </Route>
        <Route path="/fav">
        </Route>
      </Switch>
   </Layout>
  );
}

export default App;