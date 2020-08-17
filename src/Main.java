import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {

    public static Connection Conexión=null;

    public static void main(String[] args) {

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://192.168.56.2/geografia";
            String usuario = "censo";
            String clave = "abc";
            Conexión = DriverManager.getConnection(url, usuario, clave);
        }catch(ClassNotFoundException e){
            System.out.println("No encuentra la clase");
        }catch (SQLException e){
            System.out.println("Error de SQL"+e.toString());
        }


        //Comunidad c=new Comunidad("02","Aragón");
        //List<Municipio> municipios= c.getMunicipios();

        //Provincia p=new Provincia("50","Zaragoza");
        //List<Municipio> municipios= p.getMunicipios();

        Provincia p=new Provincia("50","Zaragoza");
        int pob=p.getPoblación();
        System.out.println("Población total "+ pob);


        /*if(municipios.isEmpty()){
            System.out.println("No tiene municipios");
        }else{
            System.out.println("Lista de municipios:");
            for (int i = 0; i < municipios.size(); i++) {
                Municipio m=municipios.get(i);
                System.out.println(m.getNombre());
            }
        }*/
    }
}
