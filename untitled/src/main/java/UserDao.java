import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Util.JdbcUtil;
public class UserDao {
    private JdbcUtil util=new JdbcUtil();
    public int add(Users user){
        //用户注册
        String sql="insert into users(username,password)"+"values(?,?)";
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
              ps.setString(1,user.getUserName());
              ps.setString(2,user.getPassword());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public int del(Users user){
        //用户注册
        String sql="delete from users where userid=? and username=? and password=?";
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
            ps.setInt(1,user.getUserId());
            ps.setString(2,user.getUserName());
            ps.setString(3,user.getPassword());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    public int addPets(Pets pet){
//        添加宠物
        String sql="insert into pets(petName,pet_type,master)"+"values(?,?,?)";
        PreparedStatement ps=util.createStatement(sql);
        int result=0;
        try {
            ps.setString(1,pet.getPetName());
            ps.setString(2,pet.getPet_type());
            ps.setInt(3,pet.getMaster());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public List findAll(){
        //查找所有用户
        String sql="select *from users";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        List userList=new ArrayList();
        try {
            rs=ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                Integer userId=rs.getInt("userId");
                String userName=rs.getString("userName");
                String password=rs.getString("password");
                Users users=new Users(userId,userName,password);
                userList.add(users);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return userList;

    }
    public List petfindAll(){
        //查找所有宠物
        String sql="select *from pets";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet rs=null;
        List petList=new ArrayList();
        try {
            rs=ps.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            try {
                Integer master=rs.getInt("master");
                String petName=rs.getString("petName");
                String pet_type=rs.getString("pet_type");
                Pets pet=new Pets(petName,pet_type,master);
                petList.add(pet);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return petList;

    }
    public Users Login(String userName,String password)
    {//登录查询用户
        String sql="select *from users where username=? and password=?";
        PreparedStatement ps=util.createStatement(sql);
        ResultSet resultSet= null;
        Users user=null;
        try {
            ps.setString(1,userName);
            ps.setString(2,password);
            resultSet = ps.executeQuery();
            if(resultSet.next()) {
                user=new Users(userName,password);
                System.out.print(user.getUserName());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

}

