package ink3d.ConfigurationObjects;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PrintJobConfiguration {
    private String name;
    private PrinterConfiguration printerConfiguration;
    private List <SubsetConfiguration> subsetConfigurationList;

    public PrintJobConfiguration() {
        this.name = "";
        this.printerConfiguration = new PrinterConfiguration();
        this.subsetConfigurationList = new ArrayList<>();
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PrintJobConfiguration other = (PrintJobConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.printerConfiguration, other.printerConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.subsetConfigurationList, other.subsetConfigurationList)) {
            return false;
        }
        return true;
    }
    
}
