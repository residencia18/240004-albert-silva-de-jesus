import os
import copy
import platform
import locale
from datetime import datetime
locale.setlocale(locale.LC_TIME, 'pt_BR.UTF-8')
data_e_hora_atual = datetime.now()
from abc import ABC, abstractmethod

class Data:
    
    def __init__(self, dia = 1, mes = 1, ano = 2000):
        if dia < 1 or dia > 31:
            raise ValueError("Dia inválido")
        if mes < 1 or mes > 12:
            raise ValueError("Mês inválido")
        if ano < 1900 or ano > 2100:
            raise ValueError("Ano inválido")
        self.__dia = dia
        self.__mes = mes
        self.__ano = ano
        
    @property
    def year(self):
        return self.__ano
    
    @year.setter
    def year(self, ano):
        if ano < 2000 or ano > 2100:
            raise ValueError("Ano inválido")
        self.__ano = ano

    @property
    def dia(self):
        return self.__dia
    
    @dia.setter
    def dia(self, dia):
        if dia < 1 or dia > 31:
            raise ValueError("Dia inválido")
        self.__dia = dia

    @property
    def mes(self):
        return self.__mes
    
    @mes.setter
    def mes(self, mes):
        if mes < 1 or mes > 12:
            raise ValueError("Mês inválido")
        self.__mes = mes

    @property
    def ano(self):
        return self.__ano
    
    @ano.setter
    def ano(self, ano):
        if ano < 2000 or ano > 2100:
            raise ValueError("Ano inválido")
        self.__ano = ano
    
    def __str__(self):
        return "{}/{}/{}".format(self.__dia, self.__mes, self.__ano)

    def __eq__(self, outraData):
        return  self.__dia == outraData.__dia and \
                self.__mes == outraData.__mes and \
                self.__ano == outraData.__ano
    
    def __lt__(self, outraData):
        if self.__ano < outraData.__ano:
            return True
        elif self.__ano == outraData.__ano:
            if self.__mes < outraData.__mes:
                return True
            elif self.__mes == outraData.__mes:
                if self.__dia < outraData.__dia:
                    return True
        return False
    
    def __gt__(self, outraData):
        if self.__ano > outraData.__ano:
            return True
        elif self.__ano == outraData.__ano:
            if self.__mes > outraData.__mes:
                return True
            elif self.__mes == outraData.__mes:
                if self.__dia > outraData.__dia:
                    return True
        return False

class AnaliseDados(ABC): 

    @abstractmethod
    def __init__(self, tipoDeDados):
        self.__tipoDeDados = tipoDeDados

    @abstractmethod
    def entradaDeDados(self):
        pass

    @abstractmethod
    def mostraMediana(self):
        pass
    
    @abstractmethod
    def mostraMenor(self):
        pass

    @abstractmethod
    def mostraMaior(self):
        pass
    
    @abstractmethod
    def listarEmOrdem(self):
        pass

