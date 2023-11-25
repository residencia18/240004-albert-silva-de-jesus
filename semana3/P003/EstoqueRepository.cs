using System;  
using System.Collections.Generic;
using System.IO;
 
namespace P003
{
    public interface EstoqueRepository
    {
        void Cadastrar();

        void Listar();

        void Editar();

        void Excluir();

        void Pesquisar();

        void Estatisticas();

        int ValidarEntrada(string mensagem);

        String convertePrimeiraLetraParaMaiuscula(string palavra);

        void AdcionarTupla((int, int, string, int, double) tupla);

        void AtualizarEstoque();

        bool  IsCodigoIgual(int codigo);

        void CarregarArquivo();

        void SalvarArquivo();
    }
}