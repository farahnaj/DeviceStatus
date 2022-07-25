import Table from 'react-bootstrap/Table';

const TableComponent = ({ deviceStatus }) => {
  return (
    <Table striped bordered hover size="sm">
      <tbody>
        {/* This key was added to get rid of "Each child in a list should have a unique "key" prop."*/}
        <tr key="Id">
          <th>Id</th>
          <th>Device Id</th>
          <th>Health</th>
          <th>Message</th>
          <th>Created On</th>
        </tr>
        {
          deviceStatus.deviceStatus &&
          deviceStatus.deviceStatus.map(ds =>
            /* This key was added to get rid of "Each child in a list should have a unique "key" prop."*/
            <tr key={ds.id}>
              <td>{ds.id}</td>
              <td>{ds.deviceId}</td>
              <td>{ds.health}</td>
              <td>{ds.message}</td>
              <td>{ds.createdOn}</td>
            </tr>)
        }
      </tbody>
    </Table>
  )
}
export default TableComponent
