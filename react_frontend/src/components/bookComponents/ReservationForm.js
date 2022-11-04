import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import classes from "./ReservationForm.module.css";
import { useState } from "react";
import axios from "axios";
import { useHistory } from "react-router-dom";


function ReservationForm(props) {
  const history = useHistory();

  //ModalButtons Code
  function cancelHandler() {
    props.onCancel();
  }

  // End ModalButtons Code

  const [price, setPrice] = useState(0); 
  const [bags, setBags] = useState(false);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [age, setAge] = useState(0);
  const [dni, setDni] = useState("");
  const [nationality, setNationality] = useState("");
  const [plusNineCounter, setPlusNineCounter] = useState(0);
  const [betweenTwoNineCounter, setBetweenTwoNineCounter] = useState(0);
  const [belowTwoCounter, setBelowTwoCounter] = useState(0);
  const [numSeats, setNumSeats] = useState(0);
  let newValue = 0;
  let newBag = false;
  const flightPrice = sessionStorage.getItem("price");//We have to change the '0' to props.price

  function nameChangeHandler(e) {
    setName(e.target.value);
  }

  function surnameChangeHandler(e) {
    setSurname(e.target.value);
  }

  function emailChangeHandler(e) {
    setEmail(e.target.value);
  }

  function ageChangeHandler(e) {
    setAge(e.target.value);
  }

  function dniChangeHandler(e) {
    setDni(e.target.value);
  }

  function nationalityChangeHandler(e) {
    setNationality(e.target.value);
  }

  function checkboxClickHandler() {
    newBag = !bags;
    console.log(newBag);
    setBags(newBag);
    callGetVariablePrice(newBag, plusNineCounter, betweenTwoNineCounter, belowTwoCounter);
  }

  function addPlusNineClickHandler() {
    newValue = plusNineCounter + 1;
    setPlusNineCounter(newValue);
    callGetVariablePrice(bags, newValue, betweenTwoNineCounter, belowTwoCounter);
  }

  function minusPlusNineClickHandler() {
    newValue = plusNineCounter - 1;
    if (newValue < 0) newValue = 0;
    setPlusNineCounter(newValue);
    callGetVariablePrice(bags, newValue, betweenTwoNineCounter, belowTwoCounter);
  }

  function addBetweenTwoNineCounter() {
    newValue = betweenTwoNineCounter + 1;
    setBetweenTwoNineCounter(newValue);
    callGetVariablePrice(bags, plusNineCounter, newValue, belowTwoCounter);
  }

  function minusBetweenTwoNineCounter() {
    newValue = betweenTwoNineCounter - 1;
    if (newValue < 0) newValue = 0;
    setBetweenTwoNineCounter(newValue);
    callGetVariablePrice(bags, plusNineCounter, newValue, belowTwoCounter);
  }

  function addBelowTwoCounter() {
    newValue = belowTwoCounter + 1;
    setBelowTwoCounter(newValue);
    callGetVariablePrice(bags, plusNineCounter, betweenTwoNineCounter, newValue);
  }

  function minusBelowTwoCounter() {
    newValue = belowTwoCounter - 1;
    if (newValue < 0) newValue = 0;
    setBelowTwoCounter(newValue);
    callGetVariablePrice(bags, plusNineCounter, betweenTwoNineCounter, newValue);
  }

  function callGetVariablePrice(bags, plusNineCounter, betweenTwoNineCounter, belowTwoCounter) {
    let agesString = [];
    for (let i = 0; i < plusNineCounter; i++) {
      agesString.push("18");
    }
    for (let i = 0; i < betweenTwoNineCounter; i++) {
      agesString.push("5");
    }
    for (let i = 0; i < belowTwoCounter; i++) {
      agesString.push("1");
    }
    setNumSeats(agesString.length)
    axios
      .get("http://localhost:8082/reservation/get_variable_price", {
        params: {
          ages: agesString.join(),
          bags: bags,
          price: flightPrice,
        },
      })
      .then((response) => {
        setPrice(response.data);
      });
  }

  function postReservation() {
    axios
      .post("http://localhost:8082/reservation/add", {
        flightId: sessionStorage.key("id"),
        name: name,
        surname: surname,
        nationality: nationality,
        dni: dni,
        age: age,
        bags: bags,
        email: email,
        numSeats: numSeats,
        price: price,
      })
      .then((response) => {
        history.replace("/success")
        
      })
      .catch((response) => {
        history.replace("/fail")
      });
  }

  return (
    <div className="col-sm-6">
      <Card>
        <Card.Body>
          <div className="row justify-content-between">
            <div className="col-sm-5">
              <Form.Control
                type="text"
                placeholder="Enter name"
                onChange={nameChangeHandler}
              />
            </div>
            <div className="col-sm-5">
              <Form.Control
                type="text"
                placeholder="Enter surname"
                onChange={surnameChangeHandler}
              />
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Control
                type="text"
                placeholder="Enter nationality"
                onChange={nationalityChangeHandler}
              />
            </div>
            <div className="col-sm-5">
              <Form.Control
                type="number"
                placeholder="Enter age"
                onChange={ageChangeHandler}
              />
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Control
                type="email"
                placeholder="Enter email"
                onChange={emailChangeHandler}
              />
            </div>
            <div className="col-sm-5">
              <Form.Control
                type="text"
                placeholder="Enter dni (00000000X)"
                onChange={dniChangeHandler}
              />
            </div>
          </div>
          <div className="col-sm-12 d-flex justify-content-between mx-auto mt-4">
            <div className="col-sm-6">
              <Form.Check
                type="checkbox"
                label="Check if the passenger/s is/are going to take luggage"
                onClick={checkboxClickHandler}
              />
            </div>
            <div className="col-sm-6">
                {/* This sould be a component for each counter but there is no more time :D */}
              <div className="d-flex justify-content-between">
                <p className={classes.counterTitle}>Passengers age +9</p>
                <div className="col-sm-6 d-flex justify-content-between">
                  <button
                    onClick={minusPlusNineClickHandler}
                    className={classes.counterButton}
                  >
                    -
                  </button>
                  <p className={classes.counter}>{plusNineCounter}</p>
                  <button
                    onClick={addPlusNineClickHandler}
                    className={classes.counterButton}
                  >
                    +
                  </button>
                </div>
              </div>
              <div className="d-flex justify-content-between mt-2">
                <p className={classes.counterTitle}>
                  Passengers age between 2 and 9
                </p>
                <div className="col-sm-6 d-flex justify-content-between">
                  <button
                    onClick={minusBetweenTwoNineCounter}
                    className={classes.counterButton}
                  >
                    -
                  </button>
                  <p className={classes.counter}>{betweenTwoNineCounter}</p>
                  <button
                    onClick={addBetweenTwoNineCounter}
                    className={classes.counterButton}
                  >
                    +
                  </button>
                </div>
              </div>
              <div className="d-flex justify-content-between mt-1">
                <p className={classes.counterTitle}>
                  Passengers age below 2
                </p>
                <div className="col-sm-6 d-flex justify-content-between">
                  <button
                    onClick={minusBelowTwoCounter}
                    className={classes.counterButton}
                  >
                    -
                  </button>
                  <p className={classes.counter}>{belowTwoCounter}</p>
                  <button
                    onClick={addBelowTwoCounter}
                    className={classes.counterButton}
                  >
                    +
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div className="d-flex justify-content-center">
            <p className={classes.price}>{price.toFixed(2)}€</p>
          </div>
        </Card.Body>
        <div className={classes.buttonsContainer}>
          <button className={classes.cancelButton} onClick={cancelHandler}>
            Cancel
          </button>
          <button className={classes.bookButton} onClick={postReservation}>
            Confirm
          </button>
        </div>
      </Card>
    </div>
  );
}

export default ReservationForm;
