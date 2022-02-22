package by.it.academy.Mk_JD2_88_22.vote.endpoints.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionStorage implements IStorageService {

    private final static String PERSON_ATTRIBUTE_NAME = "person";

    @Override
    public void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute(PERSON_ATTRIBUTE_NAME, person);
    }

    @Override
    public Person getFromStorage(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        return (Person) session.getAttribute(PERSON_ATTRIBUTE_NAME);
    }
}
