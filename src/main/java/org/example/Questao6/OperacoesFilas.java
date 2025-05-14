package org.example.Questao6;

public class OperacoesFilas {

    // Nó da fila
    static class No {
        int dado;
        No prox;

        No(int valor) {
            dado = valor;
            prox = null;
        }
    }

    // Classe Fila com encadeamento
    static class Fila {
        private No frente;
        private No tras;

        public Fila() {
            frente = null;
            tras = null;
        }

        public void enfileirar(int valor) {
            No novo = new No(valor);
            if (estaVazia()) {
                frente = tras = novo;
            } else {
                tras.prox = novo;
                tras = novo;
            }
        }

        public int desenfileirar() {
            if (estaVazia()) return -1;
            int valor = frente.dado;
            frente = frente.prox;
            if (frente == null) tras = null;
            return valor;
        }

        public boolean estaVazia() {
            return frente == null;
        }

        public void imprimir() {
            No atual = frente;
            System.out.print("Frente → ");
            while (atual != null) {
                System.out.print(atual.dado + " ");
                atual = atual.prox;
            }
            System.out.println("← Trás");
        }

        public int tamanho() {
            int cont = 0;
            No atual = frente;
            while (atual != null) {
                cont++;
                atual = atual.prox;
            }
            return cont;
        }

        public Fila clonar() {
            Fila nova = new Fila();
            No atual = frente;
            while (atual != null) {
                nova.enfileirar(atual.dado);
                atual = atual.prox;
            }
            return nova;
        }

        public No getFrente() {
            return frente;
        }
    }

    // 1 - Verifica se duas filas são iguais
    public static boolean saoIguais(Fila f1, Fila f2) {
        No n1 = f1.getFrente();
        No n2 = f2.getFrente();

        while (n1 != null && n2 != null) {
            if (n1.dado != n2.dado) break;
            n1 = n1.prox;
            n2 = n2.prox;
        }

        if (n1 == null && n2 == null) return true;

        int t1 = f1.tamanho();
        int t2 = f2.tamanho();
        System.out.println("Filas diferentes.");
        if (t1 > t2) System.out.println("F1 é maior.");
        else if (t2 > t1) System.out.println("F2 é maior.");
        else System.out.println("Têm tamanhos iguais mas conteúdos diferentes.");
        return false;
    }

    // 2 - Estatísticas da fila
    public static void estatisticas(Fila f) {
        Fila copia = f.clonar();
        int maior = Integer.MIN_VALUE;
        int menor = Integer.MAX_VALUE;
        int soma = 0, cont = 0;

        while (!copia.estaVazia()) {
            int valor = copia.desenfileirar();
            if (valor > maior) maior = valor;
            if (valor < menor) menor = valor;
            soma += valor;
            cont++;
        }

        if (cont == 0) {
            System.out.println("Fila vazia.");
            return;
        }

        double media = (double) soma / cont;
        System.out.println("Maior: " + maior + ", Menor: " + menor + ", Média: " + media);
    }

    // 3 - Copiar F1 para F2
    public static void copiarF1paraF2(Fila f1, Fila f2) {
        Fila copia = f1.clonar();
        while (!copia.estaVazia()) {
            f2.enfileirar(copia.desenfileirar());
        }
    }

    // 4 - Conta ímpares
    public static int contarImpares(Fila f) {
        Fila copia = f.clonar();
        int cont = 0;
        while (!copia.estaVazia()) {
            int v = copia.desenfileirar();
            if (v % 2 != 0) cont++;
        }
        return cont;
    }

    // 5 - Conta pares
    public static int contarPares(Fila f) {
        Fila copia = f.clonar();
        int cont = 0;
        while (!copia.estaVazia()) {
            int v = copia.desenfileirar();
            if (v % 2 == 0) cont++;
        }
        return cont;
    }

    // Main para testes
    public static void main(String[] args) {
        Fila F1 = new Fila();
        Fila F2 = new Fila();

        F1.enfileirar(10);
        F1.enfileirar(5);
        F1.enfileirar(2);
        F1.enfileirar(7);

        F2.enfileirar(10);
        F2.enfileirar(5);
        F2.enfileirar(2);
        F2.enfileirar(7);

        System.out.println("\nFila F1:");
        F1.imprimir();

        System.out.println("Fila F2:");
        F2.imprimir();

        System.out.println("\nSão iguais? " + saoIguais(F1, F2));

        System.out.println("\nEstatísticas de F1:");
        estatisticas(F1);

        Fila F3 = new Fila();
        copiarF1paraF2(F1, F3);
        System.out.println("\nF3 (cópia de F1):");
        F3.imprimir();

        System.out.println("\nQuantidade de pares em F1: " + contarPares(F1));
        System.out.println("Quantidade de ímpares em F1: " + contarImpares(F1));
    }
}
