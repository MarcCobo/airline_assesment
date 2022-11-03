import HomeLogo from "../components/homeComponents/HomeLogo";
import SearchBar from "../components/homeComponents/SearchBar";

function Home({addFlights}) {
  

  return (
    <div>
      <HomeLogo />
      <SearchBar addFlights={addFlights} />
    </div>
  );
}
export default Home;