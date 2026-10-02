package Lista3.exe9.sonora_fase09;

public abstract class Plano {
    private String nome;
    private int maxDispositivos;

    public Plano(String nome, int maxDispositivos) {
        setNome(nome);
        setMaxDispositivos(maxDispositivos);
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    protected void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome do plano deve conter ao menos um caractere válido");
        }

        this.nome = nome;
    }

    protected void setMaxDispositivos(int maxDispositivos) {
        if (maxDispositivos < 1) {
            throw new IllegalArgumentException("Máximo de dispositivos inválido: " + maxDispositivos + ". Precisa ser maior que 0!");
        }

        this.maxDispositivos = maxDispositivos;
    }

    public abstract boolean temAnuncios();

    public abstract double calcularMensalidade();

    public final String resumo() {
        return nome + ": R$ " + calcularMensalidade() + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}
