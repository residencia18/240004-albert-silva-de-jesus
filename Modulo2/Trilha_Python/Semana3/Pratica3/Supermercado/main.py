'''
Exercício 1: Estruturando um código com funções.

● Este exercício já foi implementado no módulo anterior, utilizando C++.Vejamos agora como ficaria uma versão feita em Python: Faça um programa
para um supermercado que permita a consulta de preço de produtos. O programa deverá armazenar de cada produto o seu código, 
seu nome e seu preço.

● Ao utilizar o programa o usuário deve poder:
1. Inserir um novo produto
2. Excluir um produto cadastrado
3. Listar todos os produtos com seus respectivos códigos e preços
4. Consultar o preço de um produto através de seu código.

O código deve ser formado de uma string numérica de 13 caracteres (pode conter zeros a esquerda, então não pode ser um número)
O nome pode ter qualquer tamanho e deve começar sempre com uma letra maiúscula.
O preço deve ser apresentado com duas casas decimais.
O sistema deve listar os produtos na tela, 10 produtos de cada vez em ordem crescente de preço.

● O código deve ser implementado numa pasta Supermercado e o programa principal deve ser implementado no arquivo main.py.
● Pode utilizar como modelo o arquivo main.py disponível na postagem da atividade. Pesquise sobre esta estrutura e para que ela serve.
● Cada uma das funcionalidades do menu de opções deve ser implementada numa função específica.
● Já que não temos structs em Python vamos usar dicionários para armazenar cada produto.
● Vamos armazenar os produtos numa lista de dicionários;

'''

import os
import platform
import locale
from datetime import datetime
locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')
data_e_hora_atual = datetime.now()
produtos = {}
proximo_id = 1

def menu():
    
    while True:
    
        limpaTela()
        formato_personalizado = "\n\t%A, %d de %B de %Y %H:%M:%S"
        data_e_hora_formatada = data_e_hora_atual.strftime(formato_personalizado)
        print(data_e_hora_formatada)
        print("\tFalta", (datetime(data_e_hora_atual.year, 12, 31) - data_e_hora_atual).days + 1, "dias para o fim do ano")
    
        print("\n\t======= SUPERMERCADO =======")
        print("\t[1] - CADASTRAR PRODUTO")
        print("\t[2] - LISTAR PRODUTOS")
        print("\t[3] - EDITAR PRODUTO")
        print("\t[4] - EXCLUIR PRODUTO")
        print("\t[5] - CONSULTAR PRODUTO")
        print("\t[0] - SAIR")
        opcao = input("\tENTRADA -> ")

        if(opcao == "1" or opcao == "2" or opcao == "3" or opcao == "4" or opcao == "5" or opcao == "0"):
            return opcao
        else:
            limpaTela()
            print("\n\tOps, opção inválida! Tente novamente.")
            pause()

def supermercadoEmPython():
    
    carregarProdutosDeArquivo()  
    
    while True:
        
        opcao = menu()
        
        match opcao:
            
            case "1":
                limpaTela()
                cadastrar()
                salvarProdutosEmArquivo()
                
            case "2":
                limpaTela()
                listar()
                pause()
                
            case "3":
                limpaTela()
                editarProduto()
                
            case "4":
                limpaTela()
                excluirProduto()
                
            case "5":
                limpaTela()
                consultarProduto()
                
            case "0":
                return
                
            case _:
                limpaTela()
                print("\n\tOps, opção inválida! Tente novamente.")
                pause()

def cadastrar():
    
    print("\n\t======= CADASTRAR PRODUTO =======")
    global proximo_id
    
    codigo = input("\n\tInforme o código do produto: ")
    nome = input("\tNome do produto: ")

    preco = float(input("\tPreço do produto: "))

    quantidade = int(input("\tQuantidade do produto: "))

    produtos[proximo_id] = {"codigo": codigo, "nome": nome.capitalize(), "preco": preco, "quantidade": quantidade}
    proximo_id += 1
    
    limpaTela()
    listar()
    print("\n\tProduto cadastrado com sucesso!")
    pause()

def listar():
    print("\n\t======= LISTAR PRODUTOS =======")

    if len(produtos) > 0:
        # Ordena os produtos com base no preço antes de listar
        produtos_ordenados = sorted(produtos.items(), key=lambda x: x[1]["preco"])

        for i, (id, produto) in enumerate(produtos_ordenados, start=1):
            print("\tid: ", id)
            print("\tCódigo: ", produto["codigo"])
            print("\tNome: ", produto["nome"])
            print("\tPreço: {:.2f}".format(produto["preco"]))
            print("\tQuantidade: ", produto["quantidade"])
            print("\t=================================")

            # Exibe 10 produtos e pausa a cada 10 produtos
            if i % 10 == 0:
                print("\n\tExibindo 10 produtos por vez...")
                pause()

    else:
        print("\n\tAinda não existem produtos cadastrados.")

