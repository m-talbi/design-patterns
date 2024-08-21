package structural.adapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
    @XmlAttribute
    public int id;

    @XmlAttribute
    public String name;

    // JAXB requires a no-argument constructor for any class that it is trying to marshal or unmarshal.
    Employee() {

    }

    public Employee(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
