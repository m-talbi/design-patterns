package structural.adapter;

import javax.xml.bind.JAXBException;

public class Main {
    public static void main(String[] args) throws JAXBException {
        var empManager = new EmployeeManager();
        IEmployee empAdapter = new EmployeeAdapter();

        System.out.println("Employees in XML");
        System.out.println(empManager.GetAllEmployees());

        System.out.println("Employees in JSON");
        System.out.println(empAdapter.GetAllEmployees());
    }
}
