## Acesso a banco de dados com JDBC

### Introdução aos Bancos de Dados Relacionais

```
Explique o que é um banco de dados relacional e por que ele é amplamente utilizado em sistemas de informação.
1. Como os dados são organizados em um banco relacional?
2. O que são chaves primárias e estrangeiras?
3. Compare bancos relacionais com bancos orientados a documentos.
```

### Banco de dados

```
Descreva uma estrutura de banco de dados de exemplo para armazenar dados sobre livros.
1. Quais são as tabelas e suas colunas principais?
2. Explique como as tabelas se relacionam?
3. O que é integridade referencial e como ela se aplica à base?
```

### Instruções SQL Básicas

```
Mostre como usar SQL para consultar e modificar dados em uma base relacional.
1. Escreva um exemplo de SELECT que retorne colunas específicas de uma tabela do banco de dados.
2. Use a cláusula WHERE para filtrar registros.
3. Apresente como ordenar livros usando ORDER BY.
4. Explique o conceito de JOIN e demonstre como utilizá-lo na prática
5. Faça um INSERT para criar novos registros.
6. Atualize registros usando UPDATE.
7. Remova registros com DELETE.
```

### Conexão com o Banco via JDBC

```
Mostre como conectar uma aplicação Java a um banco de dados relacional usando JDBC.
1. Escreva um código Java simples que se conecta ao banco.
2. Como o JDBC descobre automaticamente o driver?
3. Como criar um Statement e executar uma consulta?
```

### Leitura de Dados com ResultSet

```
Descreva como o JDBC processa os resultados de uma consulta.
1. Como iterar sobre um ResultSet?
2. Como recuperar os dados por nome de coluna?
3. O que é ResultSetMetaData e como ele pode ser usado?
```

### RowSet e Conexões Simplificadas

```
Apresente o uso da interface RowSet para facilitar o trabalho com bancos.
1. Qual a diferença entre JdbcRowSet e CachedRowSet?
2. Mostre como configurar e executar um JdbcRowSet.
3. Como a serialização de CachedRowSet pode ser útil?
```

### Uso de PreparedStatements

```
Descreva o uso de PreparedStatements para aumentar a segurança e eficiência das consultas.
1. Escreva uma consulta parametrizada que insere um registro em uma tabela.
2. Como setar os valores dos parâmetros?
3. Mostre um exemplo de consulta usando `LIKE` com parâmetros.
```

### Procedures Armazenadas

```
Mostre como chamar procedures armazenadas no banco usando JDBC.
1. O que é CallableStatement?
2. Mostre um exemplo de chamada de procedure com parâmetros de entrada e saída.
```

### Processamento de Transações

```
Explique como o processamento de transações garante consistência nos bancos relacionais.
1. O que são transações e quais suas propriedades (ACID)?
2. Mostre um exemplo com `setAutoCommit(false)` e uso de `commit` e `rollback`.
```