import { useHistory } from "react-router-dom";
import { Card } from "react-bootstrap";
import "./SearchBar.css";
import LocationComponent from "./LocationComponent";
import DatePickerComponent from "./DatePickerComponent";
import SubmitButton from "./SubmitButton";
import { useState, useEffect } from "react";
import axios from "axios";
import { DateRangePicker } from "rsuite";

function SearchBar({ addFlights }) {
  //const history = useHistory();
  //const originsHardcoded = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];
  //const destinations = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];
  const history = useHistory();
  const [origins, setOrigins] = useState(null);
  const [destinations, setDestinations] = useState([]);
  const [dates, setDates] = useState([]);

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
            style={{ border: "2px solid black", borderRadius: "98px" }}
          >
            <div className="container row justify-content-between">
              <p className="col-sm-4 title">Origin</p>
              <p className="col-sm-4 title">Destination</p>
              <p className="col-sm-4 title">Dates</p>
            </div>
            <Card.Body className="container row justify-content-between">
              <LocationComponent places={origins} locationnameid="origin" />
              <LocationComponent
                places={destinations}
                locationnameid="destination"
              />
              <DateRangePicker
              size="md"
              className="col-sm-4"
                format="yyyy-MM-dd"
                defaultCalendarValue={[
                  new Date("2022-11-01 00:00:00"),
                  new Date("2022-12-01 23:59:59"),
                ]}
              />
              {/* <DatePickerComponent datenameid="departure" />
              <DatePickerComponent datenameid="arrival" /> */}
            </Card.Body>
          </Card>
        </form>
      </div>
      <SubmitButton />
    </div>
  );
}

export default SearchBar;