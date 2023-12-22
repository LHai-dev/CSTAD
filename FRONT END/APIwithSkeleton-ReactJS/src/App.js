import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import PlaceHolderCard from './componet/Product1';
import BasicExample from './componet/BasicExmple';
import NavBar from './componet/NavBar';
function App() {
  return (
    <div className="App">
      <NavBar></NavBar>
      <PlaceHolderCard></PlaceHolderCard>
    </div>
  );
}

export default App;
