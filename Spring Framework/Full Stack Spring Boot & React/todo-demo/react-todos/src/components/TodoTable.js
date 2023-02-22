import TodoRowItem from "./TodoRowItem";

export default function TodoTable({ todos, deleteToto }) {
  return (
    <table className='table table-hover'>
      <thead>
        <tr>
          <th scope='col'>#</th>
          <th scope='col'>Description</th>
          <th scope='col'>Assigned</th>
        </tr>
      </thead>
      <tbody>
        {todos.map(todo => (
          <TodoRowItem 
            key={todo.rowNumber}
            rowNumber={todo.rowNumber}
            rowDescription={todo.rowDescription} 
            rowAssigned={todo.rowAssigned}
            deleteToto={deleteToto}
          />
        )) }
      </tbody>
    </table>
  );
}
