package com.softwarescares;

public class FloodFill
{
    //image =
     //[[1,1,1]
      //[1,1,0]
      //[1,0,1]]

    //Output =
     //[[2,2,2]
      //[2,2,0]
      //[2,0,1]]

    //sr = 1, sc = 1, newColor = 2;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        if (image[sr][sc] == newColor) return image;

        fill(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int color, int newColor)
    {
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length)
        {
            return;
        }
        image[sr][sc] = newColor;
        fill(image, sr-1, sc, color, newColor);
        fill(image, sr+1, sc, color, newColor);
        fill(image, sr, sc-1, color, newColor);
        fill(image, sr, sc+1, color, newColor);
    }

}
