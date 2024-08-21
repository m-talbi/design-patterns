package structural.adapter;

import org.json.XML;

import javax.xml.bind.JAXBException;

// adapter
public class EmployeeAdapter extends EmployeeManager implements IEmployee {
    public EmployeeAdapter() {
        super();
    }

    @Override
    public String GetAllEmployees() throws JAXBException {
        String xml = super.GetAllEmployees();
        var jsonObject = XML.toJSONObject(xml);
        return jsonObject.toString(4);
    }
}