def editarProduto():
    
    print("\n\t        EDITAR PRODUTO       ")
    listar()
    codigoDoProduto = input("\n\tInforme o CÓDIGO do produto que deseja editar: ")
    
    for id in produtos:
        
        if produtos[id]["codigo"] == codigoDoProduto:
            
            limpaTela()
            print("\n\t======= PRODUTO ENCONTRADO =======")
            print("\tCódigo: ", produtos[id]["codigo"])
            print("\tNome: ", produtos[id]["nome"])
            print("\tPreço: ", produtos[id]["preco"])
            print("\tQuantidade: ", produtos[id]["quantidade"])
            print("\t=================================")
            pause()
            
            limpaTela()
            print("\n\t======= EDITAR PRODUTO =======")
            print("\n\tInforme os novos dados do produto: ")
            codigo = input("\n\tInforme o código do produto: ")
            nome = input("\tNome do produto: ")
            preco = input("\tPreço do produto: ")
            quantidade = input("\tQuantidade do produto:")
            produtos[id] = {"codigo": codigo, "nome": nome.capitalize(), "preco": preco, "quantidade": quantidade}
            
            limpaTela()
            listar()
            print("\n\tProduto editado com sucesso!")
            pause()
            return

    print("\n\tProduto não encontrado.")
    pause()
    
def excluirProduto():
    
    print("\n\t        EXCLUIR PRODUTO       ")
    listar()
    codigoDoProduto = input("\n\tInforme o CÓDIGO do produto que deseja excluir: ")
    
    for id in produtos:
        
        if produtos[id]["codigo"] == codigoDoProduto:
            
            limpaTela()
            print("\n\t======= PRODUTO ENCONTRADO =======")
            print("\tCódigo: ", produtos[id]["codigo"])
            print("\tNome: ", produtos[id]["nome"])
            print("\tPreço: ", produtos[id]["preco"])
            print("\tQuantidade: ", produtos[id]["quantidade"])
            print("\t=================================")
            pause()
            
            limpaTela()
            print("\n\t======= EXCLUIR PRODUTO =======")
            print("\n\tDeseja realmente excluir o produto? ")
            print("\t[1] - SIM")
            print("\t[2] - NÃO")
            opcao = input("\tENTRADA -> ")
            
            if(opcao == "1"):
                del produtos[id]
                limpaTela()
                listar()
                print("\n\tProduto excluído com sucesso!")
                pause()
                return
            else:
                return

    print("\n\tProduto não encontrado.")
    pause()
    
def consultarProduto():
    
    print("\n\t        CONSULTAR PRODUTO       ")
    listar()
    codigoDoProduto = input("\n\tInforme o CÓDIGO do produto que deseja consultar: ")
    
    for id in produtos:
        
        if produtos[id]["codigo"] == codigoDoProduto:
            
            limpaTela()
            print("\n\t======= PRODUTO ENCONTRADO =======")
            print("\tCódigo: ", produtos[id]["codigo"])
            print("\tNome: ", produtos[id]["nome"])
            print("\tPreço: ", produtos[id]["preco"])
            print("\tQuantidade: ", produtos[id]["quantidade"])
            print("\t=================================")
            pause()
            return

    print("\n\tProduto não encontrado.")
    pause()
    
def salvarProdutosEmArquivo():
    
    with open("semana3/Pratica3/Supermercado/BancoDeDados/arquivo.txt", "w") as arquivo:
        
        for id_produto, produto in produtos.items():
            arquivo.write(f"{id_produto},{produto['codigo']},{produto['nome']},{produto['preco']},{produto['quantidade']}\n")

def carregarProdutosDeArquivo():
    
    try:
        with open("semana3/Pratica3/Supermercado/BancoDeDados/arquivo.txt", "r") as arquivo:
            
            linhas = arquivo.readlines()
            if not linhas:
                print("O arquivo está vazio.")
                return

            for linha in linhas:
                partes = linha.strip().split(',')
                if len(partes) == 5:
                    
                    try:
                        id_produto, codigo, nome, preco, quantidade = map(str, partes)
                        produtos[id_produto] = {
                            'codigo': codigo,
                            'nome': nome,
                            'preco': float(preco),
                            'quantidade': int(quantidade)
                        }
                    except ValueError as e:
                        print(f"Erro ao processar a linha: {linha}")
                        print(f"Mensagem de erro: {e}")
                else:
                    print(f"Formato inválido na linha: {linha}")

    except FileNotFoundError:
        print("O arquivo não foi encontrado.")
         
def pause():
  input("\tPressione Enter para continuar...")
  
def limpaTela():
  sistema_operacional = platform.system().lower()

  if sistema_operacional == "windows":
    os.system("cls")
  elif sistema_operacional == "linux":
    os.system("clear")
  else:
    print("Sistema operacional não suportado para limpar a tela.")    
                            
def main():
    supermercadoEmPython()

if __name__ == "__main__":
    main()