import { useState, useEffect } from "react";
import React from "react";
import Form from "react-bootstrap/Form";

function LocationComponent(props) {
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch(`http://localhost:8081/place/get_all`, {
      method: "GET",
      cache: "default",
    })
      .then((response) => response.json())
      .then((actualData) => setData(actualData));
  }, []);

  return (
    <div className="col-sm-4">
      <Form.Select 
        name={props.locationnameid}
        aria-label="Default select example"
      >
        7{/* {<option selected disabled>Choose one</option>} */}
        {data &&
          data.map((place) => (
            <option value={place.name} id={place.id}>
              {place.name}
            </option>
          ))}
      </Form.Select>
    </div>
  );
}

export default LocationComponent;