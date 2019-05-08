import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBookTest {

    @Test
    public void addPeople() throws Exception {
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        map1.put("Ivan", new ArrayList<>());
        map1.put("Alexey", new ArrayList<>());
        PhoneBook map2 = new PhoneBook( new HashMap<>());
        assertEquals(new PhoneBook(map1),map2.addPeople("Ivan").addPeople("Alexey"));
        assertThrows(Exception.class, () -> map2.addPeople("Ivan"));
    }

    @Test
    public void removePeople() throws Exception {
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        map1.put("Ivan", new ArrayList<>());
        PhoneBook map2 = new PhoneBook( new HashMap<>());
        map2.addPeople("Ivan");
        map2.addPeople("Alexey");
        assertEquals(new PhoneBook(map1),map2.removePeople("Alexey"));
        assertThrows(Exception.class, () -> map2.removePeople("jhdkjhkdd"));
    }

    @Test
    public void phoneAdd() throws Exception {
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        list.add("334");
        list.add("798978792");
        list.add("+67787832");
        map1.put("Ivan",list );
        map1.put("Alexey", new ArrayList<>());
        PhoneBook map2 = new PhoneBook( new HashMap<>());
        map2.addPeople("Ivan");
        map2.phoneAdd("Ivan","334");
        map2.addPeople("Alexey");
        assertEquals(new PhoneBook(map1),
                map2.phoneAdd("Ivan","798978792").phoneAdd("Ivan","+67787832"));
        assertThrows(Exception.class, () -> map2.phoneAdd("Ivan","334"));
        assertThrows(Exception.class, () -> map2.phoneAdd("jhdjhs","8478743"));
        assertThrows(Exception.class, () -> map2.phoneAdd("Ivan","980909023902M"));



    }

    @Test
    public void phoneDel() throws Exception {
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        ArrayList<String> list=new ArrayList<>();
        list.add("798978792");
        map1.put("Ivan",list );
        map1.put("Alexey", new ArrayList<>());
        PhoneBook map2 = new PhoneBook( new HashMap<>());
        map2.addPeople("Ivan");
        map2.addPeople("Alexey");
        map2.phoneAdd("Ivan","798978792");
        map2.phoneAdd("Ivan","12345");
        assertEquals(new PhoneBook(map1),map2.phoneDel("Ivan","12345"));
        assertThrows(Exception.class, () -> map2.phoneDel("Ivan","3238782792"));
        assertThrows(Exception.class, () -> map2.phoneDel("jhd232jhs","73892792"));
        assertThrows(Exception.class, () -> map2.phoneDel("Ivan","98090////3902M"));

    }

    @Test
    public void searchPeopleByPhone() throws Exception {
        ArrayList<String> list=new ArrayList<>();
        list.add("798978792");
        list.add("+67787832");
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        map1.put("Ivan",list );
        map1.put("Alexey", new ArrayList<>());
        PhoneBook map2=new PhoneBook(map1);
        assertEquals("Ivan",map2.searchPeopleByPhone("+67787832"));
        assertEquals("Alexey",
                map2.phoneAdd("Alexey","123").searchPeopleByPhone("123"));
        assertThrows(NullPointerException.class, () -> map2.searchPeopleByPhone("73892792"));
        assertThrows(NullPointerException.class, () -> map2.searchPeopleByPhone("98090////3902M"));


    }

    @Test
    public void searchPhonesByPeople() throws Exception {
        ArrayList<String> test=new ArrayList<>();
        test.add("8888");
        test.add("9999");
        Map<String, ArrayList<String>> map1 = new HashMap<>();
        PhoneBook map2=new PhoneBook(map1);
        map2.addPeople("Ivan");
        map2.addPeople("Alexey");
        map2.addPeople("Vadim");
        map2.phoneAdd("Ivan","6666").
                phoneAdd("Vadim","8888").phoneAdd("Vadim","9999");
        assertEquals(test,map2.searchPhonesByPeople("Vadim"));
        assertThrows(NullPointerException.class, () -> map2.searchPhonesByPeople("kjdks"));
        assertThrows(Exception.class, () -> map2.searchPhonesByPeople("Alexey"));

    }
}