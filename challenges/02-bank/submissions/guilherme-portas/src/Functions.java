public class Functions {
    public static void imprimeMenuInicial() {
        System.out.println("1. Abrir conta\n" +
                           "2. Consultar cliente\n" +
                           "3. Depositar\n" +
                           "4. Sacar\n" +
                           "5. Sair\n");
        
        System.out.print("Digite o número correspondente à opção desejada: ");
    }

    public final static void clearTerminal() {
        for(int i = 0; i < 50; i ++) {
            System.out.println();
        }
    }
}
