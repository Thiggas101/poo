## CRUD com JDBC no Banco DVD Rental

Desenvolva uma aplicação em Java orientada a objetos utilizando JDBC que seja capaz de realizar as operações de **criação, leitura, atualização e remoção (CRUD)** sobre a tabela `film` do banco de dados **dvdrental** (PostgreSQL).

### Requisitos Funcionais

O sistema deve permitir:

1. Inserir um novo filme
2. Listar todos os atores
3. Buscar filme por ID
4. Buscar filme por nome
5. Atualizar dados de um ator existente
6. Remover um ator por ID
7. Registrar em arquivo de log (`audit.log`) todas as alterações (inserção, atualização e exclusão)

### Requisitos Técnicos

1. Organize seu projeto com os seguintes **pacotes Java**:
```
br.edu.idp.cc.poo.dvdrental.model     → Classe Film
br.edu.idp.cc.poo.dvdrental.dao       → Classe FilmDAO
br.edu.idp.cc.poo.dvdrental.util      → ConnectionFactory e AuditLogger
br.edu.idp.cc.poo.dvdrental           → Classe Main (executável)
```
1. O acesso ao bando de dados deve usar exclusivamente o pacote `java.sql` (JDBC puro)
1. Log de auditoria deve ser feito com `java.nio.file.Files` (arquivo `audit.log`)
1. Configuração da conexão em `db.properties`