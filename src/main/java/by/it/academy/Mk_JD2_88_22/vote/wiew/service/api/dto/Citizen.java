package by.it.academy.Mk_JD2_88_22.vote.wiew.service.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * 1. ИД гражданина
 * 2. Паспорт (объект типа Паспорт)
 * 3. ФИО
 * 4. Дата рождения (LocalDate)
 * <p>
 * 3. Эквивалентность гражданина определяется по ИД гражданина и паспорту
 */

public class Citizen implements Serializable {

    private String id;
    private Passport passport;
    private String name;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate birthday;

      public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;

        return Objects.equals(id, citizen.id) && Objects.equals(passport, citizen.passport);
    }

    public boolean isPassportOwner(Passport passport) {
        return id.equals(passport.getIdCitizen());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, passport);
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id='" + id + '\'' +
                ", passport=" + passport +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';

    }
}
