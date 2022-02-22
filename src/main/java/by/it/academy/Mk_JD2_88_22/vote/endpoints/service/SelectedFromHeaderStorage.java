package by.it.academy.Mk_JD2_88_22.vote.endpoints.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectedFromHeaderStorage implements IStorageService {

    private final CookiesStorage cookiesStorage;
    private final SessionStorage sessionStorage;

    public SelectedFromHeaderStorage() {
        this.sessionStorage = new SessionStorage();
        this.cookiesStorage = new CookiesStorage();
    }

    @Override
    public void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response) {
        getService(request).addToStorage(person, request, response);
    }

    @Override
    public Person getFromStorage(HttpServletRequest request, HttpServletResponse response) {
        return getService(request).getFromStorage(request, response);
    }

    private IStorageService getService(HttpServletRequest request) {
        String storage = request.getHeader("storage");
        if (storage.equals("SESSION")) {
            return sessionStorage;
        } else if (storage.equals("COOKIES")) {
            return cookiesStorage;
        } else {
            throw new IllegalArgumentException("Не найдено выбранное хранилище");
        }
    }
}
