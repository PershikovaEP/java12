package ru.netology.repository;

import ru.netology.domain.Poster;

public class Repository {
    private Poster[] films = new Poster[0]; //задаем пустой массив

    public Poster[] findAll() {
        //возвращает массив всех хранящихся в массиве объектов
        return films;
    }

    public void save(Poster film) {
        // добавляет объект в массив
        Poster[] tmp = new Poster[films.length + 1]; //создаем временный массив tmp длиной на 1 больше
        for (int i = 0; i < films.length; i++) { // перебираем все элементы массива films
            tmp[i] = films[i];            // копируем их в новый массив tmp
        }
        tmp[tmp.length - 1] = film;  //заполняем последнюю ячейку массива
        films = tmp; //записываем временный массив в films
    }

    public Poster findById(int id) {
        // возвращает объект по идентификатору (либо null, если такого объекта нет)
        Poster tmp = null;  //начальное значение нулл
        for (Poster film : films) { //перебираем все фильмы в массиве
            if (film.getId() == id) { //если айди фильма равно айди, то выводим фильм
                tmp = film;
            }
        }
        return tmp;
    }

    public void removeById(int id) {
        //удаляет объект по идентификатору (если объекта нет, то пусть будет исключение, как на лекции)
        Poster[] tmp = new Poster[films.length - 1];  //создали массив длиной на один меньше
        int copyToIndex = 0; //переменная, сохраняющая место для копирования
        for (Poster film : films) {  //пройдем по всему массиву с фильмами
            if (film.getId() != id) {  //если id не совпадает, то копируем в эту ячейку, равную индексу, фильм
                tmp[copyToIndex] = film;
                copyToIndex++; //переставляем счетчик
            }
            films = tmp;
        }
    }

    public void removeAll() {
        //полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
        Poster[] tmp = new Poster[0];
        films = tmp;
    }
}

