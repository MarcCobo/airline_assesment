import React from "react";
import "./SearchComponent.css";
import Form from "react-bootstrap/Form";

function SearchComponent(props) {


  return (
    <div className="col-sm-3">
      <Form.Select aria-label="Default select example" >
        <option selected disabled>Choose one</option>
        {props.places.map((place) => <option value={place}>{place}</option>)}
      </Form.Select>
    </div>
  );
}

export default SearchComponent;
