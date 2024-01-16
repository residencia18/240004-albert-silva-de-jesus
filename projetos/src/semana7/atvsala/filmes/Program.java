package semana7.atvsala.filmes;

import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

import semana7.atvsala.filmes.entities.Filme;

public class Program {

    public static void main(String[] args) {

        limparTela();
        Locale.setDefault(Locale.US);

        String json_str = "{\"titulo\":\"Os Arquivos JSON\",\"ano\":1998,\"genero\":\"Ficção\"}";
        System.out.println(json_str);
        System.out.println();

        JSONObject my_obj = new JSONObject(json_str);
        JSONArray my_arr = new JSONArray();

        my_arr.put("Albert");
        my_arr.put("Bert");
        my_arr.put("Charles");
        my_arr.put("Dave");
        my_arr.put("Edward");

        System.out.println(my_arr);
        
        Filme filme = new Filme(my_obj.getString("titulo"), my_obj.getInt("ano"), my_obj.getString("genero"));
        System.out.println(filme);

        my_arr.forEach(ator -> filme.addAtor(ator.toString()));

        // System.out.println();
    }

    public static void limparTela() {
        try {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            // Trata exceções (pode ser uma exceção de interrupção)
            e.printStackTrace();
        }
    }
}
