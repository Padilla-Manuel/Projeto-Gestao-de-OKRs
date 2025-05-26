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

## 🧠 Estratégia Técnica de Implementação – Frontend

O frontend do projeto foi desenvolvido com Next.js, utilizando a estrutura de diretórios do app/, com componentes reutilizáveis, rotas dinâmicas e CSS Modules para estilização modular e escalável. A arquitetura prioriza organização, responsividade e fácil manutenção.

# 📘 Documentação Técnica – Frontend (Next.js)

Este frontend foi desenvolvido com **Next.js (estrutura app/)** e integra-se a um backend em Spring Boot para oferecer um sistema completo de **gestão de OKRs (Objectives and Key Results)**.

---

## 📦 Estrutura e Funcionalidades

### 📁 Camada de Páginas (`/app/objetivos/.../page.jsx`)

Responsável por renderizar a interface e consumir os endpoints REST expostos pelo backend.

- `/page.js` – **Home**: lista os objetivos em cards e oferece links para criar, editar e filtrar/remover.
- `/objetivos/page.jsx` – Lista de objetivos renderizada com o componente `CardOKR`.
- `/objetivos/[objetivoId]/page.jsx` – Detalhamento de um Objetivo com seus Resultados-Chave.
- `/objetivos/[objetivoId]/krs/[krId]/page.jsx` – Visualização detalhada de um KR e suas iniciativas.
- `/objetivos/[objetivoId]/krs/[krId]/iniciativas/[iniciativaId]/page.jsx` – Visualiza uma Iniciativa individual.
- `/objetivos/novo/page.jsx` – Formulário para criar Objetivo, KR e Iniciativa ao mesmo tempo.
- `/objetivos/put/page.jsx` – Página para editar Objetivo, KR e Iniciativa.
- `/objetivos/remove/page.jsx` – Confirmação de exclusão de um Objetivo.
- `/objetivos/get/page.jsx` – Listagem geral de Objetivos, KRs e Iniciativas com botão de remoção.

---

### 🧩 Componentes Reutilizáveis (`/components`)

- `BotaoVoltar.jsx` – Botão que utiliza `router.back()` para navegação reversa.
- `BotaoVoltarObjetivos.jsx` – Botão que redireciona para a rota `/objetivos`.
- `CardOKR.jsx` – Componente visual para representar cada objetivo como um card clicável.

---

### ✅ Camada de Serviços (`/services/api.ts`)

Centraliza as chamadas à API REST com funções assíncronas:

- `getObjetivos()` – Lista todos os objetivos.
- `getObjetivoById(id)` – Busca um objetivo pelo ID.
- `getKRById(objetivoId, krId)` – Busca um KR específico.
- `getIniciativaById(objetivoId, krId, iniciativaId)` – Busca uma iniciativa vinculada.

---

### ✅ Estilização

- `page.module.css`: CSS modular, com estilos separados por contexto (home, cards, formulários, dark mode).
- `globals.css`: define variáveis globais de cor, padding, margens e suporte a tema escuro.

---

### ✅ Layout Global

- `layout.js`: aplica fontes `Geist` e `Geist_Mono`, importa `globals.css` e define a estrutura base da aplicação.

---

## ✅ Padrões e Boas Práticas Aplicadas

- Roteamento baseado em arquivos (`/app/` – Next.js 13+)
- Separação entre **componentes** e **páginas**
- `fetch` com `useEffect` para requisições client-side
- Requisições assíncronas com tratamento de erro
- Navegação programática com `router.push()` e `router.back()`
- Dark mode via `prefers-color-scheme`
- Uso de `useState` e renderização condicional
- Formulários controlados com validação e feedback
- CSS Modules com escopo local para evitar conflitos

---

📌 **Este frontend foi planejado para ser altamente modular, responsivo e integrado de forma fluida com um backend RESTful. Ideal para aplicações baseadas em objetivos e metas com múltiplas entidades relacionadas.**

