package KOS.Lessons.core.thinkingInJava.chapter10;

//: innerclasses/DotNew.java
// ���������������� �������� ����������� ������ � ���������� .new
public class DotNew {
    public class Inner {
        private void print(){
            System.out.println("printInner");
        }
    }
    public static void main(String[] args) {
        DotNew dn = new DotNew();
        DotNew.Inner dni = dn.new Inner();

        dni.print();
    }
}