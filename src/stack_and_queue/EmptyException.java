package stack_and_queue;

public class EmptyException extends Exception{
    String message;
    public EmptyException(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmptyException{" +
                "message='" + message + '\'' +
                '}';
    }
}
