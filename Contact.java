// Definice třídy reprezentující kontakt
public class Contact {
    // Statický čítač pro generování identifikátorů
    private static Long idCounter = 1L;

    // Atributy kontaktu
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Konstruktor pro vytvoření kontaktu a nastavení ID
    public Contact() {
        this.id = idCounter++;
    }

    // Gettery a settery pro jednotlivé atributy

    // Getter pro jméno
    public String getFirstName() {
        return firstName;
    }

    // Setter pro jméno
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter pro příjmení
    public String getLastName() {
        return lastName;
    }

    // Setter pro příjmení
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter pro telefonní číslo
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter pro telefonní číslo
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter pro ID
    public Long getId() {
        return id;
    }

    // Přetížená metoda toString pro snadné zobrazení kontaktu
    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}