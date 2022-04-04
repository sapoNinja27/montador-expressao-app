import java.util.*;

public class Service {

    public void verificaGramaticaFinzalizavel(HashMap<Character, List<String>> gramatica) throws Exception{
        Set<Character> characters = gramatica.keySet();
        if(!characters.contains('S')){
            throw new Exception("O start é obrigatorio");
        }
        List<String> strings = new ArrayList<>();
        for (Character c: characters
        ) {
            strings.addAll(gramatica.get(c));
        }
        for (String sentenca: strings
        ) {
            for (Character c: sentenca.toCharArray()) {
                if(Character.isUpperCase(c)){
                    if(!characters.contains(c)){
                        throw new Exception("Existe uma inconsistencia nos valores da sentença");
                    }
                }
            }
        }
    }

    public void Processar(HashMap<Character, List<String>> gramatica) throws Exception{
        verificaGramaticaFinzalizavel(gramatica);
        Stack<Character> lista = new Stack<>();
        Random rand = new Random();
        StringBuilder result = new StringBuilder(gramatica.get('S').get(rand.nextInt(gramatica.get('S').size())));
        System.out.println("Start: " + result);
        boolean repita;
        do {
            char[] temp = result.toString().toCharArray();
            for (char c : temp) {
                lista.push(c);
            }
            result = new StringBuilder();
            for (Character character : lista) {
                if(!Character.isUpperCase(character)) {
                    result.append(character);
                } else {
                    for (Character sentenca: gramatica.keySet()
                    ) {
                        if(sentenca.equals(character)){
                            result.append(gramatica.get(sentenca).get(rand.nextInt(gramatica.get(sentenca).size())));
                        }
                    }
                }
            }
            lista = new Stack<>();
            System.out.println("Passo: " + result);
            repita = false;
            for (Character charactere: result.toString().toCharArray()
            ) {
                if(Character.isUpperCase(charactere)){
                    repita = true;
                }
            }
        }while(repita);
        System.out.println("final: " + result);
    }
}