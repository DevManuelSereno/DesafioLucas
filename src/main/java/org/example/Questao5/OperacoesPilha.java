package org.example.Questao5;

public class OperacoesPilha {

    // Classe que representa um nó da pilha
    static class No {
        int dado;
        No prox;

        No(int valor) {
            dado = valor;
            prox = null;
        }
    }

    // Classe Pilha usando encadeamento
    static class Pilha {
        private No topo;

        public Pilha() {
            topo = null;
        }

        public void empilhar(int valor) {
            No novo = new No(valor);
            novo.prox = topo;
            topo = novo;
        }

        public int desempilhar() {
            if (topo == null) return -1;
            int valor = topo.dado;
            topo = topo.prox;
            return valor;
        }

        public boolean estaVazia() {
            return topo == null;
        }

        public int topo() {
            if (topo == null) return -1;
            return topo.dado;
        }

        public void imprimir() {
            No atual = topo;
            System.out.print("Topo → ");
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.prox;
            }
            System.out.println();
        }

        public Pilha clonar() {
            Pilha temp = new Pilha();
            Pilha copia = new Pilha();
            No atual = topo;
            while (atual != null) {
                temp.empilhar(atual.dado);
                atual = atual.prox;
            }
            while (!temp.estaVazia()) {
                int v = temp.desempilhar();
                copia.empilhar(v);
            }
            return copia;
        }

        public int tamanho() {
            int cont = 0;
            No atual = topo;
            while (atual != null) {
                cont++;
                atual = atual.prox;
            }
            return cont;
        }

        public No getTopo() {
            return topo;
        }
    }

    // 1 - Verifica se duas pilhas são iguais
    public static boolean saoIguais(Pilha p1, Pilha p2) {
        No n1 = p1.getTopo();
        No n2 = p2.getTopo();

        while (n1 != null && n2 != null) {
            if (n1.dado != n2.dado) {
                break;
            }
            n1 = n1.prox;
            n2 = n2.prox;
        }

        if (n1 == null && n2 == null) {
            return true;
        } else {
            int t1 = p1.tamanho();
            int t2 = p2.tamanho();
            System.out.println("Pilhas diferentes.");
            if (t1 > t2) {
                System.out.println("P1 é maior.");
            } else if (t2 > t1) {
                System.out.println("P2 é maior.");
            } else {
                System.out.println("Têm tamanhos iguais mas conteúdos diferentes.");
            }
            return false;
        }
    }

    // 2 - Retorna maior, menor e média dos elementos
    public static void estatisticas(Pilha p) {
        Pilha aux = p.clonar();
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int soma = 0;
        int cont = 0;

        while (!aux.estaVazia()) {
            int v = aux.desempilhar();
            if (v > maior) maior = v;
            if (v < menor) menor = v;
            soma += v;
            cont++;
        }

        if (cont == 0) {
            System.out.println("Pilha vazia.");
            return;
        }

        double media = (double) soma / cont;
        System.out.println("Maior: " + maior + ", Menor: " + menor + ", Média: " + media);
    }

    // 3 - Copia elementos de P1 para P2
    public static void copiarP1paraP2(Pilha p1, Pilha p2) {
        Pilha aux = p1.clonar();
        while (!aux.estaVazia()) {
            p2.empilhar(aux.desempilhar());
        }
    }

    // 4 - Conta elementos ímpares
    public static int contarImpares(Pilha p) {
        Pilha aux = p.clonar();
        int cont = 0;
        while (!aux.estaVazia()) {
            int v = aux.desempilhar();
            if (v % 2 != 0) cont++;
        }
        return cont;
    }

    // 5 - Conta elementos pares
    public static int contarPares(Pilha p) {
        Pilha aux = p.clonar();
        int cont = 0;
        while (!aux.estaVazia()) {
            int v = aux.desempilhar();
            if (v % 2 == 0) cont++;
        }
        return cont;
    }

    // Método principal de testes
    public static void main(String[] args) {
        Pilha P1 = new Pilha();
        Pilha P2 = new Pilha();

        // Adicionando valores
        P1.empilhar(1);
        P1.empilhar(3);
        P1.empilhar(5);

        P2.empilhar(1);
        P2.empilhar(3);
        P2.empilhar(5);

        System.out.println("\nP1:");
        P1.imprimir();

        System.out.println("P2:");
        P2.imprimir();

        // Testando igualdade
        System.out.println("\nSão iguais? " + saoIguais(P1, P2));

        // Estatísticas
        System.out.println("\nEstatísticas de P1:");
        estatisticas(P1);

        // Cópia de P1 para nova pilha P3
        Pilha P3 = new Pilha();
        copiarP1paraP2(P1, P3);
        System.out.println("\nCópia de P1 para nova pilha P3:");
        P3.imprimir();

        // Contagem de pares e ímpares
        System.out.println("\nPares em P1: " + contarPares(P1));
        System.out.println("Ímpares em P1: " + contarImpares(P1));
    }
}
