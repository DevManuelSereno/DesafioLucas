package org.example.Questao8;

// Questão 8 Desafio Lucas

public class ListaEncadeada {

    static class No {
        int valor;
        No prox;

        No(int valor) {
            this.valor = valor;
            this.prox = null;
        }
    }

    No inicio;

    // Inserção no final da lista
    public void inserirFinal(int valor) {
        No novo = new No(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            No atual = inicio;
            while (atual.prox != null) {
                atual = atual.prox;
            }
            atual.prox = novo;
        }
    }

    // Verifica se a lista contém um valor
    public boolean contem(int valor) {
        No atual = inicio;
        while (atual != null) {
            if (atual.valor == valor) {
                return true;
            }
            atual = atual.prox;
        }
        return false;
    }

    // Imprime os elementos da lista
    public void imprimir() {
        No atual = inicio;
        while (atual != null) {
            System.out.print(atual.valor + " ");
            atual = atual.prox;
        }
        System.out.println();
    }

    // (a) União sem repetição
    public static ListaEncadeada uniaoSemRepeticao(ListaEncadeada l1, ListaEncadeada l2) {
        ListaEncadeada l3 = new ListaEncadeada();

        No atual = l1.inicio;
        while (atual != null) {
            if (!l3.contem(atual.valor)) {
                l3.inserirFinal(atual.valor);
            }
            atual = atual.prox;
        }

        atual = l2.inicio;
        while (atual != null) {
            if (!l3.contem(atual.valor)) {
                l3.inserirFinal(atual.valor);
            }
            atual = atual.prox;
        }

        return l3;
    }

    // (b) Interseção
    public static ListaEncadeada intersecao(ListaEncadeada l1, ListaEncadeada l2) {
        ListaEncadeada l4 = new ListaEncadeada();

        No atual = l1.inicio;
        while (atual != null) {
            if (l2.contem(atual.valor) && !l4.contem(atual.valor)) {
                l4.inserirFinal(atual.valor);
            }
            atual = atual.prox;
        }

        return l4;
    }

    // Teste principal
    public static void main(String[] args) {
        ListaEncadeada l1 = new ListaEncadeada();
        ListaEncadeada l2 = new ListaEncadeada();

        // Inserir dados em L1
        l1.inserirFinal(1);
        l1.inserirFinal(2);
        l1.inserirFinal(3);
        l1.inserirFinal(4);

        // Inserir dados em L2
        l2.inserirFinal(3);
        l2.inserirFinal(4);
        l2.inserirFinal(5);
        l2.inserirFinal(6);

        // União
        ListaEncadeada l3 = uniaoSemRepeticao(l1, l2);
        System.out.print("União sem repetição (L3): ");
        l3.imprimir();

        // Interseção
        ListaEncadeada l4 = intersecao(l1, l2);
        System.out.print("Interseção (L4): ");
        l4.imprimir();
    }
}

