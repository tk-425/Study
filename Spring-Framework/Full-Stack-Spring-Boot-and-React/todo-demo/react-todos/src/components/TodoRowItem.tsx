import React from "react";

type TodoRowItemProps = {
  rowNumber: number,
  rowDescription: string,
  rowAssigned: string,
  deleteTodo: Function,
};

export const TodoRowItem = (props: TodoRowItemProps) => {

  return (
    <tr key={props.rowNumber} onClick={() => props.deleteTodo(props.rowNumber)}>
      <th scope='row'>{props.rowNumber}</th>
      <td>{props.rowDescription}</td>
      <td>{props.rowAssigned}</td>
    </tr>
  );
};