package Lista3.exe9.sonora_fase09;

// Uma classe que fica vazia depois da generalização não traz comportamento novo, e termina sendo apenas um
// marcador da especialização. Ela existe para deixar a hierarquia sem ambiguidades, mas não precisa de atributos
// ou métodos próprios para representar o plano individual.
public class PlanoIndividual extends PlanoPago {
    public PlanoIndividual(double precoMensal) {
        super("Individual", 1, precoMensal);
    }

    @Override
    public double calcularMensalidade() {
        return getPrecoMensal();
    }
}
