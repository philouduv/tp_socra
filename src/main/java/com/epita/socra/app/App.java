package com.epita.socra.app;

import com.epita.socra.app.tools.*;

/**
 * Hello world!
 */
public final class App {
    private IOAdapter adapter;
    private ConvertorInterface conv = new Convertor();
    private App() {
        this(new ConsoleAdapter());
    }

    public App(IOAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        App application = new App();
        application.run();
    }

    public void run(){
        adapter.write("Enter your conversion type : ");
        String type = adapter.read();
        if (!type.equals("Roman") && !type.equals("Arabic")){
            adapter.write("Bad conversion type !");
            return;
        }
        String roman = "";
        while (roman != null){
            adapter.write("Enter your number : ");
            String number = adapter.read();
            if (type.equals("Roman"))
                roman = conv.convert_R_to_A(number);
            else
                roman = conv.convert_A_to_R(number);
            adapter.write("Here's your converted number is : " + roman + " !");
        }
    }
    public void runInRoman(){
        adapter.write("Enter your number : ");
        String number = adapter.read();
        String roman = conv.convert_R_to_A(number);
        adapter.write("Here's your converted number is : " + roman + " !");
    }
    public void runInArabic(){
        adapter.write("Enter your number : ");
        String number = adapter.read();
        String roman = conv.convert_A_to_R(number);
        adapter.write("Here's your converted number is : " + roman + " !");
    }

}
