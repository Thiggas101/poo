## Instalação do PostgreSQL

1. [Configurar servidor PostgreSQL localmente](#configurar-servidor-postgresql-localmente)
1. [Configurar servidor PostgreSQL no Supabase](#configurar-servidor-postgresql-no-supabase)
1. [Instalar pgAdmin4](#instalar-pgadmin4)
1. [Configurar servidor PostgreSQL e pgAdmin4 no docker](#configurar-servidor-postgresql-e-pgadmin4-no-docker)
1. [Compilar e rodar programa que conecta no banco de dados](#compilar-e-rodar-programa-que-conecta-no-banco-de-dados)

### Configurar servidor PostgreSQL localmente

- Instalar o PostgreSQL
```bash
sudo apt install -y postgresql-common
sudo /usr/share/postgresql-common/pgdg/apt.postgresql.org.sh
sudo apt update
sudo apt install postgresql postgresql-client
```

- Iniciar o serviço do PostgreSQL
```bash
sudo service postgresql start
```

- Definir a senha inicial do usuário postgres
```bash
sudo -u postgres psql
```

```bash
postgres=#  \password postgres
```

Caso o comando `sudo -u postgres psql` solicite senha do root e você não tenha, alterar o tipo de conexão para `trust` executando o comando abaixo

```bash
sudo nano /etc/postgresql/17/main/pg_hba.conf
```

- Testar conexão com PostgreSQL
```bash
psql -h localhost -p 5432 -U postgres -d postgres
postgres=# exit
```

- Baixar o banco de dados de exemplo
```bash
/14-db> mkdir db
/14-db> cd db
/14-db/db> wget https://neon.com/postgresqltutorial/dvdrental.zip
/14-db/db> unzip dvdrental.zip
```

- Restaurar o banco de dados
```bash
/14-db/db> pg_restore -U postgres -h localhost -p 5432 -d postgres -v dvdrental.tar --no-owner --clean --if-exists
```

- Testar conexão com banco
```bash
psql -h localhost -p 5432 -U postgres -d postgres
```

```bash
postgres=> SELECT * FROM film;
postgres=> exit
```

### Configurar servidor PostgreSQL no Supabase

- Criar conta no [Supabase](https://supabase.com/)

- Criar nova organização

- Criar novo projeto

- No topo da página, revisar informações de conexão

- Instalar cliente do PostgreSQL
```bash
sudo apt update
sudo apt install postgresql-client
psql --version
```

- Conectar no servidor de banco de dados
```bash
psql "postgresql://[USER]:[PASSOWORD]@[HOST]:5432/postgres?sslmode=require"
psql -h [HOST] -p [PORT] -U [USER] -d postgres
postgres=> \l
postgres=> exit
```

- Baixar o banco de dados de exemplo
```bash
/14-db> mkdir db
/14-db> cd db
/14-db/db> wget https://neon.com/postgresqltutorial/dvdrental.zip
/14-db/db> unzip dvdrental.zip
```

- Restaurar o banco de dados
```bash
pg_restore -U [USER] -h [HOST] -p 5432 -d postgres -v dvdrental.tar --no-owner --clean --if-exists
psql "postgresql://[USER]:[PASSOWORD]@[HOST]:5432/postgres?sslmode=require"
postgres=> SELECT * FROM film;
```

### Instalar pgAdmin4

- Instalar pgAdmin4
```bash
curl -fsS https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo gpg --dearmor -o /usr/share/keyrings/packages-pgadmin-org.gpg
sudo sh -c 'echo "deb [signed-by=/usr/share/keyrings/packages-pgadmin-org.gpg] https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'
sudo apt install pgadmin4-web
```

- Configuar o pgAdmin
```bash
sudo /usr/pgadmin4/bin/setup-web.sh
```

- Alterar a porta para rodar o pgAdmin para 8888
```bash
sudo nano /etc/apache2/ports.conf
```

- Adicionar a configuração `ServerName localhost` ao final do arquivo
```bash
sudo nano /etc/apache2/apache2.conf
```

- Reiniciar o serviço
```bash
sudo service apache2 start
```
- Acesse no browser o endereço http://localhost:8888/pgadmin4

### Configurar servidor PostgreSQL e pgAdmin4 no docker
```bash
docker-compose up -d
```

### Compilar e rodar programa que conecta no banco de dados

- Criar arquivo `db.properties` a partir do arquivo exemplo `db.properties.sample` e atualizar valores
```bash
url=jdbc:postgresql://[HOST]:5432/postgres
user=[USER]
password=[PASSWORD]
```

- Baixar driver de conexão com o PostgreSQL
```bash
/14-db> mkdir lib
/14-db> cd lib/
/14-db/lib> wget https://jdbc.postgresql.org/download/postgresql-42.7.6.jar
```

- Compilar e rodar programa

Substituir [PROGRAM] pelo nome do programa que deja rodar.

```bash
/14-db> javac -d bin src/[PROGRAM].java
/14-db> java -cp bin:lib/* [PROGRAM]
```

