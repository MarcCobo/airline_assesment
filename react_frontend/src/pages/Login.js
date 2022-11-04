import "./Login.css";
import logo from './../components/homeComponents/solights_logo_main.png'


function Login() {
  function handleSubmit(e) {
    e.preventDefault();
    console.log(e.target.email.value);

    if (!e.target.email.value) {
      alert("Email is required");
    } else if (!e.target.email.value) {
      alert("Valid email is required");
    } else if (!e.target.password.value) {
      alert("Password is required");
    } else if (
      e.target.email.value === "me@example.com" &&
      e.target.password.value === "123456"
    ) {
      alert("Successfully logged in");
      e.target.email.value = "";
      e.target.password.value = "";
    } else {
      alert("Wrong email or password combination");
    }
  }

  return (
    <div className="BigLoginCont">
      <div className="LoginCont">
      <img className="img" src={logo} alt="Please Hire Us"></img>
        <form className="form" onSubmit={handleSubmit}>
          <div className="input-group">
            <label htmlFor="email">Email</label>
            <input type="email" name="email" placeholder="youremail@solera.com" />
          </div>
          <div className="input-group">
            <label htmlFor="password">Password</label>
            <input type="password" name="password" />
          </div>
          <button className="loginButton">Login</button>
        </form>
        <button className="forgotButton">Forgot your Password</button>
      </div>
    </div>
  );
}

export default Login;
