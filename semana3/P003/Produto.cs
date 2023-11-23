using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace P003
{
    public class Produto
    {
        // Tupla privada representando os elementos do produto
        private (int Codigo, string Nome, int Quantidade, double PrecoUnitario) dadosProduto;

        // Construtor da classe Produto que aceita os parâmetros da tupla
        public Produto(int codigo, string nome, int quantidade, double precoUnitario)
        {
            // Inicializando a tupla com os parâmetros recebidos
            dadosProduto = (codigo, nome, quantidade, precoUnitario);
        }

        public int GetCodigo()
        {
            return dadosProduto.Codigo;
        }

        public void SetCodigo(int codigo)
        {
            dadosProduto = (codigo, dadosProduto.Nome, dadosProduto.Quantidade, dadosProduto.PrecoUnitario);
        }

        public string GetNome()
        {
            return dadosProduto.Nome;
        }

        public void SetNome(string nome)
        {
            dadosProduto = (dadosProduto.Codigo, nome, dadosProduto.Quantidade, dadosProduto.PrecoUnitario);
        }

        public int GetQuantidade()
        {
            return dadosProduto.Quantidade;
        }

        public void SetQuantidade(int quantidade)
        {
            dadosProduto = (dadosProduto.Codigo, dadosProduto.Nome, quantidade, dadosProduto.PrecoUnitario);
        }

        public double GetPrecoUnitario()
        {
            return dadosProduto.PrecoUnitario;
        }

        public void SetPrecoUnitario(double precoUnitario)
        {
            dadosProduto = (dadosProduto.Codigo, dadosProduto.Nome, dadosProduto.Quantidade, precoUnitario);
        }

    }
}