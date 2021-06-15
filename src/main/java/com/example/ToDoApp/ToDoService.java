package com.example.ToDoApp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoService {
    private Statement statement;
    private ResultSet result;

    public  boolean addNewTodo(int uid,String detail,String category,String date){


        try {
            statement= ConnectToDB.connectDB();

            return statement.execute("INSERT into todos(tdetail,tcategory,tdate,uid) values ('"+detail+"','"+category+"','"+date +"','"+uid+"')");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Can't add todo !");
        }finally {
            try {
                ConnectToDB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    public List<ToDoModel> fetchTodos(int uid){

        try {

            statement=ConnectToDB.connectDB();
            ArrayList<ToDoModel> list = new ArrayList<ToDoModel>();
            result = statement.executeQuery("SELECT tdetail,tcategory,tdate FROM todos where uid=" + uid);
            while (result.next()){
                String detail=result.getString("tdetail");
                String category=result.getString("tcategory");
                String date=result.getString("tdate");
                list.add(new ToDoModel(detail,category,date));
            }
            return list;
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                ConnectToDB.disconnectDB();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public boolean removeToDo(String detail){

        try {
            Statement statement= ConnectToDB.connectDB();
            return statement.execute("DELETE  FROM todos where tdetail='"+detail+"'");
        }catch (SQLException e){
            System.out.println("Error while deleting :( "+e.getMessage());
        }
        return false;
    }


}
