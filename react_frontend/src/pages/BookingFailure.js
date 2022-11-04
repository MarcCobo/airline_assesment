import classes from "./BookingResult.module.css";
import logo from "./failure-icon-10.png";
import { useHistory } from "react-router-dom";

function BookingSuccess() {
  const history = useHistory();
  function navigateHome() {
    history.replace("/")
  }

  function navigateFAQ() {
    history.replace("/faq")
  }

  return (
    <div className={classes.bigContainer}>
      <div className={classes.smallContainer}>
        <img className={classes.img} src={logo} alt="Please Hire Us"></img>
        <div className={classes.infoDiv}>
          <h2>Reservation Failed</h2>
          <br />
          <p>Your Reservation wasn't succesfully placed! <br/> Visit the FAQ page for possible causes</p>
        </div>
        <button className={classes.homeButton} onClick={navigateHome}>Back to Home</button>

        <button className={classes.FAQButtton} onClick={navigateFAQ}>
          FAQ Page
        </button>
      </div>
    </div>
  );
}
export default BookingSuccess;
