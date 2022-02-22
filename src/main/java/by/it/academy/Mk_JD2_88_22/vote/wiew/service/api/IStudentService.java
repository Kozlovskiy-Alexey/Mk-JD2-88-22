package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Citizen;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getStudentFromList();

    void putStudentToList(Student student);

    List<Citizen> getCitizenFromList();

    void putCitizenToList(Citizen student);
}
