'''
Exercício 2: Pesquisa sobre persistência de dados.

● Este exercício já foi implementado no módulo anterior, utilizando C++. Vejamos agora como ficaria uma versão feita em 
Python: Crie um dicionário para armazenar dados (nome, sobrenome, ano de nascimento, RG, ano deadmissão, salário) de 
empregados de uma empresa. Leia as informaçõies sobre os funcionários de um arquivo e guarde numa lista.
Faça uma função chamada “Reajusta_dez_porcento( )” que receba por parâmetro a lista de empregados e atualize o salário de 
cada empregado em 10%.

● Crie um aplicativo para testar a função. Pode reproduzir a estrutura utilizada no exercício anterior.

''' 

import os
import platform
import locale
from datetime import datetime, date
locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')
data_e_hora_atual = datetime.now()
funcionarios = {}
proximo_id = 1

def menu():
    
  while True:
    
    limpaTela()
    formato_personalizado = "\n\t%A, %d de %B de %Y %H:%M:%S"
    data_e_hora_formatada = data_e_hora_atual.strftime(formato_personalizado)
    print(data_e_hora_formatada)
    print("\tFalta", (datetime(data_e_hora_atual.year, 12, 31) - data_e_hora_atual).days + 1, "dias para o fim do ano")
    
    print("\n\t======= GESTÃO DE FUNCIONÁRIO =======")
    print("\t[1] - CADASTRAR")
    print("\t[2] - LISTAR")
    print("\t[3] - EDITAR")
    print("\t[4] - EXCLUIR")
    print("\t[5] - CONSULTAR")
    print("\t[6] - REAJUSTE DE 10%")
    print("\t[0] - SAIR")
    opcao = input("\tENTRADA -> ")

    if(opcao == "1" or opcao == "2" or opcao == "3" or opcao == "4" or opcao == "5" or opcao == "6" or opcao == "0"):
      return opcao
    else:
      limpaTela()
      print("\n\tOps, opção inválida! Tente novamente.")
      pause()

def gestaoFuncionario():
  
    carregarFuncionariosDeArquivo()
  
    while True:
      
      opcao = menu()
        
      if opcao == "1":
        cadastrar()
        salvarFuncionariosEmArquivo()
            
      elif opcao == "2":
        limpaTela()
        listar()
        pause() 
            
      elif opcao == "3":
        editar()
        salvarFuncionariosEmArquivo()
            
      elif opcao == "4":
        excluir()
        salvarFuncionariosEmArquivo()
            
      elif opcao == "5":
        consultar()
        
      elif opcao == "6":
        Reajusta_dez_porcento()
        salvarFuncionariosEmArquivo()
            
      elif opcao == "0":
        print("\n\tSaindo do sistema...")
        break
      
def cadastrar():
  
    global funcionarios
    limpaTela()
    global proximo_id
    
    print("\n\t======= CADASTRAR FUNCIONÁRIO =======\n")
    
    nome = input("\tNome do Funcionário: ")
    sobrenome = input("\tSobrenome do Funcionário: ")
    
    print("\tDigite a data de nascimento no formato DD/MM/YYYY: ")
    ano_nascimento = validarData()  
    
    rg = input("\tInforme o RG do Funcionário: ")
    
    print("\tAno de admissão na empresa: ")
    ano_admissao = validarData()
    
    salario = float(input("\tSalário do funcionário: "))
    
    funcionarios[proximo_id] = [nome.capitalize(), sobrenome.capitalize(), ano_nascimento, rg, ano_admissao, salario]
    proximo_id += 1
    
    limpaTela()
    listar()
    print("\n\tFuncionário cadastrado com sucesso!")
    pause()

def listar():
  
  print("\n\t======= LISTAR FUNCIONÁRIOS =======")

  if len(funcionarios) > 0:
    
    funcionarios_ordenados = sorted(funcionarios.items(), key=lambda x: x[1][5])  # Ordena pelo salário (índice 5)
    for id_funcionario, dados_funcionario in funcionarios_ordenados:
      print("\tID: ", id_funcionario)
      print("\tNome: ", dados_funcionario[0])
      print("\tSobrenome: ", dados_funcionario[1])
      print("\tAno de nascimento: ", dados_funcionario[2])
      print("\tRG: ", dados_funcionario[3])
      print("\tAno de admissão: ", dados_funcionario[4])
      print("\tSalário: R$ {:.2f}".format(dados_funcionario[5]))
      print("\t====================================")
  else:
    print("\n\tNão há funcionários cadastrados.")
    
