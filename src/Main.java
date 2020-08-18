import java.sql.SQLException;
import java.util.List;

public class Main {

    public static BaseDeDatos bdd= new BaseDeDatos();

    public static void main(String[] args) {

        try{

            bdd.conectar();
            Provincia p = new Provincia("50");
            Autonomía a= new Autonomía("02");
            //List<Municipio> municipios=p.municipios();
            List<Municipio> municipios=a.getMunicipios();

            if(municipios==null){
                System.out.println("la provincia no existe");
            }else{
                System.out.println("Poner los municipios: "+ municipios.size());
            }


        }catch (SQLException e){
            System.out.println("Error SQL"+ e.toString());
        }catch (ClassNotFoundException e){
            System.out.println("Clase no encontroda"+ e.toString());
        }

        //Comunidad c=new Comunidad("02","Aragón");
        //List<Municipio> municipios= c.getMunicipios();

        //Provincia p=new Provincia("50","Zaragoza");
        //List<Municipio> municipios= p.getMunicipios();

        //Provincia p=new Provincia("50","Zaragoza");
        //int pob=p.getPoblación();
        //System.out.println("Población total "+ pob);


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
