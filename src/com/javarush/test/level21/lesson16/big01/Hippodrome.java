package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

public class Hippodrome{
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses(){
        return horses;
    }

    public static void main(String[] args)
    {
        game = new Hippodrome();

        game.getHorses().add(new Horse("Chornuy", 3, 0));
        game.getHorses().add(new Horse("Biluy", 3, 0));
        game.getHorses().add(new Horse("Siruy", 3, 0));
        game.run();
        game.printWinner();
    }

    public void move(){
        for (Horse h : horses){
            h.move();
        }
    }

    public void print(){
        for (Horse h : horses){
            h.print();
        }
        System.out.println();
        System.out.println();
    }

    public void run(){
        for (int i = 0; i < 100; i++){
            move();
            print();
            try{
                Thread.sleep(500);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public Horse getWinner(){
        if (this.getHorses().size() != 0) {
            Horse winner = this.getHorses().get(0);
            for (int i = 1; i < this.getHorses().size(); i++) {
                if (Double.compare(this.getHorses().get(i).getDistance(), winner.getDistance()) > 0) {
                    winner = this.getHorses().get(i);
                }
            }
            return winner;
        }
        return null;
    }
    public void printWinner(){
        if (this.getWinner() != null)
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }
}