class ListaNomes(AnaliseDados):
    
    def __init__(self):
        super().__init__(type("String"))
        self.__lista = []
        self.__nomes = []
        self.__salarios = []        

    def entradaDeDados(self):
        '''
        Este método pergunta ao usuários quantos
        elementos vão existir na lista e depois
        solicita a digitação de cada um deles.
        '''
        limpaTela() 
        print("\n\t=========== CADASTRO DE NOMES ===========\n")
        
        while True:
            try:
                quantElementos = int(input("\n\tQuantos elementos vão existir na lista: "))
                break  # Se a conversão para int for bem-sucedida, sai do loop
            except ValueError:
                print("\tPor favor, digite um número inteiro válido.")
                pause() 
                limpaTela() 
        
        for i in range(quantElementos):
            while True:
                limpaTela()
                elemento = input("\n\tDigite o elemento {}: ".format(i + 1))
                if elemento.isalpha():
                    self.__lista.append(elemento)
                    break
                else:
                    limpaTela()
                    print("\tPor favor, digite apenas letras.")
                    pause() 
                    limpaTela() 
        pass

    def mostraMediana(self):
        '''
        Este método ordena a lista e mostra o
        elemento que está na metade da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular a mediana.")
            return

        lista_ordenada = sorted(self.__lista)
        tamanho = len(lista_ordenada)

        if tamanho % 2 == 0:
            meio1 = lista_ordenada[tamanho // 2 - 1]
            meio2 = lista_ordenada[tamanho // 2]
            mediana = (meio1, meio2)
        else:
            mediana = lista_ordenada[tamanho // 2]

        print(f"\n\tA mediana da lista é: {mediana[0]}")  # Mostra o primeiro valor na mediana
        pause()
        
        pass    

    def mostraMenor(self):
        '''
        Este método retorna o menos elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o menor elemento.")
            return
        
        menor = self.__lista[0]
        for elemento in self.__lista:
            if elemento < menor:
                menor = elemento
        print(f"\n\tO menor elemento da lista é: {menor}")
        pause()
        
        pass

    def mostraMaior(self):
        '''
        Este método retorna o maior elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o maior elemento.")
            return
        
        maior = self.__lista[0] 
        for elemento in self.__lista:
            if elemento > maior:
                maior = elemento
        print(f"\n\tO maior elemento da lista é: {maior}")
        pause()
        
        pass    

    def listarEmOrdem(self):
        '''
        Este método ordena a lista e mostra os
        elementos em ordem crescente
        '''
        limpaTela()
        if not self.__lista:
            print("A lista está vazia. Não é possível ordenar.")
            return

        lista_ordenada = sorted(self.__lista)
        print("\n\t=========== LISTA DE NOMES EM ORDEM ALFABÉTICA ===========\n")
        for elemento in lista_ordenada:
            print(f"\tNome: {elemento}")
        pause()
        
        pass
    
    def percorreListaDeNomesESalarios(self, outras_nomes, outras_salarios):
        
        if not self.__lista:
            limpaTela() 
            print("\n\tA lista está vazia. Não é possível percorrer a lista de nomes e salários.")
            pause()
            return
        
        limpaTela()
        print("\n\t=========== LISTA DE NOMES E SALÁRIOS ===========\n")
        for nome, salario in zip(self.__lista, outras_salarios._ListaSalarios__lista):
            print("\tNome: {}, Salário: {:.2f}".format(nome, salario))
        pause()
    
    def __str__(self):
        pass
	
class ListaDatas(AnaliseDados):
        
    def __init__(self):
        super().__init__(type(Data))
        self.__lista = []        
    
    def entradaDeDados(self):
        '''
        Este método pergunta ao usuários quantos
        elementos vão existir na lista e depois
        solicita a digitação de cada um deles
        '''
        limpaTela()
        print("\n\t=========== CADASTRO DE DATAS ===========\n")
        
        while True:
            try:
                quantElementos = int(input("\n\tQuantos elementos vão existir na lista: "))
                break  # Se a conversão para int for bem-sucedida, sai do loop
            except ValueError:
                limpaTela()
                print("\tPor favor, digite um número inteiro válido.")
                pause() 
                limpaTela() 
        
        for i in range(quantElementos):    
            while True:
                try:
                    print("\n\tDigite o elemento {}:".format(i + 1))
                    dia = int(input("\tDia: "))
                    mes = int(input("\tMês: "))
                    ano = int(input("\tAno: "))
            
                    # Verifica se a data é válida
                    data = Data(dia, mes, ano)
            
                    # Se chegou aqui, a data é válida, então podemos adicionar à lista
                    self.__lista.append(data)
                    print(f"\n\tData válida: {data}")
            
                    # Sai do loop se a entrada foi válida
                    break

                except ValueError as e:
                    limpaTela() 
                    print("\n\tOps, data invalida!\n\tPor favor, digite uma data válida.")
                    pause()
                    limpaTela() 
        pass
    
    def mostraMediana(self):
        '''
        Este método ordena a lista e mostra o
        elemento que está na metade da lista
        '''
        
        mediana = self.calcula_data_mediana()
        
        pass    
     
    def mostraMenor(self):
        '''
        Este método retorna o menos elemento da lista
        '''
    
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o menor elemento.")
            return
        
        menor = self.__lista[0]
        for elemento in self.__lista:
            if elemento < menor:
                menor = elemento
        print(f"\n\tO menor elemento da lista é: {menor}")
        pause()
        
        pass
    
    def mostraMaior(self):
        '''
        Este método retorna o maior elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o maior elemento.")
            return
        
        maior = self.__lista[0]
        for elemento in self.__lista:
            if elemento > maior:
                maior = elemento
        print(f"\n\tO maior elemento da lista é: {maior}")
        pause()
        
        pass
    
    def calcula_data_mediana(self):
        
        if not self.__lista:
            print("A lista de datas está vazia. Não é possível calcular a mediana.")
            return None

        lista_ordenada = sorted(self.__lista)
        tamanho = len(lista_ordenada)

        if tamanho % 2 != 0:
            mediana = lista_ordenada[tamanho // 2]
            print(f"\n\tA lista de datas tem um número ímpar de elementos. A mediana é: {mediana}")
        else:
            meio1 = lista_ordenada[tamanho // 2 - 1]
            meio2 = lista_ordenada[tamanho // 2]
            mediana = Data()  # Criar uma nova instância de Data para armazenar a mediana
            if meio1 < meio2:
                mediana = meio1
            else:
                mediana = meio2
                print(f"\n\tA lista de datas tem um número par de elementos. A mediana é: {mediana}")

        return mediana
    
    def listarEmOrdem(self):
        '''
        Este método ordena a lista e mostra os
        elementos em ordem crescente
        '''
        lista_ordenada = sorted(self.__lista)
    
        limpaTela()
        print("\n\t=========== LISTA DE DATAS ===========\n")
    
        for i, data in enumerate(lista_ordenada, start=1):
            print(f"\tData {i}: {data}")
        pause()
    
    def modificar_datas_anteriores_2019(self):
        
        if not self.__lista:
            limpaTela()
            print("\n\tA lista está vazia. Não é possível modificar as datas.")
            pause()
            return
        
        limpaTela()
        print("\n\t=========== DATAS ANTES E DEPOIS DA MODIFICAÇÃO ===========\n")  

        datas_modificadas = list(filter(lambda x: x is not None, map(lambda data: self.modificar_data(data), self.__lista.copy())))
        
        for data_original, data_modificada in zip(self.__lista, datas_modificadas):
            print("\tData original: {}, Data modificada: {}".format(data_original, data_modificada))
        pause()

    def modificar_data(self, data):
        if data.ano < 2019:
            # Criar uma cópia do objeto Data para evitar modificar a lista original
            data = copy.copy(data)
            data.dia = 1
        return data

    def __str__(self):
        pass

class ListaSalarios(AnaliseDados):

    def __init__(self):
        super().__init__(type(float))
        self.__lista = []        

    def entradaDeDados(self):
        '''
        Este método pergunta ao usuários quantos
        elementos vão existir na lista e depois
        solicita a digitação de cada um deles
        '''
        
        limpaTela()
        print("\n\t=========== CADASTRO DE SALÁRIOS ===========\n")
        
        while True:
            try:
                quantElementos = int(input("\n\tQuantos elementos vão existir na lista: "))
                break  # Se a conversão para int for bem-sucedida, sai do loop
            except ValueError:
                print("\tPor favor, digite um número inteiro válido.")
                pause() 
                limpaTela()
        
        for i in range(quantElementos):
            while True:
                try:
                    print("\n\tDigite o elemento {}:".format(i + 1))
                    elemento = float(input("\tNúmero: "))
            
                    # Se chegou aqui, o número é válido, então podemos adicionar à lista
                    self.__lista.append(elemento)
                    print(f"\n\tNúmero válido: {elemento}")
            
                    # Sai do loop se a entrada foi válida
                    break

                except ValueError:
                    limpaTela()
                    print("\n\tOps, entrada invalida! Por favor, digite um número válido.")
                    pause()
                    limpaTela()
        pass
            
    def mostraMediana(self):
        '''
        Este método ordena a lista e mostra o
        elemento que está na metade da lista
        '''
        
        mediana = self.calcula_salario()

        pass    

    def mostraMenor(self):
        '''
        Este método retorna o menos elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o menor elemento.")
            return
        
        menor = self.__lista[0]
        for elemento in self.__lista:
            if elemento < menor:
                menor = elemento
        print(f"\n\tO menor elemento da lista é: {menor}")
        pause()
        
        pass

    def mostraMaior(self):
        '''
        Este método retorna o maior elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o maior elemento.")
            return
        
        maior = self.__lista[0]
        for elemento in self.__lista:
            if elemento > maior:
                maior = elemento
        print(f"\n\tO maior elemento da lista é: {maior}")
        pause()
        
        pass
    
    def calcula_salario(self):
    
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular a mediana dos salários.")
            return None

        lista_ordenada = sorted(self.__lista)
        tamanho = len(lista_ordenada)

        if tamanho % 2 != 0:
            mediana = lista_ordenada[tamanho // 2]
            print(f"\n\tA lista de salários tem um número ímpar de elementos. A mediana é: {mediana:.2f}")
        else:
            meio1 = lista_ordenada[tamanho // 2 - 1]
            meio2 = lista_ordenada[tamanho // 2]
            mediana = (meio1 + meio2) / 2
            print(f"\n\tA lista de salários tem um número par de elementos. A mediana é: {mediana:.2f}")

        return mediana
    
    def listarEmOrdem(self):
        '''
        Este método ordena a lista e mostra os
        elementos em ordem crescente
        '''
        limpaTela()
        if not self.__lista:
            print("A lista está vazia. Não é possível ordenar.")
            return

        lista_ordenada = sorted(self.__lista)
        print("\n\t=========== LISTA DE SALÁRIOS EM ORDEM CRESCENTE ===========\n")
        for elemento in lista_ordenada:
            print(f"\tSalário: {elemento:.2f}")
        pause()
        
        pass
    
    def reajustar_Salarios(self):
        
        limpaTela()
        if not self._ListaSalarios__lista:
            limpaTela()
            print("\n\tA lista de salários está vazia, não é possível reajustar os salários")
            pause()
            return None

        
        def calcular_novo_salario(salario):
            return salario * 1.1  # Reajuste de 10%

        # Aplicar a função de reajuste a todos os salários usando o iterador map
        salarios_reajustados = list(map(calcular_novo_salario, self._ListaSalarios__lista))

        print("\n\t=========== SALÁRIOS ANTES E DEPOIS DO REAJUSTE ===========\n")
        
        for salario_original, salario_reajustado in zip(self._ListaSalarios__lista, salarios_reajustados):
            print("\tSalário antes: {:.2f}, Salário reajustado: {:.2f}".format(salario_original, salario_reajustado))

        # Calcular e exibir o custo total da folha de pagamento antes e depois do reajuste
        custo_folha_anterior = sum(self._ListaSalarios__lista)
        custo_folha_atual = sum(salarios_reajustados)

        print("\n\tCusto total da folha de pagamento antes do reajuste: {:.2f}".format(custo_folha_anterior))
        print("\tCusto total da folha de pagamento após o reajuste: {:.2f}".format(custo_folha_atual))

        pause()
        
class ListaIdades(AnaliseDados):
    
    def __init__(self):
        super().__init__(type(int))
        self.__lista = []        
    
    def entradaDeDados(self):
        '''
        Este método realiza a entrada de dados
        '''
        limpaTela()
        print("\n\t=========== CADASTRO DE IDADES ===========\n")
        try:
            quantElementos = int(input("\n\tDigite a quantidade de elementos da lista: "))
            self.__lista = []

            for i in range(quantElementos):
                while True:
                    elemento_str = input("\n\tDigite o elemento {}: ".format(i + 1))

                    # Verifica se a entrada não está vazia
                    if elemento_str.strip():
                        try:
                            elemento = int(elemento_str)
                            self.__lista.append(elemento)
                            break  # Sai do loop se a entrada for válida
                        except ValueError:
                            limpaTela()
                            print("\n\tOps, idade inválida. Tente novamente.")
                            pause()
                    else:
                        limpaTela()
                        print("\n\tOps, idade inválida. Tente novamente.")
                        pause()
        except ValueError:
            print("\n\tOps, digite um valor numérico válido.")
            pause()
            self.entradaDeDados()
        pass
 
    def mostraMediana(self):
        '''
        Este método ordena a lista e mostra o
        elemento que está na metade da lista
        '''
        
        mediana = self.calcula_mediana()
        
        pass    
    
    def mostraMenor(self):
        '''
        Este método retorna o menos elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o menor elemento.")
            return
        
        menor = self.__lista[0]
        for elemento in self.__lista:
            if elemento < menor:
                menor = elemento
        print(f"\n\tO menor elemento da lista é: {menor}")
        pause()
        
        pass
    
    def mostraMaior(self):
        '''
        Este método retorna o maior elemento da lista
        '''
        
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular o maior elemento.")
            return
        
        maior = self.__lista[0]
        for elemento in self.__lista:
            if elemento > maior:
                maior = elemento
        print(f"\n\tO maior elemento da lista é: {maior}")
        pause()
        
        pass
    
    def calcula_mediana(self):
        if not self.__lista:
            print("A lista está vazia. Não é possível calcular a mediana.")
            return None

        lista_ordenada = sorted(self.__lista)
        tamanho = len(lista_ordenada)

        if tamanho % 2 != 0:
            mediana = lista_ordenada[tamanho // 2]
            print(f"\n\tA lista tem um número ímpar de elementos. A mediana é: {mediana}")
        else:
            meio1 = lista_ordenada[tamanho // 2 - 1]
            meio2 = lista_ordenada[tamanho // 2]
            mediana = (meio1 + meio2) / 2
            print(f"\n\tA lista tem um número par de elementos. A mediana é: {mediana}")

        return mediana
    
    def listarEmOrdem(self):
        '''
        Este método ordena a lista e mostra os
        elementos em ordem crescente
        '''
        limpaTela()     
        print("\n\t=========== LISTA DE IDADES EM ORDEM CRESCENTE ===========\n")

        lista_ordenada = sorted(self.__lista)
        
        for elemento in lista_ordenada:
            print(f"\tIdade: {elemento}")
        pause()
        pass
  
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
        print("\tFalta", (datetime(data_e_hora_atual.year, 12, 31) - data_e_hora_atual).days + 1, "dias para o fim do ano")
    
        print("\n\t======= DATAFRUTA =======")
        print("\t[1] - INCLUIR UM NOME DA LISTA DE NOMES")
        print("\t[2] - INCLUIR SALÁRIO NA LISTA DE SALÁRIOS")
        print("\t[3] - INCLUIR DATA NA LISTA DE DATAS")
        print("\t[4] - INCLUIR IDADE NA LISTA DE IDADES")
        print("\t[5] - PERCORRER AS LISTAS DE NOME E SALÁRIOS")
        print("\t[6] - CALCULAR O VALOR DA FOLHA COM UM REAJUSTE DE 10%")
        print("\t[7] - MODIFICAR OS DIAS DE DATAS ANTERIORES A 2019")
        print("\t[0] - SAIR")
        opcao = input("\tENTRADA -> ")

        if(opcao == "1" or opcao == "2" or opcao == "3" or opcao == "4" or opcao == "5" or opcao == "6" or opcao == "7" or opcao == "0"):
            return opcao
        else:
            limpaTela()
            print("\n\tOps, opção inválida! Tente novamente...")
            pause()

def aplicativo():
    
    nomes = ListaNomes()
    salarios = ListaSalarios()
    datas = ListaDatas()
    idades = ListaIdades()
    
    while True:
        
        opcao = menu()
        
        match opcao:
           
            case "1":
                nomes.entradaDeDados()  
                nomes.listarEmOrdem()
            case "2":
                salarios.entradaDeDados()
                salarios.listarEmOrdem()    
            case "3":
                datas.entradaDeDados()
                datas.listarEmOrdem()
            case "4":
                idades.entradaDeDados()
                idades.listarEmOrdem()
                pass   
            case "5":
                nomes.percorreListaDeNomesESalarios(nomes, salarios)
            case "6":
                salarios.reajustar_Salarios()
            case "7":
                datas.modificar_datas_anteriores_2019() 
            case "0":
                limpaTela()
                print("\n\tObrigado por usar o DataFruta!")
                pause()
                exit()  
            case _:
                limpaTela()
                print("\n\tOps, opção inválida! Tente novamente.")
                pause()
    pass
              
def main():
    aplicativo()
    
if __name__ == "__main__":
    main()
