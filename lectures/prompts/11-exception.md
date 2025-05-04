### Tratamento de Exceções em Java

#### Introdução ao Tratamento de Exceções
```
Explique o que é uma exceção em Java e por que o tratamento de exceções é considerado uma abordagem eficaz para lidar com problemas em tempo de execução.  
  
Em seguida, mostre um exemplo prático de um código Java que gera uma exceção (como divisão por zero) e explique como o programa se comporta sem tratamento.

Por fim, responda detalhadamente cada um dos items abaixo?
1. O que é uma exceção em Java? Defina com suas palavras.
2. Por que o tratamento de exceções é uma prática importante em programação?
3. Liste 3 exemplos de problemas que podem ocorrer em tempo de execução e que podem ser tratados com exceções.
4. Escreva um código simples que gere uma ArithmeticException (divisão por zero) sem tratamento.
5. Explique o que acontece quando um erro desses não é tratado em Java.
```

#### Uso do bloco `try`
```
Mostre como usar o bloco `try` para delimitar um trecho de código que pode gerar uma exceção em Java.  

Apresente um exemplo prático onde se tenta abrir um arquivo para leitura usando `FileReader` dentro de um bloco `try`.

Por fim, explique detalhadamente os seguintes items:
1. O que é o bloco try em Java e para que ele serve?
2. Escreva um exemplo simples usando try para capturar uma tentativa de divisão por zero.
3. Explique, linha por linha, o que está acontecendo no seu exemplo.
4. Modifique o exemplo para tentar abrir um arquivo inexistente usando FileReader dentro de um try.
5. O que acontece se um erro ocorrer dentro do bloco try?
```

#### Uso da palavra-chave `throw`
```
Explique como e por que usamos a palavra-chave `throw` em Java.  
  
Dê um exemplo prático onde um método verifica se uma idade é negativa e, nesse caso, **lança** uma `IllegalArgumentException` usando `throw`.

Por fim, explique detalhadamente cada um dos items:
1. O que significa "lançar uma exceção" com a palavra-chave throw em Java?
2. Escreva um método que receba uma idade e lança uma IllegalArgumentException se a idade for negativa.
3. Mostre como chamar esse método corretamente e como ele se comporta quando uma exceção é lançada.
4. Explique a diferença entre throw e throws em Java.
```

#### Uso do bloco `catch`
```
Mostre como usar o bloco `catch` para capturar e tratar exceções em Java.  
  
Apresente um exemplo prático que simule uma divisão por zero, capture a exceção `ArithmeticException`, e exiba uma mensagem amigável para o usuário.

Por fim, explique detalhadamente cada um dos itens:
1. O que é um bloco catch em Java e qual seu papel no tratamento de exceções?
2. Escreva um programa que capture uma ArithmeticException ao fazer uma divisão por zero.
3. O que acontece se não houver um catch para o tipo específico de exceção lançada?
4. Crie dois blocos catch diferentes no mesmo programa: um para ArithmeticException e outro para NullPointerException.
5. O que acontece se mais de um tipo de exceção puder ser lançado?
```

#### Quando usar tratamento de exceções
```
Explique em que situações o tratamento de exceções é apropriado, e quando **não** é a melhor escolha (por exemplo, em erros de lógica que deveriam ser evitados em tempo de compilação).  
  
Apresente dois exemplos em Java: um cenário correto de uso de exceções, e um cenário onde seria melhor prevenir o erro ao invés de capturar uma exceção.

Por fim, explique detalhadamente cada um dos itens:
1. Em que tipo de situação devemos preferir o tratamento de exceções em vez de prevenir erros?
2. Dê um exemplo prático de onde o tratamento de exceção é a melhor escolha (como leitura de arquivos).
3. Dê um exemplo prático de onde é melhor prevenir o erro do que tratar exceções (como validar parâmetros antes do uso).
4. Discuta com a IA: "Qual a diferença entre erro previsto (controle de fluxo) e erro inesperado (exceção)?
```

