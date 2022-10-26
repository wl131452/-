public class Users {

    private  Integer userId;
    private String userName;
    private String password;

    Users(Integer a,String b,String c)
    {
        this.userId=a;
        this.userName=b;
        this.password=c;
    }
    Users(String b,String c)
    {
        this.userName=b;
        this.password=c;
    }
    public Integer getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

