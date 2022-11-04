import { Route, Switch } from "react-router-dom";
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Layout from './components/layout/Layout';
import Home from './pages/Home';
import AvailableFlights from "./pages/AvailableFlights";
import { useEffect, useState } from "react";
import Login from "./pages/Login";
import BookingSuccess from "./pages/BookingSuccess";
import BookingFailure from "./pages/BookingFailure";
import Faq from "./pages/Faq";
import About from "./pages/About";

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
        <Route path="/success">
          <BookingSuccess />
        </Route>
        <Route path="/fail">
          <BookingFailure />
        </Route>
        <Route path="/faq">
          <Faq/>
        </Route>
        <Route path="/about">
          <About/>
        </Route>
      </Switch>
   </Layout>
  );
}

export default App;