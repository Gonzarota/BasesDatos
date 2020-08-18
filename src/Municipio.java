import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Municipio {

    private String nombre;
    private String provincia;
    private String código;
    private int población;
    private float superficie;
    private float latitutd;
    private float longitud;
    private boolean válido;

    public void setNombre(String nuevoNombre){
        this.nombre=nuevoNombre;
    }

    public boolean getValido()
    {
        return this.válido;
    }
    public String getNombre(){
        return this.nombre;
    }

    public Municipio(String códigoProvincia, String códigoMunicipio) throws SQLException {
        this.provincia=códigoProvincia;
        this.código=códigoMunicipio;

        String sql="SELECT * FROM municipio WHERE código= ? AND provincia =?";
        PreparedStatement ps=Main.bdd.Conexión.prepareStatement(sql);
        ps.setString(1,this.código);
        ps.setString(2,this.provincia);
        ResultSet rs=ps.executeQuery();
        if(rs.next()){
            this.nombre=rs.getString("nombre");
            this.población=rs.getInt("población");
            this.superficie=rs.getFloat("superficie");
            this .latitutd=rs.getFloat("latitud");
            this.longitud=rs.getFloat("longitud");
            this.válido=true;

        }else{
            this.válido=false;
        }

    }

    public String aCadena(){

        String texto= ("Nombre: "+this.nombre+ "\n" +"Población: "+this.población);
        return texto;
    }
}
