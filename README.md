# FacadeAndApi

## Descrição

Este projeto é uma implementação de um padrão de projeto de software chamado **Facade** em combinação com uma **API**. O objetivo principal é fornecer uma interface simplificada para um conjunto complexo de interfaces em um subsistema, tornando a interação com o sistema mais fácil e intuitiva.


## Funcionalidades

- **Mapeamento de Objetos**: Utiliza a Api do https://viacep.com.br/ para mapear objetos complexos em uma interface simples.
- **Endpoints HTTP**: Fornece uma API RESTful para permitir a interação com o sistema.
- **Operações CRUD**: Suporte para operações de criação, leitura, atualização e exclusão de entidades.

## Tecnologias Utilizadas

- **Linguagem de Programação**: Java
- **Framework**: Spring Boot para construção da API
- **Bibliotecas**: Lombok para redução de boilerplate, JPA para mapeamento objeto-relacional
- **Banco de Dados**: H2 Database para armazenamento persistente

## Como Executar

1. **Clone o repositório**:
    ```bash
    git clone https://github.com/KauanJasiskis/FacadeAndApi.git
    ```
2. **Navegue até o diretório do projeto**:
    ```bash
    cd FacadeAndApi
    ```
3. **Compile e execute o projeto**:
    ```bash
    mvn spring-boot:run
    ```
4. **Acesse a API**:
    A API estará disponível em `http://localhost:8080`.








