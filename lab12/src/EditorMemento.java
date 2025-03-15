public class EditorMemento {
    private String content;
    private int position;
    private String selection;

    public EditorMemento(String content, int p, String s)
    {
        this.content=content;
        this.position=p;
        this.selection=s;
    }
    public String getContent()
    {
        return content;
    }

    public int getPosition(){
        return position;
    }
    public String getSelection()
    {
        return selection;
    }


}