#### Hierarquia de Classes de Exceção
```
Descreva a hierarquia de classes de exceção em Java, explicando a diferença entre `Exception`, `RuntimeException` e `Error`.  
 
Mostre exemplos práticos de cada um desses tipos para ilustrar seu uso.

Por fim, explique detalhadamente os itens:
1. Explique o conceito de hierarquia de classes em Java aplicado às exceções.
2. O que é a classe Throwable? Em que ela difere de Exception e Error?
3. Qual é a diferença entre Exception e RuntimeException?
4. Dê exemplos práticos de:
a. Uma Checked Exception (Exemplo: IOException)
b. Uma Unchecked Exception (Exemplo: NullPointerException)
c. Um Error (Exemplo: OutOfMemoryError)
5. Crie um diagrama simples da hierarquia de exceções mais comum.
```

#### Uso do bloco `finally`
```
Explique o propósito do bloco `finally` em Java.  
 
Apresente um exemplo prático onde um arquivo é aberto para leitura e o bloco `finally` é usado para garantir que o arquivo seja fechado, independentemente de ocorrer uma exceção.

Por fim, explique detalhadamente cada um dos itens:
1. O que é o bloco finally e qual seu objetivo?
2. Explique o que acontece se uma exceção for lançada, mas existe um bloco finally.
3. Escreva um código que abra um arquivo usando FileReader, utilize try-catch-finally, e feche o arquivo no finally.
4. Teste o que acontece se ocorrer uma exceção e se não ocorrer uma exceção — o finally é executado em ambos os casos?
```

#### Encadeamento de Exceções (Chaining)
```
Explique como capturar uma exceção e lançar outra exceção diferente em Java, mantendo a causa original (encadeamento de exceções).  
  
Mostre um exemplo prático onde uma `NumberFormatException` capturada gera uma nova `IllegalArgumentException`, encadeando as exceções.

Por fim, explique detalhadamente cada um dos itens:
1. O que significa "encadear exceções" em Java?
2. Explique a diferença entre capturar uma exceção e lançar uma nova exceção baseada na anterior.
3. Escreva um exemplo onde uma NumberFormatException é capturada e uma IllegalArgumentException é lançada usando initCause.
4. Mostre como capturar e imprimir toda a cadeia de exceções (stack trace).
```

#### Criação de Exceções Definidas pelo Usuário
```
Explique como criar uma exceção personalizada (user-defined exception) em Java, estendendo a classe `Exception`.  
  
Apresente um exemplo prático de uma exceção chamada `SaldoInsuficienteException` que é lançada quando um método de saque detecta saldo insuficiente.

Por fim, explique detalhadamente cada um dos itens:
1. Por que pode ser útil criar exceções personalizadas?
2. Crie uma classe SaldoInsuficienteException que estende Exception.
3. Implemente um método sacar(double valor) que lança SaldoInsuficienteException se o saldo for insuficiente.
4. Mostre como capturar essa exceção em outro método.
```

#### Uso de `assert`
```
Explique a funcionalidade da palavra-chave `assert` em Java.  
  
Mostre um exemplo prático em que um método utiliza `assert` para verificar se um parâmetro não é nulo, e explique como habilitar a execução de assertivas na JVM.

Por fim, explique detalhadamente cada um dos itens:
1. O que é assert em Java e para que ele serve?
2. Escreva um pequeno programa que use assert para garantir que um valor não seja nulo antes de continuar.
3. Como ativar o uso de assert na JVM ao executar o programa?
4. Explique quando usar assert e quando usar tratamento de exceções.
```

#### `try-with-resources`
```
Explique o que é o recurso `try-with-resources` em Java e em que situações ele deve ser utilizado.  
  
Apresente um exemplo prático que use `try-with-resources` para abrir um arquivo de texto usando `BufferedReader` e garantir o fechamento automático do recurso.

Por fim, explique detalhadamente cada um dos itens:
1. O que é o recurso try-with-resources e qual problema ele resolve?
2. Quais classes podem ser usadas com try-with-resources? (Dica: classes que implementam AutoCloseable)
3. Escreva um exemplo que abra um arquivo usando BufferedReader com try-with-resources.
4. Compare try-with-resources com try-finally: quais as vantagens?
```