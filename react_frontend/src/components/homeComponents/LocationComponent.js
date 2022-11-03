import React from "react";
import Form from "react-bootstrap/Form";

function LocationComponent(props) {

  return (
    <div className="col-sm-3">
      <Form.Select 
        name={props.locationnameid}
        aria-label="Default select example"
        {...props}

      >
        {/* {<option selected disabled>Choose one</option>} */}
        {props.data &&
          props.data.map((place, index) => (
            <option key={index} value={place.name} id={place.id}>
              {place.name}
            </option>
          ))}
      </Form.Select>
    </div>
  );
}

export default LocationComponent;