import classes from "./SubmitButton.module.css";

function SubmitButton() {
  return (
    <div className={classes.div}>
      <button className={classes.button} form="SearchForm">Find my Solights</button>
    </div>
  );
}
export default SubmitButton;
