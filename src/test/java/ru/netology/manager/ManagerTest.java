package ru.netology.manager;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Poster;
import ru.netology.repository.Repository;
import static org.mockito.Mockito.*;

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
    public void shouldAddNewFilmInTheOrderOfAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        manager.addNewFilm(film1);
        manager.addNewFilm(film2);
        manager.addNewFilm(film3);

        Poster[] expected = { film1, film2, film3 };
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldOutputAllFilmsInTheOrderOfAdd() {
        Repository repo = Mockito.mock(Repository.class);
        Manager manager = new Manager(repo);
        Poster[] films = { film1, film2, film3 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = { film1, film2, film3 };
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderInLimit() {
        Repository repo = Mockito.mock(Repository.class);
        Manager manager = new Manager(repo);
        Poster[] films = { film1, film2, film3 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = { film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderAboveLimit() {
        Repository repo = Mockito.mock(Repository.class);
        Manager manager = new Manager(repo);
        Poster[] films = { film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = { film10, film9, film8, film7, film6, film5, film4, film3, film2, film1 };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderWithNotFilms() {
        Repository repo = Mockito.mock(Repository.class);
        Manager manager = new Manager(repo);
        Poster[] films = { };
        doReturn(films).when(repo).findAll();

        Poster[] expected = { };
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

}
