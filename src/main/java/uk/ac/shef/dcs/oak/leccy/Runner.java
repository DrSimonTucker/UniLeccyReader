package uk.ac.shef.dcs.oak.leccy;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Does all the work
 * 
 * @author sat
 * 
 */
public class Runner
{
   public static void main(String[] args)
   {
      LeccyFileReader reader = new LeccyFileReader();
      for (File f : new File("/Users/sat/data/university-electricity/").listFiles())
         if (f.getName().endsWith(".zip"))
            try
            {
               List<Reading> readings = reader.readFile(f);
               System.out.println("Read " + f + " => " + readings.size());
            }
            catch (IOException e)
            {
               e.printStackTrace();
            }
   }
}
