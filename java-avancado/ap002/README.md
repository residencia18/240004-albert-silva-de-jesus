<h1 align="center">Documentação da API - ResidenciaTic18</h1>

## Park Manager API

A Park Manager API foi desenvolvida para oferecer uma solução abrangente de gestão de estacionamento. Até o momento, a API oferece algumas funcionalidades, incluindo registro de usuários, autenticação, recuperação de senha, gerenciamento de permissões de acesso e documentação no Swagger. Com endpoints simples e seguros, a API facilita operações essenciais de autenticação e gerenciamento de contas de usuário.

## Banco de Dados

![Imagem do banco de dados da avaliação](DBA.png)

Endpoints disponíveis:

## Usuários

- **Criar Usuário**
  - Endpoint: `/api/v1/usuarios`
  - Método: `POST`

Requisição (JSON):
```json
{
  "username": "email",
  "password": "password"
}
```

- **Obter Usuário por ID**

  - Endpoint: `/api/v1/usuarios/{id}`
  - Método: `GET`

  ...

- **Atualizar Senha**
  - Endpoint: `/api/v1/usuarios/{id}`
  - Método: `PATCH`

Requisição (JSON):
```json
{
  "currentpassword": "JAVA!@#ResTIc18",
  "newPassword": "123456AsJ@",
  "confirmPassword": "123456AsJ@"
}
```

- **Listar Todos os Usuários**
  - Endpoint: `/api/v1/usuarios`
  - Método: `GET`

## Autenticação

- **Autenticar Usuário**
  - Endpoint: `/api/v1/auth`
  - Método: `POST`

Requisição (JSON):
```json
{
  "username": "email",
  "password": "password"
}
```

Resposta de Sucesso (Código: 200 OK):
```json
{
  "token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDE5MXRhZHNzYWowMDI2QGlmYmEuZWR1LmJyIiwiaWF0IjoxNzE1NTU0NzAwLCJleHAiOjE3MTU1NTUwMDAsInJvbGUiOiJBRE1JTiJ9.koMjMKTz6b1MMWxNnKgoOalkGV8RH017P7K303UE2m4"
}
```

## Recuperação de Senha

- **Redefinir Senha por Username(e-mail)**
  - Endpoint: `/api/v1/password-recovery`
  - Método: `POST`

![Imagem da requisição POST para envio de e-mail](Post.png)

## Redefinição de Senha

- **Atualizar Senha por Token**
  - Endpoint: `/api/v1/password-reset/{token}`
  - Método: `PATCH`

![Imagem da requisição PATCH para alterar a senha](Patch-alterar-senha.png)

## Documentação da API no Swagger

Para obter mais detalhes sobre os modelos de dados e os endpoints disponíveis, consulte a documentação da API em http://localhost:8080/docs-park.html. Lá você encontrará informações detalhadas sobre como utilizar cada endpoint, os parâmetros necessários e as respostas esperadas.