---

# BotaoVoltar.jsx

Este componente é um botão de navegação para aplicações desenvolvidas com **Next.js**. Quando clicado, ele utiliza o hook `useRouter` da biblioteca `next/navigation` para retornar à página anterior no histórico de navegação do usuário, funcionando como um botão "Voltar".

## 📁 Localização
Coloque este componente dentro do seu diretório de componentes (ex: `src/app/components`) para reutilização fácil em múltiplas páginas.

## ✨ Funcionalidades
- Navega de volta para a página anterior com `router.back()`
- Estilizado com CSS modular (`page.module.css`)
- Compatível com `app/` directory do Next.js (`'use client'` habilitado)

## 📦 Importação

import BotaoVoltar from './caminho/para/BotaoVoltar';

# BotaoVoltarObjetivos.jsx

Este componente é um botão de navegação utilizado em aplicações **Next.js**, com a funcionalidade de redirecionar o usuário de volta à **página principal** (ou para a rota de `/objetivos`, se preferido). Ele utiliza o hook `useRouter` de `next/navigation` e aplica estilos via **CSS Modules**.

## 🚀 Funcionalidade
- Redireciona o usuário para a página principal com `router.push('/')`.
- Pode ser facilmente adaptado para redirecionar para `/objetivos` ou outra rota.
- Estilizado usando classes CSS (`botao` e `botaoVoltar`) definidas no arquivo `page.module.css`.

## 💻 Exemplo de Uso

import BotaoVoltarObjetivos from './caminho/para/BotaoVoltarObjetivos';

export default function MinhaPagina() {
  return (
    <>
      <BotaoVoltarObjetivos />
      {/* Outros componentes */}
    </>
  );
}

---

# CardOKR.jsx

Este componente é uma **card interface** para exibir informações de um Objetivo (OKR - Objectives and Key Results) em uma aplicação **Next.js**. Ele apresenta o título, a descrição e a porcentagem de conclusão do objetivo, além de fornecer um botão para acessar a visualização detalhada.

## 🧩 Funcionalidades
- Exibe:
  - Título do objetivo (em caixa alta)
  - Descrição do objetivo
  - Porcentagem de conclusão
- Redireciona o usuário para a página de detalhes do objetivo com um botão "Ver mais".

## 🖼️ Exemplo de visual

<CardOKR objetivo={{
  id: 1,
  titulo: 'Melhorar experiência do usuário',
  descricao: 'Refatorar interface e coletar feedbacks dos usuários.',
  porcentagemConclusao: 65
}} />

---

# page.jsx – Página de Objetivos

Este arquivo define a página principal da rota `/objetivos` de uma aplicação **Next.js**, responsável por **listar todos os Objetivos (OKRs)** recuperados do backend e exibi-los com uso de componentes visuais reutilizáveis.

## 🚀 Funcionalidade

- Busca a lista de objetivos do backend utilizando a função `getObjetivos()` via `useEffect`.
- Renderiza os objetivos em formato de cards com o componente `CardOKR`.
- Oferece navegação de retorno à página principal com `BotaoVoltarObjetivos`.

## 🔧 Tecnologias e Hooks utilizados

- `useState` e `useEffect` do **React** para gerenciamento de estado e efeito colateral.
- `getObjetivos()` de `../services/api` para obter dados da API.
- Componente reutilizável `CardOKR` para exibição individual dos objetivos.
- Componente `BotaoVoltarObjetivos` para navegação.

---

# page.jsx – Página de Detalhamento de Objetivo

Este arquivo implementa a **página dinâmica de detalhamento de um Objetivo** na aplicação Next.js, acessada por meio da rota `/objetivos/[objetivoId]`. Ele exibe informações completas do objetivo, incluindo progresso e os resultados-chave (KRs) associados, com navegação para páginas específicas de cada KR.

## 📌 Funcionalidades

