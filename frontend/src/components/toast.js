import { Button, Row, Col, Toast } from 'react-bootstrap'

const CustomToast = (props) => {
  return (
    <Row>
      <Col xs={6}>
        <Toast onClose={() => props.setShow(false)} show={props.show} delay={3000} autohide>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">{props.message}</strong>
            {/*<small>Less than a minute ago</small>*/}
          </Toast.Header>
          <Toast.Body>{props.message}</Toast.Body>
        </Toast>
      </Col>
    </Row>
  )
}

export default CustomToast;
