'''Exercício 1: Utilizando estruturas de controle de fluxo e listas.Para controlar os compromissos do dia a dia podemos utilizar um uma 
lista de tarefas. Com alguns dos recursos básicos da linguagem que já conhecemos podemos implementar o aplicativo ToDoList que permita:

● Listar as tarefas que estão registradas.
○ As tarefas já finalizadas aparecem no início da lista identificadas porum box confirmado ([x]) no final da tarefa;
○ As tarefas pendentes aparecem logo a seguir identificadas por um box vazio ([ ]) no final da tarefa;
○ Cada tarefa é precedida por um ID, número sequencial atribuído no momento que ela foi cadastrada;

○ Exemplo:
1. Preparar a marmita [x]
2. Arrumar a mochila [ ]
3. Fechar as janelas [ ]

● Registrar uma nova tarefa.
○ Uma descrição da tarefa é solicitada ao usuário (Exemplo: “arrumar o quarto”);
○ A tarefa é registrada e a ela é atribuído um ID e um box vazio é adicionado no final da string com a descrição da tarefa. 
(Exemplo: “3.arrumar o quarto[ ]”);
○ No momento de registrar, deve-se garantir que a string com a descrição da tarefa começa com maiúscula (Exemplo: “3.Arrumar o quarto[ ]”);
○ Uma mensagem confirmando a execução da tarefa deve ser apresentada. (Exemplo: “Tarefa registrada!!!”)

● Marcar uma tarefa como realizada.
○ O aplicativo solicita o identificador da tarefa e, existindo, ela é movida para o início da lista e o box vazio no final é substituído 
por um box confirmado;
○ Caso o identificado não exista ou a tarefa já tenha sido realizada nada será feito.
○ Uma mensagem confirmando a execução da tarefa deve ser apresentada.

● Editar uma tarefa.
○ O aplicativo solicita o identificador da tarefa e, existindo, é solicitada uma nova descrição da mesma;
○ O status do box da tarefa e o identificador da mesma não pode ser alterado na edição;
○ Uma mensagem confirmando a execução da tarefa deve ser apresentada.

Exercício 2: Pesquisa sobre persistência de dados.
● Durante o módulo anterior abordamos o tema de persistência de dados utilizando arquivos. Pesquise sobre arquivos em 
Python e proponha as modificações necessárias para que o aplicativo do exercício anterior utilize um arquivo para armazenar a lista 
de tarefas.
'''

import os
import platform
import locale
from datetime import datetime
locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')
data_e_hora_atual = datetime.now()
tarefas = {}
proximo_id = 1

def cadastrar():
  
    print("\n\t======= CADASTRAR TAREFA =======")
    global proximo_id
    descricao = input("\n\tDigite a descrição da tarefa: ")
    tarefas[proximo_id] = [descricao.capitalize(), False]
    proximo_id += 1
    print("\n\tTarefa registrada!!!")
    pause()
    
def listar():
  
  print("\n\t======= TAREFAS =======")
  for id_tarefa, tarefa in tarefas.items():
    if tarefa[1]:
      print(f"\t{id_tarefa}. {tarefa[0]} [x]")
    else:
      print(f"\t{id_tarefa}. {tarefa[0]} [ ]") 
  print("\t=======================") 

def marcarTarefaComoRealizada():
  
  print("\n\t======= MARCAR TAREFA COMO REALIZADA =======")
  listar()  # Mostra a lista de tarefas para que o usuário escolha qual marcar como realizada
  id_tarefa = int(input("\tDigite o ID da tarefa a ser marcada como realizada: "))

  if id_tarefa in tarefas:
    limpaTela()
    tarefas[id_tarefa][1] = True
    listar()
    print("\n\tTarefa marcada como realizada!")
    pause()
  else:
    print("\n\tID de tarefa inválido. Tente novamente.")
    pause()

def editarTarefa():
  
  print("\n\t======= EDITAR TAREFA =======")
  listar()  # Mostra a lista de tarefas para que o usuário escolha qual editar
  id_tarefa = int(input("\n\tDigite o ID da tarefa a ser editada: "))
  limpaTela()

  if id_tarefa in tarefas:
    nova_descricao = input("\n\tDigite a nova descrição da tarefa: ")
    tarefas[id_tarefa][0] = nova_descricao.capitalize()
    limpaTela()
    listar()
    print("\n\tTarefa editada com sucesso!")
    pause()
  else:
    print("\n\tID de tarefa inválido. Tente novamente.")
    pause()
    
def salvarTarefasEmArquivo():
  with open("Semana2/Pratica2/tarefas.txt", "w") as arquivo:
    
      for id_tarefa, tarefa in tarefas.items():
          arquivo.write(f"{id_tarefa},{tarefa[0]},{tarefa[1]}\n")

def carregarTarefasDeArquivo():
  try:
    with open("Semana2/Pratica2/tarefas.txt", "r") as arquivo:
      linhas = arquivo.readlines()
      if not linhas:
        print("O arquivo está vazio.")
        return
      for linha in linhas:
        partes = linha.strip().split(',')
        if len(partes) == 3:
          try:
            id_tarefa, descricao, realizada = map(str, partes)
            tarefas[id_tarefa] = [descricao, bool(realizada)]
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
      
def menu():
  
  while True:
    
    limpaTela()
    formato_personalizado = "\n\t%A, %d de %B de %Y %H:%M:%S"
    data_e_hora_formatada = data_e_hora_atual.strftime(formato_personalizado)
    print(data_e_hora_formatada)

    print("\n\t======= MENU =======")
    print("\t[1] - REGISTRAR TAREFA")
    print("\t[2] - LISTAR TAREFAS")
    print("\t[3] - MARCAR TAREFA COMO REALIZADA")
    print("\t[4] - EDITAR TAREFA")
    print("\t[0] - SAIR")
    opcao = input("\tENTRADA -> ")
    
    if(opcao == "1" or opcao == "2" or opcao == "3" or opcao == "4" or opcao == "0"):
      return opcao
    else:
      print("\tOps, opção inválida. Tente novamente.")
      pause()
    
def main(): 
 
  carregarTarefasDeArquivo()
  
  while True:
        
    opcao = menu()
        
    match opcao:
          
      case "1":
        limpaTela()
        cadastrar()
        salvarTarefasEmArquivo()
              
      case "2":
        limpaTela()
        listar()
        pause()
            
      case "3":
        limpaTela()
        marcarTarefaComoRealizada()
                
      case "4":
        limpaTela()
        editarTarefa()
                
      case "0": 
        return 
              
      case _:
        print("\tOps, Opção inválida. Tente novamente!")
        pause()
          
try:
  main()
except Exception as e:
  print("Erro não tratado:", e)
           