package eventmanagement.eventmanagement.exception;
public class applicationex extends  Exception{
    private Enumerror enumerror;

    public Enumerror getEnumerror() {
        return enumerror;
    }

    public void setEnumerror(Enumerror enumerror) {
        this.enumerror = enumerror;
    }

    public applicationex() {
    }

    public applicationex(String message) {
        super(message);
    }

    public applicationex(String message, Throwable cause) {
        super(message, cause);
    }

    public applicationex(Throwable cause) {
        super(cause);
    }

    public applicationex(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    public applicationex(String message, Throwable t, Enumerror enumerror) {
        super(message,t);
        this.enumerror=enumerror;
    }
}
