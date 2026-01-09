## Description

Esta pasta chamado de "modules" é responsável por conter as features do projeto

## Estrutura de pasta

A pasta `modules` segue uma arquitetura modular onde cada feature da aplicação é organizada como um módulo independente. Cada módulo contém toda a lógica de negócio, fontes de dados e configurações relacionadas à sua funcionalidade específica.
```
modules/
|
|-- datasource/                    # Módulo de fonte de dados
|-- tenant/                        # Módulo de gestão de inquilinos (tenants)
|-- README.md                      # Este arquivo
```

## Conceitos

### Arquitetura: Package-by-Feature + Package-by-Layer

Este projeto combina duas abordagens de organização:

1. **Package-by-Feature** (nível de módulo): Cada pasta em `modules/` representa uma feature completa
2. **Package-by-Layer** (dentro de cada módulo): Organização tradicional em camadas (controller, service, repository, model)


### Módulos (Features)
Cada subpasta dentro de `modules` representa uma **feature** completa da aplicação, seguindo uma arquitetura em camadas:

#### Camada de Controller (Apresentação)
- **api**: Interfaces e contratos de API
- **dto**: Data Transfer Objects para transferência de dados
- **request**: Objetos para requisições HTTP
- **response**: Objetos para respostas HTTP
- **graphql**: Configurações e schemas GraphQL

#### Camada de Domínio
- **domain**: Regras de negócio e entidades do domínio
- **model**: Modelos de dados e entidades

#### Camada de Dados
- **data**: Implementações de repositórios e datasources
- **repository**: Repositórios de acesso a dados

#### Camada de Serviço
- **service**: Lógica de negócio e orquestração

#### Camada de Apresentação
- **presentation**: UI, Activities, Fragments e ViewModels

#### Configuração
- **di**: Injeção de dependências (Koin/Dagger)
- **seeder**: Classes para popular dados iniciais

### Benefícios desta arquitetura
- ✅ **Separação de responsabilidades**: Cada módulo é independente
- ✅ **Reutilização**: Módulos podem ser compartilhados entre projetos
- ✅ **Manutenibilidade**: Facilita localização e correção de bugs
- ✅ **Testabilidade**: Cada módulo pode ser testado isoladamente
- ✅ **Escalabilidade**: Novos módulos podem ser adicionados facilmente
- ✅ **Clean Architecture**: Separação clara entre camadas

## Como adicionar um novo módulo

1. Crie uma nova pasta dentro de `modules/` com o nome da feature
2. Adicione as subpastas necessárias seguindo o padrão existente:
```
   nova_feature/
    |-- controller/                # 
    |   |-- api/                   # Controllers REST API
    |   |-- dto/                   # Data Transfer Objects
    |   |-- graphql/               # Resolvers GraphQL
    |   |-- request/               # Objetos de requisição
    |   └-- response/              # Objetos de resposta
    |-- model/                     # Entidades JPA
    |-- repository/                # Repositórios Spring Data
    |-- seeder/                    # Seeds para popular dados iniciais
    |-- service/                   # Serviços de lógica de negócio
```
3. Configure a injeção de dependências no arquivo de DI
4. Registre o módulo no arquivo principal de configuração da aplicação
5. Crie um README.md dentro do módulo documentando sua funcionalidade

## Módulos existentes

### datasource
Responsável pela configuração e gerenciamento das fontes de dados da aplicação, incluindo:
- Implementações de repositórios e datasources
- Entidades e interfaces do domínio
- Configuração de injeção de dependências

### tenant
Gerencia as funcionalidades relacionadas aos inquilinos (tenants) do sistema, incluindo:
- **Controllers**: Endpoints REST e GraphQL para operações CRUD
- **Data**: Repositórios e datasources específicos do tenant
- **Domain**: Regras de negócio e entidades relacionadas a tenants
- **Presentation**: UI e ViewModels para gestão de inquilinos
- **Service**: Lógica de negócio para autenticação, autorização e gestão
- **Seeder**: Dados iniciais para popular o sistema

## Convenções

- Utilize nomes descritivos e em inglês para as classes e pacotes
- Mantenha cada módulo independente e coeso
- Evite dependências circulares entre módulos
- Siga os princípios SOLID e Clean Architecture
- DTOs devem ser usados apenas na camada de controller
- Entidades de domínio não devem vazar para a camada de apresentação
- Use injeção de dependências para gerenciar as dependências entre camadas
- Documente os endpoints REST com Swagger/OpenAPI
- Cada módulo deve ter seu próprio README.md