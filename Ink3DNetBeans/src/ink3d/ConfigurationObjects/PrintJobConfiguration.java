package ink3d.ConfigurationObjects;

import java.io.File;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrintJobConfiguration {
    private String name;
    private PrinterConfiguration printerConfiguration;
    private List <SubsetConfiguration> subsetConfigurationList;

    public PrinterConfiguration getPrinterConfiguration() {
        return printerConfiguration;
    }

    public void setPrinterConfiguration(PrinterConfiguration printerConfiguration) {
        this.printerConfiguration = printerConfiguration;
    }

    public List<SubsetConfiguration> getSubsetConfigurationList() {
        return subsetConfigurationList;
    }

    public void setSubsetConfigurationList(List<SubsetConfiguration> subsetConfigurationList) {
        this.subsetConfigurationList = subsetConfigurationList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }        
}
