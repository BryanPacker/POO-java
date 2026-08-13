package Lista2.construtor;

public class Carro {
  private  String modelo;
  private  int ano;
  private  String cor;
  private  boolean documentoEmDia = true;

  // construtor
  public Carro(String modelo, int ano, String cor){
    this.modelo = modelo;
    this.ano = ano;
    this.cor = cor;
  }

  // getters
  public String getModelo() {
    return modelo;
  }

    public String getCor() {
    return cor;
  }

  public boolean isDocumentoEmDia() {
    return documentoEmDia;
  }

  public int getAno() {
    return ano;
  }

  // setters
  public void setAno(int ano) {
    this.ano = ano;
  }
  
  public void setModelo(String modelo) {
    this.modelo = modelo;
  }

  public void setCor(String cor) {
    this.cor = cor;
  }

  public void setDocumentoEmDia(boolean documentoEmDia) {
    this.documentoEmDia = documentoEmDia;
  }
}
