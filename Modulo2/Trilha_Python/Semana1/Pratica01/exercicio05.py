'''
Exercício 5: Manipulação de variáveis de ponto flutuante, explorando as características e os limites.

● Durante a aula foi apresentado o tipo de dado que permite representar um subconjunto dos números de ponto flutuante. Sobre estes tipos 
de dados:

● Demonstre como funcionam os operadores aritméticos e aritméticos compostos em Python;

● Utilizando o operador de exponenciação mostre qual a maior e a menor potência de 2 que pode ser representada com variáveis de ponto 
flutuante.

● As variáveis numéricas são imutáveis. Demonstre com exemplos as implicações desta afirmação;

● Verifique quais métodos estão disponíveis para as variáveis de ponto flutuante;

'''

import sys
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
print('\n\t='+'=' *70)
print('\t+ - * // % Operadores Aritméticos em Python + - * // %')

# Adição
a = 5.5
b = 3.5
print('\n\tAdição: {} + {} = {}'.format(a, b, a + b))

# Subtração
print('\tSubtração: {} - {} = {}'.format(a, b, a - b))

# Multiplicação
print('\tMultiplicação: {} x {} = {}'.format(a, b, a * b))

# Divisão
print('\tDivisão: {} / {} = {:.2f}'.format(a, b, a / b))

# Exponenciação
print('\tExponenciação: {} ^ {} = {}'.format(a, b, a**b))

# Divisão inteira
print('\tDivisão inteira: {} // {} = {}'.format(a, b, a // b))

# Resto da divisão
print('\tResto da divisão: {} % {} = {}'.format(a, b, a % b))

print('\t='+'=' *70)

pause()
limpaTela()
print('\t+= -= *= /= Operadores Aritméticos Compostos em Python += -= *= /=')

# Adição com atribuição
x = 10.5
y = 3.5
print('\n\tx = {}\n\ty = {}\n\tx += y'.format(x, y))
x += y
print('\tAdição com atribuição {}'.format(x))

# Subtração com atribuição
print('\n\tx = {}\n\ty = {}\n\tx -= y'.format(x, y))
x -= y
print('\tSubtração com atribuição {}'.format(x))

# Multiplicação com atribuição
print('\n\tx = {}\n\ty = {}\n\tx *= y'.format(x, y))
x *= y
print('\tMultiplicação com atribuição {}'.format(x))

# Divisão com atribuição
print('\n\tx = {}\n\ty = {}\n\tx /= y'.format(x, y))
x /= y
print('\tDivisão com atribuição {:.1f}'.format(x))
print('\t='+'=' *70)

pause()
limpaTela()
print('\tMaior e menor potência de 2 representável com variáveis de ponto flutuante:\n')
menor_potencia = 2.0 ** sys.float_info.min_exp  # Retorna o menor expoente que pode ser representado
maior_potencia = 2.0 ** sys.float_info.max_10_exp  # Maior expoente base 10 representável

print(f"\tA menor potência de 2 representável: {menor_potencia}")
print(f"\tA maior potência de 2 representável: {maior_potencia}")
print('\t='+'=' *70)

pause()
limpaTela()
print('\tImutabilidade Númerica em Python:')

# Atribuição de um valor float a uma variavel
numImult_1 = 2.5
numImult_2 = numImult_1
print('\n\tValores das variaveis:\n\tnumImult_1 = {} e numImult_2 = {}'.format(numImult_1, numImult_2))

numImult_1 += 1
print('\n\tApós a variavel numImult_1 ser incrementada: {}'
      '\n\tEnquanto a variavel numImult_2 continua igual a {}'.format(numImult_1, numImult_2))
print('\t='+'=' *70)

pause()
limpaTela() 
print('\tMetodos disponiveis em variaveis inteiras:')

print('\n\ttype(): Retorna o tipo do objeto: {}'.format(type(numImult_1)))
print('\t.real e .imag: Números complexos {} e número imaginario {}'.format(numImult_1.real, numImult_1.imag))
print('\tid(): Retorna o identificador do objeto: {}'.format(id(numImult_1)))
print('\tint(): Retorna o valor inteiro do objeto: {}'.format(int(numImult_1)))
print('\tfloat(): Retorna o valor float do objeto: {}'.format(float(numImult_1)))
print('\tcomplex(): Retorna o valor complexo do objeto: {}'.format(complex(numImult_1)))
print('\tbool(): Retorna o valor booleano do objeto: {}'.format(bool(numImult_1)))
print('\tstr(): Retorna o valor string do objeto: {}'.format(str(numImult_1)))
print('\tabs(): Retorna o valor absoluto do objeto: {}'.format(abs(numImult_1)))
print('\tpow(): Retorna o valor do objeto elevado a um valor: {}'.format(pow(numImult_1, 2)))
print('\tdivmod(): Retorna o valor da divisão e o resto da divisão do objeto: {}'.format(divmod(numImult_1, 2)))
print('\t='+'=' *70)