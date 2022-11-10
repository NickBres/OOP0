/**
 * Abstract class of commands of StringBuilder
 * @author Nikita Breslavsky, Chen Dahan
 * 4.11.2022
 */
public abstract class Command {

    protected StringBuilder stringBuilder;

    public Command(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    abstract StringBuilder apply();


}
