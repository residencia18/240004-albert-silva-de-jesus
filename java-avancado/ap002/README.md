<h1 align="center">Documentação da API - ResidenciaTic18</h1>

## Banco de Dados

![Imagem do banco de dados da avaliação](DBA.png)

## Autenticação

- **Autenticar Usuário**
  - Endpoint: `/api/v1/auth`
  - Método: `POST`

## Usuários

- **Criar Usuário**
  - Endpoint: `/api/v1/usuarios`
  - Método: `POST`
  
- **Obter Usuário por ID**
  - Endpoint: `/api/v1/usuarios/{id}`
  - Método: `GET`
  
- **Atualizar Senha**
  - Endpoint: `/api/v1/usuarios/{id}`
  - Método: `PATCH`
  
- **Listar Todos os Usuários**
  - Endpoint: `/api/v1/usuarios`
  - Método: `GET`

## Recuperação de Senha

- **Redefinir Senha por Username(e-mail)**
  - Endpoint: `/api/v1/password-recovery`
  - Método: `POST`

![Imagem da requisição GET para envio de e-mail](Get-email.png)

## Redefinição de Senha

- **Atualizar Senha por Token**
  - Endpoint: `/api/v1/password-reset/{token}`
  - Método: `PATCH`

![Imagem da requisição PATCH para alterar a senha](Patch-alterar-senha.png)