public abstract class Command {

    String backup;
    Application application;
    Editor editor;

    public Command(Application app, Editor editor) {
        this.application= app;
        this.editor= editor;
        this.backup="";
    }

    public void saveBackup(){
        this.backup= editor.text;
    }

    public abstract void execute();
}
