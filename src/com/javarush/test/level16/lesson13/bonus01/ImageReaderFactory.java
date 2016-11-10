package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

public class ImageReaderFactory {
    private static ImageReader imageReader;
    public static ImageReader getReader(ImageTypes types){
            if (types == ImageTypes.JPG)
                imageReader = new JpgReader();
            else if (types == ImageTypes.BMP)
                imageReader = new BmpReader();
            else if (types == ImageTypes.PNG)
                imageReader = new PngReader();
            else throw new IllegalArgumentException();
        return imageReader;
    }
}
