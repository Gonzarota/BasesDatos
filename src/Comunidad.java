import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Comunidad {

    private String código;
    private String nombre;

    public Comunidad(String código, String nombre)
    {
        this.código=código;
        this.nombre=nombre;
    }

    public List<Provincia> getProvincias(){
        List<Provincia> resultado = new ArrayList<Provincia>();
        return resultado;
    }

    public List<Municipio> getMunicipios(){
        List<Municipio> resultado=new ArrayList<Municipio>();

        try{
            String sql="SELECT * FROM municipio M," +
                    " provincia P WHERE M.provincia = P.código" +
                    " AND P.autonomía = ?";
            PreparedStatement ps=Main.Conexión.prepareStatement(sql);
            ps.setString(1,this.código);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                Municipio m=new Municipio();
                m.setNombre(rs.getString("nombre"));
                resultado.add(m);
            }
        }catch (SQLException e){
            System.out.println("Error de SQL"+e.toString());
        }

        return resultado;
    }
}
