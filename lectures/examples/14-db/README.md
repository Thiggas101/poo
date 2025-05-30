
### Instalar cliente do PostgreSQL
```bash
sudo apt update
sudo apt install postgresql-client
psql --version
```

### Baixar driver de conexão com o PostgreSQL
```bash
/14-db> mkdir lib
/14-db> cd lib/
/14-db/lib> wget https://jdbc.postgresql.org/download/postgresql-42.7.6.jar
```

### Baixar o banco de dados de exemplo
```bash
/14-db> mkdir db
/14-db> cd db
/14-db/db> wget https://neon.com/postgresqltutorial/dvdrental.zip
/14-db/db> unzip dvdrental.zip
```

### Conectar no servidor de banco de dados

Trocar [USER] pelo seu usuário do banco de dados
Trocar [PASSWORD] pela senha do banco de dados
Trocar [HOST] pelo nome do seu servidor

```bash
psql "postgresql://[USER]:[PASSOWORD]@[HOST]:5432/postgres?sslmode=require"
postgres=> \l
postgres=> exit
```

### Restaurar o banco de dados

Trocar [USER] pelo seu usuário do banco de dados
Trocar [PASSWORD] pela senha do banco de dados
Trocar [HOST] pelo nome do seu servidor

```bash
pg_restore -U [USER] -h [HOST] -p 5432 -d postgres -v dvdrental.tar --no-owner --clean --if-exists
psql "postgresql://[USER]:[PASSOWORD]@[HOST]:5432/postgres?sslmode=require"
postgres=> SELECT * FROM film;
```

### Instalar extenção pgAdmin no VS Code

### Compilar e rodar programa que conecta no banco de dados
