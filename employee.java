import java.util.Scanner;

class Employee1{
    int id;
    String name;
    int salary;
    public Employee1(int id,String name,int salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSalary(int salary){
        this.salary = salary;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public int getSalary(){
        return this.salary;
    }
}

public class PRA16 {

    public static Employee1 secondHighest(Employee1[] employee1s){
        int secondHighestSalary = employee1s[0].getSalary();
        int firstHighest = employee1s[0].getSalary();
        for(Employee1 emp:employee1s){
            if(emp.getSalary()>firstHighest){
                firstHighest = emp.getSalary();
            }
        }
        for(Employee1 emp:employee1s){
            if(emp.getSalary()>secondHighestSalary && emp.getSalary()<firstHighest){
                secondHighestSalary = emp.getSalary();
            }
        }
        for(Employee1 emp:employee1s){
            if(emp.getSalary()==secondHighestSalary ){
                return emp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee1[] employee1s = new Employee1[3];
        for(int i = 0;i<3;i++){
            int a = sc.nextInt();sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();sc.nextLine();
            employee1s[i] = new Employee1(a,b,c);
        }
        Employee1 emp = secondHighest(employee1s);
        System.out.println("Name "+emp.getName());
        System.out.println("Salary "+emp.getSalary());
    }
}
