package com.mm.api.util;

import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonValidator {

    public static Timestamp dateFormate(String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return new Timestamp(df.parse(date).getTime());
    }

    public static boolean isValidURL(String url) {
        /* Try creating a valid URL */
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isValidPassword(String password) {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+=])(?=\\S+$).{8,}";
        return password.matches(pattern);
    }

    @SuppressWarnings("unused")
    public static boolean validateImageDimensionsForCreativeAds(MultipartFile file) throws IOException {
        boolean result = true;

        //converting multipart to file
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        BufferedImage bimg = ImageIO.read(convFile);
        int width = bimg.getWidth();
        int height = bimg.getHeight();

        //valid dimensions 300 x 250 || 300 x 50 || 320 x 50
        if ((width != 300 || height != 250) && (width != 300 || height != 50) && (width != 320 || height != 50)) {
            result = false;
        }
        convFile.delete();
        return result;
    }

    @SuppressWarnings("unused")
    public static boolean validateImageDimensionsForCreativeAds(MultipartFile file, Integer h, Integer w) throws IOException {
        boolean result = true;

        //converting multipart to file
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();

        BufferedImage bimg = ImageIO.read(convFile);
        int width = bimg.getWidth();
        int height = bimg.getHeight();

        //valid dimensions 300 x 250 || 300 x 50 || 320 x 50
//        if((width != 300 || height != 250) && (width != 300 || height != 50) && (width != 320 || height != 50)){
//        	result = false;
//        }
        if ((width != w || height != h)) {
            result = false;
        }

        convFile.delete();
        return result;
    }

    @SuppressWarnings("unused")
    public static boolean validateImageDimensionsForCompanyLogo(MultipartFile file) throws IOException {
        boolean result = true;

        //converting multipart to file
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        BufferedImage bimg = ImageIO.read(convFile);
        int width = bimg.getWidth();
        int height = bimg.getHeight();

        if (width != 34 || height != 34) {
            result = false;
        }
        convFile.delete();
        return result;
    }

    public static boolean validateImageDimensionsFromUrl(String urlStr, Integer height, Integer width) {
        boolean result = true;
        try {
            // Create a URL for the image's location
            URL url = new URL(urlStr);
            // Get the image
            BufferedImage bi = ImageIO.read(url);

            if ((width != bi.getWidth() || height != bi.getHeight())) {
                result = false;
            }
            bi.flush();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static boolean isValidEmail(String emailStr) {
        Matcher matcher = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(emailStr);
        if (matcher.find()) {
            return true;
        } else {
            return false;
        }
    }

    public static String roundValueString(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        return decimalFormat.format(number);
    }

    public static String roundValueString1(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        return decimalFormat.format(number);
    }

    public static String roundValue(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        return decimalFormat.format(number);
    }

    public static double roundDoubleValue(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#.0000");
        return Double.valueOf(decimalFormat.format(number));
    }

}
