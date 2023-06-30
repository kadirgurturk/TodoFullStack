import "./css/app.css"
import TodoInput from './component/TodoInput'
import TodoList from './component/TodoList'
import TodoBtns from './component/TodoBtns'

function App() {
  

  return (
    <div className='app'>
      <TodoInput/>
      <TodoBtns/>
      <TodoList/>
   
    </div>
  )
}
export default App;
