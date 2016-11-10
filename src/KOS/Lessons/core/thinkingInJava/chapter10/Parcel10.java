package KOS.Lessons.core.thinkingInJava.chapter10;

//: innerclasses/Parcel10.java
// ������������ "������������� ����������" ���
// ��������������� ����������� ����������� ������
public class Parcel10 {
    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            // ������������� ���������� ��� ������� �������:
            {
                cost = Math.round(price);
                if(cost > 100)
                    System.out.println("Over budget!");
            }
            private String label = dest;
            public String readLabel() { return label; }
//            public void printLabel(){
//                System.out.println(label);
//            }
        };
    }
    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);

    }
}