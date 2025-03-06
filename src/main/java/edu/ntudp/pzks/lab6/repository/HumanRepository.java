package edu.ntudp.pzks.lab6.repository;

import java.util.List;

public interface HumanRepository <T> {

    void save (T t);

    List<T> getAll();

    List<T> getByMonthOfBirthDate(int month);

    void delete (T t);
}
