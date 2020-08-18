import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Autonomía {

    private String código;
    private String nombre;

    public Autonomía(String código)
    {
        this.código=código;
        this.nombre=nombre;
    }

    public List<Provincia> getProvincias(){
        List<Provincia> resultado = new ArrayList<Provincia>();
        return resultado;
    }

    public List<Municipio> getMunicipios()throws  SQLException{
        return Main.bdd.municipiosAutonomia(this.código);
    }
}
