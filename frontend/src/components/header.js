import React from 'react'
import { Container, Navbar, NavItem } from 'react-bootstrap'
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <Navbar bg="light">
      <Container>
        <Link to="/"><Navbar.Brand>Device Status</Navbar.Brand></Link>
      </Container>
    </Navbar>
  )
}

export default Header
