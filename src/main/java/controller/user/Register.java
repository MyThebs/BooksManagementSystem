package controller.user;

import dao.daoImpl.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class Register extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        Map<String, String[]> info = req.getParameterMap();
        User user=new User();
        UserDao userDao=new UserDao();
        int i = userDao.creatUser(user);
        if (i==1)
        {
            resp.sendRedirect("/LearnServlet/register/success.html");
        }else {
            resp.sendRedirect("/LearnServlet/register/failure.html");
        }
    }
}
