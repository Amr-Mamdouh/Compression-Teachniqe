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
public class Matrix {
    int [][]matrix;
    int sz;

    public Matrix(int SZ) {
        sz=SZ;
        matrix=new int[sz][sz];
        for(int i=0;i<sz;i++)
        {
            for(int j=0;j<sz;j++)
                matrix[i][j]=0;
        }
    }
    
	public void setmatrix1(int[][]m)
	{
		for(int i=0;i<sz;i++)
			for(int j=0;j<sz;j++)
				matrix[i][j]=m[i][j];
	}
	public int[][] getmatrix()
	{
		return matrix;
	}
	public void print()
	{
		for(int i=0;i<sz;i++)
			{
				for(int j=0;j<sz;j++)
					System.out.print(matrix[i][j]+" ");
                                System.out.println("");
				
					
			}
		System.out.println("------------------------------------------");
			
	}

    
}
