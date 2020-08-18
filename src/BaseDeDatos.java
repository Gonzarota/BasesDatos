import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDeDatos {

    public static Connection Conexión=null;

    public void conectar()throws SQLException,ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://192.168.56.2/geografia";
        String usuario = "censo";
        String clave = "abc";
        Conexión = DriverManager.getConnection(url, usuario, clave);
    }

    public List<Municipio> municipiosProvincia(String códigoProvincia) throws SQLException {

        List<Municipio> resultado = new ArrayList<Municipio>();

        String sql = "SELECT * FROM municipio WHERE provincia = ?" +
                " AND P.autonomía = ?";
        PreparedStatement ps = Main.bdd.Conexión.prepareStatement(sql);
        ps.setString(1, códigoProvincia);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            do {
                String códigoMunicipio = rs.getString("código");
                Municipio m = new Municipio(códigoProvincia, códigoMunicipio);
                m.setNombre(rs.getString("nombre"));
                resultado.add(m);
            } while (rs.next());
        }

        return resultado;

    }

    public List<Municipio> municipiosAutonomia(String códigoAutonomía)throws SQLException{
        List<Municipio> resultado = new ArrayList<Municipio>();

        String sql = "SELECT * FROM municipio M, provincia P WHERE M.provincia=P.código" +
                " AND P.autonomía = ?";
        PreparedStatement ps = Main.bdd.Conexión.prepareStatement(sql);
        ps.setString(1, códigoAutonomía);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            do {
                String códigoMunicipio = rs.getString("código");
                String códigoProvincia = rs.getString("código");
                Municipio m = new Municipio(códigoAutonomía, códigoMunicipio);
                m.setNombre(rs.getString("nombre"));
                resultado.add(m);
            } while (rs.next());
        }

        return resultado;

    }
}
