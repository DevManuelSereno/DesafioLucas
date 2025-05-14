package org.example.Questao4;

class No {
    int dado;
    No prox;
    No ant;

    No(int valor) {
        dado = valor;
        prox = null;
        ant = null;
    }
}

class PilhaLista {
    private No topo; // Representa o topo da pilha

    public PilhaLista() {
        topo = null;
    }

    // Insere um elemento no topo da pilha
    public void empilhar(int valor) {
        No novo = new No(valor);
        if (topo != null) {
            novo.prox = topo;
            topo.ant = novo;
        }
        topo = novo;
    }

    // Remove o elemento do topo e retorna seu valor
    public int desempilhar() {
        if (topo == null) {
            System.out.println("Pilha vazia!");
            return -1; // Retorno de erro simples
        }
        int valor = topo.dado;
        topo = topo.prox;
        if (topo != null) {
            topo.ant = null;
        }
        return valor;
    }

    // Consulta o valor do topo sem removê-lo
    public int topo() {
        if (topo == null) {
            System.out.println("Pilha vazia!");
            return -1;
        }
        return topo.dado;
    }

    // Verifica se a pilha está vazia
    public boolean estaVazia() {
        return topo == null;
    }

    // Imprime os elementos da pilha (do topo até o fim)
    public void imprimir() {
        No atual = topo;
        System.out.print("Topo → ");
        while (atual != null) {
            System.out.print(atual.dado + " ");
            atual = atual.prox;
        }
        System.out.println();
    }
}

public class PilhaDupla {
    public static void main(String[] args) {
        PilhaLista pilha = new PilhaLista();

        // Empilhando valores
        pilha.empilhar(10);
        pilha.empilhar(20);
        pilha.empilhar(30);

        // Mostrando conteúdo da pilha
        pilha.imprimir(); // Saída: Topo → 30 20 10

        // Mostrando o topo
        System.out.println("Topo: " + pilha.topo()); // Saída: 30

        // Desempilhando um elemento
        System.out.println("Desempilhando: " + pilha.desempilhar()); // Saída: 30
        pilha.imprimir(); // Saída: Topo → 20 10

        // Verificando se a pilha está vazia
        System.out.println("Está vazia? " + pilha.estaVazia()); // Saída: false
    }
}

