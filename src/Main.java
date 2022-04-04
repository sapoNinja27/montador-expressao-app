import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        HashMap<Character, List<String>> gramatica = new HashMap<>();

        //OBRIGATORIO: O S(start) é obrigatorio
        gramatica.put(('S'), Arrays.asList("ABCS", "ABC", "aBc"));

        gramatica.put('A', Arrays.asList("AbC", "ab"));
        gramatica.put('B', Arrays.asList("bC", "bc"));
        gramatica.put('C', Arrays.asList("Bc", "cc"));

        try {
            service.Processar(gramatica);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}