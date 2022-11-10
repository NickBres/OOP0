/**
 * To undo delete, need to save deleted string and its start place, and insert it in current StringBuilder
 * @author Nikita Breslavsky, Chen Dahan
 * 4.11.2022
 * */
public class UndoDelete extends Command {

    String str;
    int offset;

    public UndoDelete(StringBuilder stringBuilder, String str, int offset) {
        super(stringBuilder);
        this.str = str;
        this.offset = offset;
    }


    @Override
    StringBuilder apply() {
        return this.stringBuilder.insert(offset,str);
    }
}
