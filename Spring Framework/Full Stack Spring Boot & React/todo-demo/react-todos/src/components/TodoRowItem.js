function TodoRowItem(props) {
  return (
    <tr key={props.rowNumber} onClick={() => props.deleteToto(props.rowNumber)}>
      <th scope='row'>{props.rowNumber}</th>
      <td>{props.rowDescription}</td>
      <td>{props.rowAssigned}</td>
    </tr>
  )
}

export default TodoRowItem;