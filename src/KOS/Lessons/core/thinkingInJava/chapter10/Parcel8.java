package KOS.Lessons.core.thinkingInJava.chapter10;

//: innerclasses/Parcel8.java
// ����� ������������ �������� ������.
public class Parcel8 {
    public Wrapping wrapping(int x) {
        // ����� ������������ �������� ������:
        return new Wrapping(x) { // // �������� ������������.
            public int value() {
                return super.value();
            }
        }; // // ��������� ����� � �������
    }
    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.wrapping(10);
        System.out.println(w.value());
    }
}