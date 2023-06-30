import React,{useState} from 'react'
import close from "../assets/close.svg" 
import TodoApiService from '../services/TodoApiService';

export default function UpdatePopup({setClose,todo}) {

  const [task, setTask] = useState(todo.name);

  const handleInputChange = (e) => {
    setTask(e.target.value);
  };

  const updateTodo = () => {
    const newTodo = {
      name:task,
      status:todo.status
    }

    if(task === ""){
      
    }else{
      TodoApiService.updateTodoById(todo.id,newTodo);
      setTask("");
      setClose(false)
    }

  };



  return (
    <div className='updatepopup'>
        <div className="update_container">

        <img onClick={()=>{setClose(false)}} src={close}  id='close' alt="close" />

            <form >

                <input value={task} onChange={handleInputChange} className='form_input' type="text" min={3} required placeholder = "Please Enter Changes" />


                <button onClick={updateTodo} className='form_btn' id='submit-btn' type="submit" value="Gönder">Gönder</button>

            </form>    

        </div>
    </div>
  )
}
