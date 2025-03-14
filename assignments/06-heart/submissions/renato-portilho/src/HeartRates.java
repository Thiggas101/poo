
public class HeartRates {
    private String firstName;
    private String lastName;
    private int dayOfBirth;
    private int monthOfBirth;
    private int yearOfBirth;
    
    public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.monthOfBirth = monthOfBirth;


    }


 
    public int calcularIdade(int dia, int mes, int ano){
               
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

        return "Frequência cardiaca ideal: "+frequenciaMenor+ " bpm - " +frequenciaMaior+ " bpm";

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



    public int getDayOfBirth() {
        return dayOfBirth;
    }



    public void setDayOfBirth(int dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
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
}

