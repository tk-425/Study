import React, { useState } from "react";

type NewTodoFormProps = {
  addTodo: Function,
};

export const NewTodoForm = (props: NewTodoFormProps) => {
  const [assigned, setAssigned] = useState('');
  const [description, setDescription] = useState('');

  const submitTodos = () => {
    if (description && assigned) {
      props.addTodo(assigned, description);
      setAssigned('');
      setDescription('');
    } else {
      alert('Must complete the form');
    }
  }

  return (
    <div className="mt-5">
      <form action="">
        <div className="mb-3">
          <label className="form-label" htmlFor="">Assigned</label>
          <input
            type="text"
            className="form-control"
            onChange={e => setAssigned(e.target.value)}
            value={assigned}
            required
          />
        </div>
        <div className="mt-3">
          <label className="form-label" htmlFor="">Description</label>
          <textarea
            className="form-control"
            cols={30}
            rows={3}
            onChange={e => setDescription(e.target.value)}
            value={description}
            required
          />
        </div>
        <button
          type="button"
          className="btn btn-primary mt-3"
          onClick={submitTodos}
        >
          Add Todo
        </button>
      </form>
    </div>
  )
}
