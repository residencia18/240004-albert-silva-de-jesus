


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
    
        print("\n\t======= GESTÃO DE FUNCIONÁRIO =======\n")
        print("\t[1] - CADASTRAR")
        print("\t[2] - LISTAR")
        print("\t[3] - EDITAR")
        print("\t[4] - EXCLUIR")
        print("\t[5] - CONSULTAR")
        print("\t[0] - SAIR")
        opcao = input("\tENTRADA -> ")

        if(opcao == "1" or opcao == "2" or opcao == "3" or opcao == "4" or opcao == "5" or opcao == "0"):
            return opcao
        else:
            limpaTela()
            print("\n\tOps, opção inválida! Tente novamente.")
            pause()

def gestaoFuncionario():
  
    while True:
      
      opcao = menu()
        
      if opcao == "1":
        cadastrarProduto()
            
      elif opcao == "2":
        listarProdutos()
            
      elif opcao == "3":
        editarProduto()
            
      elif opcao == "4":
        excluirProduto()
            
      elif opcao == "5":
        consultarProduto()
            
      elif opcao == "0":
        print("\n\tSaindo do sistema...")
        break
      

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
    gestaoFuncionario()

if __name__ == "__main__":
    main()  