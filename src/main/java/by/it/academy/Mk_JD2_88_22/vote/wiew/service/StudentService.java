package by.it.academy.Mk_JD2_88_22.vote.wiew.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IStudentService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Citizen;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Student;
import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService {

    private final static StudentService instance = new StudentService();
    List<Student> studentList;
    List<Citizen> citizenList;

    private StudentService() {
        this.studentList = new ArrayList<>();
        this.citizenList = new ArrayList<>();
    }

    public static StudentService getInstance() {
        return instance;
    }

    @Override
    public List<Student> getStudentFromList() {
        return this.studentList;
    }

    @Override
    public void putStudentToList(Student student) {
        this.studentList.add(student);
    }

    @Override
    public List<Citizen> getCitizenFromList() {
        return this.citizenList;
    }

    @Override
    public void putCitizenToList(Citizen citizen) {
        citizenList.add(citizen);
    }
}