def editar():
  
  limpaTela()
  id_funcionario = None
    
  if len(funcionarios) > 0:
    
    print("\n\t        EDITAR FUNCIONÁRIO       \n") 
    listar()
    
    while True:
        
      id_funcionario_input = input("\n\tInforme o ID do funcionário que deseja editar: ")

      if id_funcionario_input.strip():  # Verifica se a string não é vazia após remover espaços em branco
            
        try:
          
          id_funcionario = int(id_funcionario_input)
          break  # Sai do loop se a conversão for bem-sucedida
            
        except ValueError:
          limpaTela() 
          print("\n\tPor favor, insira um número válido.")
          pause()
          limpaTela() 
          
      else:
        limpaTela()
        print("\n\tPor favor, insira um ID válido.")
        pause()
        limpaTela()
      
    if id_funcionario in funcionarios:
        
      limpaTela()
      print("\n\t======= EDITAR FUNCIONÁRIO =======")
        
      print("\n\tInforme os novos dados do funcionário: ")
      nome = input("\n\tNome do Funcionário: ")
      sobrenome = input("\tSobrenome do Funcionário: ")
      ano_nascimento = input("\tInforme o Ano de nascimento do mesmo: ")
      rg = input("\tInforme o RG do Funcionário: ")
      ano_admissao = input("\tAno de admissão na empresa: ")
      salario = float(input("\tSalário do funcionário: "))
        
      funcionarios[id_funcionario] = [nome, sobrenome, ano_nascimento, rg, ano_admissao, salario]
        
      limpaTela()
      listar()  
      print("\n\tFuncionário editado com sucesso!")
      pause()
    else:
      limpaTela()
      print("\n\tFuncionário não encontrado!")
      pause()
  else:
    print("\n\tNão há funcionários cadastrados.")
    pause()
    
def consultar():
  
  limpaTela()
  id_funcionario = None
    
  if len(funcionarios) > 0:
    
    print("\n\t        CONSULTAR FUNCIONÁRIO       \n") 
    listar()
    
    while True:
        
      id_funcionario_input = input("\n\tInforme o ID do funcionário que deseja consultar: ")

      if id_funcionario_input.strip():
            
        try:
          
          id_funcionario = int(id_funcionario_input)
          break  
            
        except ValueError:
          limpaTela() 
          print("\n\tPor favor, insira um número válido.")
          pause()
          limpaTela() 
          
      else:
        limpaTela()
        print("\n\tPor favor, insira um ID válido.")
        pause()
        limpaTela()
      
    if id_funcionario in funcionarios:
        
      limpaTela()
      print("\n\t======= CONSULTAR FUNCIONÁRIO =======")
        
      print("\n\tID: ", id_funcionario)
      print("\tNome: ", funcionarios[id_funcionario][0])
      print("\tSobrenome: ", funcionarios[id_funcionario][1])
      print("\tAno de nascimento: ", funcionarios[id_funcionario][2])
      print("\tRG: ", funcionarios[id_funcionario][3])
      print("\tAno de admissão: ", funcionarios[id_funcionario][4])
      print("\tSalário: R$ {:.2f}".format(funcionarios[id_funcionario][5]))
      print("\t====================================")
        
      pause()
        
    else:
      limpaTela()
      print("\n\tFuncionário não encontrado!")
      pause()
      
  else:
    print("\n\tNão há funcionários cadastrados.")
    pause()

def Reajusta_dez_porcento():
    
  limpaTela()
  print("\n\t========== REAJUSTE DE 10% =========")
  for id_funcionario in funcionarios:
    funcionarios[id_funcionario][5] = funcionarios[id_funcionario][5] * 1.1
    print("\tID: ", id_funcionario)
    print("\tNome: ", funcionarios[id_funcionario][0])
    print("\tSobrenome: ", funcionarios[id_funcionario][1])
    print("\tAno de nascimento: ", funcionarios[id_funcionario][2])
    print("\tRG: ", funcionarios[id_funcionario][3])
    print("\tAno de admissão: ", funcionarios[id_funcionario][4])
    print("\tSalário: R$ {:.2f}".format(funcionarios[id_funcionario][5]))
    print("\t====================================")
      
  print("\n\tFuncionários reajustados com sucesso!")
  pause() 
      
