package uk.ac.shef.dcs.oak.leccy;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Class to read data in from a zip file
 * 
 * @author sat
 * 
 */
public class LeccyFileReader
{
   public List<Reading> readFile(File in) throws IOException
   {
      List<Reading> readings = new LinkedList<Reading>();
      ZipFile file = new ZipFile(in);

      // Should be a single entry
      if (file.size() != 1)
         throw new IOException("Zip file contains more than one entry!");

      ZipEntry entry = file.entries().nextElement();

      BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(entry)));
      // Skip the header line
      reader.readLine();
      for (String line = reader.readLine(); line != null; line = reader.readLine())
      {
         readings.add(new Reading(line.trim()));
      }

      return readings;
   }
}
