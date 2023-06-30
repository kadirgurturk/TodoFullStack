import { configureStore } from '@reduxjs/toolkit'
import ListReducer from '../reducer/ListReducer'

const store = configureStore({
  reducer: {
    ListReducer : ListReducer,
  },
})


export default store;