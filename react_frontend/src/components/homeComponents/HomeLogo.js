import classes from './HomeLogo.module.css'
import logo from './solights_logo_main.png'

function HomeLogo(){
    return(
        <div className={classes.div}>
            <img className={classes.img} src={logo} alt="Please Hire Us"></img>
        </div>
    )
}
export default HomeLogo;