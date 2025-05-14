package org.example.Questao3;

public class FilaDePilhas {

    // Pilha básica de inteiros
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

    // Fila de Pilhas
    static class Fila {
        Pilha[] pilhas;
        int inicio, fim, tamanho;

        Fila(int capacidade) {
            pilhas = new Pilha[capacidade];
            inicio = 0;
            fim = 0;
            tamanho = 0;
        }

        boolean estaVazia() {
            return tamanho == 0;
        }

        boolean estaCheia() {
            return tamanho == pilhas.length;
        }

        void inserirPilha(Pilha novaPilha) {
            if (estaCheia()) {
                System.out.println("Fila cheia! Não é possível inserir mais pilhas.");
                return;
            }
            pilhas[fim] = novaPilha;
            fim = (fim + 1) % pilhas.length;
            tamanho++;
        }

        Pilha removerPilha() {
            if (estaVazia()) {
                System.out.println("Fila vazia! Nada a remover.");
                return null;
            }
            Pilha removida = pilhas[inicio];
            inicio = (inicio + 1) % pilhas.length;
            tamanho--;
            return removida;
        }

        // Insere número em uma pilha da fila (por índice lógico)
        void inserirNumeroNaPilha(int indice, int numero) {
            if (indice >= tamanho) {
                System.out.println("Índice inválido para pilha.");
                return;
            }
            int posicaoReal = (inicio + indice) % pilhas.length;
            pilhas[posicaoReal].empilhar(numero);
        }

        // Remove número de uma pilha da fila (por índice lógico)
        int removerNumeroDaPilha(int indice) {
            if (indice >= tamanho) {
                System.out.println("Índice inválido para pilha.");
                return -1;
            }
            int posicaoReal = (inicio + indice) % pilhas.length;
            return pilhas[posicaoReal].desempilhar();
        }

        void imprimirFilaDePilhas() {
            System.out.println("Fila de Pilhas:");
            for (int i = 0; i < tamanho; i++) {
                int pos = (inicio + i) % pilhas.length;
                System.out.print("Pilha " + i + ": ");
                pilhas[pos].imprimir();
            }
        }
    }

    // Testando tudo
    public static void main(String[] args) {
        Fila fila = new Fila(5); // Fila com 5 pilhas no máximo

        // Criar pilhas
        Pilha pilha1 = new Pilha(10);
        Pilha pilha2 = new Pilha(10);

        // Inserir pilhas na fila
        fila.inserirPilha(pilha1);
        fila.inserirPilha(pilha2);

        // Inserir números nas pilhas da fila
        fila.inserirNumeroNaPilha(0, 10); // insere na pilha1
        fila.inserirNumeroNaPilha(0, 20);
        fila.inserirNumeroNaPilha(1, 30);// insere na pilha2
        fila.inserirNumeroNaPilha(1, 50);

        fila.imprimirFilaDePilhas();

        // Remover número da pilha1
        int removido = fila.removerNumeroDaPilha(0);
        System.out.println("Número removido da pilha 0: " + removido);

        // Remover a primeira pilha da fila
        Pilha pilhaRemovida = fila.removerPilha();
        System.out.println("Pilha removida da fila:");
        pilhaRemovida.imprimir();

        fila.imprimirFilaDePilhas();
    }
}

