import { Card } from "react-bootstrap";
import "./SearchBar.css";
import LocationComponent from "./LocationComponent";
import DatePickerComponent from "./DatePickerComponent";

function SearchBar() {
  const origins = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];
  const destinations = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];

  return (
    <div id="div">
      <form>
      <Card className="col-sm-10 offset-sm-1" style={{border: "2px solid black" , borderRadius: "98px"}}>
        <div className="container">
          <p className="col-sm-3 title" >Origin</p>
          <p className="col-sm-3 title">Destination</p>
          <p className="col-sm-3 title">Start date</p>
          <p className="col-sm-3 title">End date</p>
        </div>
        <Card.Body className="container">
          <LocationComponent places={origins} locationnameid="origin"/>
          <LocationComponent places={destinations} locationnameid="destination"/>
          <DatePickerComponent datenameid="departure" />
          <DatePickerComponent datenameid="arrival" />
        </Card.Body>
      </Card>
      
      <div id="div2">
        <button>Find my Flights!</button>
      </div>
      </form>
    </div>
  );
}

export default SearchBar;
