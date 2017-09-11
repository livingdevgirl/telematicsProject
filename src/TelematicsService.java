import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;



public class TelematicsService {

    private VehicleInfo vehicleInfo;

    public TelematicsService (VehicleInfo newVehicle) {
    }


    public static void report (VehicleInfo vehicleInfo) {

//        String vin = String.valueOf(vehicleInfo.VIN);
//

        try {
            ObjectMapper mapper = new ObjectMapper ();
            File carFile = new File (vehicleInfo.getVIN () + ".json");
            String json = mapper.writeValueAsString (vehicleInfo);
            System.out.println (String.format ("Hey dude so your VIN is %s, that's great! NOW you gotta make a file that's a .json file and return an html template dummy.", vehicleInfo.VIN));
            //this is working
            String odometer = String.format ("%.1s", vehicleInfo.odometer);
            String consumption = String.format ("%.2s", vehicleInfo.consumption);
            String lastReading = String.format ("%.3s", vehicleInfo.lastReading);
            String liters = String.format ("%.4s", vehicleInfo.engineSize);
            String basichtml = String.format ("<html>\n" +
                    "<body>\n" +
                    "The current odometer reading is " +
                    odometer.toString () +
                    "miles\n" +
                    "The total consumption is " +
                    consumption.toString () +
                    "gallons\n" +
                    "the last reading the odometer was " +
                    lastReading +
                    "miles\n" +
                    "the total engine size in liters is " +
                    liters +
                    "." +
                    "</html>", vehicleInfo.consumption);





            //new code
            FileWriter fileWriter;
            fileWriter = new FileWriter (carFile);
            fileWriter.write (json);
            fileWriter.close();



            //filewriter for HTML
//            FileWriter htmlFile = new FileWriter (fileWriter.getAbsolutePath("dashboard.html"));
            String htmlDirection = "dashboard.html";
            File htmlFile = new File(htmlDirection);
                FileOutputStream stream = new FileOutputStream(htmlFile, false);
                byte[] myBytes = basichtml.getBytes();
                stream.write(myBytes);
                stream.close();

            File file = new File (".");

            for (File f : file.listFiles ()) {

                if (f.getName ().endsWith (".json")) {
                    // Now you have a File object named "f".
                    // You can use this to create a new instance of Scanner
                    VehicleInfo vi = mapper.readValue (json, VehicleInfo.class);
                    String viWrite = mapper.writer ().writeValueAsString (vi);
                    System.out.println ("Json information is " + f.getName () + viWrite);

                }

            }
        } catch (JsonProcessingException e) {
            e.printStackTrace ();
        } catch (IOException g) {
            g.printStackTrace ();
        }

    }

    //add method to get the info from json into list
//
//    public static List<VehicleInfo> transfer (VehicleInfo vi) throws IOException {
//        File file = new File (".");
//        List<VehicleInfo> vinfo = new ArrayList<> ();
//        for (File x : file.listFiles ()) {
//            if (x.getName ().endsWith (".json")) {
//                ObjectMapper lemapper = new ObjectMapper ();
//                vinfo.add (lemapper.readValue (x, VehicleInfo.class));
//            }
//        }
//        return vinfo;
//    }
}