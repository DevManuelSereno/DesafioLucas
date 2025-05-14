package org.example.Questao9;

class TipoItem {
    int chave;

    TipoItem(int chave) {
        this.chave = chave;
    }
}

class TipoLista {
    TipoItem item;
    TipoLista anterior, proximo;

    TipoLista() {
        this.item = null;
        this.anterior = this.proximo = this; // nó-cabeça aponta para ele mesmo
    }

    TipoLista(TipoItem item) {
        this.item = item;
        this.anterior = this.proximo = null;
    }
}

public class ListaDuplamenteEncadeada {

    // (b) Localiza o nó na posição P
    static TipoLista Locate(TipoLista L, int P) {
        TipoLista aux = L.proximo;
        int i = 1;
        while (aux != L && i < P) {
            aux = aux.proximo;
            i++;
        }
        if (aux == L || i != P) return null;
        return aux;
    }

    // (c) Insere o item E na posição P
    static void InsereP(TipoLista L, TipoItem E, int P) {
        if (P <= 0) {
            System.out.println("Erro: posição inválida.");
            return;
        }

        // Inserção na posição 1 (após o nó-cabeça)
        if (P == 1) {
            TipoLista novo = new TipoLista(E);
            novo.proximo = L.proximo;
            novo.anterior = L;
            L.proximo.anterior = novo;
            L.proximo = novo;
            return;
        }

        TipoLista pos = Locate(L, P);

        if (pos == null) {
            // Tentar inserir no final se P == tamanho + 1
            TipoLista ultimo = L.proximo;
            int count = 1;
            while (ultimo != L && count < P - 1) {
                ultimo = ultimo.proximo;
                count++;
            }

            if (count != P - 1 || ultimo == L) {
                System.out.println("Erro: Lista tem menos que " + (P - 1) + " elementos.");
                return;
            }

            TipoLista novo = new TipoLista(E);
            novo.proximo = ultimo.proximo;
            novo.anterior = ultimo;
            ultimo.proximo.anterior = novo;
            ultimo.proximo = novo;
        } else {
            TipoLista novo = new TipoLista(E);
            novo.anterior = pos.anterior;
            novo.proximo = pos;
            pos.anterior.proximo = novo;
            pos.anterior = novo;
        }
    }

    // (d) Remove e retorna o item da posição P
    static TipoItem RemovaP(TipoLista L, int P) {
        TipoLista pos = Locate(L, P);
        if (pos == null) {
            System.out.println("Erro: Lista tem menos que " + P + " elementos.");
            return null;
        }
        pos.anterior.proximo = pos.proximo;
        pos.proximo.anterior = pos.anterior;
        return pos.item;
    }

    // Imprime a lista
    static void ImprimeLista(TipoLista L) {
        TipoLista aux = L.proximo;
        System.out.print("Lista: ");
        while (aux != L) {
            System.out.print(aux.item.chave + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TipoLista cabeca = new TipoLista(); // nó-cabeça

        InsereP(cabeca, new TipoItem(10), 1); // insere 10 na posição 1
        InsereP(cabeca, new TipoItem(20), 2); // insere 20 na posição 2
        InsereP(cabeca, new TipoItem(30), 3); // insere 30 na posição 3
        InsereP(cabeca, new TipoItem(25), 3); // insere 25 na posição 3 (entre 20 e 30)

        ImprimeLista(cabeca); // Lista: 10 20 25 30

        TipoItem removido = RemovaP(cabeca, 2); // remove o item da posição 2
        if (removido != null)
            System.out.println("Removido: " + removido.chave); // deve remover 20

        ImprimeLista(cabeca); // Lista: 10 25 30
    }
}

