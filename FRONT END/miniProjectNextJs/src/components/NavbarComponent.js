"use client";
import Link from "next/link";
import { Card, Button, Placeholder } from 'react-bootstrap';

import Image from 'next/image'


import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';

export default function NavbarComponent({}) {
  
  return (
    <div className="container">

      <Navbar bg="light" expand="lg">
        <Container fluid>
          <Navbar.Brand href="#"><div className="img-icon"><img alt="limhai.png" src='https://i.redd.it/3m58gz4ak8a61.png'/></div></Navbar.Brand>
          <Navbar.Toggle aria-controls="navbarScroll" />
          <Navbar.Collapse id="navbarScroll">
            <Nav
              className="me-auto my-2 my-lg-0 d-flex justify-center container"
              style={{ maxHeight: '100px' }}
              navbarScroll
            >
              <Nav.Link href="/">Home</Nav.Link>
              <Nav.Link href="/about-us">Top us</Nav.Link>
              <Nav.Link href="/dashboard">dashboard</Nav.Link>
              <Nav.Link href="/introduct">introduct</Nav.Link>
              <Nav.Link href="/insert-product1">insert</Nav.Link>
              <Nav.Link href="/trip-Island-Kampot">trip-Kampot22</Nav.Link>
            </Nav>
            <Form className="d-flex">
            {/* <Link href='/Insert-product' className="mr-30"><Button>Insert</Button></Link> */}
              <Link href='/login'><Button>login</Button></Link>
            </Form>
          </Navbar.Collapse>
        </Container>
      </Navbar>
    
  </div>  

  );
}
