import axios from "axios";

const API_URL = "http://localhost:2222/todo/api/v1"


class TodoApiService {

    
    /// "localhost:2222/todo/api/v1/save"
    todoSave( TodoDto ) {
        return axios.post(API_URL + "/save", TodoDto)
    }

    
    getTodoList() {
        return axios.get(API_URL + "/list")
    }


    //"localhost:2222/todo/api/v1/find/{id}"
     findTodoById(id) {

        return axios.get(API_URL + "/find/" + id)
    }

    
    //"localhost:2222/todo/api/v1/delete/{id}")
    deleteTodoById( id) {

        return axios.delete(API_URL + "/delete/" + id)

    }


    //"localhost:2222/todo/api/v1/update", "localhost:2222/todo/api/v1/update/{id}"})
    updateTodoById(id,todoDto) {
        
        return axios.put(API_URL + "/update/" + id,todoDto)
    }


    //"localhost:2222/todo/api/v1/delete/{status}")
    deleteByStatus( status) {


        return axios.delete(API_URL + "/delete/?status=" + status)
    }

    
    //"localhost:2222/todo/api/v1/deleteall")
    deleteAll() {

        return axios.delete(API_URL + "/deleteall/")

    }

    
    //"localhost:2222/todo/api/v1/status/{status}")
    findByStatus(status) {

        return axios.get(API_URL + "/status/" + status)
    }


    //"localhost:2222/todo/api/v1/?name={name}")
    findByNameContaining(value) {

        return axios.get(API_URL + "/?name=" + value)

    }

    //"localhost:2222/todo/api/v1/list/page/?page={currentPage}&size={pageSize}")
    todoPagination(currentPage, pageSize) {

        return axios.get(API_URL + "/list/page/?page=" + currentPage + "&size=" + pageSize)
    }

   
    //"localhost:2222/todo/api/v1/list/sort/?field={field}")
    todoSort( field) {

        return axios.get(API_URL + "/list/sort/?field=" + field)
    }
}

export default new TodoApiService();