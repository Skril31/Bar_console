package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class func
{
    public static ResultSet insert_employee(String FIO, String sex, int age, int fk_id_post){
        try(Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_ADD_EMPLOYEE = "INSERT INTO \"Employee\"(\"FIO\",\"Sex\",\"Age\",\"fk_id_post\") VALUES(?,?,?,?) RETURNING id_employee;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_EMPLOYEE);
            preparedStatement.setString(1, FIO);
            preparedStatement.setString(2, sex);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, fk_id_post);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //добавление должности
    public static ResultSet insert_post(String post_name, int wage){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_ADD_POST = "INSERT INTO \"Post\"(\"Name\",\"Wages\") VALUES ( ?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_POST);
            preparedStatement.setString(1, post_name);
            preparedStatement.setInt(2, wage);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet insert_method(String method_name,String description){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_ADD_POST = "INSERT INTO \"Coocking_method\"(\"Name\",\"Description\") VALUES ( ?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_POST);
            preparedStatement.setString(1, method_name);
            preparedStatement.setString(2, description);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static void insert_cocktail_to_method(int id_cocktail, int id_method){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_ADD_POST = "INSERT INTO \"Cocktail_to_method\"(\"fk_id_method\",\"fk_id_cocktail\") VALUES ( ?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_POST);
            preparedStatement.setInt(1, id_method);
            preparedStatement.setInt(2, id_cocktail);
            preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    //удаление сотрудника
    public static ResultSet delete_employee(int id_employee){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_DELETE_EMPLOYEE = "DELETE FROM \"Employee\" WHERE id_employee=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_EMPLOYEE);
            preparedStatement.setInt(1, id_employee);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //удаление должности
    public static ResultSet delete_post(String post_name){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_DELETE_POST = "DELETE FROM \"Post\" WHERE \"Name\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_POST);
            preparedStatement.setString(1, post_name);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ResultSet delete_method(String method_name){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_DELETE_POST = "DELETE FROM \"Coocking_method\" WHERE \"Name\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_POST);
            preparedStatement.setString(1, method_name);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet delete_cocktail_to_method(int id_cocktail, int id_method){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_DELETE_POST = "DELETE FROM \"Cocktail_to_method\" WHERE \"fk_id_cocktail\"=? AND \"fk_id_method\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_DELETE_POST);
            preparedStatement.setInt(1, id_cocktail);
            preparedStatement.setInt(2, id_method);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //обновление сотрудника
    public static ResultSet update_employee(String FIO,String sex, int age, int fk_id_post, int id_employee){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_UPDATE_EMPLOYEE = "UPDATE \"Employee\" SET \"FIO\"=?,\"Sex\"=?, \"Age\"=?, \"fk_id_post\"=? WHERE \"id_employee\"=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_EMPLOYEE);
            preparedStatement.setString(1, FIO);
            preparedStatement.setString(2, sex);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, fk_id_post);
            preparedStatement.setInt(5, id_employee);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    //обновление должности
    public static ResultSet update_post(String post_name,int wage,int id_post){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_UPDATE_POST = "UPDATE \"Post\" SET \"Name\"=?, \"Wages\"=? WHERE id_post=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_POST);
            preparedStatement.setString(1, post_name);
            preparedStatement.setInt(2, wage);
            preparedStatement.setInt(3, id_post);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet update_method(int id_method,String method_name, String description){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_UPDATE_METHOD = "UPDATE \"Coocking_method\" SET \"Name\"=?, \"Description\"=? WHERE id_method=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_METHOD);
            preparedStatement.setString(1, method_name);
            preparedStatement.setString(2, description);
            preparedStatement.setInt(3, id_method);
            return preparedStatement.executeQuery();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet update_cocktail_to_method(int id_cocktail, int id_method, int id_cocktail_after, int id_method_after){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_UPDATE_POST = "UPDATE \"Cocktail_to_method\" SET \"fk_id_cocktail\"=?, \"fk_id_method\"=? WHERE fk_id_cocktail=? AND fk_id_method=?;";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_UPDATE_POST);
            preparedStatement.setInt(1, id_cocktail_after);
            preparedStatement.setInt(2, id_method_after);
            preparedStatement.setInt(3, id_cocktail);
            preparedStatement.setInt(4, id_method);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet count_employee_post(String post_name){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COUNT_EMPLOYEE = "SELECT COUNT(*) as count FROM \"Employee\" JOIN \"Post\" ON fk_id_post=id_post WHERE \"Post\".\"Name\"= ?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COUNT_EMPLOYEE);
            preparedStatement.setString(1, post_name);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet count_employee_wage(int wage){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COUNT_WAGE = "SELECT COUNT(*) as count FROM \"Employee\" JOIN \"Post\" ON id_post=fk_id_post  WHERE \"Wages\" >  ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COUNT_WAGE);
            preparedStatement.setInt(1, wage);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ResultSet count_glass_volume(int volume){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COUNT_WAGE = "SELECT COUNT(*) as count FROM \"Glass\"  WHERE \"Volume\" >  ?" ;
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COUNT_WAGE);
            preparedStatement.setInt(1, volume);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static List<Employee> employee_select_id(int id_employee){
        List<Employee> emp = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_EMPLOYEE = "SELECT id_employee,\"FIO\",\"Age\",\"Sex\",\"Post\".\"id_post\",\"Post\".\"Name\",\"Post\".\"Wages\" FROM \"Employee\" JOIN \"Post\" ON \"Post\".\"id_post\"=\"fk_id_post\" WHERE id_employee= ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_EMPLOYEE);
            preparedStatement.setInt(1, id_employee);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                emp.add(new Employee(result.getInt("id_employee"),result.getString("FIO"),result.getString("Sex"), result.getInt("Age"), new Post(result.getInt("id_post"), result.getString("Name"), result.getInt("Wages") )));
            }
            return emp;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static List<Post> post_select_id(String name){
        List<Post> pos = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_POST = "SELECT id_post,\"Name\",\"Wages\" FROM \"Post\" WHERE \"Name\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_POST);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                pos.add(new Post(result.getInt("id_post"), result.getString("Name"), result.getInt("Wages") ));
            }
            return pos;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static List<Method> method_select_id(String method_name){
        List<Method> met = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_METHOD = "SELECT id_method,\"Name\",\"Description\" FROM \"Coocking_method\" WHERE \"Name\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_METHOD);
            preparedStatement.setString(1, method_name);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                met.add(new Method(result.getInt("id_method"), result.getString("Name"), result.getString("Description") ));
            }
            return met;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    static List<Employee> employee_select_all(){
        List<Employee> emp = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_EMPLOYEE = "SELECT id_employee,\"FIO\",\"Age\",\"Sex\",\"Post\".\"id_post\",\"Post\".\"Name\",\"Post\".\"Wages\" FROM \"Employee\" JOIN \"Post\" ON \"Post\".\"id_post\"=\"fk_id_post\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_EMPLOYEE);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                emp.add(new Employee(result.getInt("id_employee"),result.getString("FIO"),result.getString("Sex"), result.getInt("Age"), new Post(result.getInt("id_post"), result.getString("Name"), result.getInt("Wages") )));
            }
            return emp;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    static List<Post> post_select_all(){
        List<Post> pos = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_POST = "SELECT id_post,\"Name\",\"Wages\" FROM \"Post\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_POST);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                pos.add(new Post(result.getInt("id_post"), result.getString("Name"), result.getInt("Wages") ));
            }
            return pos;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    static List<Method> method_select_all(){
        List<Method> met = new ArrayList();
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_SELECT_METHOD = "SELECT id_method,\"Name\",\"Description\" FROM \"Coocking_method\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_METHOD);
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()){
                met.add(new Method(result.getInt("id_method"), result.getString("Name"), result.getString("Description") ));
            }
            return met;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public static ResultSet cocktail_to_method_insert_cocktail(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COCKTAIL = "SELECT id_cocktail,\"Name\" FROM \"Cocktail\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COCKTAIL);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ResultSet cocktail_to_method_insert_method(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COCKTAIL = "SELECT id_method,\"Name\" FROM \"Coocking_method\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COCKTAIL);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static ResultSet cocktail_to_method_select(){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COCKTAIL = "SELECT id_method,\"Coocking_method\".\"Name\" as met,\"Cocktail\".\"id_cocktail\",\"Cocktail\".\"Name\" as coc FROM \"Coocking_method\" JOIN \"Cocktail_to_method\" ON id_method = \"Cocktail_to_method\".\"fk_id_method\" JOIN \"Cocktail\" ON \"Cocktail_to_method\".\"fk_id_cocktail\"=\"Cocktail\".\"id_cocktail\"";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COCKTAIL);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public static ResultSet cocktail_to_method_select_name(String name){
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/BAR", "postgres", "")) {
            String SQL_COCKTAIL = "SELECT id_method,\"Coocking_method\".\"Name\" as met,\"Cocktail\".\"id_cocktail\",\"Cocktail\".\"Name\" as coc FROM \"Coocking_method\" JOIN \"Cocktail_to_method\" ON id_method = \"Cocktail_to_method\".\"fk_id_method\" JOIN \"Cocktail\" ON \"Cocktail_to_method\".\"fk_id_cocktail\"=\"Cocktail\".\"id_cocktail\" WHERE \"Cocktail\".\"Name\"=?";
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_COCKTAIL);
            preparedStatement.setString(1, name);
            ResultSet result = preparedStatement.executeQuery();
            return result;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
