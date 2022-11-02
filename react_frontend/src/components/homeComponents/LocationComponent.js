import React from "react";
import Form from "react-bootstrap/Form";

function LocationComponent(props) {
  return (
    <div className="col-sm-3">
      <Form.Select name={props.locationnameid} aria-label="Default select example" >
        <option selected disabled>Choose one</option>
        {props.places.map((place) => <option value={place} id={place}>{place}</option>)}
      </Form.Select>
    </div>
  );
}

export default LocationComponent;
