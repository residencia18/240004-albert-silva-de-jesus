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
print('\n\t='+'=' *60)
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

print('\t='+'=' *60)

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

print('\t='+'=' *60)