/*
Crie uma classe chamada Veiculo com propriedades para representar características básicas de um veículo,
como Modelo, Ano, e Cor. Implemente um programa principal que cria uma instância da classe Veiculo,
define valores para suas propriedades e exibe essas informações no console.
*/

public class Carro
{
    private string modelo;
    private int ano;
    private string cor;

    public string Modelo
    {
        get { return modelo; }
        set { modelo = value; }
    }

    public int Ano
    {
        get { return ano; }
        set { ano = value; }
    }

    public string Cor
    {
        get { return cor; }
        set { cor = value; }
    }
}

Carro carro = new Carro();


