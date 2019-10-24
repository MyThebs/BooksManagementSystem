package dao;

import pojo.User;

import java.util.List;


public interface IUserDao
{
    public int creatUser(User user);
    public User queryUser(User user);
    public List<User> queryUserAll();
    public int updateUser(User user);
    public int deleteUser(User user);
}
