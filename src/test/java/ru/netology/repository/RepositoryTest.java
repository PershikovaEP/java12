package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Poster;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    Repository repo = new Repository();
    Poster film1 = new Poster(1, "Бладшот", "Боевик", "???");
    Poster film2 = new Poster(2, "Вперёд", "мультфильм", "???");
    Poster film3 = new Poster(3, "Отель Белград", "комедия", "???");

    //@BeforeEach      //выполнять перед каждым тестом добавление объектов
    //public void setup() {
       // repo.save(film1);
      //  repo.save(film2);
       // repo.save(film3);
   // }

    @Test
    public void shouldAddNewFilmAndOutputAllFilmsInTheOrderOfAdd() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);

        Poster[] expected = {film1, film2, film3};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);

        Poster expected = film1;
        Poster actual = repo.findById(1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNullWhenNotId() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);

        Poster expected = null;
        Poster actual = repo.findById(4);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldFindNullWhenNotFilms() {

        Poster expected = null;
        Poster actual = repo.findById(4);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveId() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);

        repo.removeById(film2.getId());

        Poster[] expected = {film1, film3};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAll() {
        repo.save(film1);
        repo.save(film2);
        repo.save(film3);
        repo.removeAll();

        Poster[] expected = {};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveAllWhenNotFilms() {
        repo.removeAll();

        Poster[] expected = {};
        Poster[] actual = repo.findAll();

        assertArrayEquals(expected, actual);
    }


}
