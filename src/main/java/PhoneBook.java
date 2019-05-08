import java.util.*;

public class PhoneBook {
    private Map<String, ArrayList<String>> phoneBook;

    @Override
    public String toString() {
        return "PhoneBook{" + "phoneBook=" + phoneBook + '{';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook1 = (PhoneBook) o;
        return Objects.equals(phoneBook, phoneBook1.phoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneBook);
    }
    public PhoneBook( Map<String, ArrayList<String>> map) { this.phoneBook = map; }
    static boolean truePhone(String number) {
        return number.matches("[0-9+*#\\-]+");
    }

    PhoneBook addPeople(String people)
        throws Exception { //добавление человека в телефонной книге
        if (phoneBook.containsKey(people)) throw new Exception();
    phoneBook.put(people, new ArrayList<String>());
    return new PhoneBook(phoneBook);
    }

    PhoneBook removePeople(String people)
        throws Exception {//Удаление человека из телефонной книги
        if (!phoneBook.containsKey(people)) throw new Exception();
    phoneBook.remove(people);
    return new PhoneBook(phoneBook);
    }

    PhoneBook phoneAdd(String people, String phone)
        throws Exception {//Добавление номера
        if (!truePhone(phone) || !phoneBook.keySet().contains(people)) throw new Exception();
    ArrayList<String> a;
    a = phoneBook.get(people);
    if (a.contains(phone)) throw new Exception();
    a.add(phone);
    phoneBook.put(people, a);
    return new PhoneBook(phoneBook);
    }

    PhoneBook phoneDel(String people, String phone)
        throws Exception {//Удаление номера
        if (!truePhone(phone) || !phoneBook.keySet().contains(people)) throw new Exception();
    ArrayList<String> a;
    a = phoneBook.get(people);
    if (!a.contains(phone)) throw new Exception();
    a.remove(phone);
    phoneBook.put(people, a);
    return new PhoneBook(phoneBook);
    }

    String searchPeopleByPhone(String phone) throws Exception {
        String people = null;
        for (Map.Entry<String, ArrayList<String>> pair : phoneBook.entrySet()) {
            ArrayList<String> a = pair.getValue();
            if (a.contains(phone))
                people = pair.getKey();
        }
        if (people.isEmpty()) throw new Exception();
        return people;
    }

    ArrayList<String> searchPhonesByPeople(String people) throws Exception {
        ArrayList<String> a = null;
        for (Map.Entry<String, ArrayList<String>> pair : phoneBook.entrySet()) {
            if (people.equals(pair.getKey()))
                a = pair.getValue();
        }
        if (a.isEmpty()) throw new Exception();
        return a;
    }
}