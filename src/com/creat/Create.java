package com.creat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class Create {
	
	//Create的构造方法
	Create(){
		
		Qrcode code1 = new Qrcode();
		
		//解码跟二维码的容错率和解码模式有关！！！！！
		code1.setQrcodeEncodeMode('B');
		//设置容错率
		code1.setQrcodeErrorCorrect('M');
		
		String base64 = "iVBORw0KGgoAAAANSUhEUgAAABkAAAAUCAMAAABPqWaPAAAABGdBTUEAALGPC/xhBQAAAAFzUkdCAK7OHOkAAAAeUExURWZmYzYuKz40L29ubIiIhn18eV5dWiklIktHRBAMC8Ud5soAAADHSURBVCjPVZALkgQhCEMBJeD9LzwBdHaHtqpLngkfcV+LhyGZkMXvRgoZj6RqRIrwST0TUUUBpBoJLxMkoQZ3KsyUKkt5hFeD4AKiV0ZgtGG+f0T0u034KqMO1fYbgOosf0g+N2f5v7xqoiRAE69aF9ELZQU08ax8o1xThWSPaFpj/ddZk+35rRQ16XSw9/ad/7uu3V0yGrXZXPREa8iWN5EF45h8yWpFIebPCRRqst8aKn/yLDyNY3anTZDs+RLaDSkQtQLBB1l/BcZMoSCnAAAAAElFTkSuQmCC";
		String str = "BEGIN:VCARD\n" + 
				  "PHOTO;ENCODING=b:"+base64+"\n"+ 
				  "FN:左星光\n" + 
				  "ORG:河北科技师范学院\n" + 
				  "TITLE:学生\n" + 
				  "ADR;WORK:秦皇岛海港区360号\n" + 
				  "ADR;HOME:河北科技师范学院\n" + 
				  "TEL;CELL,VOICE:123456789\n" + 
				  "TEL;WORK,VOICE:123456789\r\n" + 
				  "URL;WORK;:http://www.hevttc.edu.cn\n" + 
				  "EMAIL;INTERNET,HOME:920945416@qq.com\n" + 
				  "END:VCARD";
		boolean[][] count = code1.calQrcode(str.getBytes());
		int codesize = 67+12*(code1.getQrcodeVersion() - 1);
		
		BufferedImage buffer = new BufferedImage(codesize, codesize, BufferedImage.TYPE_INT_RGB);
		Graphics2D gra = buffer.createGraphics();
		//修改画板颜色并清除画板
		gra.setBackground(Color.white);
		gra.setColor(Color.black);
		gra.clearRect(0, 0, codesize, codesize);
		
		int startR = 235;
		int startG = 125;
		int startB = 16;
		int endR = 12;
		int endG = 239;
		int endB = 120;
		
		
		for (int i = 0; i < count.length; i++) {
			for (int j = 0; j < count.length; j++) {
				if(count[i][j]){
					int r = startR + (endR - startR) * (j+1)/count.length;
					int g = startG + (endG - startG) * (j+1)/count.length;
					int b = startB + (endB - startB) * (j+1)/count.length;
					Color color = new Color(r,g,b);
					gra.setColor(color);
					
					gra.fillRect(i*3+2, j*3+2, 3, 3);
				}
			}
		}
		
		
		try {
			/**
			 * programpath：获取项目所在路径
			 * logopath：引用的logo的路径
			 * codepath：生成二维码的路径
			 * logo：读取的logo图像
			 * logosize：logo的大小
			 * logox：logo的横纵坐标
			 */
			File dir = new File("");
			String programpath= dir.getCanonicalPath();
			String logopath = programpath + "\\" + "logo.jpg";
			String codepath = programpath + "\\";
			
			Image logo = ImageIO.read(new File(logopath));
			int logosize = codesize/3;
			int logox = (codesize-logosize)/2;
			gra.drawImage(logo, logox, logox, logosize, logosize, null);
			
			gra.dispose();
			buffer.flush();
			
			ImageIO.write(buffer, "jpg", new File(codepath+"code.jpg"));
			System.out.println(codepath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
