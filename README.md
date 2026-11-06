
## Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- Postman
- Visual Studio Code

## Funcionalidades

- Cadastrar novos livros.
- Listar todos os livros cadastrados.
- Buscar livros pelo ID.
- Retornar HTTP 404 para livros não encontrados.
- Listar apenas livros disponíveis (desafio adicional).
- Armazenar os dados no banco H2 com persistência em arquivo.

## Estrutura do projeto

```text
api-biblioteca/
├── src/
│   └── main/
│       ├── java/
│       │   └── br/edu/ifpi/apibiblioteca/
│       │       ├── controller/
│       │       │   └── LivroController.java
│       │       ├── service/
│       │       │   └── LivroService.java
│       │       ├── repository/
│       │       │   └── LivroRepository.java
│       │       ├── model/
│       │       │   └── Livro.java
│       │       └── ApiBibliotecaApplication.java
│       └── resources/
│           └── application.properties
├── postman/
│   └── API-Biblioteca.postman_collection.json
├── .mvn/
├── .gitignore
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## Arquitetura

O projeto segue uma arquitetura organizada em camadas:

- **Model:** representa a entidade Livro.
- **Repository:** realiza as operações de acesso ao banco de dados utilizando JpaRepository.
- **Service:** implementa as operações e regras da aplicação.
- **Controller:** recebe as requisições HTTP e disponibiliza os endpoints REST.

## Entidade Livro

| Atributo | Tipo | Descrição |
|---|---|---|
| id | Long | Identificador gerado automaticamente |
| titulo | String | Título do livro |
| autor | String | Nome do autor |
| anoPublicacao | Integer | Ano de publicação |
| disponivel | Boolean | Indica se o livro está disponível |

## Endpoints da API

URL base: `http://localhost:8080`

| Método | Endpoint | Descrição | Status esperado |
|---|---|---|---|
| POST | `/livros` | Cadastrar livro | 201 Created |
| GET | `/livros` | Listar todos os livros | 200 OK |
| GET | `/livros/{id}` | Buscar livro pelo ID | 200 OK |
| GET | `/livros/9999` | Consultar ID inexistente | 404 Not Found |
| GET | `/livros/disponiveis` | Listar livros disponíveis | 200 OK |

### Exemplo de cadastro

**POST /livros**

```json
{
  "titulo": "Introdução à Programação",
  "autor": "Ana Silva",
  "anoPublicacao": 2022,
  "disponivel": true
}
```

O identificador do livro é gerado automaticamente.

## Banco de dados H2

A aplicação utiliza o banco de dados H2 em modo arquivo, garantindo a persistência dos registros após o encerramento e a reinicialização da aplicação.

Configuração no `application.properties`:

```properties
spring.datasource.url=jdbc:h2:file:./data/bibliotecadb
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

**Console H2:** `http://localhost:8080/h2-console`

**Consulta de todos os livros:**

```sql
SELECT * FROM LIVROS;
```

**Consulta de livros disponíveis:**

```sql
SELECT * FROM LIVROS WHERE DISPONIVEL = TRUE;
```

## Como executar o projeto

### Pré-requisitos

- JDK 21 instalado.
- Git para clonar o repositório.
- Postman para testar os endpoints.

### Executar a aplicação

Abra o terminal na pasta principal do projeto.

No Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

No Linux ou macOS:

```bash
./mvnw spring-boot:run
```

Após a inicialização, a aplicação estará disponível em:

`http://localhost:8080`

## Testes com Postman

O projeto acompanha uma Collection do Postman contendo as requisições utilizadas nos testes da API.

**Arquivo:** `postman/API-Biblioteca.postman_collection.json`

Foram realizados testes de cadastro, listagem, busca por ID, tratamento de erro HTTP 404 e listagem de livros disponíveis.

## Teste de persistência

Para verificar a persistência dos dados, foram realizados os seguintes procedimentos:

1. Cadastro de três livros no banco H2.
2. Consulta dos livros cadastrados por meio do endpoint `GET /livros`.
3. Encerramento da aplicação Spring Boot.
4. Reinicialização da aplicação.
5. Nova consulta ao endpoint `GET /livros`.
6. Verificação dos registros no console H2.

**Resultado:** os três livros permaneceram cadastrados após reiniciar a aplicação, confirmando o funcionamento da persistência em arquivo.

## Desafio adicional

Foi implementado o endpoint:

`GET /livros/disponiveis`

Esse endpoint utiliza um método de consulta do Spring Data JPA para retornar somente os livros cujo atributo `disponivel` seja `true`.