- Carregamento assíncrono do objetivo pelo `objetivoId` via função `getObjetivoById()`.
- Exibição de:
  - Título e descrição do objetivo
  - Porcentagem de conclusão com **barra de progresso**
  - Lista de Resultados-Chave (KRs) vinculados, com botões navegáveis
- Navegação de retorno utilizando o componente `BotaoVoltar`.

## 🔧 Tecnologias Utilizadas

- `async function` com `getObjetivoById` para requisição de dados no server-side
- Estilização via `CSS Modules` (`page.module.css`)
- Navegação com `next/link`
- Componente `BotaoVoltar` reutilizável para retornar à página anterior

## 💡 Destaques Visuais

- **Barra de progresso dinâmica** baseada na porcentagem de conclusão do objetivo

---

# page.jsx – Página de Detalhamento de Resultado-Chave (KR)

Este componente renderiza a **visualização detalhada de um Resultado-Chave (KR)** associado a um Objetivo específico, acessado por meio da rota dinâmica `/objetivos/[objetivoId]/krs/[krId]`. Ele também exibe todas as **Iniciativas vinculadas** ao KR.

## 🚀 Funcionalidades

- Carrega os dados do KR de forma assíncrona via `getKRById(objetivoId, krId)`.
- Exibe:
  - Descrição, meta e progresso do KR
  - **Barra de progresso visual**
  - Lista de iniciativas vinculadas ao KR com links navegáveis
- Botão de retorno à página anterior com `BotaoVoltar`.

## 🔧 Tecnologias Utilizadas

- `async/await` com carregamento de dados de API
- `use params` via `Next.js` para extrair `objetivoId` e `krId`
- `next/link` para navegação entre páginas
- Estilização com `CSS Modules` (`page.module.css`)
- Componente `BotaoVoltar` para navegação simples

##📦 Dependências
getKRById (API de serviços)

next/link

page.module.css

BotaoVoltar

---

# page.jsx – Página de Detalhamento de Iniciativa

Este componente representa a **página de visualização detalhada de uma Iniciativa**, vinculada a um Resultado-Chave (KR) específico de um Objetivo. A página é acessada por meio da rota dinâmica aninhada:

## 🧩 Funcionalidades

- Busca assíncrona dos dados da iniciativa por meio da função `getIniciativaById()`.
- Exibe:
  - Título e descrição da iniciativa
  - Porcentagem de conclusão
  - **Barra de progresso visual**
- Navegação de retorno com o componente `BotaoVoltar`.

## 🛠️ Tecnologias Utilizadas

- `async/await` com dados carregados via servidor
- Extração de parâmetros da URL com `params`
- Estilização com `CSS Modules` (`page.module.css`)
- Navegação com componente reutilizável `BotaoVoltar`

## 📊 Barra de Progresso

A porcentagem de progresso da iniciativa é exibida tanto em texto quanto graficamente

---

# page.jsx – Página de Listagem e Remoção de Objetivos

Esta página implementa uma visualização detalhada de todos os Objetivos (OKRs), incluindo seus Resultados-Chave (KRs) e respectivas Iniciativas. Também permite a **remoção de objetivos** diretamente via interface, integrando com o backend RESTful da aplicação.

## 🚀 Funcionalidades

- Busca e exibe todos os Objetivos da API (`GET /api/objetivos`)
- Renderiza:
  - Título e descrição do objetivo
  - Lista de Resultados-Chave com suas metas
  - Lista de Iniciativas de cada KR
- Permite **remover um objetivo** via botão "Deletar" (`DELETE /api/objetivos/:id`)
- Navegação com botão de retorno (`BotaoVoltarObjetivos`)

## 📦 Requisições HTTP

- `GET http://localhost:8080/api/objetivos` – para buscar todos os objetivos
- `DELETE http://localhost:8080/api/objetivos/{id}` – para deletar um objetivo específico

---

