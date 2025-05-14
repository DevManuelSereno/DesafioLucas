package org.example.Questao1;

public class InversorDePalavras {

    // Classe Pilha de caracteres
    static class Pilha {
        char[] elementos;
        int topo;

        Pilha(int capacidade) {
            elementos = new char[capacidade];
            topo = -1;
        }

        void empilhar(char c) {
            topo++;
            elementos[topo] = c;
        }

        char desempilhar() {
            char c = elementos[topo];
            topo--;
            return c;
        }

        boolean estaVazia() {
            return topo == -1;
        }
    }

    public static void main(String[] args) {
        // Texto de entrada
        char[] texto = ("ESTE EXERCÍCIO É MUITO FÁCIL.").toCharArray();

        Pilha pilha = new Pilha(100); // tamanho arbitrário

        for (int i = 0; i < texto.length; i++) {
            char atual = texto[i];

            if (atual != ' ' && atual != '.') {
                // Se for letra, empilha
                pilha.empilhar(atual);
            } else {
                // Se for espaço ou ponto, desempilha tudo (inverte a palavra)
                while (!pilha.estaVazia()) {
                    System.out.print(pilha.desempilhar());
                }

                // Imprime o caractere separador (espaço ou ponto)
                System.out.print(atual);
            }
        }
    }
}
