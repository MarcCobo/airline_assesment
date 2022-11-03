import { useHistory } from "react-router-dom";
import { Card } from "react-bootstrap";
import "./SearchBar.css";
import LocationComponent from "./LocationComponent";
import DatePickerComponent from "./DatePickerComponent";
import SubmitButton from "./SubmitButton";
import { useState, useEffect } from "react";
import axios from "axios";

function SearchBar({ addFlights }) {
  //const history = useHistory();
  //const originsHardcoded = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];
  //const destinations = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];
  const history = useHistory();
  const [origins, setOrigins] = useState(null);
  const [destinations, setDestinations] = useState([]);

  useEffect(() => {
    fetch(`http://localhost:8081/place/get_all`, {
      method: "GET",
      cache: "default",
    })
      .then((response) => response.json())
      .then((actualData) => setOrigins(actualData));
  }, []);

  function originChangeHandler(e) {
    const value = e.target.value;
    console.log("change");
    axios
      .get("http://localhost:8081/place/get_destinations", {
        params: { origin: value },
      })
      .then((response) => {
        console.log(response.data);
        setDestinations(response.data);
      });
  }

  function GetDataFromUser(e) {
    e.preventDefault();
    const data2 = Object.fromEntries(new FormData(e.target));
    console.log(data2);
    FetchFlights(data2);
    history.replace("/AvailableFlights")
  }

  function FetchFlights(data2) {

    let url = `http://localhost:8081/flight/get_by_origin_destination_date_between?origin=${data2.origin}&destination=${data2.destination}&startDate=${data2.startDate}&endDate=${data2.endDate} 
    `
    console.log(url)
    fetch(url, {
      method: "GET",
      cache: "default",
    })
      .then((response) => response.json())
      .then((response) => 
      addFlights(response))
     
  }

  return (
    <div>
      <div id="div">
        <form id="SearchForm" onSubmit={GetDataFromUser}>
          <Card
            className="col-sm-10 offset-sm-1"
          >
            <div className="container row justify-content-between">
              <p className="col-sm-3 title">Origin</p>
              <p className="col-sm-3 title">Destination</p>
              <p className="col-sm-3 title">Start date</p>
              <p className="col-sm-3 title">End date</p>
            </div>
            <Card.Body className="container">
            <LocationComponent
                data={origins}
                places={origins}
                locationnameid="origin"
                onChange={originChangeHandler}
              />
              <LocationComponent
                data={destinations}
                places={destinations}
                locationnameid="destination"
              />
              <DatePickerComponent datenameid="startDate" />
              <DatePickerComponent datenameid="endDate" /> 
            </Card.Body>
          </Card>
        </form>
      </div>
      <SubmitButton />
    </div>
  );
}

export default SearchBar;