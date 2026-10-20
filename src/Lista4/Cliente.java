package Lista4;

import java.util.Locale;

public class Cliente {

    private String nome;
    private String email;
    private int idade;
    private Cliente indicadoPor;
    private double saldoCashback;

    public Cliente(String nome, String email, int idade) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome não pode ser nulo nem vazio");
        }

        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("Email não pode ser nulo nem vazio");
        }

        if (!email.contains("@")) {
            throw new IllegalArgumentException("Insira um e-mail válido");
        }

        this.nome = nome;
        this.email = email;
        setIdade(idade);
        saldoCashback = 0;
    }

    public Cliente(String nome, String email, int idade, Cliente indicadoPor) {
        this(nome, email, idade);

        if (indicadoPor == null) {
            throw new IllegalArgumentException("Cliente indicador não pode ser nulo");
        }

        this.indicadoPor = indicadoPor;
        indicadoPor.creditarCashback(10);
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
            throw new IllegalArgumentException("Idade inválida: " + idade + ". Precisa estar entre 0 e 120");
        }

        this.idade = idade;
    }

    public Cliente getIndicadoPor() {
        return indicadoPor;
    }

    public double getSaldoCashback() {
        return saldoCashback;
    }

    public boolean isMaiorDeIdade() {
        return idade >= 18;
    }

    public void creditarCashback(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        saldoCashback += valor;
    }

    public void usarCashback(double valor) throws SaldoInsuficienteException {
        if (valor <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que 0");
        }

        if (valor > saldoCashback) {
            throw new SaldoInsuficienteException(saldoCashback, valor);
        }

        saldoCashback -= valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        Cliente outro = (Cliente) obj;
        return email.equalsIgnoreCase(outro.getEmail());
    }

    @Override
    public int hashCode() {
        return email.toLowerCase(Locale.ROOT).hashCode();
    }

    @Override
    public String toString() {
        return nome + " <" + email + ">";
    }
}
