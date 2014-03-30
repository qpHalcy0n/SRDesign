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
    private List <ExtruderMaterialConfiguration> extruderMaterials;

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

    public List<ExtruderMaterialConfiguration> getExtruderMaterials() {
        return extruderMaterials;
    }

    public void setExtruderMaterials(List<ExtruderMaterialConfiguration> extruderMaterials) {
        this.extruderMaterials = extruderMaterials;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.printerConfiguration);
        hash = 17 * hash + Objects.hashCode(this.subsetConfigurationList);
        hash = 17 * hash + Objects.hashCode(this.extruderMaterials);
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
        if (!Objects.equals(this.extruderMaterials, other.extruderMaterials)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PrintJobConfiguration{" + "name=" + name + ", printerConfiguration=" + printerConfiguration + ", subsetConfigurationList=" + subsetConfigurationList + ", extruderMaterials=" + extruderMaterials + '}';
    }

    
}
