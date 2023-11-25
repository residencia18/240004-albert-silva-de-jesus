using System;
using System.Collections.Generic;
using System.IO;

namespace P003
{
    public class EstoqueService : EstoqueRepository
    {
        private List<(int Id, int Codigo, string Nome, int Quantidade, double Preco)> ListaDeTuplas { get; set; }

        public EstoqueService()
        {
            // Inicializa a lista no construtor padrão
            ListaDeTuplas = new List<(int Id, int Codigo, string Nome, int Quantidade, double Preco)>();
        }

        public void AdcionarTupla((int, int, string, int, double) tupla)
        {
            ListaDeTuplas.Add(tupla);
        }

        public void Cadastrar()
        {
            Console.WriteLine("\n\t========== CADASTRAR PRODUTO ==========");
            int codigo;

            do
            {
                codigo = ValidarEntrada("\n\tInforme o Código do Produto");

            } while (IsCodigoIgual(codigo));

            Console.Write("\n\tInforme o nome do Produto: ");
            string nome = Console.ReadLine()!;
            nome = convertePrimeiraLetraParaMaiuscula(nome);

            int quantidade = ValidarEntrada("\n\tInforme a quantidade do Produto");

            double preco = ValidarEntrada("\n\tInforme o preço do Produto");

            AdcionarTupla(new Estoque(codigo, nome, quantidade, preco).DadosEstoque);

            App.LimparTela();
            Listar();
            Console.WriteLine("\n\tProduto cadastrado com sucesso!");
            App.Pause();

        }

        public void Listar()
        {
            Console.WriteLine("\n\t========== LISTAR PRODUTOS ==========");

            if (ListaDeTuplas.Count == 0)
            {
                Console.WriteLine("\n\tNão há produtos cadastrados.");
                App.Pause();
                return;
            }

            foreach (var item in ListaDeTuplas)
            {
                Console.WriteLine($"\tID: {item.Id}");
                Console.WriteLine($"\tCódigo: {item.Codigo}");
                Console.WriteLine($"\tNome: {item.Nome}");
                Console.WriteLine($"\tQuantidade: {item.Quantidade}");
                Console.WriteLine($"\tPreço: {item.Preco}");
                Console.WriteLine("\t======================================");
            }

        }

        public void Editar()
        {
            int codigo = ValidarEntrada("\n\tInforme o CÓDIGO do Produto");

            // Encontre o índice da tupla a ser editada
            int indiceParaEdicao = ListaDeTuplas.FindIndex(item => item.Codigo == codigo);

            if (indiceParaEdicao != -1)
            {
                var itemParaEdicao = ListaDeTuplas[indiceParaEdicao];

                App.LimparTela();
                Console.WriteLine("\n\t           EDITAR PRODUTO           ");
                Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                Console.WriteLine($"\n\tID: {itemParaEdicao.Id}");
                Console.WriteLine($"\tCódigo: {itemParaEdicao.Codigo}");
                Console.WriteLine($"\tNome: {itemParaEdicao.Nome}");
                Console.WriteLine($"\tQuantidade: {itemParaEdicao.Quantidade}");
                Console.WriteLine($"\tPreço: {itemParaEdicao.Preco}");
                Console.WriteLine("\t======================================");

                Console.WriteLine("\n\tInforme os novos dados do Produto");
                App.Pause();
                App.LimparTela();

                int novoCodigo = ValidarEntrada("\n\tInforme o Código do Produto");

                Console.Write("\n\tInforme o nome do Produto: ");
                string novoNome = Console.ReadLine()!;
                novoNome = convertePrimeiraLetraParaMaiuscula(novoNome);

                int novaQuantidade = ValidarEntrada("\n\tInforme a quantidade do Produto");

                double novoPreco = ValidarEntrada("\n\tInforme o preço do Produto");

                // // Crie uma nova tupla com os dados atualizados
                // var novaTupla = (itemParaEdicao.Id, novoCodigo, novoNome, novaQuantidade, novoPreco);

                // // Substitua a tupla antiga pela nova na lista
                // ListaDeTuplas[indiceParaEdicao] = novaTupla;

                //Outra forma de fazer: Usando o LINQ para criar uma nova lista com a tupla substituída
                ListaDeTuplas = ListaDeTuplas
                    .Select((item, index) => index == indiceParaEdicao
                        ? (itemParaEdicao.Id, novoCodigo, novoNome, novaQuantidade, novoPreco)
                        : item)
                    .ToList();

                App.LimparTela();
                Listar();
                Console.WriteLine("\n\tProduto editado com sucesso!");

            }
            else
            {
                Console.WriteLine("\n\tOps, não há produtos cadastrados com esse código.");
            }

        }

