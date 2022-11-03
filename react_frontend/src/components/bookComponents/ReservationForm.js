import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import classes from "./ReservationForm.module.css";
import { useState } from "react";
import axios from "axios";

function ReservationForm(props) {
  const [price, setPrice] = useState(0); //We have to change the '0' to props.price
  const [bags, setBags] = useState(false);


  function checkboxClickHandler(e) {
    e.preventDefault();
    setBags(e.target.value);
    callGetVariablePrice(e)
  }

  function callGetVariablePrice(e) {
    e.preventDefault();
    axios
      .get("http://localhost:8082/reservation/get_variable_price", {params: {
        ages: "1, 5, 10",
        bags: bags,
        price: 200.0,
      }})
      .then((response) => {
        console.log(response);
      });
  }

  return (
    <div className="col-sm-6 offset-3">
      <Card>
        <Card.Body>
          <div className="row justify-content-between">
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter name" />
            </div>
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter surname" />
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter nationality" />
            </div>
            <div className="col-sm-5">
              <Form.Control
                type="number"
                placeholder="Enter age"
              />
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Check
                type="checkbox"
                label="Check if the passenger is going to take luggage"
                onClick={checkboxClickHandler}
              />
            </div>
            <div className="col-sm-5 d-flex justify-content-center">
              <button>+</button>
              <button>-</button>
            </div>
            <p className={classes.price}>{price}€</p>
          </div>
        </Card.Body>
      </Card>
    </div>
  );
}

export default ReservationForm;
