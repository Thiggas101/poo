### Manipulação de arquivos e serialização de objetos

#### Manipulação Básica de Arquivos (Create, Read, Write, Update)

##### Criação e Escrita em Arquivos de Texto com `FileWriter`

```
Explique como realizar a criação e escrita em arquivos de texto com `FileWriter`, apresentando detalhadamente informações para os itens abaixo

1. O que é a classe `FileWriter` e como ela pode ser usada para criar um arquivo de texto em Java?
2. Escreva um programa Java que crie um arquivo chamado `dados.txt` e grave três linhas de texto.
3. O que acontece se você executar o programa duas vezes? O conteúdo será sobrescrito?
```

##### Leitura de Arquivos de Texto com `BufferedReader`

```
Explique como realizar leitura de arquivos de texto com o `BufferedReader`, detalhando os seguintes itens:

1. Explique o uso das classes `FileReader` e `BufferedReader`.
2. Escreva um código para ler o conteúdo do arquivo `dados.txt` criado anteriormente.
3. Como lidar com exceções ao ler arquivos?
```

##### Atualização de Arquivos (read → modify → write):**

```
Explique como realizar atualização de arquivos

1. Como atualizar o conteúdo de um arquivo em Java se não é possível fazer "edições diretas"?
2. Implemente um programa que leia o arquivo `dados.txt`, substitua todas as ocorrências da palavra "teste" por "exemplo" e salve o resultado em um novo arquivo.
```

#### Trabalhando com NIO.2 (Informações de Arquivos e Diretórios)

##### Introdução ao `java.nio.file.Path` e `Files`

```
Apresente uma síntese do pacote NIO.2

1. O que são as classes `Path` e `Files` no pacote `java.nio.file`?
2. Escreva um exemplo que obtenha o nome do arquivo, tamanho e se ele é legível/escrevível.
```

##### Listagem de diretórios com `DirectoryStream`

```
Explique como realizar a listagem de diretórios com `DirectoryStream`

1. Como listar todos os arquivos de um diretório usando NIO.2?
2. Escreva um código que imprima todos os arquivos `.txt` de um diretório especificado.
```

##### Criação, cópia, movimentação e exclusão com NIO.2

```
Explique como realizar a criação, cópia, movimentação e exclusão com NIO.2

1. Demonstre como criar diretórios e arquivos usando `Files.createFile` e `Files.createDirectory`.
2. Como copiar, mover e excluir arquivos com NIO.2? Mostre exemplos.
```

#### Diferença entre Arquivos Texto e Binários

##### Conceito e diferenças práticas

```
1. Qual a diferença entre arquivos texto e binários?
2. Dê exemplos reais de cada tipo de arquivo.
3. Por que arquivos binários são mais eficientes para dados estruturados?
```

##### Leitura/Escrita de arquivos binários com `DataInputStream` e `DataOutputStream`

```
1. Explique o funcionamento das classes `DataInputStream` e `DataOutputStream`.
2. Implemente um programa que grave uma lista de inteiros em um arquivo binário e outro que leia.
```

#### Uso do `Formatter` e `Scanner` para Entrada e Saída

##### Escrita com `Formatter`

```
1. O que é a classe `Formatter` e quais suas vantagens?
2. Escreva um programa que utilize `Formatter` para gravar um arquivo com dados tabulados (nome, idade, saldo).
```

##### Leitura com `Scanner`

```
1. Demonstre como utilizar `Scanner` para ler o conteúdo desse mesmo arquivo e imprimir os dados no console.
2. Como lidar com erros de leitura e formatação?
```

#### Processamento Sequencial de Arquivos (Exemplo: Consulta de Créditos)

##### Análise do problema

```
1. Como um programa de consulta de crédito pode se beneficiar de arquivos sequenciais?
2. Que tipo de estrutura de dados e organização de arquivo são necessárias?
```

##### Implementação

```
1. Implemente um programa que grave dados de clientes com número da conta, nome e saldo.
2. Implemente uma funcionalidade que permita consultar os saldos por número de conta.
3. Implemente um filtro para listar apenas contas com saldo negativo.
```

#### Serialização de Objetos

##### Conceito de Serialização e XML:**

```
Explique de maneira detalhada o conceito de serialização de objetos e o que é XML e responda as questões:

1. O que é serialização em Java?
2. Quais são os benefícios da serialização em XML?
3. Apresente um exemplo de estrutura XML para representar um objeto `Pessoa`.
```

##### Uso do JAXB para Serializar e Desserializar

```
1. O que é o JAXB e como ele facilita a serialização de objetos em XML?
2. Crie uma classe `Pessoa` anotada com `@XmlRootElement`, `@XmlElement`, etc.
3. Implemente um exemplo que grave uma lista de objetos `Pessoa` em um arquivo XML.
4. Implemente um exemplo que leia o arquivo XML e reconstrua a lista de objetos.
```