import "./App.css";
import NavBar from "./componet/NavBar";
import Profile from "./componet/Profile";
import Icon from "./componet/Icon";
import ImgAllIphone from "./componet/ImgAllIphone";
import TextIphone from "./componet/TextIphone";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import BasicExample from "./componet/BasicExample";
import Footer from "./componet/Footer";
import Feedback from "./componet/Feedback";


function App() {
  return (
    <>
      <div className="NavBar">
        <div className="img">
          <Profile></Profile>
        </div>
        <div className="NavBar1">
          <NavBar></NavBar>
        </div>
      </div>
      <main className="bodyBig">
      <div className="img1">
      <ImgAllIphone></ImgAllIphone>
      </div>
      <div className="Text1">
        <TextIphone></TextIphone>
      </div>
      <div className="HomePod">
      <BasicExample></BasicExample>
      <BasicExample></BasicExample>
      <BasicExample></BasicExample>
      </div>
      <div className="feedback">
      <div className="feedback1"><Feedback></Feedback></div>
      
      </div>
      
      
        
      </main>
      <footer>
      <Footer></Footer>
      </footer>

    </>
  );
}
export default App;
