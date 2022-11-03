function AvailableFlights({ flights }) {
  return (
    <div>

      {flights && flights.map((flight, index) => {
        return (
          <div className="card" key={index}>
            <div className="card-body">
              <h5 className="card-title">{flight.layover_text}</h5>
              <p className="card-text">
                Some quick example text to build on the card title and make up
                the bulk of the card's content.
              </p>
              {/* <a href="#" class="btn btn-primary">
                Go somewhere
              </a> */}
            </div>
          </div>
        );
      })}
    </div>
  );
}
export default AvailableFlights;