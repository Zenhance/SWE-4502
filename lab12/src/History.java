import java.util.Stack;

public class History {
      private Stack<EditorMemento> mementoes = new Stack<>();

      private TextEditor e;
      public History(TextEditor e)
      {
          this.e=e;
      }

      public void Backup()
      {
          mementoes.push(e.createMemento());

      }
      public void Undo()
      {
          if(mementoes.isEmpty())
          {
              System.out.println("No history to undo");
              return;
          }

          EditorMemento m =mementoes.pop();
          e.restoreMemento(m);
          System.out.println("Undo successful");
      }
}
