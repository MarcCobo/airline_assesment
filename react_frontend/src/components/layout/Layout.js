import MainNavigation from "./MainNavigation";
import Footer from "./Footer";
import classes from "./Layout.module.css";

//Main Layout Designed for Reusable Components, implemented with props.children

function Layout(props) {
  return (
    <div>
      <MainNavigation />
      <main className={classes.main}>{props.children}</main>
      <Footer />
    </div>
  );
}
export default Layout;