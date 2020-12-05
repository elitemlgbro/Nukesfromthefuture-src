package nukesfromthefuture.util;

import nukesfromthefuture.Nukesfromthefuture;
import nukesfromthefuture.Reference;
import org.apache.logging.log4j.Level;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class UpdateChecker {
    public static boolean newUpdate = false;
    public static String versionNumber = "";

    public static void checkForUpdate(){
        try{
            URL modSrc = new URL("https://raw.githubusercontent.com/elitemlgbro/Nukesfromthefuture-src/master/src/main/java/nukesfromthefuture/Reference.java");
            BufferedReader readerIG = new BufferedReader(new InputStreamReader(modSrc.openStream()));

            Nukesfromthefuture.logger.log(Level.INFO, "Finding new updates, if any!");
            String versionInfoLine;

            while((versionInfoLine = readerIG.readLine()) != null){
                if(versionInfoLine.contains("String version")){
                    int start = versionInfoLine.indexOf('"');
                    int end = versionInfoLine.lastIndexOf('"');

                    String sub = versionInfoLine.substring(start + 1, end);
                    newUpdate = !Reference.version.equals(sub);
                    versionNumber = sub;
                    Nukesfromthefuture.logger.info("Found new Update: " + sub);
                    break;
                }
            }
            Nukesfromthefuture.logger.info("Update check ended.");
            readerIG.close();
        }catch(IOException e){
            Nukesfromthefuture.logger.warn("Update check failed!");
        }
    }
}
