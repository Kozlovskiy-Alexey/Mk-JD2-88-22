package by.it.academy.Mk_JD2_88_22.vote.controllers.mains;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Citizen;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Passport;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JSONMain1 {

    private final static String STUDENT_ID_KEY = "id";
    private final static String STUDENT_NAME_KEY = "name";
    private final static String STUDENT_AGE_KEY = "age";
    private final static String STUDENT_SCORE_KEY = "score";
    private final static String STUDENT_OLYMPIC_GAME_KEY = "olympicGamer";

    public static void main(String[] args) throws IOException {

        JSONObject node1 = new JSONObject();

        Student student1 = new Student();
        student1.setId(2);
        student1.setAge(18);
        student1.setName("Ilia");
        student1.setScore(125.54);
        student1.setOlympicGamer(true);


        node1.put(STUDENT_ID_KEY, 1);
        node1.put(STUDENT_NAME_KEY, "Alexey");
        node1.put(STUDENT_AGE_KEY, 38);
        node1.put(STUDENT_SCORE_KEY, 99.99);
        node1.put(STUDENT_OLYMPIC_GAME_KEY, true);
        String s = node1.toJSONString();
        System.out.println(s);
        System.out.println(System.currentTimeMillis());

//        Passport passport1 = new Passport("1", "123456", "Партизанский проспект 137", LocalDate.now());
//        Passport passport2 = new Passport("2", "123457", "Партизанский проспект 137", LocalDate.now());
//        Citizen citizen1 = new Citizen("100", passport1, "Алексей Козловский", LocalDate.of(1983, 4, 21));
//        Citizen citizen2 = new Citizen("101", passport2, "Илья Козловский", LocalDate.of(2009, 9, 16));
//
//        // записать Java объект в Json файл
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File("D:\\Java\\Mk-JD2-88-22\\src\\main\\java\\by\\it\\academy\\Mk_JD2_88_22\\vote\\controllers\\mains\\example.json");
//        mapper.writeValue(file, citizen1);
//
//        // Java object to Json
//        String valueAsString = mapper.writeValueAsString(citizen1);
//        System.out.println(valueAsString);
//
//        String valueAsString1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(citizen1);
//        System.out.println(valueAsString1);
//
//        // Json to Java object from file
//        Citizen citizenFromJson1 = mapper.readValue(file, Citizen.class);
//        System.out.println(citizenFromJson1);
//
//        // Json String to Java object
//        Citizen readValue = mapper.readValue("{\"id\":\"100\",\"passport\":{\"id\":\"1\",\"idCitizen\":\"123456\",\"address\":" +
//                "\"Партизанский проспект 137\",\"createDate\":19033},\"name\":\"Алексей Козловский\",\"birthday\":" +
//                "\"21.04.1983\"}", Citizen.class);
//        System.out.println(readValue);
//
//        List<Citizen> citizenList = new ArrayList<>();
//        citizenList.add(citizen1);
//        citizenList.add(citizen2);
//
//        mapper.writeValue(file, citizenList);
//        String arrayFromFile = "{\"id\":\"100\",\"passport\":{\"id\":\"1\",\"idCitizen\":\"123456\",\"address\":" +
//                "\"Партизанский проспект 137\",\"createDate\":19033},\"name\":\"Алексей Козловский\"," +
//                "\"birthday\":\"21.04.1983\"}";
//        List<Citizen> citizenList1 = mapper.readValue(file, new TypeReference<List<Citizen>>() {
//        });
//        System.out.println();
//        citizenList1.forEach(System.out::println);
//
//        System.out.println();
//        String jsonString = "{\"id\" : \"125\", \"name\" : \"Alexey\", \"lastName\" : \"Kozlovskiy\"}";
//        Map<String, Object> stringObjectMap = mapper.readValue(jsonString, new TypeReference<Map<String, Object>>() {
//        });
//        stringObjectMap.forEach((key, value) -> System.out.println(key + " : " + value));


    }
}
