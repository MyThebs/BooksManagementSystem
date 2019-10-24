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

public class UserList extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        UserDao userDao = new UserDao();
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        User queryUser = userDao.queryUser(user);
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

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
