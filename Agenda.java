import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Agenda {
    private HashMap<String, String> contacts;
    private final String AGENDA = "src/assets/files/agenda.txt";

    public Agenda () {
        contacts = new HashMap<>();
        loadContacts();
    }

    public String addContact(String name, String number) {
        if (contacts.containsKey(name) || contacts.containsValue(number)) {
            return "El nombre o el número seleccionado ya existe.";
        } else {
            contacts.put(name, number);
            saveContacts();
            return "Contacto agregado correctamente.";
        }
    }

    public String searchContactByName(String name) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(name)) {
                return entry.getKey() + " " + entry.getValue();
            }
        }
        return "No se ha encontrado ningún contacto con ese nombre.";
    }

    public String removeContact(String nombre) {
        if (contacts.containsKey(nombre)) {
            contacts.remove(nombre);
            saveContacts();
            return "Contacto eliminado y agenda actualizada.";
        } else {
            return "No se ha encontrado el contacto.";
        }
    }

    public void viewAgenda() {
        System.out.println("AGENDA");
        System.out.println("------------------------");
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }

    public void loadContacts() {
        try (BufferedReader br = new BufferedReader(new FileReader(AGENDA))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                if (data.length == 2) {
                    contacts.put(data[0], data[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveContacts() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(AGENDA, false))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
