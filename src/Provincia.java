import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Provincia {

    private String código;
    private String nombre;
    private String autonomía;
    private boolean válido;


    public Provincia(String código)throws  SQLException
    {
        this.código=código;
        this.nombre=nombre;
        this.válido=válido;

        String sql="SELECT * FROM provincia WHERE código= ?";
        PreparedStatement ps=Main.bdd.Conexión.prepareStatement(sql);
        ps.setString(1,this.código);
        ResultSet rs=ps.executeQuery();

        if(rs.next()){
            this.nombre=rs.getString("nombre");
            this.autonomía=rs.getString("autonomía");
            this.válido=true;

        }else{
            this.válido=false;
        }

    }

    public String aCadena(){
        return "Código: "+this.código+"\n"+ this.nombre + "\nAutonomia: "+autonomía;
    }

    public boolean getValido(){
        return this.válido;
    }

    public List<Municipio> getMunicipios(){
        List<Municipio> resultado=new ArrayList<Municipio>();

        try{
            String sql="SELECT * FROM municipio M" +
                    " WHERE M.provincia = ? ORDER BY M.nombre";
            PreparedStatement ps=Main.bdd.Conexión.prepareStatement(sql);
            ps.setString(1,this.código);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                //Municipio m=new Municipio();
                //m.setNombre(rs.getString("nombre"));
                //resultado.add(m);
            }
        }catch (SQLException e){
            System.out.println("Error de SQL"+e.toString());
        }

        return resultado;
    }

    public int getPoblación(){

        int resultado=-1;

        try {
            String sql = "SELECT SUM(población)AS total FROM municipio M" +
                    " WHERE M.provincia = ?";
            PreparedStatement ps = Main.bdd.Conexión.prepareStatement(sql);
            ps.setString(1, this.código);
            ResultSet rs = ps.executeQuery();

            rs.next();
            resultado= rs.getInt("total");


        }catch (SQLException e){
            System.out.println("Error de SQL"+e.toString());
        }

        return resultado;
    }

    public List<Municipio> municipios()throws  SQLException{
        return Main.bdd.municipiosProvincia(this.código);
    }
}
