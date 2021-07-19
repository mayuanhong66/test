package dao;

import entity.Account;
import tuil.Shujuku;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    public boolean rename(String name) {
        // 检验名字是否重复
        boolean f=false;
        String sql="select name from account where name='"+name+"'";//数据库语句，查询界面输入和表中name是否重复
        Connection conn = Shujuku.conn();//创建连接
        Statement state = null;//建立Statement对象，执行静态SQL语句
        ResultSet rs = null;//ResultSet对象 是查询数据库时的返回对象，读取返回结果集

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {//不重复，返回true
                f = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(rs, state, conn);
        }
        return f;
    }

    public boolean add(Account account) {
        //添加
        String sql = "insert into account(name,amount,money,time) values('" +account.getName() + "','" + account.getAmount() + "','" + account.getMoney() + "','" +account.getTime() + "')";//添加
        Connection conn = Shujuku.conn();
        Statement state = null;
        boolean f = false;
        int a=0;
        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(state, conn);
        }
        if (a > 0) {
            f = true;
        }
        return f;
    }


    public boolean delete(String name) {
        // 通过名字删除
        boolean f=false;
        String sql = "delete from account where name ='" + name + "'";//删除
        Connection conn = Shujuku.conn();
        Statement state = null;
        int a=0;
        try {
            state = conn.createStatement();
            a=state.executeUpdate(sql);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(state, conn);
        }
        if(a>0) {
            f=true;
        }
        return f;
    }
    public boolean update(Account account) {
        // 修改
        String sql = "update account set amount='" + account.getAmount() + "', money='" + account.getMoney()+"',time='" + account.getTime()+"'where name='"+account.getName()+"'";
        Connection conn = Shujuku.conn();
        Statement state = null;
        boolean f = false;
        int a = 0;

        try {
            state = conn.createStatement();
            a = state.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(state, conn);
        }

        if (a > 0) {
            f = true;
        }
        return f;

    }
    public List<Account> show(String name) {
        // 列出数据
        String sql = "select * from account";
        Connection conn = Shujuku.conn();
        Statement state = null;
        ResultSet rs = null;
        List<Account> list = new ArrayList<>();
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Account bean = null;
            while (rs.next()) {

                String a = rs.getString("name");
                String b = rs.getString("amount");
                String c= rs.getString("money");
                String d= rs.getString("time");
                bean= new Account( a,b,c,d);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(rs, state, conn);
        }

        return list;
    }

    public Account getByname(String name) {
        //通过名字得到
        //模糊查询
        String sql = "select * from account where ";
        if (name != "") {
            sql += "name like '%" + name + "%'";
        }
        Connection conn = Shujuku.conn();
        Statement state = null;
        ResultSet rs = null;
        Account account = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String d=rs.getString("name");
                String a = rs.getString("amount");
                String b=rs.getString("money");
                String c=rs.getString("time");
                account = new Account(d,a,b,c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(rs, state, conn);
        }

        return account;
    }

    public List<Account> list() {
        String sql = "select * from account";
        List<Account> list = new ArrayList<>();
        Connection conn = Shujuku.conn();
        Statement state = null;
        ResultSet rs = null;

        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            Account bean = null;
            while (rs.next()) {

                String a = rs.getString("name");
                String b = rs.getString("amount");
                String c = rs.getString("money");
                String d = rs.getString("time");
                bean = new Account(a,b,c,d);
                list.add(bean);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(rs, state, conn);
        }

        return list;
    }

    public Account getByname2(String name) {
        String sql = "select * from account where ";
        if (name != "") {
            sql += "name like '%" + name + "%'";
        }
        Connection conn = Shujuku.conn();
        Statement state = null;
        ResultSet rs = null;
        Account account = null;
        try {
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                String d=rs.getString("name");
                String a = rs.getString("amount");
                String b=rs.getString("money");
                String c=rs.getString("time");
                account = new Account(d,a,b,c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Shujuku.close(rs, state, conn);
        }

        return account;
    }
}
