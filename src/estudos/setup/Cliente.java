package estudos.setup;

public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nome, String cpf){
  
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException();          
        }

        if (cpf == null || cpf.isBlank()) {
            throw new IllegalArgumentException();
        }
        
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