        public void Excluir()
        {
            string userInput;
            int codigo = ValidarEntrada("\n\tInforme o CÓDIGO do Produto");

            // Encontra o índice da tupla a ser excluída
            int indiceParaExclusao = ListaDeTuplas.FindIndex(item => item.Codigo == codigo);

            if (indiceParaExclusao != -1)
            {
                var itemParaExclusao = ListaDeTuplas[indiceParaExclusao];

                App.LimparTela();
                Console.WriteLine("\n\t           EXCLUIR PRODUTO           ");
                Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                Console.WriteLine($"\n\tID: {itemParaExclusao.Id}");
                Console.WriteLine($"\tCódigo: {itemParaExclusao.Codigo}");
                Console.WriteLine($"\tNome: {itemParaExclusao.Nome}");
                Console.WriteLine($"\tQuantidade: {itemParaExclusao.Quantidade}");
                Console.WriteLine($"\tPreço: {itemParaExclusao.Preco}");
                Console.WriteLine("\t======================================");

                do
                {
                    Console.WriteLine("\n\tDeseja realmente excluir esse produto?");
                    Console.WriteLine("\n\t[1] - SIM");
                    Console.WriteLine("\t[2] - NÃO");
                    Console.Write("\tENTRADA -> ");
                    userInput = Console.ReadLine()!;

                    if (!string.IsNullOrEmpty(userInput) && Int32.TryParse(userInput, out int opcao))
                    {
                        // A conversão foi bem-sucedida
                        if (opcao == 1)
                        {
                            // Remova a tupla da lista
                            ListaDeTuplas.RemoveAt(indiceParaExclusao);

                            App.LimparTela();
                            Listar();
                            Console.WriteLine("\n\tProduto excluído com sucesso!");

                        }
                        else if (opcao == 2)
                        {
                            App.LimparTela();
                            Listar();
                            Console.WriteLine("\n\tProduto não foi excluído.");
                            return;
                        }
                        else
                        {
                            Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção de 1 a 2.");
                        }
                    }
                    else
                    {
                        Console.WriteLine("\n\tEntrada inválida. Por favor, insira um número válido.");
                    }

                } while (userInput != "1" && userInput != "2");

            }
            else
            {
                Console.WriteLine("\n\tOps, não há produtos cadastrados com esse código.");
            }

            App.Pause();
        }

        public void Pesquisar()
        {
            Console.WriteLine("\n\t========== PESQUISAR PRODUTO ==========");

            if (ListaDeTuplas.Count == 0)
            {
                Console.WriteLine("\n\tNão há produtos cadastrados.");
                App.Pause();
                return;
            }

            int codigo = ValidarEntrada("\n\tInforme o Código do Produto");

            // Encontre o índice da tupla a ser pesquisada
            int indiceParaPesquisa = ListaDeTuplas.FindIndex(item => item.Codigo == codigo);

            try
            {
                if (indiceParaPesquisa != -1)
                {
                    var itemParaPesquisa = ListaDeTuplas[indiceParaPesquisa];

                    App.LimparTela();
                    Console.WriteLine("\n\t           PESQUISAR PRODUTO           ");
                    Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                    Console.WriteLine($"\n\tID: {itemParaPesquisa.Id}");
                    Console.WriteLine($"\tCódigo: {itemParaPesquisa.Codigo}");
                    Console.WriteLine($"\tNome: {itemParaPesquisa.Nome}");
                    Console.WriteLine($"\tQuantidade: {itemParaPesquisa.Quantidade}");
                    Console.WriteLine($"\tPreço: {itemParaPesquisa.Preco}");
                    Console.WriteLine("\t======================================");
                }
                else
                {
                    throw new ProdutoNaoEncontradoException();
                }

                App.Pause();
            }
            catch (ProdutoNaoEncontradoException ex)
            {
                Console.WriteLine($"\tOps, {ex.Message}");
                App.Pause();
            }
        }

