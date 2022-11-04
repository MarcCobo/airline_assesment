import classes from "./SubmitButton.module.css";

// Reusable Component to for Submitting the Form of Searchbar

function SubmitButton() {
  return (
    <div className={classes.div}>
      <button className={classes.button} form="SearchForm">Find my Solights</button>
    </div>
  );
}
export default SubmitButton;