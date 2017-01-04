package javaapplication4;
import java.sql.*;

public class JavaApplication4 {

    public static void main(String[] args) {
        Connection con =null;
        try{
            String _driver = "com.mysql.jdbc.Driver";
            String _url ="jdbc:mysql://localhost/test?user=sa&password=!password123";
            Class.forName(_driver);
            con=DriverManager.getConnection(_url);
            String sql ="select * from test1 where id =? limit 10";
            PreparedStatement stmt=con.prepareStatement(sql);
            stmt.setString(1, "5");
            ResultSet res =stmt.executeQuery();
            while(res.next())
            {
                System.out.println(res.getString("id")+" "+res.getString("amount")+" "+res.getString("price"));
            }
            res.close();
            stmt.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            if(con!=null){
                try{
                    System.out.println("SQL closed...");
                }
                catch (Exception e2){
                }
            }
        }
    }
    
}
