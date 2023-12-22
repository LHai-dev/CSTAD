"use client"
import React, { useState, useEffect } from "react";
import { Card, Button, Placeholder } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";
import Image from 'next/image'

export default function UserComponent({ name, avatar, creationAt ,role,id,email}) {


  
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    // Simulate API call
    setTimeout(() => {
      setIsLoading(false);
    }, 2000);
  }, []);

  return (
    <>
      <div className="col-sm-4 col-md-6 col-lg-4 mt-5">
        {isLoading ? (
          <div className="d-flex justify-center items-center">
          <Card style={{ width: "18rem" }}>
            <Card.Img
              variant="top"
              src="https://www.itechinsiders.com/wp-content/uploads/2019/01/1_okufk5mMDbTfqA5iS_rldQ.png"
            />
            <Card.Body>
              <Placeholder as={Card.Title} animation="glow">
                <Placeholder xs={6} />
              </Placeholder>
              <Placeholder as={Card.Text} animation="glow">
                <Placeholder xs={7} /> <Placeholder xs={4} />{" "}
                <Placeholder xs={4} /> <Placeholder xs={6} />{" "}
                <Placeholder xs={8} />
              </Placeholder>
              <Placeholder.Button variant="primary" xs={6} />
            </Card.Body>
          </Card>
          </div>

        ) : (
          <div className="d-flex justify-center items-center">
          <div style={{ width: "200px" }}>
            <imgge unoptimized
              style={{ borderRadius: "100px" }}
              className="p-8 rounded-t-lg"
              src={avatar ? avatar   : "/images/placeholder-image.png"}
              alt="product image"
            />
            <h2  className="text-center">{name}</h2>
            <p>
              <label className="d-flex justify-center">
                <strong className="">Roles: </strong>
                {role}
              </label>
              
            </p>
            <p>
            <div className="d-flex justify-center">
            <a className="btn btn-secondary " href={`/user-Detail/${id}`}>
                View details »
              </a>
            </div>

            </p>
          </div>
          </div>
        )}
      </div>
    </>
  );
}