def excluir():
  
  limpaTela()
  id_funcionario = None
    
  if len(funcionarios) > 0:
    
    print("\n\t        EXCLUIR FUNCIONÁRIO       \n") 
    listar()
    
    while True:
        
      id_funcionario_input = input("\n\tInforme o ID do funcionário que deseja excluir: ")

      if id_funcionario_input.strip():
            
        try:
          
          id_funcionario = int(id_funcionario_input)
          break  
            
        except ValueError:
          limpaTela() 
          print("\n\tPor favor, insira um número válido.")
          pause()
          limpaTela() 
          
      else:
        limpaTela()
        print("\n\tPor favor, insira um ID válido.")
        pause()
        limpaTela()
      
    if id_funcionario in funcionarios:
        
      limpaTela()
      print("\n\t======= EXCLUIR FUNCIONÁRIO =======")
        
      print("\n\tVocê tem certeza que deseja excluir o funcionário abaixo?")
      print("\n\tID: ", id_funcionario)
      print("\tNome: ", funcionarios[id_funcionario][0])
      print("\tSobrenome: ", funcionarios[id_funcionario][1])
      print("\tAno de nascimento: ", funcionarios[id_funcionario][2])
      print("\tRG: ", funcionarios[id_funcionario][3])
      print("\tAno de admissão: ", funcionarios[id_funcionario][4])
      print("\tSalário: R$ {:.2f}".format(funcionarios[id_funcionario][5]))
      print("\t====================================")
        
      while True:
            
        opcao = input("\n\t[1] - SIM\n\t[2] - NÃO\n\tENTRADA -> ")
            
        if opcao == "1":
          del funcionarios[id_funcionario]
          limpaTela()
          listar()
          print("\n\tFuncionário excluído com sucesso!")
          pause()
          break
        
        elif opcao == "2":
          limpaTela()
          print("\n\tFuncionário não excluído!")
          pause()
          break
        
        else:
          limpaTela()
          print("\n\tOpção inválida! Tente novamente.")
          pause()
          limpaTela()
          
    else:
      limpaTela()
      print("\n\tFuncionário não encontrado!")
      pause()
      
  else:
    print("\n\tNão há funcionários cadastrados.")
    pause()
    
def salvarFuncionariosEmArquivo():
  
  global funcionarios
  with open("semana3/exercicio2/arquivo.txt", "w") as arquivo:
    funcionarios_ordenados = sorted(funcionarios.items(), key=lambda x: x[1][5])
    for id_funcionario, dados_funcionario in funcionarios.items():
        arquivo.write(f"{id_funcionario},{dados_funcionario[0]},{dados_funcionario[1]},{dados_funcionario[2]},{dados_funcionario[3]},{dados_funcionario[4]},{dados_funcionario[5]}\n")

def carregarFuncionariosDeArquivo():
  
  global funcionarios
 
  try:
    with open("semana3/exercicio2/arquivo.txt", "r") as arquivo:
      
      linhas = arquivo.readlines() 
     
      if not linhas:
        print("\n\tCarregando funcionários...")
        print("O arquivo está vazio.")
        return
      
      for linha in linhas:
        partes = linha.strip().split(',')

        if len(partes) == 7:
          try:
            id_funcionario, nome, sobrenome, ano_nascimento, rg, ano_admissao, salario = map(str, partes)
            
            funcionarios[int(id_funcionario)] = [
              nome,
              sobrenome,
              ano_nascimento,
              rg,
              ano_admissao,
              float(salario) 
            ]
            
          except ValueError as e:
            print(f"Erro ao processar a linha: {linha}")
            print(f"Mensagem de erro: {e}")
        else:
          print(f"Formato inválido na linha: {linha}")

  except FileNotFoundError:
    print("O arquivo não foi encontrado.")
      
def validarData():
  
  while True:
      
    data_nascimento_input = input("\tDATA ENTRADA -> ")

    try:
          
      # Tenta criar um objeto datetime a partir da string e do formato fornecidos
      data_nascimento = datetime.strptime(data_nascimento_input, '%d/%m/%Y')

      # Obtém o ano do nascimento
      ano_nascimento = data_nascimento.date().year

      # Obtém o ano atual
      ano_atual = date.today().year

      # Verifica se o ano de nascimento é menor ou igual ao ano atual
      if ano_nascimento <= ano_atual:
        print("\tOps, data válida!")

        # Formata a data no formato desejado
        formato_personalizado = "%d/%m/%Y"
        data_nascimento_formatada_str = data_nascimento.strftime(formato_personalizado)

        return data_nascimento_formatada_str  # Retorna a data de nascimento validada e formatada

      else:
        limpaTela()
        print("\tOps, data invalida! Certifique-se de fornecer uma data válida.")
        pause()
        limpaTela() 
                
    except ValueError:
      # Se ocorrer um erro ao tentar converter para datetime, ou seja, se não for uma data válida
      limpaTela() 
      print("\tOps, data invalida! formato correto: DD/MM/YYYY")
      pause()
      limpaTela()
            
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