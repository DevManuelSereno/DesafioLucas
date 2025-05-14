package org.example.Questao2;

public class OrdenarPilha {

    // Pilha de inteiros feita à mão
    static class Pilha {
        int[] elementos;
        int topo;

        Pilha(int capacidade) {
            elementos = new int[capacidade];
            topo = -1;
        }

        void empilhar(int valor) {
            topo++;
            elementos[topo] = valor;
        }

        int desempilhar() {
            int valor = elementos[topo];
            topo--;
            return valor;
        }

        int topo() {
            return elementos[topo];
        }

        boolean estaVazia() {
            return topo == -1;
        }

        void imprimir() {
            for (int i = topo; i >= 0; i--) {
                System.out.print(elementos[i] + " ");
            }
            System.out.println();
        }
    }

    // Função para ordenar a pilha em ordem crescente
    static void ordenarPilha(Pilha original) {
        Pilha auxiliar = new Pilha(100);

        while (!original.estaVazia()) {
            int temp = original.desempilhar();

            // Mover os elementos da auxiliar de volta para original se forem maiores que o temp
            while (!auxiliar.estaVazia() && auxiliar.topo() > temp) {
                original.empilhar(auxiliar.desempilhar());
            }

            // Inserir o temp na posição correta
            auxiliar.empilhar(temp);
        }

        // Agora a pilha auxiliar está em ordem decrescente
        // Podemos movê-la de volta para a original se quisermos a ordem crescente com o menor no topo
        while (!auxiliar.estaVazia()) {
            original.empilhar(auxiliar.desempilhar());
        }
    }

    public static void main(String[] args) {
        Pilha pilha = new Pilha(100);

        // Inserindo valores na pilha (exemplo: 3, 1, 4, 2)
        pilha.empilhar(2);
        pilha.empilhar(1);
        pilha.empilhar(4);
        pilha.empilhar(3);
        pilha.empilhar(5);

        System.out.println("Pilha original:");
        pilha.imprimir();

        ordenarPilha(pilha);

        System.out.println("Pilha ordenada (menor no topo):");
        pilha.imprimir();
    }
}
