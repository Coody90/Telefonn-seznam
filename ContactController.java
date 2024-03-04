import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    // Seznam kontaktů
    private List<Contact> contacts = new ArrayList<>();

    // Endpoint pro získání seznamu všech kontaktů
    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // Endpoint pro získání konkrétního kontaktu podle ID
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        Contact foundContact = findContactById(id);
        return foundContact != null ?
                new ResponseEntity<>(foundContact, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint pro vytvoření nového kontaktu
    @PostMapping
    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
        contacts.add(contact);
        return new ResponseEntity<>("Contact created successfully", HttpStatus.CREATED);
    }

    // Endpoint pro aktualizaci kontaktu podle ID
    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        Contact existingContact = findContactById(id);
        if (existingContact != null) {
            // Aktualizovat atributy kontaktu
            existingContact.setFirstName(updatedContact.getFirstName());
            existingContact.setLastName(updatedContact.getLastName());
            existingContact.setPhoneNumber(updatedContact.getPhoneNumber());
            return new ResponseEntity<>("Contact updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pro smazání kontaktu podle ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        Contact existingContact = findContactById(id);
        if (existingContact != null) {
            contacts.remove(existingContact);
            return new ResponseEntity<>("Contact deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Contact not found", HttpStatus.NOT_FOUND);
        }
    }

    // Pomocná metoda pro nalezení kontaktu podle ID
    private Contact findContactById(Long id) {
        return contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

