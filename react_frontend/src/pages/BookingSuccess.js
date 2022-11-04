import classes from "./BookingSuccess.module.css";
import logo from "./success-icon-10.png";
import { useHistory } from "react-router-dom";

function BookingSuccess() {
  const history = useHistory();
  function navigateHome() {
    history.replace("/")
  }

  return (
    <div className={classes.bigContainer}>
      <div className={classes.smallContainer}>
        <img className={classes.img} src={logo} alt="Please Hire Us"></img>
        <div className={classes.infoDiv}>
          <h2>Reservation Success</h2>
          <br />
          <p>Your Reservation was placed succesfully!</p>
        </div>
        {/* <button className={classes.loginButtton}>Login </button> */}

        <button className={classes.homeButton} onClick={navigateHome}>
          Back to Home
        </button>
      </div>
    </div>
  );
}
export default BookingSuccess;
