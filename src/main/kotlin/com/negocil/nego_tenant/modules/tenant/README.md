## Description

Esta pasta chamado de "tenant" é responsável pela gestão de inquilinos 

## Estrutura de pasta

A pasta `tenant` segue uma uma estrutura usando o padrão `package-by-Layer`.
```
|-- tenant/                        # Módulo de gestão de inquilinos (tenants)
|   |-- controller/                # Controllers REST
|   |   |-- api/                   # Interfaces de API
|   |   |-- dto/                   # Data Transfer Objects
|   |   |-- graphql/               # Resolvers GraphQL
|   |   |-- request/               # Objetos de requisição
|   |   └-- response/              # Objetos de resposta
|   |-- model/                     # Entidades JPA
|   |-- repository/                # Repositórios Spring Data
|   |-- seeder/                    # Seeds para popular dados iniciais
|   |-- service/                   # Serviços de lógica de negócio
|   └-- README.md                  # Documentação do módulo
```