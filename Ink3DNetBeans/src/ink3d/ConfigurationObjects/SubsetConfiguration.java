package ink3d.ConfigurationObjects;

import java.io.File;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SubsetConfiguration {
    private String name;
    private double bottomZ;
    private double topZ;
    File amfFile;
    File gCodeFile;
    private PrintConfiguration printConfiguration;
    private List<FileConfiguration> fileConfigurations;

    public double getBottomZ() {
        return bottomZ;
    }

    public void setBottomZ(double bottomZ) {
        this.bottomZ = bottomZ;
    }

    public double getTopZ() {
        return topZ;
    }

    public void setTopZ(double topZ) {
        this.topZ = topZ;
    }

    public File getAmfFile() {
        return amfFile;
    }

    public void setAmfFile(File amfFile) {
        this.amfFile = amfFile;
    }

    public File getgCodeFile() {
        return gCodeFile;
    }

    public void setgCodeFile(File gCodeFile) {
        this.gCodeFile = gCodeFile;
    }

    public PrintConfiguration getPrintConfiguration() {
        return printConfiguration;
    }

    public void setPrintConfiguration(PrintConfiguration printConfiguration) {
        this.printConfiguration = printConfiguration;
    }

    public List<FileConfiguration> getFileConfigurations() {
        return fileConfigurations;
    }

    public void setFileConfigurations(List<FileConfiguration> fileConfigurations) {
        this.fileConfigurations = fileConfigurations;
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
        hash = 37 * hash + Objects.hashCode(this.name);
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
        final SubsetConfiguration other = (SubsetConfiguration) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (Double.doubleToLongBits(this.bottomZ) != Double.doubleToLongBits(other.bottomZ)) {
            return false;
        }
        if (Double.doubleToLongBits(this.topZ) != Double.doubleToLongBits(other.topZ)) {
            return false;
        }
        if (!Objects.equals(this.amfFile, other.amfFile)) {
            return false;
        }
        if (!Objects.equals(this.gCodeFile, other.gCodeFile)) {
            return false;
        }
        if (!Objects.equals(this.printConfiguration, other.printConfiguration)) {
            return false;
        }
        if (!Objects.equals(this.fileConfigurations, other.fileConfigurations)) {
            return false;
        }
        return true;
    }
    
    
}
