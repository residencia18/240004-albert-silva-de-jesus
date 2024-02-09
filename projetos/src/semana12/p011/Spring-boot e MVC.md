## 1. Explique brevemente os conceitos fundamentais do padrão de arquitetura MVC (Model-View-Controller). Descreva o papel de cada componente (Model, View e Controller) e como eles interagem entre si.

- **Model (Modelo):** Responsável pela lógica de negócios e pelo armazenamento de dados da aplicação. Ele representa o estado da aplicação e fornece métodos para manipular esses dados.
- **View (Visão):** É responsável pela apresentação dos dados ao usuário. Ela exibe a interface do usuário e interage com o usuário, enviando comandos e recebendo entradas.
- **Controller (Controlador):** Recebe as entradas do usuário da View, processa essas entradas com base na lógica de negócios definida no Model e atualiza a View conforme necessário.

- **A interação entre o Controlador, a Visão e o Modelo segue o seguinte fluxo:**

  1. O usuário interage com a View.
  2. A View envia os dados da interação para o Controlador.
  3. O Controlador processa os dados e atualiza o Modelo conforme necessário.
  4. O Modelo notifica a View sobre as alterações.
  5. A View atualiza a interface do usuário com base nas alterações no Modelo.

## 2. Quais são as principais vantagens de usar o padrão MVC em uma aplicação web? Dê exemplos de situações em que a separação de responsabilidades oferecida pelo MVC é benéfica.

- Separação de responsabilidades: Cada componente tem uma função clara, o que facilita a manutenção e o desenvolvimento paralelo.
- Reutilização de código: A lógica de negócios pode ser reutilizada com diferentes interfaces de usuário.
- Facilidade de teste: Os componentes podem ser testados de forma independente, facilitando a identificação e correção de erros.
- Exemplo de benefício: Se um designer precisa alterar a aparência de uma página da web, ele pode modificar a View sem afetar o Controller ou o Model.

## 3. Crie um cenário hipotético de uma aplicação web simples e mostre como esta aplicação funciona se implementada utilizando MVC.

- Uma aplicação de blog: O Model gerencia os posts, comentários e usuários. O Controller processa as solicitações dos usuários, como criar um novo post ou adicionar um comentário. A View exibe os posts, comentários e formulários de criação de post para os usuários.

## 4. Como o MVC facilita a manutenção e a escalabilidade de um projeto? Dê exemplos práticos de como a estrutura do MVC contribui para esses objetivos.

- Facilita a manutenção: Como cada componente tem uma função clara, é mais fácil identificar e corrigir problemas. Por exemplo, se houver um problema na apresentação dos dados, é provável que o problema esteja na View. Se houver um problema na lógica de negócios, é provável que o problema esteja no Modelo ou no Controlador. Isso facilita a identificação e correção de erros. Além disso, como os componentes são independentes, é possível atualizar ou substituir um componente sem afetar os outros. Por exemplo, se for necessário atualizar a interface do usuário, isso pode ser feito sem alterar a lógica de negócios ou o armazenamento de dados. 
- Facilita a escalabilidade: Como a lógica de negócios está separada do código de apresentação, é mais fácil adicionar novas funcionalidades ou interfaces de usuário sem afetar o restante do sistema. Por exemplo, se for necessário adicionar uma API REST para acessar os dados da aplicação, isso pode ser feito sem alterar o Modelo ou a View existentes.

## 5. O que é o Spring Boot e quais são seus principais objetivos? Explique como o Spring Boot simplifica o desenvolvimento de aplicativos Java.

- O Spring Boot é um framework para desenvolvimento de aplicativos Java que visa simplificar o processo de configuração e desenvolvimento. Seus principais objetivos são:

  - Simplificar a configuração: O Spring Boot fornece configurações padrão para muitos componentes comuns, o que reduz a quantidade de configuração necessária para iniciar um novo projeto.
  - Facilitar o desenvolvimento: O Spring Boot fornece um conjunto de ferramentas e bibliotecas que facilitam o desenvolvimento de aplicativos Java, como suporte a anotações, injeção de dependência e testes automatizados.
  - Promover boas práticas: O Spring Boot incentiva o uso de boas práticas de desenvolvimento, como a separação de responsabilidades, a modularização do código e a reutilização de componentes. Isso facilita a manutenção e a escalabilidade dos aplicativos. 

## 6. Pesquise sobre o ciclo de vida de uma aplicação Spring Boot e o descreva aqui, incluindo as fases de inicialização, configuração e execução. Destaque a importância de anotações.


## 7. Você conhece outros Frameworks para desenvolvimento de APIs Rest como o Spring Boot? Pesquise sobre alguns (inclusive de outras linguagens) e fale um pouco sobre eles.

## 8. Uma aplicação desenvolvida com Spring Boot pode ser back end de aplicações front end desenvolvidas com outras plataformas que não sejam Java? Que relação há entre isto e o protocolo https?