        public void AtualizarEstoque()
        {
            Console.WriteLine("\n\t========== ATUALIZAR ESTOQUE ==========");

            if (ListaDeTuplas.Count == 0)
            {
                Console.WriteLine("\n\tNão há produtos cadastrados.");
                App.Pause();
                return;
            }

            int codigo = ValidarEntrada("\n\tInforme o Código do Produto");

            // Encontre o índice da tupla a ser atualizada
            int indiceParaAtualizacao = ListaDeTuplas.FindIndex(item => item.Codigo == codigo);

            try
            {
                if (indiceParaAtualizacao != -1)
                {
                    var itemParaAtualizacao = ListaDeTuplas[indiceParaAtualizacao];

                    App.LimparTela();
                    Console.WriteLine("\n\t           ATUALIZAR ESTOQUE           ");
                    Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                    Console.WriteLine($"\n\tID: {itemParaAtualizacao.Id}");
                    Console.WriteLine($"\tCódigo: {itemParaAtualizacao.Codigo}");
                    Console.WriteLine($"\tNome: {itemParaAtualizacao.Nome}");
                    Console.WriteLine($"\tQuantidade: {itemParaAtualizacao.Quantidade}");
                    Console.WriteLine($"\tPreço: {itemParaAtualizacao.Preco}");
                    Console.WriteLine("\t======================================");

                    do
                    {
                        Console.WriteLine("\n\tDeseja dar entrada ou saída no estoque?");
                        Console.WriteLine("\n\t[1] - ENTRADA");
                        Console.WriteLine("\t[2] - SAÍDA");
                        Console.WriteLine("\t[3] - VOLTAR");
                        Console.Write("\tENTRADA -> ");
                        string userInput = Console.ReadLine()!;

                        if (!string.IsNullOrEmpty(userInput) && Int32.TryParse(userInput, out int opcao))
                        {
                            // A conversão foi bem-sucedida
                            if (opcao == 1)
                            {
                                int novaQuantidade = ValidarEntrada($"\n\tInforme a entrada da quantidade do produto, {itemParaAtualizacao.Nome}: ");

                                // Verifica se a entrada é maior que a quantidade atual
                                if (ListaDeTuplas.Any(item => (item.Quantidade + novaQuantidade) < 0))
                                {
                                    throw new QuantidadeInvalidaException("A entrada não pode ser maior que a quantidade atual do produto.");
                                }
                                else
                                {
                                    if (novaQuantidade < 0)
                                    {
                                        throw new QuantidadeInvalidaException("A entrada não pode ser menor que zero.");
                                    }
                                }

                                // Atualize a quantidade na tupla existente
                                var produto = ListaDeTuplas[indiceParaAtualizacao];
                                novaQuantidade = produto.Quantidade + novaQuantidade;

                                // Garante que a quantidade não seja negativa
                                novaQuantidade = Math.Max(0, novaQuantidade);

                                // Substitua a tupla antiga pela nova na lista
                                ListaDeTuplas[indiceParaAtualizacao] = (produto.Id, produto.Codigo, produto.Nome, novaQuantidade, produto.Preco);

                                App.LimparTela();
                                Console.WriteLine("\n\t           ATUALIZAR ESTOQUE           ");
                                Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                                Console.WriteLine($"\tID: {itemParaAtualizacao.Id}");
                                Console.WriteLine($"\tCódigo: {itemParaAtualizacao.Codigo}");
                                Console.WriteLine($"\tNome: {itemParaAtualizacao.Nome}");
                                Console.WriteLine($"\tQuantidade: {itemParaAtualizacao.Quantidade}");
                                Console.WriteLine($"\tPreço: {itemParaAtualizacao.Preco}");
                                Console.WriteLine("\t======================================");
                                Console.WriteLine("\n\tEstoque atualizado com sucesso!");
                                Console.WriteLine("\n\tEstoque atualizado com sucesso!");
                            }
                            else
                            {
                                if (opcao == 2)
                                {
                                    int novaQuantidade = ValidarEntrada($"\n\tInforme a saída da quantidade do produto, {itemParaAtualizacao.Nome}: ");

                                    // Verifica se a saída é maior que a quantidade atual
                                    if ((itemParaAtualizacao.Quantidade - novaQuantidade) < 0)
                                    {
                                        throw new QuantidadeInvalidaException("A saída não pode ser maior que a quantidade atual do produto.");
                                    }
                                    else
                                    {
                                        if (novaQuantidade < 0)
                                        {
                                            throw new QuantidadeInvalidaException("A saída não pode ser menor que zero.");
                                        }
                                    }

                                    // Atualize a quantidade na tupla existente
                                    var produto = ListaDeTuplas[indiceParaAtualizacao];
                                    novaQuantidade = produto.Quantidade - novaQuantidade;

                                    // Garante que a quantidade não seja negativa
                                    novaQuantidade = Math.Max(0, novaQuantidade);

                                    // Substitua a tupla antiga pela nova na lista
                                    ListaDeTuplas[indiceParaAtualizacao] = (produto.Id, produto.Codigo, produto.Nome, novaQuantidade, produto.Preco);

                                    App.LimparTela();
                                    Console.WriteLine("\n\t           ATUALIZAR ESTOQUE           ");
                                    Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                                    Console.WriteLine($"\tID: {itemParaAtualizacao.Id}");
                                    Console.WriteLine($"\tCódigo: {itemParaAtualizacao.Codigo}");
                                    Console.WriteLine($"\tNome: {itemParaAtualizacao.Nome}");
                                    Console.WriteLine($"\tQuantidade: {itemParaAtualizacao.Quantidade}");
                                    Console.WriteLine($"\tPreço: {itemParaAtualizacao.Preco}");
                                    Console.WriteLine("\t======================================");
                                    Console.WriteLine("\n\tEstoque atualizado com sucesso!");
                                }
                                else
                                {
                                    if (opcao == 3)
                                    {
                                        App.LimparTela();
                                        Listar();
                                        return;
                                    }
                                    else
                                    {
                                        Console.WriteLine("\n\tOpção inválida. Por favor, escolha uma opção de 1 a 3.");
                                    }
                                }
                            }

                        }
                        else
                        {
                            Console.WriteLine("\n\tEntrada inválida. Por favor, insira um número válido.");
                        }


                    } while (true);
                }
                else
                {
                    throw new ProdutoNaoEncontradoException();
                }
            }
            catch (QuantidadeInvalidaException ex)
            {
                Console.WriteLine($"\tOps, {ex.Message}");
                App.Pause();
            }
            catch (Exception ex)
            {
                Console.WriteLine($"\tOps, {ex.Message}");
                App.Pause();
            }
        }

