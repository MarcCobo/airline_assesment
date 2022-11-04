import classes from "./About.module.css";
import { useHistory } from "react-router-dom";

function About() {
  const history = useHistory();

  function navigateHome() {
    history.replace("/");
  }

  return (
    <div className={classes.bigContainer}>
      <div className={classes.smallContainer}>
        <div className={classes.infoDiv}>
          <h2>About</h2>
          <br />
        </div>
        <div className={classes.infoDiv}>
          <p>
            This is a mock Airlines App created from the DMG Group (David - Marc - George) of Solera.Inc! 
            It simulates a flight aggregator, designed to collect flights from different airlines and present them in a single page approach.
            The data is pure fiction and has nothing to do with the actual airlines. <br/><br/>&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	&nbsp;	©2022 Solights - Property of Solera Inc. All Rights Reserved
          </p>
        </div>
        <button className={classes.homeButton} onClick={navigateHome} style={{marginTop: "40px"}}>
          Back to Home
        </button>
      </div>
    </div>
  );
}
export default About;
