package controller.user;

import dao.daoImpl.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Login extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

        int currentPage = Integer.parseInt(req.getParameter("currentPage"));
        List<User> userList=getUserList(currentPage);
        HttpSession session = req.getSession();
        session.setAttribute("currentPage",currentPage);
        session.setAttribute("userList", userList);
        //req.getRequestDispatcher("/user/admin.jsp").forward(req,resp);
        resp.sendRedirect("/BooksManagementSystem/user/userman.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Map<String, String[]> info = req.getParameterMap();
        User user = new User();
        user.setUname(info.get("uname")[0]);
        user.setUpwd(info.get("upwd")[0]);
        UserDao userDao = new UserDao();
        User queryUser = userDao.queryUser(user);
        HttpSession session = req.getSession();
        List<User> userList=getUserList(1);
        List<User> userListAll=getUserListAll();
        session.setAttribute("userList",userList);
        session.setAttribute("username",user.getUname());
        session.setAttribute("currentPage",1);
        session.setAttribute("pages",userListAll.size()%5==0?userListAll.size()/5:userListAll.size()/5+1);

        if (queryUser.getUname()!=null)
        {
            resp.sendRedirect("/BooksManagementSystem/user/admin.jsp");
        } else
        {
            resp.sendRedirect("/BooksManagementSystem/login.html");
        }

    }

    private List<User> getUserList(int currentPage)
    {
        UserDao userDao=new UserDao();
        List<User> userList = userDao.queryUserAll();
        if (userList.size()>currentPage*5)
        {
            return userList.subList((currentPage-1)*5,currentPage*5);
        }else {
            return userList.subList((currentPage-1)*5,userList.size());
        }

    }

    private List<User> getUserListAll()
    {
        return new UserDao().queryUserAll();
    }
}
