package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Poster;
import ru.netology.repository.Repository;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

public class Manager1Test {
    Repository repo = Mockito.mock(Repository.class);
    Manager manager = new Manager(repo, 5);
    Poster film1 = new Poster(1, "Бладшот", "Боевик", "???");
    Poster film2 = new Poster(2, "Вперёд", "мультфильм", "???");
    Poster film3 = new Poster(3, "Отель Белград", "комедия", "???");
    Poster film4 = new Poster(4, "Джентельмены", "боевик", "???");
    Poster film5 = new Poster(5, "Человек-невидимка", "ужасы", "???");
    Poster film6 = new Poster(6, "Тролли. Мировой тур", "мультфильм", "???");
    Poster film7 = new Poster(7, "Номер один", "комедия", "???");
    Poster film8 = new Poster(8, "Номер два", "боевик", "???");
    Poster film9 = new Poster(9, "Номер три", "мультфильм", "???");
    Poster film10 = new Poster(10, "Номер четыре", "комедия", "???");
    Poster film11 = new Poster(11, "Номер пять", "мелодрама", "???");
    Poster film12 = new Poster(12, "Номер шесть", "комедия", "???");

    @Test
    public void shouldAddNewFilmAndOutputAllFilmsInTheOrderOfAddWithConstructorLimit() {
        Poster[] films = { film1, film2, film3 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = {film1, film2, film3};
        Poster[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderInLimitWithConstructorLimit() {
        Poster[] films = { film1, film2, film3 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = {film3, film2, film1};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayInReverseOrderAboveLimitWithConstructorLimit() {
        Poster[] films = { film1, film2, film3, film4, film5, film6, film7, film8, film9, film10, film11, film12 };
        doReturn(films).when(repo).findAll();

        Poster[] expected = {film5, film4, film3, film2, film1};
        Poster[] actual = manager.findLast();

        assertArrayEquals(expected, actual);
    }
}

