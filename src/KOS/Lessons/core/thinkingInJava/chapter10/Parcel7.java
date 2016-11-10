package KOS.Lessons.core.thinkingInJava.chapter10;

//: innerclasses/Parcel7.java
// ����� ���������� ��������� ����������� ����������� ������
public class Parcel7 {
    public Contents contents() {
        return new Contents() {// �������� ����������� ������
            private int i = 11;
            public int value() { return i; }
        };  // � ������ �������� ����� � ������� ����������
    }
    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        System.out.println(c.value());
    }
}