package Lista4;

public class Cliente {

    private String nome;
    private String email;
    private int idade;
    private Cliente indicadoPor;
    private double saldoCashback;

    public Cliente(String nome, String email, int idade){
        
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo nem vazio");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo nem vazio");
        }
        
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Insira um e-mail válido");
        }

        if (idade < 1) {
            throw new IllegalArgumentException("Idade não pode ser menor que 1");
        }

        this.nome = nome;
        this.email = email;
        setIdade(idade);
        saldoCashback = 0;

    }

    public Cliente(String nome, String email, int idade, Cliente indicadoPor){

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo nem vazio");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo nem vazio");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Insira um e-mail válido");
        }
        if (indicadoPor == null) {
            throw new IllegalArgumentException("Email não pode ser nulo nem vazio");
        }

        this.nome = nome;
        this.email = email;
        setIdade(idade);
        this.indicadoPor = indicadoPor;    
        saldoCashback = 10;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {

        if (idade < 0 || idade > 120) {
            throw new IllegalArgumentException("Idade não pode ser menor que 1");
        }

        this.idade = idade;
    }

    public Cliente getIndicadoPor() {
        return indicadoPor;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public boolean isMaiorDeIdade(int idade){
        if (idade >= 18) {
            return true;
        }

        return false;
    }

    public void creditarCashback(double valor){
        
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior ou igual a 0");
        }

        saldoCashback += valor;
    }

    public void usarCashback(double valor){

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior ou igual a 0");            
        }

        if (valor > saldoCashback) {
            throw new IllegalArgumentException("Saldo insuficiente");            
        }

        saldoCashback -= valor;
    }

    public boolean equals(Cliente cliente){
        return true;
    }
}
