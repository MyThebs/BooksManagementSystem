package DBUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils
{
    private static String driverName;
    private static String url;
    private static String userName;
    private static String password;

    static
    {
        Properties properties=new Properties();
        try
        {
            InputStream inputStream=DBUtils.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            properties.load(inputStream);
            driverName=properties.getProperty("driverName");
            url=properties.getProperty("url");
            userName=properties.getProperty("userName");
            password=properties.getProperty("passWord");
            Class.forName(driverName);


        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            throw new RuntimeException("找不到dbconfig.properties配置文件");
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        Connection connection=null;
        try
        {
            connection= DriverManager.getConnection(url,userName,password);
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    public static <T> void closeAll(T...objects)
    {
        for(Object object:objects)
        {
            if (object != null)
            {
                try
                {
                    if (object instanceof ResultSet)
                    {
                        ((ResultSet) object).close();
                        System.out.println("关闭ResultSet");
                    }
                    if(object instanceof Statement)
                    {
                        ((Statement) object).close();
                        System.out.println("关闭statment");
                    }
                    if(object instanceof Connection)
                    {
                        ((Connection) object).close();
                        System.out.println("关闭connection");
                    }
                }catch(SQLException e)
                {
                    e.printStackTrace();
                }
            }

        }
    }
}
