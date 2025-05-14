package org.example.Questao7;

public class ListaEstaticaEncadeada {

    // Tamanho máximo da lista
    static final int TAMANHO = 100;

    // Classe interna que representa um nó
    static class No {
        int dado; // Valor armazenado
        int prox; // Índice do próximo nó
    }

    // Vetor de nós simulando a lista
    No[] lista = new No[TAMANHO];

    // Índices que controlam a estrutura
    int inicio; // Índice do primeiro elemento da lista encadeada
    int livre;  // Índice do primeiro elemento da lista livre (gavetas vazias)

    // Construtor que inicializa a estrutura
    public ListaEstaticaEncadeada() {
        // Inicializa todos os nós e encadeia a lista livre
        for (int i = 0; i < TAMANHO; i++) {
            lista[i] = new No();
            lista[i].prox = i + 1;
        }
        lista[TAMANHO - 1].prox = -1; // Fim da lista livre
        inicio = -1; // Lista encadeada inicialmente vazia
        livre = 0;   // Primeira posição livre é 0
    }

    // Inserção no início da lista encadeada
    public void inserirInicio(int valor) {
        if (livre == -1) {
            System.out.println("Lista cheia!");
            return;
        }

        int novo = livre;            // Reserva a posição livre
        livre = lista[livre].prox;   // Atualiza o ponteiro da lista livre

        lista[novo].dado = valor;    // Insere o valor
        lista[novo].prox = inicio;   // Aponta para o antigo início
        inicio = novo;               // Atualiza o novo início
    }

    // Remoção no início da lista encadeada
    public void removerInicio() {
        if (inicio == -1) {
            System.out.println("Lista vazia!");
            return;
        }

        int removido = inicio;          // Guarda o índice a ser removido
        inicio = lista[inicio].prox;    // Novo início da lista

        // Coloca o nó removido de volta na lista livre
        lista[removido].prox = livre;
        livre = removido;
    }

    // Exibição da lista encadeada
    public void exibir() {
        int atual = inicio;
        while (atual != -1) {
            System.out.print(lista[atual].dado + " ");
            atual = lista[atual].prox;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListaEstaticaEncadeada lista = new ListaEstaticaEncadeada();

        // Testando inserções
        lista.inserirInicio(10);
        lista.inserirInicio(20);
        lista.inserirInicio(30);
        System.out.print("Lista após inserções: ");
        lista.exibir(); // Deve exibir: 30 20 10

        // Testando remoção
        lista.removerInicio();
        System.out.print("Lista após uma remoção: ");
        lista.exibir(); // Deve exibir: 20 10
    }
}
