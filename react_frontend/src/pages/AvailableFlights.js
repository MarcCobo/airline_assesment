function AvailableFlights({ flights }) {
  return (
    <div>

      {flights && flights.map((flight) => {
        return (
          <div class="card">
            <div class="card-body">
              <h5 class="card-title">{flight.layover_text}</h5>
              <p class="card-text">
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