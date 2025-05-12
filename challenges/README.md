## Desafios

Nesta página você encontra:
* [Instruções para executar testes locais](#instruções-para-executar-testes-locais)


### Lista de desafios

|#|Descrição|Assunto|
|---|---|---|
| 1 | [String Reverse](./01-reverse/) | Estruturas de controle e iteração |
| 2 | [IDP Bank](./02-bank/) | Classes, objetos, métodos, atributos |
| 3 | [Parking](./03-parking/) | Herança, polimorfismo |
| 4 | [Report](./04-report/) | Manipulação de arquivos |

### Instruções para executar testes locais

Cada desafio é acompanhada de testes unitários. Para avaliar seu código antes de submetê-lo, execute os seguintes comandos a partir de seu diretório pessoal de cada desafio.

 ```bash
 mkdir -p lib
 ```

```bash
 curl -L -o lib/junit-platform-console-standalone-1.11.4.jar https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.11.4/junit-platform-console-standalone-1.11.4.jar
```

```bash
 javac -cp "lib/*" -d bin src/*.java ../../test/*.java
 ```

 ```bash
 java -jar lib/junit-platform-console-standalone-1.11.4.jar --class-path bin --scan-class-path
 ```