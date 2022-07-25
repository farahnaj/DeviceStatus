import Header from '../components/header';

import IconMenu from '../components/menu';
import { useNavigate } from 'react-router-dom';
import Container from '@mui/material/Container';

export default function home() {
  return (
    <>
      <Container maxWidth="sm">
        <Header />
        <IconMenu />
      </Container>
    </>
  )
}
