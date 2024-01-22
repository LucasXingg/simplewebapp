package gameRuntime;

public class LOG {
    
    public static void log(String message_, String method_, String class_){
        String msg = String.join("", "LOG: {", class_, ".", method_, "} ", message_);
        System.out.println(msg);
    }

    public static void log(Exception e, String method_, String class_){
        String msg = String.join("", "LOG: {", class_, ".", method_, "} ", e.getMessage());
        System.out.println(msg);
        e.printStackTrace();
    }

    public static void log(Exception e, String method_, String class_, String line_){
        String msg = String.join("", "LOG: {", class_, ".", method_, "} ", e.toString(), " (In line: ", line_, " )");
        System.out.println(msg);
        e.printStackTrace();
    }

}
