# Projeto Gestão de OKRs

## 🧠 Estratégia Técnica de Implementação
O back-end deste projeto foi desenvolvido utilizando o Spring Boot como base para construção de uma API REST robusta, com foco em escalabilidade, manutenibilidade e integração eficiente com o front-end (via HTTP/CORS). A aplicação segue o padrão arquitetural MVC (Model-View-Controller) e está dividida em três camadas principais

## 📦 Estrutura e Funcionalidades
- Camada Controller : Responsável por expor a API REST para operações CRUD sobre as entidades . Utiliza anotações do Spring (@RestController, @RequestMapping, etc.) para mapear rotas HTTP e processar requisições dos clientes.

- Camada Service: Contém a lógica de negócio associada às clases. Além das operações padrão (listar, buscar, salvar, atualizar, deletar), essa camada também:

- Atualiza automaticamente a porcentagem de conclusão do ResultadoChave relacionado sempre que uma iniciativa é criada ou removida.

- Implementa lógica de upsert no método put() (atualiza ou cria uma iniciativa com base no ID informado).

- Camada Repository: Utiliza a interface JpaRepository para abstrair o acesso ao banco de dados com métodos prontos para persistência, busca e remoção de dados.

- Entidades: Mapeada como uma entidade JPA, representa uma iniciativa ligada a um ResultadoChave (relacionamento @ManyToOne). Os dados incluem título, descrição e porcentagem de conclusão.

## ✅ Padrões e Boas Práticas aprendidas em sala de aula
Injeção de Dependências com @Autowired

- Requisições RESTful com suporte a CORS para integração com frontend (Next.js/React)

- Uso de Optional para evitar NullPointerException

- Respostas HTTP apropriadas (200 OK, 201 Created, 204 No Content, 404 Not Found)

- Separação de responsabilidades entre as camadas da aplicação





| Aluno |  RA   |
|-------|-------|
|Manuel Padilla       |   10426597    |
|Guilherme       |  10443768     |
|Felipe       |   10443843    |
