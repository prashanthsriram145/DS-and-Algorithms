package com.personal.dsalgo;

public class TowersOfHanoi {

    public void process(int diskNumber, char from, char to, char aux) {
        if (diskNumber == 1) {
            System.out.println(String.format("Moving disk %d from %s to %s ", diskNumber, from, to));
            return;
        }

        process(diskNumber - 1, from, aux, to);


        System.out.println(String.format("Moving disk %d from %s to %s ", diskNumber, from, to));

        process(diskNumber - 1, aux, to, from);
    }

    public static void main(String[] args) {
        TowersOfHanoi towersOfHanoi = new TowersOfHanoi();
        towersOfHanoi.process(3, 'A', 'C', 'B');
    }
}