        public void Estatisticas()
        {
            throw new System.NotImplementedException();
        }

        public bool IsCodigoIgual(int codigo)
        {

            if (ListaDeTuplas.Count == 0)
            {
                return false;
            }

            // Encontre o índice da tupla a ser verificada
            int indiceParaVerificacao = ListaDeTuplas.FindIndex(item => item.Codigo == codigo);


            if (indiceParaVerificacao != -1)
            {
                var itemParaAtualizacao = ListaDeTuplas[indiceParaVerificacao];

                App.LimparTela();
                Console.WriteLine("\n\t      CODIGO JÁ ESTA CADASTRADO        ");
                Console.WriteLine("\n\t========== DADOS DO PRODUTO ==========");
                Console.WriteLine($"\n\tID: {itemParaAtualizacao.Id}");
                Console.WriteLine($"\tCódigo: {itemParaAtualizacao.Codigo}");
                Console.WriteLine($"\tNome: {itemParaAtualizacao.Nome}");
                Console.WriteLine($"\tQuantidade: {itemParaAtualizacao.Quantidade}");
                Console.WriteLine($"\tPreço: {itemParaAtualizacao.Preco}");
                Console.WriteLine("\t======================================");

                Console.WriteLine("\n\tO código informado já está cadastrado. Por favor, informe outro código.");
                App.Pause();
                return true;
            }
            return false;
        }

