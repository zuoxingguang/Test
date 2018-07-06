package com.creat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.reader.QRCodeImageReader;

public class MainMathod {
	
	public static void main(String[] args) {
		Create creat = new Create();
//		try {
//			
//			File dir = new File("");
//			String programpath= dir.getCanonicalPath();
//			String codepath = programpath + "\\"+"code.jpg";
//			System.out.println(codepath);
//			
//			File file = new File(codepath);
//			BufferedImage bufferedImage = ImageIO.read(file);
//			
//			QRCodeDecoder qrCodeDecoder = new QRCodeDecoder();
//			byte[] bytes = qrCodeDecoder.decode(new MyQRcodeImage(bufferedImage));
//			
//			String str = new String(bytes);
//			System.out.println(str);
//			
//		}catch (IOException e) {
//			e.printStackTrace();
//		}
	}
}
