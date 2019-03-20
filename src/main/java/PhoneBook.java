import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class People {
    String name;
    Set<String> phonenumber;
}



public class PhoneBook {
    final Map<String, Set<String>> pb = new HashMap<>();
    public void add(People name) {}
    void searchPeople(String phonenumber){
        if (phonenumber == null) System.out.print("Неправильные значения");
        for (String name: pb.keySet()) {
            if (pb.containsKey(phonenumber)) System.out.print(name);
        }
    }
    void searchNumber(String name){
        System.out.print(pb.get(name));
    }
    void remooveNumber(String name, Set<String> phonenumber){
        Set<String> numbers;
        numbers = pb.get(name);
        numbers.remove(phonenumber);
        pb.replace(name, numbers);
    }
    void remoovePeople(String name){
        System.out.print(pb.remove(name));
    }

} 