import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.deploy.util.SyncFileAccess;


import java.io.File;



public class TelematicsService {

    static void report(VehicleInfo vehicleInfo) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            String json = mapper.writeValueAsString(vehicleInfo);
            System.out.println(String.format("Hey dude so your VIN is %s, that's great! NOW you gotta make a file that's a .json file and return an html template dummy.", vehicleInfo.VIN));


        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
//REPROMPT  SOMEONE TO INPUT AND CATCH THE ERROR WITH A RETURN MESSAGE TO USER DO NOT JUST PRINT STACK TRACE DAMMIT.

//    File file = new File(".json");
//            for (File f : file.listFiles()) {
//        if (f.getName().endsWith(".json")) {
//            // Now you have a File object named "f".
//            // You can use this to create a new instance of Scanner

    }



}
