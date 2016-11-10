package KOS.Lessons.oop.customerRental;

public class Rental {
    private int kind;
    private int days;

    public Rental(int kind, int days){
        this.kind = kind;
        this.days = days;
    }

    public double getBasePrice(){
        return 3.87;
    }

    private double amountFor(){
        double result;
        result = days*getBasePrice();
        if (kind==1){
            result = result*1.5;
        }
        if (kind==2){
            result = result*2;
        }
        if (kind==3){
            result = result*3;
        }
        if (days>7){
            result = result*3;
        }
        return result;
    }

//    private double amountFor(Rental rental){
//        double result;
//        result = rental.getDays()*rental.getBasePrice();
//        if (rental.getKind()==1){
//            result = result*1.5;
//        }
//        if (rental.getKind()==2){
//            result = result*2;
//        }
//        if (rental.getKind()==3){
//            result = result*3;
//        }
//        if (rental.getDays()>7){
//            result = result*3;
//        }
//        return result;
//    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
