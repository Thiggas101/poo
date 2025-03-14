### Estudo de caso: IDP Bank

Você foi contratado pela fintech IDP Bank, em razão do seu conhecimento em Programação Orientada a Objetos (POO), para desenvolver um Banco Digital que permita o gerenciamento de clientes e suas contas bancárias.

No seu primeiro dia de tralho você recebeu a especificação do sistema. Sua tarefa é programar o sistema de forma que atenda plenamente aos requisitos de negócio e técnicos definidos.

#### Objetivo do Sistema

O objetivo do sistema é possibilitar que os clientes possam abrir contas bancárias, realizar transações financeiras e gerenciar seus investimentos.

O sistema deverá permitir:

* Cadastrar de clientes
* Abrir de conta
* Realizar depósitos e saques
* Aplicar taxas e rendimentos
* Gerar relatórios e auditoria de transações

#### Cronograma

O projeto será implementado em 4 semanas, cada uma focada em um conjunto de funcionalidades específicas:

| Semana | Funcionalidade | Objetivo |
|---|---|--- |
| 1 | Cadastro e abertura de contas | Aplicar os conceitos de classe, objeto, atributos, métodos, atributos e métodos de classe (static), modificadores de acesso, get e set, sobrecarga (_overload_) de métodos e construtores, palavra reservada _this_ |

#### Semana 1: Especificação das funcionalidades

##### Geral

1. Ao inciar, o programa deve exibir um menu de opções para o usuário escolher a ação desejada: 1. [Abrir conta](#abertura-de-conta); 2. [Consultar cliente](#consultar-cliente); 3. [Depositar]; (#depositar); 4. [Sacar](#sacar); 5. [Sair](#sair)
```bash
Seja bem-vindo ao IDP Bank! Escolha uma das opções abaixo:

1. Abrir conta
2. Consultar cliente
3. Depositar
4. Sacar
5. Sair

Digite o número correspondente à opção desejada: 
```
2. Ao digitar a opção deseja, o sistema deverá seguir para a ação correspondente.

##### Abrir conta

1. O programa deve solicitar ao usuário as informações do cliente.
```bash
Digite os dados para a abertura da conta.

Primeiro nome: João  
Sobrenome: Silva  
CPF: 123.456.789-00 
```
2. O programa deve gerar um número de conta único automaticamente para cada novo cliente.
3. Inicialmente, haverá apenas um tipo de conta e cada cliente terá exatamente uma conta.
4. O programa deve imprimir os dados do cliente e os detalhes da conta criada.
```bash
Cliente cadastrado com sucesso!

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Conta criada com sucesso! Pressione Enter para continuar...
```
6. O programa deve retornar para o início
7. Se o usuário digitar uma opção inválida, o programa deve informar que a opção é inválida e solicitar a opção novamente
```bash
Opção inválida. Tente novamente.

Digite o número correspondente à opção desejada: 
```

##### Consultar cliente

1. O programa deve exibir as informações do cliente
```bash
Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
2. O programa deve retornar para o início

##### Depositar

1. O programa deve solicitar o valor a ser depositado
```bash
Digite o valor que deseja depositar.

Valor: 

```
2. O programa deve somar o valor depositado na conta do cliente e apresentar as informações do cliente
```bash
Valor depositado com sucesso na conta do cliente João da Silva.

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
3. O programa deve retornar para o início

##### Sacar

1. O programa deve solicitar o valor a ser sacado
```bash
Digite o valor que deseja sacar.

Valor: 

```
2. O programa deve subtratir o valor depositado na conta do cliente e apresentar as informações do cliente
```bash
Valor sacado com sucesso da conta do cliente João da Silva.

Nome: João Silva  
CPF: 123.456.789-00  
Número da Conta: 1001  
Saldo: R$ 0,00

Pressione enter para continuar...
```
3. O programa deve retornar para o início

##### Sair

1. O programa deve encerrar a execução

###### Requisitos de implementação

1. O programa deve conter uma classe chamada `IDPBank`.
2. A classe `IDPBank` deve ter os seguintes métodos públicos (`public`) e estáticos (`static`)
    * `main`: deve receber um parâmetro do tipo `String[]` e não retornar nenhum valor (`void`)
    * `createCustomer`: deve receber `firstName`, `lastName` e `CPF`, todos do tipo `String`, e deve retornar um objeto `Customer`
    * `openAccount`: deve receber um objeto `Customer` e deve retornar um objeto `Account`.
    * `deposit`: recebe como parâmetro `amount` do tipo `double` para ser somado ao saldo `balance` da conta do cliente
    * `withdraw`: recebe como parâmetro `amount` do tipo `double` para ser subtraído do saldo `balando` da conta do cliente
3. O programa deve ter uma classe chamada `Customer`, que deve ter:
    * atributos privados:
        * `firstName` (`String`): Primeiro nome do cliente.
        * `lastName` (`String`): Sobrenome do cliente.
        * `cpf` (`String`): CPF do cliente.
        * `accounts` (`Account`) → Conta do cliente (inicialmente haverá apenas uma conta, nas próximas iterações esse atributo será alterado para poder receber mais de uma conta).
    * um construtor que recebe os atributos acima como parâmetros `firstName`, `lastName` e `cpf`. 
    * métodos de acesso (`get` e `set`) para seus atributos.
    * método `addAccount(Account account)` que retorna um `boolean` para associar a conta com o cliente
    * método `displayInformation()` que retornar uma `String` para imprimir os detalhes do cliente
4. O programa deve conter uma classe chamada `Account`, que deve ter:
    * atributos privados
        * `id` (int) → Número único da conta bancária.
        * `balance` (double) → Saldo inicial da conta, que deve começar em R$ 0,00.
    * um construtor que inicializa a conta com um número de conta único e saldo zero.
    * métodos de acesso (`get` e `set`) para seus atributos.
        * O método `get` referente ao saldo, deve retorar o saldo formatado
        * O método `set` referente ao saldo, deve impedi saldo negativo
    * método `deposit(double amount)` para depositar valor na conta
    * método `withdraw(double amount)` para sacar valor da conta
    * um atributo de classe (`static`) `accountCounter` do tipo `int` para controlar a quantidade de contas criadas. Cada nova conta deve receber um número sequencial gerado automaticamente pela aplicação, garantindo unicidade.
5. Utilizar a classe [java.util.Scanner](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Scanner.html) para ler entrada do console.
6. Utilizar a classe [System.out](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/lang/System.html#out) para imprimir informações no console.