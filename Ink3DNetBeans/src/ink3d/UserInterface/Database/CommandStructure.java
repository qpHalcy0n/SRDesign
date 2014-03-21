package ink3d.UserInterface.Database;

/**
 *
 * @author daniellain
 */
public abstract class CommandStructure {
    protected Object result;
    
    public abstract void execute();
    
    public Object getResult(){
        return result;
    }
}
