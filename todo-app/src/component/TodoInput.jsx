import React, { useState } from 'react'
import TodoApiService from '../services/TodoApiService';

export default function TodoInput() {
  const [task, setTask] = useState('');

  const handleInputChange = (e) => {
    setTask(e.target.value);
  };

  const handleAddTask = () => {

    

    const newTodo = {
      name:task,
      status:"TODO"
    }

    if(task === ""){
      alert("Lütfen Inputu Boş Bırakmayınız")
    }else{
      TodoApiService.todoSave(newTodo);
      setTask("");
    } //---> Değerin boş olması durumunu handler ediyoruz.


  };

  return (
    <div className='TodoInput'>
      <h2>TodoInput</h2>

      <div className='Input'>
        <input
          onChange={handleInputChange} value={task} className='taskInput' type='text' placeholder='New Todo' required minLength={3} />
        <button onClick={handleAddTask} className='addTask'>
          Add New Task
        </button>
      </div>
    </div>
  );
}
