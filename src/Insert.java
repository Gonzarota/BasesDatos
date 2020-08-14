import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
    public static void main(String[] args){

        Connection cnx;
        String urlCnx= "jdbc:postgresql://192.168.56.2/geografia";
        Statement sentencia;
        String sql="INSERT INTO ccaa(código,nombre) VALUES ('99','Javalandia')";
        int insert;

        try{
            Class.forName("org.postgresql.Driver");
            cnx= DriverManager.getConnection(urlCnx,"censo","abc");
            sentencia=cnx.createStatement();
            insert=sentencia.executeUpdate(sql);
            System.out.println("Se han insertado "+insert+" filas");

        }catch(ClassNotFoundException e){
            System.out.println("No encuentro la clase");
        }catch(SQLException e){
            System.out.println("Errror de SQL");
        }
    }
}
