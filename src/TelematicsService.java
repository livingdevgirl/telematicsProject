import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

import java.io.FileWriter;



public class TelematicsService {

    private VehicleInfo vehicleInfo;
    public TelematicsService(){};


    public static void report(VehicleInfo vehicleInfo){

//        String vin = String.valueOf(vehicleInfo.VIN);
//




        try {
            ObjectMapper mapper = new ObjectMapper();
            File carFile = new File(vehicleInfo.getVIN() + ".json");
            String json = mapper.writeValueAsString(vehicleInfo);
            System.out.println(String.format("Hey dude so your VIN is %s, that's great! NOW you gotta make a file that's a .json file and return an html template dummy.", vehicleInfo.VIN));
            //this is working

            //new code
            FileWriter fileWriter;
            fileWriter = new FileWriter(carFile);
            fileWriter.write(json);
            fileWriter.close();




            File file = new File(".");

            for (File f : file.listFiles()) {

                if (f.getName().endsWith(".json")) {

                    VehicleInfo value = null;
                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                VehicleInfo vi = mapper.readValue(json, VehicleInfo.class);

                String viWrite = mapper.writer().writeValueAsString(vi);
                    System.out.println("Json information is " + f.getName() + viWrite);

                    mapper.writeValue(new File(f.getName() + ".html") , newDashboard(value));

                }

            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException g){
            g.printStackTrace();
        }
//REPROMPT  SOMEONE TO INPUT AND CATCH THE ERROR WITH A RETURN MESSAGE TO USER DO NOT JUST PRINT STACK TRACE DAMMIT.


    }
    public static String newDashboard(VehicleInfo vehicleInfo){
        String html = "<html>" +
                "<body> #" +
                "</body>" +
                "</html>";


        html.replace("#", "number");
        return String.format(html);
    }
};




