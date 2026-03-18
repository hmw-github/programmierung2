package kapitel1;

public class SwitchExample {
    public static void main(String[] args) {
        String day = "Monday";

        String typeOfDay = switch (day) {
            case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" -> "Weekday";
            case "Saturday", "Sunday" -> "Weekend";
            default -> "Invalid day";
        };
        
        // valid switch 
        switch (day) {
        case "Monday":
        	typeOfDay = "Weekday";
        	break;
        case "Tuesday":
        	typeOfDay = "Weekday";
        	break;
        default:
        	typeOfDay = "Invalid day";        	
        }
        

        System.out.println("Today is a: " + typeOfDay);
    }
}
