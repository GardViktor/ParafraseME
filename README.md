# ParafraseME

Aplicação pessoal de estudo e anotações, desenvolvida em Java com Spring Boot, criada para unir leitura, anotações, paráfrase e exercícios em uma única ferramenta.

O projeto começou como um projeto de estudos e continua evoluindo à medida que aprendo e aplico novos conceitos de desenvolvimento de software. Ao mesmo tempo, ele atende a uma necessidade pessoal: ter uma ferramenta para organizar e reforçar o conhecimento adquirido através da leitura.

<p align="center"><em>Interface da aplicação — screenshots serão adicionados conforme o projeto evolui.</em></p>

---

## Sobre o projeto

A ideia central do ParafraseME é simples:

```
📖 Ler → 📝 Anotar → 💭 Parafrasear → 🧠 Entender → ✏️ Praticar
```

Em vez de simplesmente armazenar informações de um livro, o objetivo é incentivar o aprendizado ativo, explicando o conteúdo com suas próprias palavras.

A aplicação permite cadastrar livros, criar anotações a partir do seu conteúdo e associar exercícios a essas anotações. O projeto foi criado principalmente para uso próprio, o que significa que seu desenvolvimento está diretamente ligado à forma como estudo e faço anotações.

---

## Arquitetura

O projeto começou com uma estrutura em camadas simples:

```
Model → Repository → Service → Controller
```

Conforme novos conceitos foram aprendidos e responsabilidades foram melhor identificadas, a arquitetura evoluiu:

```
Controller → DTO → Mapper → Model → Repository → Database
```

A aplicação também separa os controllers responsáveis pela API REST dos controllers responsáveis pela interface visual.

**API REST**
```
Request → Controller → Service → Mapper → Model → Repository → Database
```

**Interface Web**
```
Browser → Controller UI → Service → Thymeleaf → HTML
```

Um dos principais objetivos do projeto é entender esses níveis de abstração na prática e aprender como as responsabilidades podem ser distribuídas entre diferentes camadas.

---

## Domínio

O domínio atual é baseado em três entidades principais:

```
Livro (1:N) → Anotação (1:N) → Exercício
```

| Entidade | Descrição |
|---|---|
| **Livro** | Representa os livros em estudo. Um livro pode conter múltiplas anotações relacionadas ao seu conteúdo. |
| **Anotação** | Representa o conteúdo estudado de um livro. Pode conter informações como capítulo, página e a explicação escrita com as próprias palavras. |
| **Exercício** | Permite associar exercícios às anotações, transformando o conteúdo estudado em algo que pode ser praticado e revisado. |

---

## Tecnologias

**Backend**
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA
- Hibernate
- Lombok

**Frontend**
- HTML
- Thymeleaf

**Banco de dados**
- H2
- JPA / Hibernate
- Flyway

**Ferramentas**
- Maven
- Git / GitHub
- Postman
- Swagger / OpenAPI
- IntelliJ IDEA

---

## DTOs e Mappers

Conforme o projeto evoluiu, DTOs e Mappers foram introduzidos para melhorar a separação de responsabilidades. Em vez de expor as entidades diretamente pela API, DTOs são usados para representar os dados trocados entre a aplicação e o cliente.

**Requisição**
```
Request → DTO → Mapper → Entity
```

**Resposta**
```
Entity → Mapper → DTO → Response
```

Esse foi um dos conceitos introduzidos no projeto como parte do processo de aprendizado.

---

## Banco de dados

O projeto usa H2 como banco de dados durante o desenvolvimento, com JPA/Hibernate cuidando do mapeamento objeto-relacional.

```
Livro
 └── Anotações
      └── Exercícios
```

O Flyway é usado para versionar as mudanças no banco de dados, permitindo que o schema evolua junto com a aplicação.

---

## API REST

A aplicação expõe uma API REST para interação com seus recursos. A API foi testada com Postman, permitindo validar as requisições de forma independente da interface visual. `ResponseEntity` é usado para trabalhar com respostas HTTP e códigos de status.

**Exemplo — recurso Livro**

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/livros/criar` | Cria um novo livro |
| `GET` | `/livros/listar` | Lista todos os livros |
| `GET` | `/livros/listar/{id}` | Busca um livro por ID |
| `PUT` | `/livros/alterar/{id}` | Atualiza um livro |
| `DELETE` | `/livros/deletar/{id}` | Remove um livro |

---

## Interface Web

A interface visual é construída com HTML e Thymeleaf. A camada web é separada dos controllers REST, permitindo que a mesma aplicação forneça tanto uma API quanto uma interface visual.

*Screenshots serão adicionados aqui conforme a interface evoluir.*

---

## Processo de desenvolvimento

O processo de desenvolvimento também faz parte da experiência de aprendizado. As funcionalidades são desenvolvidas em branches separadas e integradas à branch principal após a implementação.

```
main
 ├── feature/...
 ├── feature/...
 └── feature/...
```

O projeto também utiliza:

- **Branches** — desenvolvimento isolado de funcionalidades
- **Issues** — organização de tarefas e funcionalidades
- **Milestones** — agrupamento de tarefas em estágios de desenvolvimento
- **Merge** — integração de funcionalidades concluídas
- **Commits padronizados** — manutenção do histórico organizado

Git e GitHub, portanto, não são usados apenas como ferramentas de versionamento, mas também como parte das práticas de desenvolvimento aprendidas ao longo do projeto.

---

## Aprendizado através do projeto

ParafraseME é, antes de tudo, um projeto de estudos. Sua arquitetura não foi definida uma única vez e deixada estática — ela vem evoluindo conforme novos conceitos são aprendidos e aplicados.

Alguns dos conceitos explorados no projeto:

- Arquitetura em camadas
- Abstração e separação de responsabilidades
- DTOs e Mappers
- `ResponseEntity`
- APIs REST
- Spring Boot / Spring Data JPA / Hibernate
- Relacionamentos entre entidades
- H2 e Flyway (versionamento de banco de dados)
- Thymeleaf
- Git e GitHub (branches, merge, issues, milestones)
- Padronização de commits

O objetivo não é apenas implementar funcionalidades, mas entender por que certas abordagens são usadas, quais problemas elas resolvem e como a arquitetura muda conforme a aplicação cresce.

---

## Por que ParafraseME?

O nome vem da ideia central do projeto:

> Não apenas leia. Explique com suas próprias palavras.

ParafraseME nasceu de uma necessidade pessoal de organizar anotações e reforçar o que aprendo através da leitura. Por isso, o projeto tem dois propósitos:

**Ferramenta de estudo pessoal** + **Laboratório de desenvolvimento de software**

É um projeto onde posso estudar, experimentar, errar, refatorar e aplicar novos conceitos enquanto construo algo que eu realmente uso no dia a dia.

A aplicação evolui junto com meu conhecimento.

*Um projeto construído para aprender desenvolvendo.*
