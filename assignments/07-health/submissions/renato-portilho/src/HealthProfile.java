
public class HealthProfile {
    private String firstName;
    private String lastName;
    private char gender;
    private int dayOfBIrth;
    private int monthOfBirth;
    private int yearOfBirth;
    private double heightInInches;
    private double weightInPounds;

    public HealthProfile(String firstName, String lastName, char gender, int dayOfBirth, int monthOfBirth, int yearOfBirth, double heightInInches, double weightInPounds ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dayOfBIrth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.weightInPounds = weightInPounds;
        this.heightInInches = heightInInches;
        
    }


    public int calculateAge(int dia, int mes, int ano){
               
        int idade;
                if(dia < 0 || dia > 31 || mes > 12 || mes < 0 || ano > 2025 || ano < 1900){
                    idade = -1;
        }else{
                if(mes > 5 ){
                        idade = 2024 - ano;
        }else{
                if(mes < 5){
                        idade = 2025 - ano;
        }else{
                if(dia <= 5) {
                        idade = 2025 - ano;
                    
        }else{
                        idade = 2024 - ano;
                }

            }
        }
                }
        return idade;
    }

    public int calcularfrequenciaMaxima(int idade){
         
        return 220 - idade;

    }

    public String frequenciaCardiacaIdeal(int frequenciaMaxima){
        int frequenciaMaior = (int) (0.8 * frequenciaMaxima);
        int frequenciaMenor = (int) (0.5 * frequenciaMaxima);

        return "Frequência cardiaca ideal: "+frequenciaMenor+ "bpm - " +frequenciaMaior+ "bpm";

    }

    public double calcularBMI(double peso, double altura){
       

        return (peso * 703) / (altura * altura);
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public char getGender() {
        return gender;
    }


    public void setGender(char gender) {
        this.gender = gender;
    }


    public int getDayOfBIrth() {
        return dayOfBIrth;
    }


    public void setDayOfBIrth(int dayOfBIrth) {
        this.dayOfBIrth = dayOfBIrth;
    }


    public int getMonthOfBirth() {
        return monthOfBirth;
    }


    public void setMonthOfBirth(int monthOfBirth) {
        this.monthOfBirth = monthOfBirth;
    }


    public int getYearOfBirth() {
        return yearOfBirth;
    }


    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }


    public double getHeightInInches() {
        return heightInInches;
    }


    public void setHeightInInches(double heightInInches) {
        this.heightInInches = heightInInches;
    }


    public double getWeightInPounds() {
        return weightInPounds;
    }


    public void setWeightInPounds(double weightInPounds) {
        this.weightInPounds = weightInPounds;
    }
}

