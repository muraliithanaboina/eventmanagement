package eventmanagement.eventmanagement.exception;


public enum Enumerror {
   Event_not_found("404"),
 attendee_Not_found("404");
    private String value="";

    Enumerror(String value) {
        this.value = value;
    }
}
