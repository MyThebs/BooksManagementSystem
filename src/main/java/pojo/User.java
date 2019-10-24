package pojo;

public class User
{
    private int uid;
    private String uname;
    private String upwd;
    private String rname;
    private String email;
    private int mobile;

    public User()
    {
    }

    @Override
    public String toString()
    {
        return "User{" + "uid=" + uid + ", uname='" + uname + '\'' + ", upwd='" + upwd + '\'' + ", rname='" + rname + '\'' + ", email='" + email + '\'' + ", mobile='" + mobile + '\'' + '}';
    }

    public void setUid(int uid)
    {
        this.uid = uid;
    }

    public int getUid()
    {
        return uid;
    }

    public String getUname()
    {
        return uname;
    }

    public void setUname(String uname)
    {
        this.uname = uname;
    }

    public String getUpwd()
    {
        return upwd;
    }

    public void setUpwd(String upwd)
    {
        this.upwd = upwd;
    }

    public String getRname()
    {
        return rname;
    }

    public void setRname(String rname)
    {
        this.rname = rname;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getMobile()
    {
        return mobile;
    }

    public void setMobile(int mobile)
    {
        this.mobile = mobile;
    }

    public User(int uid, String uname, String upwd, String rname, String email, int mobile)
    {
        this.uid = uid;
        this.uname = uname;
        this.upwd = upwd;
        this.rname = rname;
        this.email = email;
        this.mobile = mobile;
    }
}
