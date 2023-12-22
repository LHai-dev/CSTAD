package co.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class jbdc {
    private  static Jdbcimpl jdbcimpl;
    private static Scanner s;

    public static void main(String[] args) {
        jdbcimpl = new Jdbcimpl();
        s = new Scanner(System.in);


        Elearning elearning1 = new Elearning();

        do {
            System.out.println("1.Insert Name ");
            System.out.println("2.Show dateBase");
            System.out.println("3.update dateBase");
            System.out.println("4.delete by id");
            System.out.println("5.select by id");
            System.out.println("6. select by name");
            int opt;
            System.out.println("Enter your Want ......");
            opt = s.nextInt();
            switch (opt){
                case 1 -> {
                    System.out.print("Enter Name: ");
                    elearning1.setName(s.next());
                    System.out.print("Enter gender: ");
                    elearning1.setGender(s.next());
                    System.out.print("Enter age: ");
                    elearning1.setAge(s.nextInt());
                    System.out.println("Enter major: ");
                    elearning1.setMajor(s.next());
                    insertEle(elearning1);
                    System.out.println("thank you .........");
                    s.nextLine();
                }
                case 2 ->{
                    insertEle1();
                System.out.println("thank you .........");
                s.nextLine();
                }
                case 3 ->{

                        s = new Scanner(System.in);
                        System.out.print("Enter ID: ");
                        int id = s.nextInt();

                        System.out.print("Enter Name : ");
                        String name = s.next();

                        System.out.print("Enter gender: ");
                        String gender = s.next();

                        System.out.print("Enter age : ");
                        int age = s.nextInt();

                        System.out.print("Enter major (leave empty if no change): ");
                        String major = s.next();

                    elearning1.setId(id);
                    elearning1.setName(name);
                    elearning1.setGender(gender);
                    elearning1.setAge(age);
                    elearning1.setMajor(major);
                        updateEle(elearning1);
                    System.out.println("thank you .........");
                    s.nextLine();
                    }
                    case 4->{
                        System.out.print("Enter ID to Delete: ");
                        int id = s.nextInt();
                        elearning1.setId(id);
                        deleteByID(elearning1);
                        System.out.println("thank you .........");
                        s.nextLine();
                    }
                    case 5->{
                        System.out.print("Enter ID to selete: ");
                        int id = s.nextInt();
                        elearning1.setId(id);
                        seleteByID(elearning1);
                        System.out.println("thank you .........");
                        s.nextLine();
                    }
                    case 6->{
                        System.out.println("select by name");
                        String name = s.next();
                        elearning1.setName(name);
                        createSelectByName(elearning1);
                        System.out.println("thank you .........");
                        s.nextLine();
                    }

                }
            }while (true);
        }
        private  static void createSelectByName(Elearning elearning){
        try(Connection connection = jdbcimpl.dataSource().getConnection()){
            String createSelectByName = "FROM ele WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(createSelectByName);
            statement.setString(1,elearning.getName());
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                insertEle1();
            } else {
                System.out.println("No record found with name " + elearning.getName());
            }
        }catch (SQLException e){
            e.printStackTrace();
            }
        }

//
  private static void seleteByID(Elearning elearning){
        try(Connection connection = jdbcimpl.dataSource().getConnection()) {
            String seleteByID="SELECT * FROM ele WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(seleteByID);
            statement.setInt(1, elearning.getId());

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                insertEle1();
            }else {
                System.out.println("No record found with id " + elearning.getId());

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
  }
    private static void deleteByID(Elearning elearning){
        try(Connection connection = jdbcimpl.dataSource().getConnection()){
            String deleteByID = "DELETE FROM ele WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(deleteByID);
            statement.setInt(1,elearning.getId());
            int count = statement.executeUpdate();
            System.out.println(count);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private static void updateEle(Elearning elearning){
        try(Connection connection = jdbcimpl.dataSource().getConnection()) {
            String updateSql = "UPDATE ele SET name = ?, age = ?, major = ?, gender = ? WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(updateSql);
            statement.setString(1, elearning.getName());
            statement.setInt(2, elearning.getAge());
            statement.setString(3, elearning.getMajor());
            statement.setString(4, elearning.getGender());
            statement.setInt(5, elearning.getId()); // assuming user inputs the id value to update

            int count = statement.executeUpdate();
            System.out.println(count);

        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    private static void insertEle(Elearning elearning){
        try(Connection connection = jdbcimpl.dataSource().getConnection()) {
            String insertSql = "INSERT INTO ele (id, name, age, major, gender) VALUES (nextval('ele_id_seq'), ?, ?, ?, ?)";
//            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO ele (id, name, age, email, password) VALUES (nextval('ele_id_seq'), ?, ?, ?, ?)");

            PreparedStatement statement = connection.prepareStatement(insertSql);

            statement.setString(1,elearning.getName());
            statement.setInt(2,elearning.getAge());
            statement.setString(3,elearning.getMajor());
            statement.setString(4,elearning.getGender());

            int count = statement.executeUpdate();
            System.out.println(count);
            // Get the generated id value from the insert statement
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int id = generatedKeys.getInt(1);
                System.out.println("New record inserted with id: " + id);
            }
        }catch (SQLException e){
    e.printStackTrace();
        }
    }
    private static void insertEle1(){
//        String connectionUrl = "jdbc:postgresql://localhost:5432/   ";
//        String name1 = "postgres";
//        String password = "Hai172212";
        try(Connection connection = jdbcimpl.dataSource().getConnection()) {

//            System.out.println(connection.getSchema());
            String selectSql = "SELECT * FROM ele";
            //2 Execute SQL Statement
            PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = preparedStatement.executeQuery();
            //3 . process Result with ResultSet
            List <Elearning> list = new ArrayList<>();

            while (resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String major = resultSet.getString("major");
                Integer age = resultSet.getInt("age");
                String gender = resultSet.getString("gender");
                list.add(new Elearning(id , name , gender, age, major));
            }
            list.forEach(System.out::println);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
