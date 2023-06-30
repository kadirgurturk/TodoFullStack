import React, { useEffect, useState } from 'react';
import Delete from "../assets/delete.svg" 
import pencil from "../assets/pencil.svg" 
import { useDispatch,useSelector } from 'react-redux';
import TodoApiService from '../services/TodoApiService';
import UpdatePopup from './UpdatePopup';

export default function TodoList() {

  const [todos,setTodos] = useState([]);
  const text = useSelector(state => state.ListReducer.list)
  const [isClose,setClose] = useState(false);
  const [updateTodo, setUpdateTodo] = useState();
  
  
  useEffect(()=>{
    TodoApiService.todoSort("id").then(
        (response)=>{
            setTodos(response.data)
        }
    ).catch((err)=>{
        console.error("List Failed" + err)
    });
  },[])

  useEffect(()=>{
    if(text === "All"){
        TodoApiService.todoSort("id").then(
            (response)=>{
                setTodos(response.data)
            }
        ).catch((err)=>{
            console.error("List Failed" + err)
        });
    }
    if(text === "Todo"){
        TodoApiService.findByStatus("TODO").then(
            (response)=>{
                setTodos(response.data)
            }
        ).catch((err)=>{
            console.error("List Failed Whwn Trying to Get TODO" + err)
        });
    }
    if(text === "Done"){
        TodoApiService.findByStatus("DONE").then(
            (response)=>{
                setTodos(response.data)
            }
        ).catch((err)=>{
            console.error("List Failed Whwn Trying to Get DONE" + err)
        });
    }
  },)

  
    const changeStatus = (todo) =>{
        let id = todo.id;
        todo.status = todo.status === "DONE" ? "TODO" : "DONE"

        TodoApiService.updateTodoById(id,todo).then(
            (response)=>{
                console.log("Update Done");
            }
        ).catch((err)=>{
            console.error("List Failed Whwn Trying to Get DONE" + err)
        });
        }

    const deleteAllDone = () =>{
        TodoApiService.deleteByStatus("DONE").then(
            (response)=>{
                console.log("Delete All Done");
            }
        ).catch((err)=>{
            console.error("List Failed When Trying to Get DONE" + err)
        });
    }

    const deleteAll = () =>{
        TodoApiService.deleteAll().then(
            (response)=>{
                console.log("Delete All Done");
            }
        ).catch((err)=>{
            console.error("List Failed When Trying to Get DONE" + err)
        });
    }

    const deleteById = (id) =>{
        TodoApiService.deleteTodoById(id).then(
            (response)=>{
                console.log( id + "id Todo Deleted" );
            }
        ).catch((err)=>{
            console.error("List Failed When Trying to Get DONE" + err)
        });
    }

    const handleClose = (todo) =>{
        setUpdateTodo(todo)
        setClose(true)
    }


  return (
    <div className='todoList'>
        <div className='list'>
            {todos?.map(todo => (
                <div key={todo.id} className='todo'>
                    <span className={todo.status === "DONE" ? "ıtem_done" : "ıtem_todo"} > {todo.name} </span>
                    <span className='todo_act'>
                        <input key={todo.id} onClick={()=>{changeStatus(todo)}} id='check' type="checkbox" checked={todo.status === "DONE"}  />
                        <img onClick={()=>{handleClose(todo)}} className='update listImg' src={pencil} alt='düzenle'/>
                        <img onClick={()=>{deleteById(todo.id)}} className='delete listImg' src={Delete} alt="sil"/>
                    </span>
                    
                </div>
            ))}
        </div>
        <div className='todoList_btns'>
                <button onClick = {deleteAll} className="deleteBtn" >Delete All Tasks</button>
                <button onClick = {deleteAllDone} className="deleteBtn" >Delete Done Tasks</button>
        </div>
        {isClose && <UpdatePopup setClose={setClose} todo={updateTodo} /> }
    </div>
  )
}
