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

def registrar_tarefa(tarefas, descricao, id_tarefa):
    tarefas[id_tarefa] = [descricao.capitalize(), False]
    print("\n\tTarefa registrada!!!")
    pause()
    
def listar_tarefas(tarefas):
    print("\n\t======= TAREFAS =======")
    for id_tarefa, tarefa in tarefas.items():
      concluida = "x" if tarefa[1] else " "
      print(f"\t{id_tarefa}. {tarefa[0]} [{concluida}]")
    pause()

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

# Dicionário para armazenar as tarefas (ID: (descricao, concluida))
tarefas = {}
proximo_id = 1

while True:
    
    limpaTela() 
    
    formato_personalizado = "\t%A, %d de %B de %Y %H:%M:%S"
    data_e_hora_formatada = data_e_hora_atual.strftime(formato_personalizado)
    print(data_e_hora_formatada)

    print("\n\t======= MENU =======")
    print("\t[1] - REGISTRAR TAREFA")
    print("\t[2] - LISTAR TAREFAS")
    print("\t[3] - MARCAR TAREFA COMO REALIZADA")
    print("\t[4] - EDITAR TAREFA")
    print("\t[0] - SAIR")
    escolha = input("\tENTRADA -> ")

    if escolha == "1":
      descricao = input("\tDigite a descrição da tarefa: ")
      registrar_tarefa(tarefas, descricao, proximo_id)
      proximo_id += 1
    elif escolha == "2":
       listar_tarefas(tarefas)
    elif escolha == "3":
      id_tarefa = int(input("\tDigite o ID da tarefa a ser marcada como realizada: "))
      marcar_tarefa_como_realizada(tarefas, id_tarefa)
    elif escolha == "4":
      id_tarefa = int(input("\tDigite o ID da tarefa a ser editada: "))
      nova_descricao = input("\tDigite a nova descrição da tarefa: ")
      editar_tarefa(tarefas, id_tarefa, nova_descricao)
    elif escolha == "0":
      break
    else:
      print("\tOpção inválida. Tente novamente.")