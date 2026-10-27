package ListaPosProvaAV2.aquecimento;

public class Senha {
    private int numero;
    private String setor;
    private static int totalEmitidas;

    /* A variável totalEmitidas precisa ser estático por que ele permite guardar um número específico por instância */

    /* tirando o static cada senha fica com o seu contador começando do 0 entao todas iam sair com numero 1, e nem compila
       por causa do getTotalEmitidas que é static e nao consegue usar atributo que nao é static */

    /* o contador sobe no totalEmitidas++ que fica depois do if, entao se o setor for invalido a exceção sai antes e o numero nao é gasto */
    public Senha(String setor){
        if (setor == null || setor.isBlank()) {
            throw new IllegalArgumentException("setor inválido");
        }

        this.totalEmitidas++;
        this.setor = setor;
        this.numero = totalEmitidas;
    }

    public int getNumero() {
        return numero;
    }

    public String getSetor() {
        return setor;
    }

    /* precisa ser static pra chamar Senha.getTotalEmitidas() direto pela classe, se nao for da erro e so daria pra chamar com um objeto criado */
    public static int getTotalEmitidas() {
        return totalEmitidas;
    }

    @Override
    public String toString() {
        return this.numero + " - " + this.setor;
    }
}
