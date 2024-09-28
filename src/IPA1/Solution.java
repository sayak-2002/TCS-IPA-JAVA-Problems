package IPA1;

import java.util.*;



public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        Employee[] emp = new Employee[n];
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt(); sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt(); sc.nextLine();
            char d = sc.next().charAt(0); sc.nextLine();
            double e = sc.nextDouble(); sc.nextLine();
            emp[i] = new Employee(a, b, c, d, e);
        }
        int inputAge = sc.nextInt(); sc.nextLine();

        Employee[] ans1 = getEmployeeWithSecondLowestSalary(emp);
        if (ans1 != null && ans1.length > 0) {
            System.out.println(ans1[0].getId() + "#" + ans1[0].getName());
        } else {
            System.out.println("No second lowest salary found");
        }


        int ans2 = countEmployeesBasedOnAge(emp, inputAge);
        if (ans2 == 0) {
            System.out.println("No employee found for the given age");
        } else {
            System.out.println(ans2);
        }
        sc.close();
    }

    public static int countEmployeesBasedOnAge(Employee[] emp, int inputAge) {
        int count = 0;
        for(int i=0; i<emp.length; i++) {
            if(emp[i].getAge() == inputAge) {
                count++;
            }
        }
        return count;
    }

    public static Employee[] getEmployeeWithSecondLowestSalary(Employee[] emp) {
        double min1 = Double.MAX_VALUE, min2 = Double.MAX_VALUE;
        for(int i=0; i<emp.length; i++) {
            double salary = emp[i].getSalary();
            if(salary < min1) {
                min2 = min1;
                min1 = salary;
            } else if (salary > min1 && salary < min2) {
                min2 = salary;
            }
        }

        List<Employee> result = new ArrayList<>();
        for(int i=0; i<emp.length; i++) {
            if(Objects.equals(emp[i].getSalary(), min2)) {
                result.add(emp[i]);
            }
        }

        return result.isEmpty() ? null : result.toArray(new Employee[0]);
    }
}


class Employee {
    private int id, age;
    private String name;
    private char gender;
    private double salary;

    public Employee(int id, String name, int age, char gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}