public class TextEditor {
    private String content;
    private int position;
    private String selection;

    public TextEditor(){
        this.content="";
        this.position = 0;
        this.selection="";
    }

    public  void setContent(String content)
    {
        this.content= content;
    }
    public void addSelection(String selection)
    {
        this.selection=selection;
    }
    public void ClearSelection()
    {
        this.selection="";
    }
    public void ClearState()
    {
        this.content="";
        this.position = 0;
        this.selection="";
    }
    public void setPosition(int p)
    {
        this.position=p;
    }
    public void displayState()
    {
        System.out.println("content :" + content);
        System.out.println("position :" + position);
        System.out.println("selection :" + selection);

    }
    public EditorMemento createMemento(){
        return new EditorMemento(content,position,selection);
    }
    public void restoreMemento(EditorMemento e){
        if(e!= null)
        {
            this.content= e.getContent();
            this.position= e.getPosition();
            this.selection =e.getSelection();
        }
    }

    public String getContent() {
        return this.content;
    }

    public int getPosition() {
        return  this.position;
    }
}
