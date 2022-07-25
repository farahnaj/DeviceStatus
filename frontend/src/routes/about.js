
import Header from '../components/header';

import Container from '@mui/material/Container';
import IconMenu from '../components/menu';

export default function About() {
  return (
    <>
      <Container maxWidth="sm">
        <Header />
        <IconMenu />
        <h3>About</h3>
        <p> Device Status is a simple API implementation for multiple devices to save and search for health status.</p>
      </Container>
    </>
  )
}
