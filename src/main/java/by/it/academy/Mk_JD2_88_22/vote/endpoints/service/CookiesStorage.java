package by.it.academy.Mk_JD2_88_22.vote.endpoints.service;

import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.IStorageService;
import by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto.Person;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class CookiesStorage implements IStorageService {

    private static final String FIRST_NAME_KEY = "firstName";
    private static final String LAST_NAME_KEY = "lastName";
    private static final String AGE_KEY = "age";

    @Override
    public void addToStorage(Person person, HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(createCookie(FIRST_NAME_KEY, person.getFirstName()));
        response.addCookie(createCookie(LAST_NAME_KEY, person.getLastName()));
        response.addCookie(createCookie(AGE_KEY, person.getAge()));
    }

    @Override
    public Person getFromStorage(HttpServletRequest request, HttpServletResponse response) {
        String firstName = getValueFromCookies(FIRST_NAME_KEY, request);
        String lastName = getValueFromCookies(LAST_NAME_KEY, request);
        int age = Integer.parseInt(getValueFromCookies(AGE_KEY, request));
        return new Person(firstName, lastName, age);
    }

    private Cookie createCookie(String key, Object value) {
        Cookie cookie = new Cookie(key, URLEncoder.encode(String.valueOf(value), StandardCharsets.UTF_8));
        cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(1)));
        return cookie;
    }

    private String getValueFromCookies(String cookiesName, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookiesName.equals(cookie.getName())) {
                    return URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                }
            }
        }
        return null;
    }
}
