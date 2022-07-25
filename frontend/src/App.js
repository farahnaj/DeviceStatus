import './App.css';
import Header from './components/header';
import Container from '@mui/material/Container';
import Button from 'react-bootstrap/Button';
import IconMenu from './components/menu';
import CustomToast from './components/toast';
import Row from 'react-bootstrap/Row';
import ToastContainer from 'react-bootstrap/ToastContainer'
import Col from 'react-bootstrap/Col';
import FormInput from './components/input';
import { useState } from 'react';
import TableComponent from './components/table';
import Stack from '@mui/material/Stack';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
const axios = require('axios').default;

/**
* App reads from text input and searches for all device status of that device
* Reference: Converted to function using https://www.twilio.com/blog/react-choose-functional-components
*/
const url = "http://127.0.0.1:8080/api/v1/devicestatus?deviceId="

const searchDeviceStatus = (deviceId, setDeviceStatus, setShow, setMessage) => {
  const urlWithDeviceId = url + deviceId;
  // Using Axios instead of the fetch for more readable requests code
  axios.get(urlWithDeviceId)
    .then((response) => {
      setDeviceStatus({ deviceStatus: response.data });
    })
    .catch((error) => {
      // TODO: Add alerts on failure
      setMessage({ error: error.data })
      console.log("Error processing response" + error);
      console.log(error);
      setShow(true);
    });
}
const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));

const SearchDeviceStatus = () => {
  const [deviceId, setDeviceId] = useState("");
  const [deviceStatus, setDeviceStatus] = useState("");
  const [show, setShow] = useState(false);
  const [message, setMessage] = useState("");
  return (<>
    <Container maxWidth="sm">
      <Header />
      <Box sx={{ width: '100%' }}>
        <Stack direction="column" spacing={10}>
          <Item>
            <IconMenu /></Item>
          <Item>
            <Row>
              <Col>
                {/** What is this about. Check why this property setNameState needs to be same in child component */}
                <FormInput setNameState={setDeviceId} placeholder="Device Id" />
              </Col>
              <Col>
                <Button variant="primary" id="search" onClick={() => searchDeviceStatus(deviceId, setDeviceStatus, setShow, setMessage)}>Search</Button>
              </Col>
            </Row>
            <Row>
              <Col>
                <TableComponent deviceStatus={deviceStatus} />
              </Col>
            </Row>
            <ToastContainer position='middle-center'>
              <CustomToast show={show} setShow={setShow} message={message} />
            </ToastContainer>
          </Item>
        </Stack>
      </Box>
    </Container>
  </>);
}

export default SearchDeviceStatus;
