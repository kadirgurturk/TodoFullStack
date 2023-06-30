import React, { useEffect, useState } from 'react'
import { useDispatch,useSelector } from 'react-redux';
import {ListChange} from "../reducer/ListReducer";
import TodoApiService from '../services/TodoApiService';

export default function TodoBtns() {
    const dispatch = useDispatch();
    const [activeBtn, setActiveBtn] = useState("All")
    const text = useSelector(state => state.ListReducer.list)


    const ListUpdate = (status) =>{  
        dispatch(ListChange(status))
          setActiveBtn(status)
    }

  return (

    <div className='todoBtns'>
        <h2>TodoList</h2>
        <div className='todoBtns_btns'>
          <button onClick={()=>{ListUpdate("All")}}  className={activeBtn === "All" ? "activebtn" : "listbtn"}>All</button>
          <button onClick={()=>{ListUpdate("Todo")}} className={activeBtn === "Todo" ? "activebtn" : "listbtn"}>Todo</button>
          <button onClick={()=>{ListUpdate("Done")}} className={activeBtn === "Done" ? "activebtn" : "listbtn"}>Done</button>
        </div>

    </div>
  )
}
