import HomeLogo from "../components/homeComponents/HomeLogo";
import SearchBar from "../components/homeComponents/SearchBar";

//Main Home Page that uses Reusable Components

function Home({addFlights}) {

  return (
    <div>
      <HomeLogo />
      <SearchBar addFlights={addFlights} />
    </div>
  );
}
export default Home;