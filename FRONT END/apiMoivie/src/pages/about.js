import React from "react";
import NavBarComponent from "@/components/NavBarComponent";
import Container from "react-bootstrap/Container";
import {Col, Row} from "react-bootstrap";
import Card from "react-bootstrap/Card";
import ListGroup from 'react-bootstrap/ListGroup';

import Button from "react-bootstrap/Button";
import {No_Image} from "@/lib";
import Link from "next/link";

export default function AboutUs(){

    let cols = []
    for (let i=0;i<5;i++){
        cols.push(
            <Col>
                 <Card style={{ width: '18rem' }}>
      <Card.Img variant="top" src="https://thumbs.gfycat.com/EverlastingRadiantDassierat-size_restricted.gif" />
      <Card.Body>
        <Card.Title>Card Title</Card.Title>
        <Card.Text>
          Some quick example text to build on the card title and make up the
          bulk of the card's content.
        </Card.Text>
      </Card.Body>
      <ListGroup className="list-group-flush">
        <ListGroup.Item>Cras justo odio</ListGroup.Item>
        <ListGroup.Item>Dapibus ac facilisis in</ListGroup.Item>
        <ListGroup.Item>Vestibulum at eros</ListGroup.Item>
      </ListGroup>
      <Card.Body>
        <Card.Link href="#">Card Link</Card.Link>
        <Card.Link href="#">Another Link</Card.Link>
      </Card.Body>
    </Card>
            </Col>
        )
    }

    return (
        <>
            <Container>
                <Row xs={1} sm={2} md={3} lg={4} xl={5} className={"g-3"}>
                    {cols}
                </Row>
            </Container>
        </>
    )
}