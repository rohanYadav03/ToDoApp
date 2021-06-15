package com.example.ToDoApp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/list_todo")
public class ListToDO extends HttpServlet {

    //For Using ToDo services as retrieve list etc.
    ToDoService service = new ToDoService();

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {


        int uid=1;

        httpServletRequest.setAttribute("list", service.fetchTodos(uid));
        httpServletRequest.getRequestDispatcher("/index.jsp").forward(httpServletRequest, httpServletResponse);
    }
}