# page.jsx – Página de Criação de Novo Objetivo

Este componente representa a **interface de formulário para criação de um novo Objetivo**, incluindo um Resultado-Chave (KR) e uma Iniciativa inicial, em um sistema de gestão de OKRs com Next.js.

## ✨ Funcionalidades

- Permite cadastrar:
  - Um novo Objetivo (com título e descrição)
  - Um Resultado-Chave (com descrição e meta)
  - Uma Iniciativa associada ao KR (com título e descrição)
- Submete os dados via `POST` para a API:

---

# page.jsx – Página de Edição de Objetivo, KRs e Iniciativas

Esta página permite ao usuário editar um Objetivo existente, bem como atualizar seus Resultados-Chave e respectivas Iniciativas. É parte do frontend de uma aplicação Next.js integrada com uma API REST.

## ✨ Funcionalidades

- Busca e lista todos os Objetivos cadastrados.
- Permite selecionar um Objetivo para edição.
- Edita os seguintes campos:
  - Título e descrição do Objetivo
  - Descrição e meta de cada Resultado-Chave (KR)
  - Título e descrição de cada Iniciativa
- Envia atualizações para a API:
  - `PUT /api/objetivos/:id`
  - `PUT /api/resultados-chaves/:id`
  - `PUT /api/iniciativas/:id`
- Redireciona para a listagem após salvar.
- Inclui botão de retorno com `BotaoVoltarObjetivos`.

## 📦 Requisições

- `GET /api/objetivos` – lista todos os objetivos
- `GET /api/objetivos/:id` – busca dados completos do objetivo selecionado
- `PUT /api/objetivos/:id` – atualiza objetivo
- `PUT /api/resultados-chaves/:id` – atualiza KR
- `PUT /api/iniciativas/:id` – atualiza Iniciativa

## 🧠 Lógica de Atualização

- O objetivo é atualizado com `handleSubmitObjetivo`.
- Cada KR ou Iniciativa pode ser atualizado individualmente com botões dedicados:

<button onClick={() => handleUpdateIniciativa(ini)}>Salvar Iniciativa</button>
# page.jsx – Página de Remoção de Objetivo

Este componente representa a página de confirmação e execução da **remoção de um Objetivo** (OKR) na aplicação Next.js. Utiliza rota dinâmica para obter o `id` do objetivo e realiza a operação de exclusão via `DELETE`.

## 🧩 Funcionalidades

- Recupera os dados do objetivo a ser removido com `GET /api/objetivos/:id`
- Exibe os dados do objetivo selecionado
- Permite confirmar a remoção com `DELETE /api/objetivos/:id`
- Redireciona automaticamente para `/objetivos` após a exclusão
- Opção de cancelar a operação
- Inclui botão de retorno com `<BotaoVoltarObjetivos />`

## 🔧 Requisições

- `GET http://localhost:8080/api/objetivos/:id` – para carregar o objetivo
- `DELETE http://localhost:8080/api/objetivos/:id` – para excluir o objetivo

## 🧠 Lógica de Confirmação

- O objetivo é carregado no `useEffect` a partir do `id` obtido por `useParams()`.
- Após a confirmação, o método `handleDelete` é chamado

---

# api.ts – Módulo de Acesso à API

Este arquivo contém funções utilitárias para comunicação com o backend da aplicação via **API RESTful**, centralizando as operações de `GET` para Objetivos, Resultados-Chave (KRs) e Iniciativas.

## 📦 Funções Disponíveis

### 🔹 `getObjetivos()`
- **Descrição:** Retorna a lista de todos os objetivos.
- **Requisição:** `GET /api/objetivos`

### 🔹 `getObjetivoById(id: number)`
- **Descrição:** Retorna os dados completos de um objetivo específico.
- **Requisição:** `GET /api/objetivos/:id`

