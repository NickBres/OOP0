/**
 * To undo insert, need to save start and end offsets of inserted String and delete it from StringBuilder
 * @author Nikita Breslavsky, Chen Dahan
 * 4.11.2022
 */
public class UndoInsert extends Command {

    int start,end;

    public UndoInsert(StringBuilder stringBuilder, int start, int end) {
        super(stringBuilder);
        this.start = start;
        this.end = end;
    }


    @Override
    StringBuilder apply(){
       return this.stringBuilder.delete(start,end);
    }

}
