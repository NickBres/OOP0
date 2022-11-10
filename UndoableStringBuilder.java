import java.util.Stack;

/**
 *  String Builder wrap with undo function
 *   Using Stack of commands to save every step back.
 *   Every change creates new Command as an opposite of change and saves it in stack.
 *   When "undo", deletes last command from stack and apply its on StringBuilder.
 *
 *   @author Nikita Breslavsky, Chen Dahan
 *   4.11.2022
 */
 public class UndoableStringBuilder{


  final private Stack<Command> commands = new Stack<>();
  final private StringBuilder stringBuilder = new StringBuilder();



    /**
     * creates UndoInsert command adds it to stack and append new String to StringBuilder
     * @param str  string to append
     * @return last edited UndoableStringBuilder
     */
    public UndoableStringBuilder append(String str) {
        Command newDelete = new UndoInsert(this.stringBuilder,stringBuilder.length(),stringBuilder.length() + str.length());
        commands.add(newDelete);
        this.stringBuilder.append(str);
        return this;
    }

    /**
     * creates UndoDelete command adds it to stack and delete characters from StringBuilder
     * @param start  start point to delete from
     * @param end  end point to delete to
     * @return  last edited UndoableStringBuilder
     */
    public UndoableStringBuilder delete(int start,int end){
        String toDelete = this.stringBuilder.substring(start,end);
        Command newAppend = new UndoDelete(this.stringBuilder,toDelete,start);
        commands.add(newAppend);
        this.stringBuilder.delete(start,end);
        return this;
    }

    /**
     *  creates UndoInsert command adds it to stack and insert new String from offset point
     * @param offset  point to enter new string
     * @param str  new string to enter
     * @return last edited UndoableStringBuilder
     */
    public UndoableStringBuilder insert(int offset,String str){
        Command newDelete = new UndoInsert(this.stringBuilder,offset,offset + str.length());
        commands.add(newDelete);
        this.stringBuilder.insert(offset,str);
        return this;
    }

    /**
     * ccreates UndoReplace command adds it to stack and replaces characters in StringBuilder with new String
     * @param start  start point to replace from
     * @param end  end point to replace to
     * @param str  new string to replace
     * @return last edited UndoableStringBuilder
     */
    public UndoableStringBuilder replace(int start, int end, String str){
        Command undoReplace = new UndoReplace(this.stringBuilder,start,this.stringBuilder.substring(start,end));
        commands.add(undoReplace);
        this.stringBuilder.replace(start,end,str);
        return this;
    }
    /**
     * creates UndoReverse command adds it to stack and reverses StringBuilder
     * @return last edited UndoableStringBuilder
     */
    public UndoableStringBuilder reverse(){
        Command undoReverse = new UndoReverse(this.stringBuilder);
        commands.add(undoReverse);
        this.stringBuilder.reverse();
        return this;
    }

    /**
     * return to previous change using Stack of commands
     * @return previous change UndoableStringBuilder
     */
    public UndoableStringBuilder undo(){
        if(!commands.isEmpty()){//check if stack is not empty before delete
             commands.pop().apply();//delete item
        }
         return this;
    }


    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }
}
