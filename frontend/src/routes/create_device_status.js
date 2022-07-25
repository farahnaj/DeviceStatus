import Header from '../components/header';
import Stack from '@mui/material/Stack';
import CustomToast from '../components/toast';
import IconMenu from '../components/menu';
import Box from '@mui/material/Box';
import TextField from '@mui/material/TextField';
import Button from '@mui/material/Button';
import Paper from '@mui/material/Paper';
import { styled } from '@mui/material/styles';
import ToastContainer from 'react-bootstrap/ToastContainer'
import { useState } from 'react';
import Container from '@mui/material/Container';
const axios = require('axios').default;
const url = "http://127.0.0.1:8080/api/v1/devicestatus/create"

const create = async (deviceId, health, details, setShow, setMessage) => {
  await axios.put(url, { "deviceId": deviceId, "health": health, "message": details })
    .then((response) => {
      setShow(true);
      setMessage("Saved");
    })
    .catch((error) => {
      setShow(true);
      setMessage(error.response.data.httpStatus + "Error creating device status");
    });
}

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
  ...theme.typography.body2,
  padding: theme.spacing(1),
  textAlign: 'center',
  color: theme.palette.text.secondary,
}));


const CreateDeviceStatus = () => {
  const [deviceId, setDeviceId] = useState("");
  const [health, setHealth] = useState("");
  const [details, setDetails] = useState("");
  const [show, setShow] = useState(false);
  const [message, setMessage] = useState("");

  return (
    <>
      <Container maxWidth="sm">
        <Header />
        {/* Pass show and setShow as properties to the CustomToast. */}

        <Box sx={{ width: '100%' }}>

          <Stack direction="column" spacing={10}>
            <Item>
              <IconMenu />
            </Item>
            <Item>
              <Box
                component="form"
                sx={{
                  '& .MuiTextField-root': { m: 1, width: '25ch' },
                }}
                noValidate
                autoComplete="off"
              >
                <div>
                  <TextField
                    required
                    id="outlined-required"
                    label="Divice Id"
                    defaultValue=""
                    helperText="Id of the device"
                    onChange={(event) => setDeviceId(event.target.value)}
                  />
                </div>
                <div>
                  <TextField
                    required
                    id="outlined-required"
                    label="Health"
                    defaultValue=""
                    helperText="How is the device?"
                    onChange={(event) => setHealth(event.target.value)}
                  />
                </div>
                <div>
                  <TextField
                    required
                    id="outlined-required"
                    label="message"
                    defaultValue=""
                    helperText="Any more details?"
                    onChange={(event) => setDetails(event.target.value)}
                  />
                </div>
                <Stack direction="row" spacing={2}>
                  <Button variant="contained" type="submit"
                    onClick={(event) => { event.preventDefault(); create(deviceId, health, details, setShow, setMessage) }}>
                    Submit
                  </Button>

                  <Button variant="contained" type="reset">Reset</Button>
                </Stack>
              </Box>

              <ToastContainer position='middle-center'>
                <CustomToast show={show} setShow={setShow} message={message} />
              </ToastContainer>
            </Item>
          </Stack>
        </Box>
      </Container>
    </>
  )
}

export default CreateDeviceStatus;
