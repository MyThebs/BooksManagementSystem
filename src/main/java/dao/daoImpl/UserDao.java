package dao.daoImpl;

import dao.IUserDao;
import pojo.User;
import DBUtils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDao implements IUserDao
{
    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    @Override
    public int creatUser(User user)
    {
        try
        {
            connection = DBUtils.getConnection();
            String sql = "insert into user(uname,upwd,rname,email,mobile) values(?,?,?,?,?)";
            System.out.println(user.toString() + "正在注册");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpwd());
            preparedStatement.setString(3, user.getRname());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setInt(5, user.getMobile());
            int count = preparedStatement.executeUpdate();
            if (count == 1)
            {
                System.out.println("成功注册用户"+user.toString());
            }
            return count;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DBUtils.closeAll(resultSet, preparedStatement, connection);
        }

        return 0;
    }

    @Override
    public User queryUser(User user)
    {
        try
        {
            connection = DBUtils.getConnection();
            String sql = "SELECT * FROM user WHERE uname=? and upwd=?";
            System.out.println("uname:" + user.getUname() + "  password:" + user.getUpwd() + "正在登陆");
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUname());
            preparedStatement.setString(2, user.getUpwd());
            resultSet = preparedStatement.executeQuery();
            User queryUser=new User();
            while (resultSet.next())
            {
                queryUser.setUid(resultSet.getInt(1));
                queryUser.setUname(resultSet.getString(2));
                queryUser.setUpwd(resultSet.getString(3));
                queryUser.setRname(resultSet.getString(4));
                queryUser.setEmail(resultSet.getString(5));
                queryUser.setMobile(resultSet.getInt(6));
                System.out.println(user.getUname()+"登陆成功，用户信息为"+user.toString());
            }

            return queryUser;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DBUtils.closeAll(resultSet, preparedStatement, connection);
        }

        return null;
    }

    @Override
    public List<User> queryUserAll()
    {

        List<User> userList=new ArrayList<User>();
        try
        {
            connection = DBUtils.getConnection();
            String sql = "SELECT * FROM user";
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next())
            {
                User newUser=new User();
                newUser.setUid(resultSet.getInt(1));
                newUser.setUname(resultSet.getString(2));
                newUser.setUpwd(resultSet.getString(3));
                newUser.setRname(resultSet.getString(4));
                newUser.setEmail(resultSet.getString(5));
                newUser.setMobile(resultSet.getInt(6));
                userList.add(newUser);
            }
            System.out.println("查询到所有的user"+userList.toString());
            return userList;
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            DBUtils.closeAll(resultSet, preparedStatement, connection);
        }
        return userList;
    }


    @Override
    public int updateUser(User user)
    {
        return 0;
    }

    @Override
    public int deleteUser(User user)
    {
        return 0;
    }
}
