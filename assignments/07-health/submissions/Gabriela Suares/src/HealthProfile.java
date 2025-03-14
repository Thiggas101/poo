class HealthProfile {
    private String nome, sobrenome;
    private char genero;
    private int diaNascimento, mesNascimento, anoNascimento;
    private double alturaEmPolegadas, pesoEmLibras;

    public HealthProfile(String nome, String sobrenome, char genero, int diaNascimento, int mesNascimento, int anoNascimento, double alturaEmPolegadas, double pesoEmLibras) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.diaNascimento = diaNascimento;
        this.mesNascimento = mesNascimento;
        this.anoNascimento = anoNascimento;
        this.alturaEmPolegadas = alturaEmPolegadas;
        this.pesoEmLibras = pesoEmLibras;
    }

    public int calcularIdade(int anoAtual) {
        return anoAtual - anoNascimento;
    }

    public int calcularFrequenciaCardiacaMaxima() {
        return 220 - calcularIdade(2025);
    }

    public String calcularFaixaFrequenciaCardiacaAlvo() {
        int frequenciaMaxima = calcularFrequenciaCardiacaMaxima();
        return (int)(frequenciaMaxima * 0.50) + " bpm - " + (int)(frequenciaMaxima * 0.85) + " bpm";
    }

    public double calcularIMC() {
        return (pesoEmLibras * 703) / (alturaEmPolegadas * alturaEmPolegadas);
    }

    public String getNome() { return nome; }
    public String getSobrenome() { return sobrenome; }
    public char getGenero() { return genero; }
    public int getDiaNascimento() { return diaNascimento; }
    public int getMesNascimento() { return mesNascimento; }
    public int getAnoNascimento() { return anoNascimento; }
    public double getAlturaEmPolegadas() { return alturaEmPolegadas; }
    public double getPesoEmLibras() { return pesoEmLibras; }

    public static void exibirTabelaIMC() {
        System.out.println("\nTabela de Classificação IMC:");
        System.out.println("IMC\t\tClassificação");
        System.out.println("< 18.5\t\tAbaixo do peso");
        System.out.println("18.5 - 24.9\tPeso normal");
        System.out.println("25.0 - 29.9\tSobrepeso");
        System.out.println(">= 30.0\t\tObesidade");
    }
}
