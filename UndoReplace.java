/** Replace function deletes characters and inserts new string.
 *To make an undo it uses Undo insert and delete functions.
 * @author Nikita Breslavsky, Chen Dahan
 * 4.11.2022
 */
public class UndoReplace extends Command {

    int start;
    String str;

    public UndoReplace(StringBuilder stringBuilder, int start, String str) {
        super(stringBuilder);
        this.start = start;
        this.str = str;
    }



    @Override
    StringBuilder apply() {
       new UndoInsert(this.stringBuilder,start,str.length()).apply();
       return  new UndoDelete(this.stringBuilder,str,start).apply();
    }
}
