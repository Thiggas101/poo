
import java.time.LocalDate;


public class HeartRates {

  private String firstName;
  private String lastName;
  private int dayOfBirth;
  private int monthOfBirth;
  private int yearOfBirth;


  public HeartRates(String firstName, String lastName, int dayOfBirth, int monthOfBirth, int yearOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.dayOfBirth = dayOfBirth;
    this.monthOfBirth = monthOfBirth;
    this.yearOfBirth = yearOfBirth;
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

  public int calculateAge(int currentYear){
    int idade = currentYear-this.yearOfBirth;
    if(LocalDate.now().getMonthValue() < this.monthOfBirth) idade--;
    return idade;
  }

  public int calculateMaxHeartRate(){
    return 220 - this.calculateAge(LocalDate.now().getYear());
  }

  public String calculateTargetHeartRate(){
    String ans = new String();
    int limiteInferior = (int) (this.calculateMaxHeartRate()*0.5);
    int limiteSuperior = (int) (this.calculateMaxHeartRate()*0.85);
    ans += limiteInferior + " bpm - " + limiteSuperior + " bpm";
    return ans;
  }
}