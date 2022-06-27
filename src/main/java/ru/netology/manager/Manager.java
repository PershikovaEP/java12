package ru.netology.manager;

import ru.netology.domain.Poster;
import ru.netology.repository.Repository;

public class Manager {

    private Repository repo;  //поле репозитория
    private int maxLimit = 10;

    public Manager(Repository repo) {  //конструктор, через который получает менеджер значения c репозитрия
        this.repo = repo;
    }

    public Manager(Repository repo, int maxLimit) { //конструктор для получения значений с репозитория и указания лимита
        this.repo = repo;
        this.maxLimit = maxLimit;
    }

    public void addNewFilm(Poster film) {
        //добавление нового фильма
       repo.save(film);
    }

    public Poster[] findAll() {
        //вывод всех фильмов в порядке добавления
        return repo.findAll();
    }

    public Poster[] findLast() {
        //Вывод максимум лимит* последних добавленных фильмов в обратном от добавления порядке
        Poster[] films = repo.findAll();  //берем массив из репо
        int resultLength;  //переменная, определяющая длину массива
        if (films.length > maxLimit) {   //если длина массива с фильмами больше макс лимита, то длина равна макс
            resultLength = maxLimit;
        } else {            //иначе длина равна длине массива с фильмами
            resultLength = films.length;
        }

        Poster[] result = new Poster[resultLength]; //создали новый массив длиной равной вычисленной длине
        for (int i = 0; i < resultLength; i++) {    //перебираем фильмы
            result[i] = films[resultLength - 1 - i];  //и записываем результат в обратном порядке
        }
        return result;
    }
}
