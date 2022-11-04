import classes from "./AvailableFlights.module.css";
import { useEffect, useState } from "react";
import airplaneLogo from "./Airplane-PNG-Free-Download.png";
import ReservationForm from "../components/bookComponents/ReservationForm";
import { propTypes } from "react-bootstrap/esm/Image";
import arrow from './arrow-icon-10.png'

//Main page that shows Available Flights.

function AvailableFlights({ flights }) {
  const [isModal, setIsModal] = useState(false);
  const [placeData, setPlaceData] = useState();
  const [placeData2, setPlaceData2] = useState();


  //Fetching Location Data for Available Flights
  useEffect(() => {
    getAllLocations();
  }, []);

  function getAllLocations() {
    console.log(flights);
    fetch(`http://localhost:8081/place/get/${flights[0].origin}`, {
      method: "GET",
    })
      .then((response) => response.json())
      .then((actualData) => {
        setPlaceData(() => {
          return actualData;
        });
      });

    fetch(`http://localhost:8081/place/get/${flights[0].destination}`, {
      method: "GET",
    })
      .then((response) => response.json())
      .then((actualData2) => {
        setPlaceData2(() => {
          return actualData2;
        });
      });
  }
  // End Fetching Location Data for Available Flights

  //Main Function returns a map of all Available Flights fetched in Searcbar.js
  // and passed here thorugh Searchbar >> Home >> App >> AvailableFlight
  return (
    <div>
      {flights &&
        flights.map((flight, index) => {
          return (
            <div className={classes.bigcontainer}>
              <div className={classes.container} key={index}>
                <div className={classes.mainbody}>
                  <img
                    className={classes.img}
                    src={airplaneLogo}
                    alt="Airplane Image"
                  ></img>
                  <h5 className={classes.from}>
                    Origin <br />
                   <p style={{fontSize: "30px",marginTop: "10px"}}>{placeData && placeData.name}</p> 
                  </h5>
                  <img
                    className={classes.img2}
                    src={arrow}
                    alt="Arrow Image"
                  ></img>
                  <h5 className={classes.to}>
                    Destination
                    <br />
                    <p style={{fontSize: "30px",marginTop: "10px"}}>{placeData2 && placeData2.name}</p>
                  </h5>

                  <p className={classes.airline2}>Airline: {flight.airline}</p>

                  <p className={classes.airline}></p>
                  <p className={classes.date}>Flight No: {flight.flight_num}</p>
                  <p className={classes.flightno}>Date: {flight.date}</p>
                  
                  <p className={classes.flightno}>No. of Layovers: {flight.layover}</p>
                  <p className={classes.flightno}>Layover Location: {flight.layover_text}</p>
                  
                  <button
                    className={classes.button}
                    onClick={() => {
                      sessionStorage.setItem("id", flight.id);
                      sessionStorage.setItem("price", flight.price);
                      setIsModal(!isModal);
                    }}
                  >
                    Book <br/>
                    {flight.price}&euro;
                  </button>
                </div>
              </div>
            </div>
          );
        })}
      {isModal && (
        <div className={classes.modaldiv}>
          <ReservationForm onCancel={() => setIsModal(!isModal)} />
        </div>
      )}
    </div>
  );
}
export default AvailableFlights;
