import React from "react";
import Form from "react-bootstrap/Form";

function DatePickerComponent(props) {
  return (
    <div className="col-sm-3">
      <Form.Control type="date" name={props.datenameid} id={props.datenameid} required/>
    </div>
  );
}

export default DatePickerComponent;
