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
