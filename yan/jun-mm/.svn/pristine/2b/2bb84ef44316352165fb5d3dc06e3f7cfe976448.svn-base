package com.junkj.common.utils;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.imageio.ImageIO;

import org.apache.shiro.codec.Base64;

import com.junkj.common.IdGen.IdGenerate;
import com.junkj.common.config.Global;
import com.swetake.util.Qrcode;

/**
 * 二维码工具类
 * 
 * @author cheng
 *
 */
public class QrcodeUtils {

	public static String createCode(String codeVal) {
		return createCode(codeVal, null, null);
	}

	public static String createCode(String codeVal, String fielName) {
		return createCode(codeVal, fielName, null);
	}

	public static String createCode(String codeVal, Integer size) {
		return createCode(codeVal, null, size);
	}

	public static String createCode(String codeVal, String fielName, Integer size) {
		// 二维码存放目录
		String qrPath = "/qrcode";
		// 完整二维码路径
		String loclPath =  Global.getFileDir(qrPath);
		// 文件名称
		String randomName = IdGenerate.nextId();
		// 二维码名称
		String qrName = (fielName == null ? randomName : fielName) + ".jpg";
		BufferedImage bufImg = null;
		try {
			size = size == null ? 7 : size;
			Qrcode qrcodeHandler = new Qrcode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
			qrcodeHandler.setQrcodeVersion(size);
			// 获得内容的字节数组，设置编码格式
			byte[] contentBytes = codeVal.getBytes("utf-8");
			// 图片尺寸
			int pixoff = 10;
			int imgSize = 63 + pixoff * 2 + 12 * (size - 1);
			bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			// 设置背景颜色
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);

			// 设定图像颜色> BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量，不设置可能导致解析出错
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < imgSize) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				throw new Exception("QRCode content bytes length = " + contentBytes.length + " not in [0, 800].");
			}
			gs.dispose();
			bufImg.flush();
			File targetFile = new File(loclPath, qrName);
			// 创建文件夹
			if (!targetFile.exists()) {
				targetFile.mkdirs();
			}
			// 输出到文件流
			ImageIO.write(bufImg, "jpg", targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 返回相对路径
		return qrPath + "/" + qrName;
	}

	public static void main(String[] args) {
		String str = "6YKA6K+356CB772cbnVsbDvlkZjlt6Xlt6Xlj7fvvZw3Nzc75ZGY5bel5aeT5ZCN772c5bCP5piOO+iuv+WuouWnk+WQje+9nOaWr+iSguiKrDvorr/lrqLmgKfliKvvvZzpmL/mlq/okoLoiqw76K6/5a6i55S16K+d772c6Zi/5pav6JKC6IqsYWE76K6/5a6i5YWs5Y+4772c5pav6JKC6IqsYSdzJ2Rhc2Q75p2l6K6/5pe26Ze0772cMjAxOC0wNy0yMyAxMTowNDoyMi4wO+adpeiuv+S6i+eUse+9nOmYv+iQqOW+t2ZmO+Wnk+WQje+9nOmYv+aWr2Enc2FzO+W5tOmihu+9nOeahOmYv+iQqOW+t2ZmO+aAp+WIq++9nOmYv+aWr+iSguiKrDs=";
			System.out.println(Base64.decodeToString(str.getBytes()));
	}


	public static String createCodeBase64(String codeVal) {
		BufferedImage bufImg = null;
		Integer size = 15;
		Qrcode qrcodeHandler = new Qrcode();
		try {
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码尺寸，取值范围1-40，值越大尺寸越大，可存储的信息越大
			qrcodeHandler.setQrcodeVersion(size);
			// 获得内容的字节数组，设置编码格式
			byte[] contentBytes = codeVal.getBytes("utf-8");
			// 图片尺寸
			int pixoff = 10;
			int imgSize = 63 + pixoff * 2 + 12 * (size - 1);
			bufImg = new BufferedImage(imgSize, imgSize, BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();
			// 设置背景颜色
			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, imgSize, imgSize);

			// 设定图像颜色> BLACK
			gs.setColor(Color.BLACK);
			// 设置偏移量，不设置可能导致解析出错
			// 输出内容> 二维码
			if (contentBytes.length > 0 && contentBytes.length < imgSize) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				return "";
			}
			gs.dispose();
			bufImg.flush();
			
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ImageIO.write(bufImg, "jpg", out);
			byte[] b = out.toByteArray();
			return "data:image/jpg;base64,"+new String(Base64.encode(b));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

//	public static void main(String[] args) throws Exception {
//		ServerSocket server = new ServerSocket(8889);
//		System.out.println("服务器开启连接...端口为8889");
//		Socket s = server.accept();
//		while(true){
//			System.out.println("一客户端连接服务器，服务器传输图片...");
//			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
//			BufferedImage image = ImageIO.read(new File("1.gif"));	//读取1.gif并传输
//			ByteArrayOutputStream out = new ByteArrayOutputStream();
//			boolean flag = ImageIO.write(image, "gif", out);
//			byte[] b = out.toByteArray();
//			dout.write(b);
//			s.close();
//			System.out.println("图片传送完毕,服务器开启连接...端口为8889");
//			s = server.accept();
//			
//		}
//	}


}
