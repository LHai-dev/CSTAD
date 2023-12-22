import React from 'react'
import Link from 'next/link'
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import Button from "react-bootstrap/Button";

export default function NavBarComponent() {
  return (
    <>
       <Navbar bg="light" expand="lg" className={"  top-0 start-0"} style={{zIndex: "1"}}>
            <Container>
                <Navbar.Brand className="fw-bolder border-bottom border-3 border-dark"  >
                    <Link href="/" className="text-decoration-none">
                        <img style={{width:'70px'}} src='https://i.pinimg.com/736x/eb/ce/d1/ebced19cf1b7b54b997aab87e2c6cae8.jpg'/>
                    </Link>
                </Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Link href="/about" className="nav-link">
                            About Us
                        </Link>
                       
                        <Link href="/movies" className="nav-link">
                            Movies
                        </Link>
                        <Link href="/npm" className="nav-link">
                           dataTable
                        </Link>
                        <Link href="/npm13" className="nav-link">
                           dataTable
                        </Link>
                    </Nav>
                  
                </Navbar.Collapse>
            </Container>
        </Navbar>

    </>
  )
}
