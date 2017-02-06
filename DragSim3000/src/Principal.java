
public class Principal {
    public static void main(String[] args) {
        ListeVoitures a = new ListeVoitures();

        System.out.println(a.voitures.get(0).getMasse());
        System.out.println(a.voitures.get(5).getMasse());
    }
}
