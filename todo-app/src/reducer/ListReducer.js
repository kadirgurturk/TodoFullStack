import { createSlice } from "@reduxjs/toolkit";


const ListReducer = createSlice({
    name:"FilterList",
    initialState:{
        list: "All"
    },
    reducers:{
        ListChange: (state,actions) =>{
            state.list = actions.payload
        },
        
    }
})

export const {ListChange} = ListReducer.actions;

export default ListReducer.reducer;