package KOS.Lessons.core;

class Cat
{
    public static void print(int n)
    {
        System.out.println("int = " + n);
    }
    public static void print(short n)
    {
        System.out.println("short = " +n);
    }
    public static void print(Integer n)
    {
        System.out.println("Integer = " +n);
    }
    public static void print(String s)
    {
        System.out.println("String = " +s);
    }
    public static void main(String[] args)
    {
        Cat.print(1);
        Cat.print((byte)1);
        Cat.print("1");
        Cat.print((int)2.3f);
    }
}