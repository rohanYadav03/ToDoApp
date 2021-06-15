package com.example.ToDoApp;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/add_todo")
public class AddToDo extends HttpServlet {

    ToDoService service=new ToDoService();


    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletRequest.getRequestDispatcher("/new_todo.jsp").forward(httpServletRequest,httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        ToDoService add_todo_services=new ToDoService();



        // Adding new ToDo.
        String detail=request.getParameter("newToDO");
        String category=request.getParameter("category");
        String date=request.getParameter("date");
        int Uid= 1;

        add_todo_services.addNewTodo(Uid,detail,category,date);
        response.sendRedirect("list_todo");


    }
}
