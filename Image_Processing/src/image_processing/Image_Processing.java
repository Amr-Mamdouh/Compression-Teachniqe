/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image_processing;

/**
 *
 * @author amr
 */
import java.awt.Image;
import java.io.File;
public class Image_Processing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RW r=new RW();
        int sz=4;
        String s="F:\\Picture\\Fun\\22d587cb66 - Copy - Copy.jpg";
        r.read_image(s,sz);
	 
    }
    
}
