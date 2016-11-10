package KOS.Lessons.oop.worker;

class PermanentEmployee extends Employee implements Comparable<Employee>  {
    private double averageSalary;

    PermanentEmployee(String name, double averageSalary){
        this.name = name;
        this.averageSalary = averageSalary;//
    }

    @Override
    public double salaryCount() {
        return averageSalary;
    }
    public String toString(){
        return "# " + this.getName() + " id_" + this.getId() +  " Fix " + " $" + averageSalary;
    }

    // sorts collection of employees in descending order by the average monthly salary
    // in the case of equal salary - by the name
    @Override
    public int compareTo(Employee employee) {
        // for descending order we compare employee, this
        int compareRez = Double.compare(employee.salaryCount(), this.salaryCount());
        if (compareRez != 0 ) return compareRez;
        //if salaries are equal, compare names
        return this.getName().compareTo(employee.getName());
    }


}
