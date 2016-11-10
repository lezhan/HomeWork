package com.javarush.test.level20.lesson07.task04;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.text.SimpleDateFormat;
import java.util.Date;
/* Externalizable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать.
Объект всегда должен содержать актуальные на сегодняшний день данные.*/
public class Solution implements Externalizable{
    public static void main(String[] args) {
        System.out.println(new Solution(4));
    }
    private static final long serialVersionUID = 1L;
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(){}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    @Override
    public String toString() {
        return this.string;
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException{
        out.writeObject(currentDate);
        out.writeObject(temperature);
        out.writeObject(string);
    }
    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException{
        currentDate = (Date) in.readObject();
        temperature = (int) in.readObject();
        string = (String) in.readObject();
    }
}
