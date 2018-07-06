package com.creat;

import java.awt.image.BufferedImage;

import jp.sourceforge.qrcode.data.QRCodeImage;

public class MyQRcodeImage implements QRCodeImage {

	BufferedImage bufferedImage;
	
	MyQRcodeImage(BufferedImage bufferedImage){
		this.bufferedImage = bufferedImage;
	}
	@Override
	public int getHeight() {
		return this.bufferedImage.getHeight();
	}

	@Override
	public int getPixel(int arg0, int arg1) {
		
		return this.bufferedImage.getRGB(arg0, arg1);
	}

	@Override
	public int getWidth() {
		
		return this.bufferedImage.getWidth();
	}
	
}
