package Lista2.listaexe.q2;

public class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        if(preco > 0){
            this.preco = preco;
        }
        else{
            System.out.println("valor invalido preço deve ser maior que 0");
        }
    }
    public int getEstoque() {
        return estoque;
    }
    public void vender(int quantidade){
        if (quantidade < estoque) {
            estoque -= quantidade;
        }
        else{
            System.out.println("Quantidade maior que o estoque");            
        }
    }

    public void repor(int quantidade){
        if (quantidade > 0) {
            estoque += quantidade;
        }
        else{
            System.out.println("Quantidade não pode ser negativa");            
        }
    }
    
}
