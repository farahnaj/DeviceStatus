import {Form } from 'react-bootstrap'

// Note the property name matches verbatim
const FormInput = ({ setNameState, placeholder }) => {
// This is another way of passing props
// const FormInput = (props) => 
// Laters props.setNameState will work to call the function on the property
    return (
        <Form>
            <Form.Control
                type="text"
                id="inputdevice"
                placeholder={placeholder}
                onChange={(event) => setNameState(event.target.value)}
            aria-describedby="Enter device id"/>
        </Form>
    )
}

export default FormInput