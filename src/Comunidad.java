import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comunidad {

    private String código;
    private String nombre;

    public List<Provincia> getProvincias(){
        List<Provincia> resultado = new ArrayList<Provincia>();
        return resultado;
    }

    public List<Municipio> getMunicipios(){
        List<Municipio> resultado=new ArrayList<Municipio>();

        try{
            Class.forName("org.postgresql.Driver");
            String url="jdbc:postgresql://192.168.56.2/geografia";
            String usuario="censo";
            String clave="abc";
            Connection c= DriverManager.getConnection(url,usuario,clave);
            Statement s=c.createStatement();
            ResultSet rs=s.executeQuery("SELECT * FROM municipio");
                    while(rs.next()){
                        Municipio m=new Municipio();
                        m.setNombre(rs.getString("nombre"));
                        resultado.add(m);
                    }
        }catch (ClassNotFoundException e){
            System.out.println("No encuentra la clase");
        }catch (SQLException e){
            System.out.println("Error de SQL"+e.toString());
        }

        return resultado;
    }
}
