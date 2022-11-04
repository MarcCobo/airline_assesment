import classes from "./Faq.module.css";
import { useHistory } from "react-router-dom";

function Faq() {
  const history = useHistory();
  function navigateHome() {
    history.replace("/");
  }
  
  return (
    <div className={classes.bigContainer}>
      <div className={classes.smallContainer}>
        <div className={classes.infoDiv}>
          <h2>FAQ</h2>
          <br />
        </div>
        <div className={classes.infoDiv}>
          <h4>1. Why did my reservation failed?</h4>
          <p>
            Most cases of failed reservations are caused because of fields
            without input. <br />
            Please try to re-do the reservation with filling all the appropriate
            fields!
          </p>
        </div>
        <div className={classes.infoDiv}>
          <h4>
            2. I filled in all of the appropriate fields. Why does it keep
            failing?
          </h4>
          <p>
            Probably the developers are to be blamed about it. <br />
          </p>
        </div>
        <button className={classes.homeButton} onClick={navigateHome} style={{marginTop: "40px"}}>
          Back to Home
        </button>
      </div>
    </div>
  );
}
export default Faq;
