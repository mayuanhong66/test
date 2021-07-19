package servlet;


import entity.Account;
import sevice.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Service service=new Service();
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if(method.equals("add"))
        {
            add(req,resp);
        }else if(method.equals("delete")) {
            delete(req,resp);
        }else if(method.equals("update")) {
            update(req,resp);
        }else if(method.equals("list")) {
            list(req,resp);
        }else if(method.equals("getByname")) {
            getByname(req,resp);
        }else if(method.equals("show")) {
            show(req,resp);
        }
        else if(method.equals("getByname2")) {
            getByname2(req,resp);
        }
    }
    private void show(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Account> accounts = service.list();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("show.jsp").forward(req,resp);
    }
    private void add(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String a = req.getParameter("name");
        String b = req.getParameter("amount");
        String c = req.getParameter("money");
        String d=req.getParameter("time");
        Account account=new Account(a,b,c,d);
        int k=service.add(account);
        if(k==2) {
            req.setAttribute("message", "添加成功");//setAttribute方法用于将内容保存在对象中，传到add.jsp中
            req.getRequestDispatcher("add.jsp").forward(req,resp);//getRequestDispatcher方法用于进入下一个页面
        }
        if(k==0)
        {
            req.setAttribute("message", "重复，请重新录入");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
        if(k==1)
        {
            req.setAttribute("message", "数据库添加失败");
            req.getRequestDispatcher("add.jsp").forward(req,resp);
        }
    }
    private void delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        int k=service.delete(name);
        if(k==0) {
            req.setAttribute("message", "删除失败");
            req.getRequestDispatcher("deleteByname.jsp").forward(req,resp);
        }
        if(k==1) {
            req.setAttribute("message", "删除成功");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
    private void update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        // 修改
        req.setCharacterEncoding("utf-8");
        String a = req.getParameter("name");
        String b = req.getParameter("amount");
        String c = req.getParameter("money");
        String d=req.getParameter("time");
        Account account=new Account(a,b,c,d);
        int k=service.update(account);
        if(k==1) {
            req.setAttribute("message", "修改成功");
            req.getRequestDispatcher("AccountServlet?method=show").forward(req,resp);
        }else {
            req.setAttribute("message", "修改失败");
            req.getRequestDispatcher("show.jsp").forward(req,resp);
        }
    }

    private void getByname(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        //按照名字删除
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Account account=service.getByname(name);
        if(account==null) {
            req.setAttribute("message", "查询不到,请重新选择");
            req.getRequestDispatcher("deleteByname.jsp").forward(req,resp);
        }else {
            req.setAttribute("account", account);
            req.getRequestDispatcher("delete.jsp").forward(req,resp);
        }
    }

    private void getByname2(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        //通过名字修改
        req.setCharacterEncoding("utf-8");
        String name = req.getParameter("name");
        Account account=service.getByname2(name);
        req.setAttribute("account", account);
        req.getRequestDispatcher("update.jsp").forward(req,resp);
    }
    private void list(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        req.setCharacterEncoding("utf-8");
        List<Account> accounts = service.list();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

}
