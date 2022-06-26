package ru.netology.manager;

import ru.netology.domain.Poster;

public class Manager {
    //все фильмы должны храниться внутри массива в поле самого менеджера.
    //изначально нулевой массив
    private Poster[] films = new Poster[0];
    private int maxLimit = 10;

    public Manager() {
    }

    public Manager(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    public void addNewFilm(Poster film) {
        //добавление нового фильма
        Poster[] tmp = new Poster[films.length + 1]; //создаем временный массив tmp длиной на 1 больше
        for (int i = 0; i < films.length; i++) { // перебираем все элементы массива films
            tmp[i] = films[i];            // копируем их в новый массив tmp
        }
        tmp[tmp.length - 1] = film;  //заполняем последнюю ячейку массива
        films = tmp; //записываем временный массив в films
    }

    public Poster[] findAll() {
        //вывод всех фильмов в порядке добавления
        return films;
    }

    public Poster[] findLast() {
        //Вывод максимум лимит* последних добавленных фильмов в обратном от добавления порядке
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
