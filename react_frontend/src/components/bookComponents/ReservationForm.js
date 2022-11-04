import Form from "react-bootstrap/Form";
import Card from "react-bootstrap/Card";
import classes from "./ReservationForm.module.css";
import { useState } from "react";
import axios from "axios";

function ReservationForm(props) {
  //ModalButtons Code
  function cancelHandler() {
    props.onCancel();
  }

  function confirmHandler() {
    props.onConfirm();
  }
  // End ModalButtons Code

  const [price, setPrice] = useState(0); //We have to change the '0' to props.price
  const [bags, setBags] = useState(false);
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [email, setEmail] = useState("");
  const [age, setAge] = useState(0);
  const [dni, setDni] = useState("");
  const [nationality, setNationality] = useState("");
  const [plusNineCounter, setPlusNineCounter] = useState(0);
  let newValue = 0;
  let newBag = false;

  function nameChangeHandler(e){
    setName(e.target.value)
  }

  function surnameChangeHandler(e){
    setSurname(e.target.value)
  }

  function emailChangeHandler(e){
    setEmail(e.target.value)
  }

  function ageChangeHandler(e){
    setAge(e.target.value)
  }

  function dniChangeHandler(e){
    setDni(e.target.value)
  }

  function nationalityChangeHandler(e){
    setNationality(e.target.value)
  }

  function checkboxClickHandler() {
    newBag = !bags;
    console.log(newBag);
    setBags(newBag);
    callGetVariablePrice(newBag, plusNineCounter);
  }

  function addPlusNineClickHandler() {
    newValue = plusNineCounter + 1;
    setPlusNineCounter(newValue);
    callGetVariablePrice(bags, newValue);
  }

  function minusPlusNineClickHandler() {
    newValue = plusNineCounter - 1;
    if (newValue < 0) newValue = 0;
    setPlusNineCounter(newValue);
    callGetVariablePrice(bags, newValue);
  }

  function callGetVariablePrice(bags, plusNineCounter) {
    let agesString = [];
    for (let i = 0; i < plusNineCounter; i++) {
      agesString.push("18");
    }

    axios
      .get("http://localhost:8082/reservation/get_variable_price", {
        params: {
          ages: agesString.join(),
          bags: bags,
          price: 200.0,
        },
      })
      .then((response) => {
        setPrice(response.data);
      });
  }

  function postReservation() {
    axios
      .post("http://localhost:8082/reservation/add", {
        flightId: 1,
        name: name,
        surname: surname,
        nationality: nationality,
        dni: dni,
        age: age,
        bags: bags,
        email: email,
        numSeats: 2,
        price: 300.0,
      })
      .then((response) => {
        console.log(response);
      });
  }

  return (
    <div className="col-sm-6">
      <Card>
        <Card.Body>
          <div className="row justify-content-between">
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter name" onChange={nameChangeHandler}/>
            </div>
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter surname" onChange={surnameChangeHandler}/>
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter nationality" onChange={nationalityChangeHandler}/>
            </div>
            <div className="col-sm-5">
              <Form.Control type="number" placeholder="Enter age" onChange={ageChangeHandler}/>
            </div>
          </div>
          <div className="row justify-content-between mt-4">
            <div className="col-sm-5">
              <Form.Control type="email" placeholder="Enter email" onChange={emailChangeHandler}/>
            </div>
            <div className="col-sm-5">
              <Form.Control type="text" placeholder="Enter dni (00000000X)" onChange={dniChangeHandler}/>
            </div>
          </div>
            <div className="col-sm-8 d-flex justify-content-between mx-auto mt-4">
            <div className="col-sm-5">
              <Form.Check
                type="checkbox"
                label="Check if the passenger/s is/are going to take luggage"
                onClick={checkboxClickHandler}
              />
            </div>
              <p>Passengers age +9</p>
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
            <div className="d-flex justify-content-center">
              <p className={classes.price}>{price}€</p>
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
