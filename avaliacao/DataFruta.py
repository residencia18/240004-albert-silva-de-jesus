import os
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

# Métodos ok
class ListaNomes(AnaliseDados):
    
    def __init__(self):
        super().__init__(type("String"))
        self.__lista = []        

    def entradaDeDados(self):
        '''
        Este método pergunta ao usuários quantos
        elementos vão existir na lista e depois
        solicita a digitação de cada um deles.
        '''
        limpaTela() 
        print("\n\t=========== CADASTRO DE NOMES ===========\n")
        
        quantElementos = int(input("\tQuantos elementos vão existir na lista: "))
        
        for i in range(quantElementos):
            elemento = input("\n\tDigite o elemento {}: ".format(i + 1))
            self.__lista.append(elemento)
        pass
        
        limpaTela()
        print("\n\t=========== LISTA DE NOMES ===========\n")
        
        for i in range(quantElementos):
            print("\tNome {}: {}".format(i + 1, self.__lista[i]))
        pass
        pause()

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
        
        quantElementos = int(input("\tQuantos elementos vão existir na lista: "))
        
        for i in range(quantElementos):
            try:
                print("\n\tDigite o elemento {}:".format(i + 1))
                dia = int(input("\tDia: "))
                mes = int(input("\tMês: "))
                ano = int(input("\tAno: "))
                data = Data(dia, mes, ano)
                self.__lista.append(data)
                print(f"\n\tData válida: {data}")
            
            except ValueError as e:
                print(f"\n\tErro: {e}")
        pass
    
        limpaTela()
        print("\n\t=========== LISTA DE DATAS ===========\n")
        
        for i in range(quantElementos):
            print("\tData {}: {}".format(i + 1, self.__lista[i]))
        pass
        pause()
    
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
        
        quantElementos = int(input("\tQuantos elementos vão existir na lista: "))
        
        for i in range(quantElementos):
            elemento = float(input("\n\tDigite o elemento {}: ".format(i + 1)))
            self.__lista.append(elemento)
            
        limpaTela()
        print("\n\t=========== LISTA DE SALÁRIOS ===========\n")
        
        for i in range(quantElementos):
            print("\tSalário {}: {:.2f}".format(i + 1, self.__lista[i]))  
        pass
        pause()

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
    
    def __str__(self):
        pass

class ListaIdades(AnaliseDados):
    
    def __init__(self):
        super().__init__(type(int))
        self.__lista = []        
    
    def entradaDeDados(self):
        '''
        Este método pergunta ao usuários quantos
        elementos vão existir na lista e depois
        solicita a digitação de cada um deles
        '''
        limpaTela() 
        print("\n\t=========== CADASTRO DE IDADES ===========\n")
        
        quantElementos = int(input("\tQuantos elementos vão existir na lista: "))
        
        for i in range(quantElementos):
            elemento = int(input("\n\tDigite o elemento {}: ".format(i + 1)))
            self.__lista.append(elemento)
        pass
        
        limpaTela() 
        print("\n\t=========== LISTA DE IDADES ===========\n")
        
        for i in range(quantElementos):
            print("\tIdade {}: {}".format(i + 1, self.__lista[i]))
        pass
        pause() 
    
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

    def __str__(self):
     
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

def main():
    
    nomes = ListaNomes()
    datas = ListaDatas()
    salarios = ListaSalarios()
    idades = ListaIdades()

    # listaListas = [nomes, datas, salarios, idades]

    # for lista in listaListas:
    #     lista.entradaDeDados()
    #     lista.mostraMediana()
    #     lista.mostraMenor()
    #     lista.mostraMaior()

if __name__ == "__main__":
    main()
