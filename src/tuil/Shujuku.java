package tuil;

import java.sql.*;

public class Shujuku {
    public static Connection conn(){
        String url="jdbc:mysql://localhost:3306/Cource";//填写你的数据库名
        String userName="root";//填写你的用户名，我的是sa
        String userPwd="123";//填写你的密码tzk19991029
        Connection connection=null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载驱动成功！");

        }catch(Exception e){

            e.printStackTrace();

            System.out.println("加载驱动失败！");
        }
        try{
            connection= DriverManager.getConnection(url,userName,userPwd);
            System.out.println("连接数据库成功！");
        }catch(Exception e){
            e.printStackTrace();
            System.out.print("SQL Server连接失败！");
        }
        return connection;
    }
    public static void close (Statement state, Connection conn) {//关闭
        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close (ResultSet rs, Statement state, Connection conn) {//关闭
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (state != null) {
            try {
                state.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
