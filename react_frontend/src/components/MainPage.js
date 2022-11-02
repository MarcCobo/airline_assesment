import { Card } from "react-bootstrap";
import "./MainPage.css";
import SearchComponent from "./SearchComponent";
import DatePickerComponent from "./DatePickerComponent";

function MainPage() {
  const origins = ["Barcelona", "Madrid", "Sevilla", "Bilbao"];

  return (
    <div id="div">
      <Card className="col-sm-10 offset-sm-1">
        <div className="container">
          <p className="col-sm-3 title">Origin</p>
          <p className="col-sm-3 title">Destination</p>
          <p className="col-sm-3 title">Start date</p>
          <p className="col-sm-3 title">End date</p>
        </div>
        <Card.Body className="container">
          <SearchComponent places={origins} />
          <SearchComponent places={origins} />
          <DatePickerComponent />
          <DatePickerComponent />
        </Card.Body>
      </Card>
    </div>
  );
}

export default MainPage;