        public int ValidarEntrada(string mensagem)
        {
            int valor;

            do
            {
                App.LimparTela();
                Console.WriteLine("\n\t========== SISTEMA DE GERENCIAMENTO DE PRODUTOS ========== ");
                Console.Write($"\t{mensagem}: ");

                string input = Console.ReadLine()!;

                try
                {
                    valor = Int32.Parse(input);

                    if (valor <= 0)
                    {
                        throw new OverflowException($"\n\tOps, entrada inválida! O valor não pode ser menor ou igual a zero.");
                    }
                    return valor;
                }
                catch (FormatException)
                {
                    App.LimparTela();
                    Console.WriteLine($"\n\tOps, entrada inválida. Por favor, insira um número válido.");
                    App.Pause();
                }
                catch (OverflowException ex)
                {
                    App.LimparTela();
                    Console.WriteLine(ex.Message);
                    App.Pause();
                }

            } while (true);
        }

        public String convertePrimeiraLetraParaMaiuscula(string palavra)
        {
            string palavraComMaiuscula = "";
            bool converteu = true;

            do
            {
                // Verifica se a string não está vazia
                if (!string.IsNullOrEmpty(palavra))
                {
                    // Converte a primeira letra para maiúscula
                    palavraComMaiuscula = char.ToUpper(palavra[0]) + palavra.Substring(1);
                    converteu = false;
                }
                else
                {
                    Console.WriteLine("\n\tA string está vazia.");
                    Console.Write("\tPressione Enter para continuar... ");
                    Console.ReadLine();
                    App.LimparTela();

                    Console.Write("\n\tInforme o nome do Produto: ");
                    palavra = Console.ReadLine()!;
                }
            } while (converteu);

            return palavraComMaiuscula;
        }

        public void SalvarArquivo()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/semana3/P003/BancoDeDados/dados.txt"); // Nome do arquivo no diretório do projeto

            try
            {
                using (StreamWriter writer = new StreamWriter(caminhoArquivo))
                {
                    foreach (var item in ListaDeTuplas)
                    {
                        // Formatando os dados para gravar no arquivo
                        string linha = $"{item.Id},{item.Codigo},{item.Nome},{item.Quantidade},{item.Preco}";
                        writer.WriteLine(linha);
                    }
                }

                Console.WriteLine("Dados salvos com sucesso.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Ocorreu um erro ao salvar o arquivo: {ex.Message}");
            }
        }

        public void CarregarArquivo()
        {
            string caminhoArquivo = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "C:/Users/alber/OneDrive/Documentos/ProjetosResidencia/residenciaDotNet/semana3/P003/BancoDeDados/dados.txt"); // Nome do arquivo no diretório do projeto

            try
            {
                ListaDeTuplas.Clear(); // Limpa a lista antes de carregar novos dados

                using (StreamReader reader = new StreamReader(caminhoArquivo))
                {
                    while (!reader.EndOfStream)
                    {
                        string linha = reader.ReadLine()!;
                        string[] dados = linha.Split(',');

                        // Certifique-se de que existam dados suficientes na linha
                        if (dados.Length >= 5)
                        {
                            int id = int.Parse(dados[0]);
                            int codigo = int.Parse(dados[1]);
                            string nome = dados[2];
                            int quantidade = int.Parse(dados[3]);
                            double preco = double.Parse(dados[4]);

                            AdcionarTupla(new Estoque(codigo, nome, quantidade, preco).DadosEstoque);
                        }
                        else
                        {
                            Console.WriteLine("A linha no arquivo não contém dados suficientes.");
                        }
                    }
                }

                Console.WriteLine("Dados carregados com sucesso.");
            }
            catch (Exception ex)
            {
                Console.WriteLine($"Ocorreu um erro ao carregar o arquivo: {ex.Message}");
            }
        }

    }
}