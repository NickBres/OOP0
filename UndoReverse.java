/**
 * To undo a reverse just need to reverse it again
 * this command applies reverse command on string builder
 * @author Nikita Breslavsky, Chen Dahan
 * 4.11.2022
 */
public class UndoReverse extends Command {

    public UndoReverse(StringBuilder stringBuilder) {
        super(stringBuilder);
    }

    @Override
    StringBuilder apply(){
        return  this.stringBuilder.reverse();
    }

}
