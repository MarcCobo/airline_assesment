import { Link } from "react-router-dom";
import classes from "./MainNavigation.module.css";
import logo from "./solights_logo.png";

function MainNavigation() {
  return (
    <header className={classes.header}>
      <Link to="/">
        <img className={classes.img} src={logo} alt="Solights" />
      </Link>
      <nav>
        <ul>
          <li>
            <Link to="/login" style={{textDecoration: "none"}}>Login</Link>
          </li>
          <li>
            <Link to="/about" style={{textDecoration: "none"}}>About</Link>
          </li>
          <li>
            <Link to="/faq" style={{textDecoration: "none"}}>FAQ</Link>
          </li>
          {/*
            <div className={classes.logo} >Solights</div>
          <li>
            <Link to="/new">New Meetup</Link>
          </li>
          <li>
            <Link to="/fav">My Favorites</Link>
          </li>
          */}
        </ul>
      </nav>
    </header>
  );
}
export default MainNavigation;
