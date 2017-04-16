package image_processing;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class RW {
	int heigh=0,wedith=0;
        int sz;
	int [][]pixelsr;
        int [][]pixelsb;
        int [][]pixelsg;
        double [][]avg;
	ArrayList<Matrix>mr=new ArrayList<Matrix>();
        ArrayList<Matrix>mb=new ArrayList<Matrix>();
        ArrayList<Matrix>mg=new ArrayList<Matrix>();
	Matrix M;
	int [][]M1=new int[2][2];
        ///////////////////////Average Matrix/////////////////////////////////////////////
        public void setaverage(ArrayList<Matrix> avrg)
        {   Matrix M;
            
            for(int i=0;i<avrg.size();i++)
            {   M=new Matrix(sz);
                int [][]X=new int[sz][sz];
                    M=avrg.get(i);
                    X=M.getmatrix();
                    for(int j=0;j<sz;j++)
                    {   for(int x=0;x<sz;x++)
                        {
                                avg[j][x]+=X[j][x];
                        }
                        
                    }
            }
            for(int j=0;j<sz;j++)
                    {   for(int x=0;x<sz;x++)
                        { avg[j][x]/=avrg.size();}
                    }
            
        }
        ////Read Image///////////////////////////////////////////////
	public void read_image(String s,int SZ)
	{ sz=SZ;
            avg=new double[sz][sz];
		File file=new File(s);
		BufferedImage image=null;
		try 
		{
			
			image=ImageIO.read(file);
			heigh=image.getHeight();
			wedith=image.getWidth();
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("H	"+heigh+"  W  "+wedith);
			pixelsr=new int[heigh][wedith];  
                        pixelsg=new int[heigh][wedith];
                        pixelsb=new int[heigh][wedith];
        for(int x=0;x<wedith;x++) {
            for(int y=0;y<heigh;y++){
                int rgb=image.getRGB(x, y);
                int alpha=(rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = (rgb >> 0) & 0xff;
                
                pixelsr[y][x]=r;
                pixelsb[y][x]=b;
                pixelsg[y][x]=g;
                
            }
        }
     
       
        for(int i=0;i<100;i+=sz)
        {
        	 for(int j=0;j<100;j+=sz)
        	 {
        		 M1[0][0]=pixels[i][j]; 
        		 M1[0][1]=pixels[i][j+1];
        		 M1[1][0]=pixels[i+1][j];
        		 M1[1][1]=pixels[i+1][j+1];
                         M=new Matrix(sz);
                         M.setmatrix1(M1);
                         
        		mr.add(M);	
        	 }
        	 
        }
        System.out.println("\nMatrix Size :"+mr.size()+" \n");
        for(int i=0;i<100;i++)
        {for(int j=0;j<100;j++)
        {
            System.out.print(pixels[i][j]+" ");
        }
            System.out.println("\n");
        }
            
        for(int i=0;i<100;i++)
        	mr.get(i).print();
        File fileout=new File("F:\\Picture\\Fun\\22d587cb66 - Copy - Copy2.jpg");

        BufferedImage image2=new BufferedImage(wedith,heigh,BufferedImage.TYPE_INT_RGB );


        for(int x=0;x<wedith ;x++)
        for(int y=0;y<heigh;y++) {
        image2.setRGB(x,y,(pixels[y][x]<<16)|(pixels[y][x]<<8)|(pixels[y][x]));

        }

        try {
        ImageIO.write(image2, "jpg", fileout);
        } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        }

	}//end read fun 
	

}//end class
