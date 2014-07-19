import java.awt.image.BufferedImage;
import java.awt.*;
import javax.swing.*;
import java.net.URL;
import java.io.*;
import javax.imageio.ImageIO;
import java.util.Scanner;
import java.util.Random;

class Coral {

    public static void main(String[] args) throws Exception {

        BufferedImage coralImg0;
        BufferedImage coralImg1;
        BufferedImage coralImg2;
        BufferedImage coralImg3;
        /*Create an array that contains the images (exept 0),
        * for easy randomization*/
        BufferedImage[] coralArray = new BufferedImage[3];

        coralImg0 = ImageIO.read(new File("coral0.jpg"));
        coralImg1 = ImageIO.read(new File("coral1.jpg"));
        coralImg2 = ImageIO.read(new File("coral2.jpg"));
        coralImg3 = ImageIO.read(new File("coral3.jpg"));

        coralArray[0] = coralImg1;
        coralArray[1] = coralImg2;
        coralArray[2] = coralImg3;
        
        int height = 0;        
        int h_modifier = 348;
        int n_img = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Give number of images: ");
        String s =  input.next();
        try {
                n_img = Integer.parseInt(s);
        } catch (NumberFormatException e) {
                System.out.println("That's not an integer!");
                System.exit(1);
        }

        final BufferedImage largeCoral =
            new BufferedImage(624,n_img*348,BufferedImage.TYPE_INT_RGB);
 
        Graphics g = largeCoral.getGraphics();
        /*always begin with coral0*/
        g.drawImage(coralImg0, 0, height, null);
        height += h_modifier;

        Random rnd = new Random();
        int j;
        
        for (int i = 1; i < n_img; i++) {
                g.drawImage(coralArray[rnd.nextInt(3)], 0, height, null);
                height += h_modifier;
        }
       File utfil = new File("image.jpg"); 

        ImageIO.write(largeCoral, "jpg", utfil);
    }
}
