# Nego Tenant API

> Backend centralizado para gestão multi-tenant da plataforma Negocil

[![Kotlin](https://img.shields.io/badge/Kotlin-1.9+-purple.svg)](https://kotlinlang.org)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)

## 📋 Descrição

**Nego Tenant** é uma aplicação REST API e GraphQL desenvolvida para gerenciar os **tenants** (inquilinos) da empresa **Negocil**. A aplicação fornece funcionalidades de gerenciamento de contas, projetos e usuários em uma arquitetura **multi-tenant**, permitindo que múltiplos clientes utilizem a mesma infraestrutura de forma isolada e segura.

### 🎯 Objetivo da Aplicação

Esta aplicação serve como **backend centralizado** para:

- 🏢 **Gestão de Tenants**: Cadastro e administração de empresas/clientes
- 👥 **Gestão de Usuários**: Controle de acesso e permissões por tenant
- 📊 **Gestão de Projetos**: Organização e acompanhamento de projetos por tenant
- 🔐 **Isolamento de Dados**: Garantir que cada tenant acesse apenas seus próprios dados
- 🔌 **APIs Flexíveis**: Suporte tanto REST quanto GraphQL para diferentes casos de uso

## 🏗️ Estrutura do Projeto

```
src/main/kotlin/com.negocil.nego_tenant/
|-- config/                        # Configurações do projeto
|   |-- SecurityConfig.kt          # Configuração de segurança
|   |-- DatabaseConfig.kt          # Configuração do banco de dados
|   |-- GraphQLConfig.kt           # Configuração do GraphQL
|
|-- modules/                       # Features do projeto (módulos de negócio)
|   |__ tenant/                    # Módulo de gestão de tenants
|       ├── controller/
|       ├── service/
|       ├── repository/
|       └── model/
|
|── shared/                        # Código compartilhado entre módulos
|   ├── exception/                 # Exceções customizadas
|   ├── util/                      # Utilitários
|   ├── dto/                       # DTOs comuns
|   └── model/                     # Modelos base
|
|-- NegoTenantApplication.kt       # Classe principal da aplicação
```

## 🚀 Tecnologias Utilizadas

- **Kotlin** - Linguagem de programação principal
- **Spring Boot 4.0.1** - Framework para desenvolvimento da API
- **Spring Data JPA** - Persistência de dados
- **Spring Security** - Autenticação e autorização
- **PostgreSQL** - Banco de dados relacional
- **GraphQL** - API flexível para consultas complexas
- **REST** - API tradicional para operações CRUD
- **Gradle** - Gerenciador de dependências e build

## 📦 Pré-requisitos

- JDK 25 ou superior
- Gradle 8.x
- PostgreSQL 18+
- Docker (opcional, para desenvolvimento)

## 🔧 Configuração

### 1. Clone o repositório

```bash
git clone https://github.com/negocil-nego/negotenant
cd negotenant
```

### 2. Configure o banco de dados

Crie um arquivo `application.yml` em `src/main/resources/`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/negotenant
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### 3. Execute a aplicação

```bash
./gradlew bootRun
```

A aplicação estará disponível em `http://localhost:8080`

## 🐳 Docker

Para executar com Docker:

```bash
docker-compose up -d
```

## 📚 Documentação da API

### REST API

Acesse a documentação Scaler em:
```
http://localhost:8080/scalar
```

### GraphQL

Acesse o playground GraphQL em:
```
http://localhost:8080/graphiql
```

### Exemplos de uso

#### REST - Criar um Tenant

```bash
POST /api/v1/tenants
Content-Type: application/json

{
  "name": "Empresa XYZ",
  "key": "empresa-xyz"
}
```

#### GraphQL - Consultar Tenants

```graphql
query {
  tenants {
    uuid
    name
    key
    users {
      name
      email
    }
  }
}
```

## 🧪 Testes

Execute os testes com:

```bash
./gradlew test
```

Para gerar relatório de cobertura:

```bash
./gradlew jacocoTestReport
```

## 🏛️ Arquitetura Multi-Tenant

A aplicação implementa **isolamento de dados por tenant** usando as seguintes estratégias:

1. **Database per Tenant**: Cada tenant possui seu próprio schema no banco de dados
2. **Row-Level Security**: Filtros automáticos aplicados em todas as queries
3. **Tenant Context**: Identificação do tenant via header HTTP ou token JWT

### Fluxo de Requisição

```
Cliente → API Gateway → Tenant Resolver → Database Tenant Específico
```

## 🔐 Segurança

- Autenticação via JWT
- Autorização baseada em roles (ADMIN, USER, MANAGER)
- Isolamento de dados por tenant
- Rate limiting por tenant
- Auditoria de ações críticas

## 📈 Roadmap

- [ ] Implementar cache distribuído com Redis
- [ ] Adicionar mensageria com Kafka
- [ ] Criar dashboard de monitoramento
- [ ] Implementar backup automático por tenant
- [ ] Adicionar suporte a webhooks

## 🤝 Contribuindo

1. Fork o projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

## 📝 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 👥 Equipe

Desenvolvido pela equipe **Negocil**

## 📞 Contato

- Website: [negocil.com](https://negocil.com)
- Email: dev@negocil.com

---

⭐ Se este projeto te ajudou, considere dar uma estrela!