import classes from "./Footer.module.css";

//Main Footer used in all of pages

function Footer() {
  return (
    <footer className={classes.footer}>
      <p className={classes.p}>©2022 Solights - Property of Solera Inc. All Rights Reserved</p>
    </footer>
  );
}
export default Footer;