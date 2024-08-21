package structural.adapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.*;

// adaptee
public class EmployeeManager {
    public List<Employee> employees;

    public EmployeeManager() {
        employees = new ArrayList<>();
        this.employees.add(new Employee(31, "Peter"));
        this.employees.add(new Employee(52, "John"));
        this.employees.add(new Employee(13, "Jason"));
    }

    public String GetAllEmployees() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();

        for (Employee employee : employees) {
            marshaller.marshal(employee, sw);
        }

        return sw.toString();
    }
}
