'''
Exercício 4: Manipulação de variáveis de tipo string e explorando os métodos da classe.

● As variáveis de tipo string possuem uma série de funcionalidades já implementadas e seus caracteres e substrings podem ser acessados 
usando indexação e slicing. Crie um exemplo onde:

● Declare uma variável nome atribuindo a ela seu nome completo;

● Pesquise por funcionalidades já implementadas nas strings e separe em duas variáveis novas seu nome do seu sobrenome;

● Verifique qual das duas novas variáveis antecede a outra na ordem alfabética;

● Verifique a quantidade de caracteres de cada uma das novas variáveis;

● Verifique se seu nome é um palíndromo;
'''

nome = 'Albert Silva de Jesus'

# espaco_indice = nome.index(' ')
# nome = nome[:espaco_indice]
# sobrenome = nome[espaco_indice + 1:]

print(f'\n\tNome completo: ' + nome + '.')

partes = nome.split(' ')

print('\tNome: ' + partes[0] + '.')
print('\tSobrenome: ' + partes[1] + '.')
print(f'\tDepois do sobrenome: {partes[2]} {partes[3]}.')
print('\t='+'=' *50)

print('\tAntecede na ordem alfabética:\n')

if partes[0] < partes[1]:
  print(f'\t{partes[0]} antecede {partes[1]} na ordem alfabética.')
else:
  print(f'\t{partes[1]} antecede {parte[0]} na ordem alfabética.')
  
print('\t='+'=' *50)

print('\tQuantidade de caracteres:\n')
print(f'\tA quantidade de caracteres no nome {partes[0]} é {len(partes[0])}.')
print(f'\tA quantidade de caracteres no sobrenome {partes[1]} é {len(partes[1])}.')
print('\t='+'=' *50)

nome = nome.lower()  # Converter para minúsculas para evitar problemas com maiúsculas e minúsculas
nome = nome.replace(' ', '')  # Remover espaços em branco

print('\tPalíndromo:\n')
if nome == nome[::-1]:
  print(f'\t{partes[0]} {partes[1]} {partes[2]} {partes[3]} não é um palíndromo.')
else:
  print(f'\t{partes[0]} {partes[1]} {partes[2]} {partes[3]} não é um palíndromo.')

print('\t='+'=' *50, '\n')