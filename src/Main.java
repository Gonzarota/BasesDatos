import java.util.List;

public class Main {
    public static void main(String[] args) {

        Comunidad c=new Comunidad();
        List<Municipio> municipios= c.getMunicipios();

        if(municipios.isEmpty()){
            System.out.println("No tiene municipios");
        }else{
            System.out.println("Lista de municipios:");
            for (int i = 0; i < municipios.size(); i++) {
                Municipio m=municipios.get(i);
                System.out.println(m.getNombre());
            }
        }
    }
}
