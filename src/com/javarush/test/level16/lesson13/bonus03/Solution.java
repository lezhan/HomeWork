package com.javarush.test.level16.lesson13.bonus03;

/* Отдебажим все на свете
Разобраться, что делает програма.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)

Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message
*/

public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        threadA.start();
        threadA.setUncaughtExceptionHandler(handler);
        threadB.start();
        threadB.setUncaughtExceptionHandler(handler);
        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException x) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}

//для этой задачи нашел 3 способа решения:
//        1) здесь уже обсуждался и заключается он в использовании функции setDefaultUncaughtExceptionHandler() вместо setUncaughtExceptionHandler() в конструкторе класса TestedThread.
//        2)
//
//
//        threadA.start();
//        threadA.setUncaughtExceptionHandler(handler);
//        threadB.start();
//        threadB.setUncaughtExceptionHandler(handler);
//
//
//
//        Конструктор класса TestedThread можно не менять(оставить дефолтным), а можно все из него вычистить ибо оно все равно там не нужно, да и сам конструктор убрать.
//
//        3) добавить в try Thread.currentThread().setUncaughtExceptionHandler(handler). Конструктор класса TestedThread можно не менять(оставить дефолтным), а можно все из него вычистить ибо оно все равно там не нужно, да и сам конструктор убрать.
//
//        Во все 3 случаях программа выдает искомый результат, но, как я подозреваю, правильно она работает только во 2, 3 — т.е. выводит эксепшн от конкретно своей нити.
//        Вопрос: прав ли я?
//        вопрос 2: правильно ли я понимаю, что по дефолту у нас поток TestedThread запушен в потоках threadA и threadB и в исходном коде мы перехватываем UncaughtException именно от TestedThread, а надо от threadA и threadB?
//
//        0
//        0
//
//        5 комментариев
//        подписаться на новые комментарии
//        konstantin_v
//
//        konstantin_v
//        28 июля 2014, 14:51
//        0
//        1
//
//        Интересная задача.
//        Класс TestedThread, который представляет собой поток, создаётся уже запущенным (start() вызывается в конструкторе). Кроме того, в данном потоке установлен обработчик необработанных исключений.
//
//
//        TestedThread commonThread = new TestedThread(handler);
//
//
//        Т.о. переменная commonThread ссылается на уже запущенный поток.
//
//
//        Thread threadA = new Thread(commonThread, "Нить 1");
//        Thread threadB = new Thread(commonThread, "Нить 2");
//
//
//        При создании новых потоков threadA и threadB мы используем конструктор public Thread(Runnable target, String name). В качестве первого параметра мы передаем запущенный поток. Но фактически мы просто используем метод run() класса TestedThread. При создании потоков threadA и threadB конструктор TestedThread не используется, обработчики необработанных исключений для данных потоков не установлены (имеется в виду вариант задачи по умолчанию). Поэтому RuntimeException в последних двух потоках и не обрабатываются как мы того хотим.
//
//        p.s. подробно про UncaughtExceptionHandler: javatutor.net/articles/catching-uncaught-exceptions
//
//        Ответить
//
//        GDove
//
//        GDove
//        28 июля 2014, 15:09
//        0
//        ↑
//
//        когда я создавал тему, я еще не осознал, что любой поток это отдельная и независимая сущность, поэтому сам вопрос в теме задан немного не корректно. Твое пояснение детальное и понятное, я так не смог =)
//        если ты обратишь внимание, то в основной ветке обсуждения задачи, пипл действует по варианту 1), что на мой взгляд не верно, т.к. устанавливает хендлер для всех нитей, а нам нужно только для нити А и В.
//
//        Ответить
//
//        konstantin_v
//
//        konstantin_v
//        28 июля 2014, 15:21
//        0
//        ↑
//
//        решил написать развернутое объяснение, т.к. в основной ветке есть множество комментариев типа: «решил, но не понял как». Сам долго не мог понять как можно создать поток из потока)
//
//        Все стало на свои места после добавления следующей строки в конструктор TestedThread.
//
//
//        System.out.println(Thread.currentThread().getName());
//
//
//        Проанализировав вывод, можно понять, что в программе работают четыре нити:
//        main, Thread-0, Нить 1, Нить 2. Но это я уже повторяюсь.
//
//        Ответить
//
//        GDove
//
//        GDove
//        28 июля 2014, 15:33
//        0
//        ↑
//
//        собственно теперь, если кто-то захочет разобраться, то оставленных комментариев будет достаточно =)
//
//        Ответить
//
//        belarus2012
//
//        belarus2012
//        23 октября 2014, 21:34
//        0
//        ↑
//
//        очень помогло, а то и вправду сделал но не понял как.
//        У меня другой вопрос. Я перенес setUncaughtExceptionHandler в блок Run.
//        и если написать просто setUncaughtExceptionHandler(new OurUncaughtExceptionHandler()) — оно не работает, а если Thread.currentThread().set~… то всё ок.
//        хотя как я понимаю этот метод выполняется в контексте текущего потока и должен применяться для текущего потока.
//        Даже в дебаггере проверил, что this == Thread.currentThread();
//
//
//        можете объяснить почему так работает?
//
//        Да если сделать commonThread.interrupt() в main тогда у нас выведется три надписи
//        Нить 1: My exception message
//        Thread-0: My exception message
//        Нить 2: My exception message
//        но если сделать не через currentThread() тогда отрабатывает только для Thread-0
//
//        Ответить
//
//        Оставить комментарий
