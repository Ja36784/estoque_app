# Estoque App - Gerenciamento de Estoque

Este é um sistema simples de gerenciamento de estoque, construído utilizando **Spring Boot**, **Spring JPA**, **MySQL**, **Maven**, **Thymeleaf**, e integrado ao **phpMyAdmin** para gerenciar o banco de dados. O sistema permite realizar operações básicas de controle de produtos, como adicionar, listar, remover e atualizar a quantidade de produtos em estoque.

---

## Funcionalidades

- **Adicionar Produto**: Permite adicionar um novo produto com nome, preço e quantidade no estoque.
- **Remover Produto**: Remove um produto específico pelo nome.
- **Atualizar Quantidade**: Atualiza a quantidade em estoque de um produto existente.
- **Listar Produtos**: Exibe todos os produtos cadastrados no estoque.
- **Valor Total do Estoque**: Calcula o valor total de todos os produtos no estoque (preço * quantidade).

---

## Tecnologias Usadas

- **Spring Boot**: Framework para criação da aplicação.
- **Spring Data JPA**: Para interação com o banco de dados.
- **Thymeleaf**: Motor de templates para a criação de páginas HTML dinâmicas.
- **Spring Web**: Para criar endpoints HTTP e construir uma API REST.
- **MySQL**: Banco de dados para armazenamento das informações dos produtos.
- **DevTools**: Para facilitar o desenvolvimento, permitindo hot reload da aplicação.
- **Maven**: Gerenciador de dependências e build do projeto.
- **phpMyAdmin**: Interface web para gerenciamento do banco de dados MySQL.

---

## Pré-requisitos

- **Java 17+** (ou versão superior).
- **Maven**: Para gerenciar dependências e build do projeto.
- **MySQL**: Banco de dados local ou remoto.
- **IDE Eclipse**: Para desenvolvimento e execução da aplicação.

---

## Como Rodar a Aplicação

### Passo 1: Clonar o Repositório

Clone o repositório para a sua máquina local usando o comando abaixo:

```bash
git clone https://github.com/Ja36784/estoque_app
```

### Passo 2: Configurar o Banco de Dados MySQL

1. **Instalar o MySQL**: Caso não tenha o MySQL instalado, faça a instalação. Se já tiver o MySQL, verifique se o servidor está em execução.
2. **Configurar o banco de dados**: No **phpMyAdmin**, crie um banco de dados com o nome `estoque_db` ou altere o nome conforme sua preferência.
3. **Configuração do `application.properties`**: No arquivo `src/main/resources/application.properties`, configure as credenciais de acesso ao seu banco de dados MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco_de_dados?useSSL=false&serverTimezone=UTC
spring.datasource.username=root  # substitua com o seu usuário do MySQL
spring.datasource.password=root  # substitua com a sua senha do MySQL
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
```

4. **Criar a tabela `produto`**: Quando a aplicação for executada pela primeira vez, ela criará automaticamente a tabela `produto` com os campos necessários (`id`, `nome`, `preco`, `quantidade_em_estoque`) no banco de dados configurado.

### Passo 3: Importar o Projeto para o Eclipse

1. Abra o **Eclipse** e selecione **File > Import**.
2. Escolha **Maven > Existing Maven Projects** e clique em **Next**.
3. Selecione o diretório do projeto clonado e clique em **Finish**.

### Passo 4: Rodar o Projeto

1. Na IDE Eclipse, localize o arquivo principal do seu projeto (`EstoqueAppApplication.java`).
2. Clique com o botão direito sobre o arquivo e escolha **Run As > Java Application**.

O **Spring Boot** iniciará o servidor embutido (geralmente na porta 8080).

A aplicação estará disponível em [http://localhost:8080](http://localhost:8080) (ou a porta configurada).

### Passo 5: Acessando o Sistema

O sistema de gerenciamento de estoque pode ser acessado no navegador através da interface do **Thymeleaf**. Você pode acessar as funcionalidades básicas da seguinte forma:

- **Página Inicial**: Lista todos os produtos.
- **Adicionar Produto**: Formulário para adicionar novos produtos.
- **Remover Produto**: Remover produtos existentes através de seu nome.
- **Atualizar Quantidade**: Atualizar a quantidade de um produto.
- **Valor Total**: Exibir o valor total do estoque.

### Passo 6: Hot Reload (DevTools)

A aplicação utiliza o **Spring DevTools** para habilitar o hot reload. Isso significa que, ao fazer alterações no código, o servidor será reiniciado automaticamente sem a necessidade de reiniciar manualmente o aplicativo.

---

## Estrutura do Projeto

```plaintext
estoque-app/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── kaspper/
│   │   │   │   │   ├── estoque_app/
│   │   │   │   │   │   ├── controller/                 # Controladores responsáveis pelas páginas web
│   │   │   │   │   │   ├── model/                      # Entidades JPA (Produto.java)
│   │   │   │   │   │   ├── repository/                 # Interface do repositório (ProdutoRepository.java)
│   │   │   │   │   │   ├── service/                    # Lógica de negócios (Estoque.java)
│   │   │   │   │   │   └── EstoqueAppApplication.java  # Classe principal do Spring Boot
│   │   └── resources/
│   │       ├── application.properties        # Configurações do banco de dados
│   │       ├── static/                       # Arquivos estáticos (CSS, JS, Imagens)
│   │       └── templates/                    # Templates do Thymeleaf (HTML)
│   │           └── index.html                # Página principal
│   └── pom.xml                               # Arquivo de configuração do Maven
│
└── README.md                                 # Este arquivo
```

---

## Contribuição

Sinta-se à vontade para abrir issues ou enviar pull requests se quiser contribuir para o projeto!
