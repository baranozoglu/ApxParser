package exception;

public class CouldNotParseFile extends Throwable {
    public CouldNotParseFile() {
        super("Something went wrong during parsing!");
    }

    public CouldNotParseFile(String message) {
        super(message);
    }
}