### 🔹 `getKRById(objetivoId: number, krId: number)`
- **Descrição:** Retorna os dados de um Resultado-Chave vinculado a um objetivo.
- **Requisição:** `GET /api/objetivos/:objetivoId/krs/:krId`

### 🔹 `getIniciativaById(objetivoId: number, krId: number, iniciativaId: number)`
- **Descrição:** Retorna os dados de uma iniciativa vinculada a um Resultado-Chave e Objetivo.
- **Requisição:** `GET /api/objetivos/:objetivoId/krs/:krId/iniciativas/:iniciativaId`

## 🔧 Uso nos Componentes

Cada função pode ser importada e utilizada em componentes `page.jsx` ou `tsx` da aplicação para carregamento de dados. Exemplo:

import { getObjetivoById } from '../services/api';

const objetivo = await getObjetivoById(3);

## ✅ Benefícios
Facilita a reutilização de lógica de requisição

Mantém o código mais limpo e organizado

Separa a lógica de dados da lógica de interface

# layout.js – Layout Raiz da Aplicação

Este arquivo define o **layout raiz** (`RootLayout`) da aplicação Next.js, que envolve todas as páginas. Ele também importa fontes do Google via `next/font` e aplica estilos globais via `globals.css`.

## 🧱 Estrutura

### 📄 Fonts
Importa e aplica duas fontes do Google:
- `Geist` (Sans)
- `Geist_Mono` (Monoespaçada)

Elas são associadas a variáveis CSS para uso consistente nos estilos globais:

## 🧠 Finalidade
Aplicar estilos globais e fontes a todas as páginas

Definir a estrutura HTML base (idioma, corpo, estilos)

Centralizar a lógica de layout do projeto
variable: "--font-geist-sans"
variable: "--font-geist-mono"

---

# globals.css – Estilos Globais

Este arquivo define os **estilos globais** da aplicação Next.js. Ele configura o tema visual base (claro e escuro), aplica resets de layout, define variáveis CSS e garante consistência visual em toda a aplicação.

## 🎨 Variáveis de Tema

As cores principais são definidas no `:root`:

:root {
  --background: #969696;
  --foreground: #f8fafc;
}

# page.module.css – Estilos Modulares da Aplicação

Este arquivo define os estilos CSS utilizados em toda a aplicação **Next.js**, organizados por contexto (listagem, criação, edição, remoção, visualização). Ele usa **CSS Modules**, garantindo escopo local e evitando conflitos entre classes.

## 🎨 Principais Categorias de Estilos

## ✅ Estilização Geral

- **Fonte:** usa Segoe UI e cores adaptadas ao modo claro/escuro
- **Reset:** remove margens e paddings padrão
- **Animações:** transições suaves e efeitos hover nos botões e cards

### 🧾 Títulos e Botões

.titulo          /* Título com gradiente e animação de hover */
.botao           /* Botão padrão reutilizável */
.botaoVoltar     /* Estilo específico para botões de voltar */
.botoesContainer /* Layout horizontal dos botões */

---

# page.js – Página Inicial da Aplicação

Este componente implementa a **home page** da aplicação de gestão de OKRs desenvolvida em **Next.js**. A página exibe uma saudação, lista os objetivos cadastrados e oferece botões de navegação para criar, filtrar/remover e editar objetivos.

## 🚀 Funcionalidades

- Carrega dinamicamente os Objetivos da API:
  ```js
  GET http://localhost:8080/api/objetivos
  
## Exibe os objetivos em cartões (card) com:

Título

Descrição

Botão de acesso à página de detalhamento (/objetivos/[id])

## Oferece navegação para:

Criar novo objetivo

Filtrar e remover objetivos

Editar objetivos existentes

Título central com destaque visual

Cards de Objetivos com cores alternadas (card1, card2, card3)

Botões de ação alinhados ao centro

| Aluno |  RA   |
|-------|-------|
|Manuel Padilla       |   10426597    |
|Guilherme       |  10443768     |
|Felipe       |   10443843    |
