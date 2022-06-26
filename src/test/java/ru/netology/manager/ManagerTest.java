package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

public class ManagerTest {

    Poster film1 = new Poster(1, "Бладшот", "Боевик", "???");
    Poster film2 = new Poster(2, "Вперёд", "мультфильм", "???");
    Poster film3 = new Poster(3,"Отель Белград","комедия","???");
    Poster film4 = new Poster(4,"Джентельмены","боевик","???");
    Poster film5 = new Poster(5,"Человек-невидимка","ужасы","???");
    Poster film6 = new Poster(6,"Тролли. Мировой тур","мультфильм","???");
    Poster film7 = new Poster(7,"Номер один","комедия","???");
    Poster film8 = new Poster(8,"Номер два","боевик","???");
    Poster film9 = new Poster(9,"Номер три","мультфильм","???");
    Poster film10 = new Poster(10,"Номер четыре","комедия","???");
    Poster film11 = new Poster(11,"Номер пять","мелодрама","???");
    Poster film12 = new Poster(12,"Номер шесть","комедия","???");


    @Test
    public void shouldAddNewFilmAndOutputAllFilmsInTheOrderOfAdd() {
        Manager manager = new Manager();
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        Poster[] expected = { film1, film2, film3 };
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddNewFilmAndOutputAllFilmsInTheOrderOfAddWithConstructor() {
        Manager manager = new Manager(5);
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        Poster[] expected = { film1, film2, film3 };
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderInLimit() {
        Manager manager = new Manager();
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        Poster[] expected = { film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderInLimitWithConstructor() {
        Manager manager = new Manager(5);
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        Poster[] expected = { film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldReturnArrayInReverseOrderAboveLimit() {
        Manager manager = new Manager();
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);
        manager.addNewFilm(film4);
        manager.addNewFilm(film5);
        manager.addNewFilm(film6);
        manager.addNewFilm(film7);
        manager.addNewFilm(film8);
        manager.addNewFilm(film9);
        manager.addNewFilm(film10);
        manager.addNewFilm(film11);
        manager.addNewFilm(film12);

        Poster[] expected = { film10, film9, film8, film7, film6, film5, film4, film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderAboveLimitWithConstructor() {
        Manager manager = new Manager(5);
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);
        manager.addNewFilm(film4);
        manager.addNewFilm(film5);
        manager.addNewFilm(film6);
        manager.addNewFilm(film7);
        manager.addNewFilm(film8);
        manager.addNewFilm(film9);
        manager.addNewFilm(film10);
        manager.addNewFilm(film11);
        manager.addNewFilm(film12);

        Poster[] expected = { film5, film4, film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}
