package KOS.Lessons.oop.worker;

public class HourEmployee extends Employee implements Comparable<Employee>{
    private double hourRate;

    HourEmployee(String name, double hourRate){
        this.name = name;
        this.hourRate = hourRate;
    }

    @Override
    public double salaryCount() {
        return 20.8*8*hourRate;
    }
    public String toString(){
        return "# " + getName() + " id_" + getId() + " #Hour" + " $" + salaryCount();
    }

    // sorts collection of employees in descending order by the average monthly salary
    // in the case of equal salary - by the name
    @Override
    public int compareTo(Employee employee) {
        int compareRez = Double.compare(employee.salaryCount(), this.salaryCount());
        if (compareRez != 0 ) return compareRez;
        return this.getName().compareTo(employee.getName());
    }
}
