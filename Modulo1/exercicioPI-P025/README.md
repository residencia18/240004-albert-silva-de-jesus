# AtividadePI-P025

## Exercício 2: Desenvolvimento de uma Rede Social Baseada no TwitterVocê foi contratado para desenvolver uma rede social baseada no Twitter (agora X). A rede social terá funcionalidades básicas, como a capacidade de criar perfis de usuário, postar tweets (apenas texto até 255 caracteres), seguir outros usuários e receber feeds de tweets de pessoas que você segue.Funcionalidades Principais:
### • Os usuários podem se registrar na rede social, especificando um nome de usuário único e seu nome real.
### • Os usuários podem postar tweets.
### • Os usuários podem seguir outros usuários.
### • Os usuários podem ver um feed de tweets dos usuários que estão seguindo.
### • Os tweets devem ser exibidos em ordem cronológica, com os mais recentes no topo.
### • Os dados devem ser salvos e recuperados em arquivo.

## Classes a serem Criadas:
### Usuario:
### A classe Usuario representará os usuários da rede social. Cada usuário terá um nome de usuário único, um nome real, uma lista de seguidores e uma lista de pessoas que ele segue. Atributos:

### • nome_usuario (string) - Nome de usuário único.
### • nome (string) - Nome real do usuário.
### • seguidores (lista de objetos Usuario) - Lista de usuários que seguem este usuário.
### • seguindo (lista de objetos Usuario) - Lista de usuários que este usuário está seguindo.Métodos:
### • postar_tweet(tweet) - Permite que o usuário poste um tweet.
### • seguir(usuario) - Permite que o usuário comece a seguir outro usuário.
### • receber_feed() - Retorna uma lista de tweets dos usuários que ele está seguindo.
## Tweet:
### A classe Tweet representará os tweets postados pelos usuários. Cada tweet terá um autor, um conteúdo de texto e uma data de criação.
## Atributos:
### • autor (objeto Usuario) - O usuário que postou o tweet.
### • conteudo (string) - O texto do tweet.
### • data_criacao (data e hora) - A data e hora em que o tweet foi postado.
## RedeSocial:
### A classe RedeSocial será responsável por gerenciar todos os usuários e tweets na rede social.
## Atributos:
### • usuarios (lista de objetos Usuario) - Lista de todos os usuários registrados na rede social.
### • tweets (lista de objetos Tweet) - Lista de todos os tweets postados na rede social.
## Métodos:
### • registrar_usuario(nome_usuario, nome) - Permite que um novo usuário seja registrado na rede social.
### • buscar_usuario(nome_usuario) - Retorna um objeto Usuario com base no nome de usuário.
### • listar_usuarios() - Retorna uma lista de todos os usuários registrados.
### • listar_tweets() - Retorna uma lista de todos os tweets postados na rede social.
### Esta é uma descrição simplificada do problema que envolve a criação de uma rede social baseada no Twitter. A implementação real envolveria detalhes técnicos, como persistência de dados em um sistema gerenciar de banco de dados, interfaces de usuário, segurança e muito mais. No entanto, essa descrição fornece uma base sólida para começar a criar as classes e a lógica por trás dessa rede social em C++ usando os conceitos de programação orientada a objetos.

