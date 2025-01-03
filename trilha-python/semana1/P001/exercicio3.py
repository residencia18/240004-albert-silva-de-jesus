'''
Exercício 3: Manipulação de variáveis de tipo string e explorando o uso de print.

● Os caracteres numéricos aparecem na tabela ASCII, e em outras, numa sequência que começa pelo caractere '0' até o caractere '9'. 
As strings em Python são formadas por conjuntos de caracteres que podem ser tratadas também como valores numéricos. 
Com base nestas afirmações desenvolva um programa em Python que:

● Imprima na tela, utilizando print, cada um dos caracteres numéricos e seu correspondente código numérico. Pesquise como modificar o
comportamento do print para imprimir como caractere e como número.
Exemplo:'0' - 48
'1' - 49
…
'9' - 57

● Modifique o exercício anterior para que a saída imprima também o código numérico em octal e em hexadecimal.

● Acrescente ao código do exercício anterior a possibilidade de ler um caractere qualquer e imprima no mesmo formato do inciso anterior.
Pesquise como ler um valor da entrada padrão.

● Pesquise como trabalha Python os caracteres especiais, ‘ç’ e ‘ã’ por exemplo. Acrescente no código do exercício anterior um exemplo
que demonstra como usar este recurso.

'''

print('\n\tCaracteres numéricos e seus códigos numéricos:\n')

for i in range(10):
  print(f"\t'{str(i)}' - {ord(str(i))}")
print('\t='+'=' *60)
  
print('\tCaracteres numéricos e seus códigos numéricos em octal e hexadecimal:\n') 

for i in range(10):
  char = str(i)
  dec_value = ord(char)
  oct_value = oct(dec_value)
  hex_value = hex(dec_value)
  print(f"\t'{char}' - Decimal: {dec_value}, Octal: {oct_value}, Hexadecimal: {hex_value}")
print('\t='+'=' *60)

caractere = input('\tDigite um caractere qualquer: ')

str(caractere)
dec_value = ord(caractere)
oct_value = oct(dec_value)
hex_value = hex(dec_value)
print(f"\n\t'{caractere}' - Decimal: {dec_value}, Octal: {oct_value}, Hexadecimal: {hex_value}")
print('\t='+'=' *60)

print('\tCaracteres especiais e seus códigos numéricos em octal e hexadecimal:')
caractereEspecial1 = 'ç'
caractereEspecial2 = 'ã'

str(caractereEspecial1)
str(caractereEspecial2)

dec_value1 = ord(caractereEspecial1)
oct_value1 = oct(dec_value1)
hex_value1 = hex(dec_value1)

dec_value2 = ord(caractereEspecial2)
oct_value2 = oct(dec_value2)
hex_value2 = hex(dec_value2)

print(f"\n\t'{caractereEspecial1}' - Decimal: {dec_value1}, Octal: {oct_value1}, Hexadecimal: {hex_value1}")
print(f"\t'{caractereEspecial2}' - Decimal: {dec_value2}, Octal: {oct_value2}, Hexadecimal: {hex_value2}")
print('\t='+'=' *60)