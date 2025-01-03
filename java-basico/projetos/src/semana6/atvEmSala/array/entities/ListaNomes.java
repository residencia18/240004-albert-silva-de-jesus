/*Suponha um método que preenche um array de nomes de pessoas. – Escreva um método que verifica se um nome específico está presente
no array. – Elabore uma versão deste método usando o array e outra convertenddo o array para uma lista – Escreva um método que MODIFICA um 
nome específico no array, se ele existir (gere uma exception caso contrário) – Elabore uma versão deste método usando o array e outra
convertenddo o array para uma lista */

package semana6.atvEmSala.array.entities;

import semana6.atvEmSala.array.exceptions.NomeNaoEncontradoException;

public class ListaNomes {

    private String[] nomes;

    public ListaNomes() {
    }

    public ListaNomes(String[] nomes) {
        this.nomes = nomes;
    }

    public String[] getNomes() {
        return nomes;
    }

    public void setNome(String nome, int index) {
        this.nomes[index] = nome;
    }

    public boolean verificaNome(String nome) {
        for (String nomeLista : nomes) {
            if (nomeLista.equals(nome)) {
                return true;
            }
        }
        return false;
    }

    public void modificaNome(String nome, int index) {
        if (verificaNome(nome)) {
            System.out.print("Informe o novo nome: ");
            nome = System.console().readLine();
            setNome(nome, index);
        } else {
            throw new NomeNaoEncontradoException("Ops, nome não encontrado!...");
        }
    }

    public void imprimeNomes() {
        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

}
