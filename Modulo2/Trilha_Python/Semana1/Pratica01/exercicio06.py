'''
Exercício 6: Manipulando listas

● Dado o seguinte código, e antes de implementar, veja o que será impresso em cada caso:

L = [1,2,3,4,5,6,7,8,9]
print(L[::-1])
print(L[-1::])
print(L[:-1:])
print(L[::-2])
print(L[-2::])
print(L[:-2:])

● Uma forma simplificada de determinar o seu animal no zodiaco chines é apresentada na seguinte tabela:

ano do nascimento % 12 | signo
        0              | macaco
        1              | galo
        2              | cão
        3              | porco
        4              | rato
        5              | boi
        6              | tigre
        7              | coelho
        8              | dragão
        9              | serpente
        10             | cavalo
        11             | carneiro
        
● Descubra qual o signo de um usuário de acordo com seu ano de nascimento.

'''

import os
import platform

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
      
limpaTela()
print('\n\t='+'=' *30)
print('\tManipulando listas:\n')

L = [1,2,3,4,5,6,7,8,9]
print('\t{}'.format(L[::-1]))
print('\t{}'.format(L[-1::]))
print('\t{}'.format(L[:-1:]))
print('\t{}'.format(L[::-2]))
print('\t{}'.format(L[-2::]))
print('\t{}'.format(L[:-2:]))
pause()
limpaTela() 

print('\n\t='+'=' *50)
print('\tSigno de um usuário de acordo com seu ano de nascimento:\n')

anoDeNascimento = int(input('\tDigite o seu ano de nascimento: '))

switch_meses = {
    0: lambda: 'Macaco',
    1: lambda: 'Galo',
    2: lambda: 'Cão',
    3: lambda: 'Porco',
    4: lambda: 'Rato',
    5: lambda: 'Boi',
    6: lambda: 'Tigre',
    7: lambda: 'Coelho',
    8: lambda: 'Dragão',
    9: lambda: 'Serpente',
    10: lambda: 'Cavalo',
    11: lambda: 'Carneiro'
}   

print('\n\tSigno: {}'.format(switch_meses.get(anoDeNascimento % 12, lambda: "Ano de Nascimento Invalido!")()))
print('\t='+'=' *50, '\n')