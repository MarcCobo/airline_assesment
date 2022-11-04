import classes from "./AvailableFlights.module.css";
import { useEffect, useState } from "react";
import airplaneLogo from "./Airplane-PNG-Free-Download.png";

function AvailableFlights({ flights }) {
  const [placeData, setPlaceData] = useState();
  const [placeData2, setPlaceData2] = useState();

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
                    alt="Please Hire Us"
                  ></img>
                  <h5 className={classes.from}>
                    Origin <br />
                    {placeData && placeData.name}
                  </h5>
                  <h5 className={classes.to}>
                    Destination
                    <br />
                    {placeData2 && placeData2.name}
                  </h5>

                  <p className={classes.airline}>Airline: {flight.airline}</p>
                  <p className={classes.date}>Date: {flight.date}</p>
                  <button className={classes.button}>Book</button>
                </div>
              </div>
            </div>
          );
        })}
    </div>
  );
}
export default AvailableFlights;
