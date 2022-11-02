import React from "react";
import Form from "react-bootstrap/Form";

function DatePickerComponent() {
  return (
    <div className="col-sm-3">
      <Form.Control type="date" name="date_of_birth"  />
    </div>
  );
}

export default DatePickerComponent;
