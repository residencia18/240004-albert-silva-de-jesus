<h1 align="center">Comandos DotNet</h1>

```bash
Verifica a versão do .NET SDK:
dotnet --version

Lista todas as versões do .NET SDK instaladas:
dotnet --list-sdks

Remove uma versão específica do .NET SDK:
dotnet --uninstall-sdk versao_a_ser_removida

Atualiza o .NET SDK:
dotnet --version

Complia o projeto
dotnet build

Executa o projeto
dotnet run

Criar um Projeto DotNet

1º Cria uma pasta para o projeto
mkdir nome_do_projeto

2º Acessar a pasta do projeto
Cd nome_da_pasta

3º Cria um novo projeto Console do .NET dotnet new console
Obs. Outra alternativa de criar o projeto: Cria um novo projeto Console do .NET e a pasta do projeto
dotnet new console -o nome_do_projeto

Baixa todos os pacotes que a aplicação precisa
dotnet restore

Utilizado para limpar(remover) todos os arquivos de cache da aplicação antes do comando dotnet build para não pegar nenhum tipo de sujeira...
dotnet clean

```

