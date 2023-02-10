package eventmanagement.eventmanagement.exception;

import org.springframework.context.annotation.Configuration;

@Configuration
public class Applicationerror {
    private  Enumerror mess;
    private String Description;
    private Throwable throwable;

    public Enumerror getMess() {
        return mess;
    }

    public void setMess(Enumerror mess) {
        this.mess = mess;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}

