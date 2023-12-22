import React, { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel';


export default function ControlledComponet() {
    const [index, setIndex] = useState(0);

    const handleSelect = (selectedIndex, e) => {
      setIndex(selectedIndex);
    };
  
    return (
      <Carousel activeIndex={index} onSelect={handleSelect}>
        <Carousel.Item>
          <div >
          <img
            className="d-block w-100 "
            src="https://scontent.fpnh11-1.fna.fbcdn.net/v/t39.30808-6/349948544_1235093013876679_1393895489140581857_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=730e14&_nc_ohc=p7WogAhAbk0AX8ChqRc&_nc_ht=scontent.fpnh11-1.fna&oh=00_AfBYmSt_x8w4LShpa3vrfmY6SU-WEPJ2_OdkbD0wFP0g4Q&oe=64768B72"
            alt="First slide"
          />
          </div>
          
          <Carousel.Caption>
            <h3>Visal in 2022</h3>
            <p>The sun gently warmed my skin as I lay in the hammock, surrounded by the soothing sounds of nature—a perfect moment of pure chill and relaxation.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <div >
          <img
            className="d-block w-100 "
            src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349156090_162328079948409_3455990291960201444_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=a4a2d7&_nc_ohc=4dubaTYobGgAX91Gcuz&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfBdvpPKy6J3qbG7iwB9uFueSPzL7Ztj-DlMO0btJoX_Nw&oe=6475C65C"
            alt="First slide"
          />
          </div>
          
          <Carousel.Caption>
            <h3>memory in 2022</h3>
            <p>I found the perfect spot by the serene lake, where I could simply unwind and enjoy the chill and relaxing atmosphere.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349159164_195585630099384_288428394717001688_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=RBXaX0s5GbYAX9wit_k&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfCLYnPRnqRsEAYAj70321ic0g5aB6KTOOOELqsWALV-rw&oe=64769A1B"
            alt="Second slide"
          />
  
          <Carousel.Caption>
            <h3></h3>
            <p>After a long day, I love to unwind in my cozy hammock, surrounded by the gentle breeze and the soothing sounds of nature—a truly chill and relaxing experience.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="https://scontent.fpnh11-2.fna.fbcdn.net/v/t39.30808-6/349152787_569787741892316_89611971407503401_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=730e14&_nc_ohc=XC8dt3Ph3JAAX8r3vQM&_nc_ht=scontent.fpnh11-2.fna&oh=00_AfAbxBS9ZmvhecYmSJtLtBE2Us7LdrM9zejFILq0pRO7FQ&oe=647626E8"
            alt="Third slide"
          />
  
          <Carousel.Caption>
            <h3> chill and relaxing </h3>
            <p>
            Sitting by the crackling campfire, laughter and stories filled the air, evoking a sense of warmth and comfort as old memories with dear friends flooded my mind, creating an unforgettable bond that time could never erase.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel>
    );
}
