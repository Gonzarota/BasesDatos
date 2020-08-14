import java.sql.*;

public class Listado {
    public static void main(String[] args){
        Connection cn;
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Clase cargada correctamente");
        }catch(ClassNotFoundException e){
            System.out.println("Error chungo: "+e.toString());
        }

        try {
            cn = DriverManager.getConnection("jdbc:postgresql://192.168.56.2/geografia", "censo", "abc");
            String sql="SELECT * FROM ccaa ORDER BY código";
            Statement sentencia= cn.createStatement();
            ResultSet filas=sentencia.executeQuery(sql);
            while(filas.next()){
                String código=filas.getString("código");
                String nombre=filas.getString("nombre");
                System.out.println("código: "+código);
                System.out.println("nombre: "+nombre);
                System.out.println("");
            }
            System.out.println("Conexión establecida");
        }catch(SQLException e){
            System.out.println("Error: " +e.toString());
        }



        System.out.println("Programa finalizado");
    }
}
