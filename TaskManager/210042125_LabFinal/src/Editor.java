public class Editor {
    public String text;

    public String getText(){
        return text;
    }

    public void deselectText(){
        text= "";
    }

    public void deleteText(){
        text="";
    }
    public void insertText(String text){
        this.text= text;
    }

}
