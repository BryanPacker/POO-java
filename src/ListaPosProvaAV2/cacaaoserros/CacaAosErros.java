package ListaPosProvaAV2.cacaaoserros;

import ListaPosProvaAV2.setup.Cliente;
import ListaPosProvaAV2.setup.ItemSetup;
import ListaPosProvaAV2.setup.Montagem;
import ListaPosProvaAV2.setup.Orcamento;
import ListaPosProvaAV2.setup.Peca;

public class CacaAosErros {

    /* B1
       a) o if usa > 5 entao com 5 itens ele deixa passar e entra o 6º
       b) adicionando 6 itens, os 6 entram, era pra dar erro no 6º
       c) if (itens.size() == 5) { throw new IllegalStateException("orçamento cheio"); } */

    /* B2
       a) item repetido nao é argumento invalido, o item ta certo, quem impede é o estado do orçamento entao é IllegalStateException.
          IllegalArgumentException é so pro null
       b) adicionando a placa 2 vezes da IllegalArgumentException, era pra ser IllegalStateException
       c) if (itens.contains(item)) { throw new IllegalStateException("item já está no orçamento"); } */

    /* B3
       a) ta testando o lotado antes do repetido, a ordem certa é null, repetido e lotado
       b) com 5 itens adicionando de novo um que ja ta no orçamento sai "lotado", era pra sair que o item ja esta incluido
       c) troca a ordem dos dois ultimos if */

    /* B4
       a) o for lança a exceção no primeiro item que for diferente, entao so funciona se for o primeiro da lista,
          e com a lista vazia o for nem roda e nao lança nada
       b) com 3 itens removendo o segundo da erro de nao encontrado, era pra remover.
          com a lista vazia nao acontece nada, era pra dar erro
       c) boolean removeu = itens.remove(item);
          if (!removeu) { throw new IllegalStateException("item não encontrado"); } */

    /* B5
       a) o contador aumenta antes de validar o preço, entao o item invalido gasta um codigo
       b) valido, invalido, valido sai codigo 1 e 3, deveria sair 1 e 2
       c) colocar o if do precoBase antes do totalItens++ (igual ta no ItemSetup) */

    /* B6
       a) usa o precoBase e esquece do desconto de 10%
       b) 3 monitores de 1200 da 540, deveria dar 486 (3240 * 0.15)
       c) return calcularPreco() * 0.15; */

    /* B7
       a) o nome ta tostring com s minusculo entao nao sobrescreve o toString do Object, é um metodo novo
       b) o println mostra uma coisa tipo ListaPosProvaAV2.setup.Peca@1b6d3586. com o @Override o compilador
          da erro falando que o metodo nao sobrescreve nada
       c) @Override
          public String toString() { ... }
       o @Override vale pro Object tambem por que toda classe herda de Object, entao o toString é um metodo herdado como qualquer outro */

    /* B8
       1 - a variavel é Peca, devia ser ItemSetup
       2 - getSolicitante() imprime o objeto Cliente tipo Cliente@4e25154f, tem que usar getSolicitante().getNome()
       3 - println(getItens()) imprime a lista toda numa linha so, tem que usar for each
       4 - a ultima linha adiciona a placa de novo e da exceção sem try/catch entao o programa para */
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(new Cliente("Marina Souza", "123.456.789-00"), "Blumenau", 7);
        ItemSetup placa = new Peca("Placa de vídeo", 2500.0, 1);
        ItemSetup montagem = new Montagem("Montagem e cabeamento", 80.0, 2);
        orcamento.adicionarItem(placa);
        orcamento.adicionarItem(montagem);

        System.out.println("Solicitante: " + orcamento.getSolicitante().getNome());
        for (ItemSetup item : orcamento.getItens()) {
            System.out.println(item);
        }

        try {
            orcamento.adicionarItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        try {
            orcamento.removerItem(placa);
            orcamento.removerItem(placa);
        } catch (IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
