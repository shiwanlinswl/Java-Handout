package cn.tedu.bin;

import java.io.IOException;

public class Demo07 {

	public static void main(String[] args) 
		throws IOException{
		//int c = '中';
		int c = 0x4e2d;
		System.out.println(c);
		System.out.println(Integer.toBinaryString(c));  
		int m = 0x3f;
		//将c的最后6位截取下来为k
		int k = c&m;
		System.out.println(Integer.toBinaryString(k));
		//将字符c的编为UTF-8，得到最后一个字节b3
		int b3 = c&0x3f|0x80; 
		System.out.println(Integer.toBinaryString(b3));
		//编码b2
		int b2 = (c>>>6)&0x3f|0x80;
		System.out.println(Integer.toBinaryString(b2));
		//编码b1
		int b1 = (c>>>12)|0xe0;
		//验证：
		byte[] bytes = {(byte)b1,(byte)b2,(byte)b3};
		String str = new String(bytes, "UTF-8");
		System.out.println(str);//中
		char cc = decodeUtf8(bytes);
		System.out.println(cc);
	}
	
	public static char decodeUtf8(byte[] bytes){
		int b1 = bytes[0];
		int b2 = bytes[1];
		int b3 = bytes[2];
		System.out.println(Integer.toBinaryString(b1));
		//b1 = 11111111 11111111 11111111 11100100 
		//b2 = 11111111 11111111 11111111 10111000
		//b3 = 11111111 11111111 11111111 10101101
		
// (b1&0xf)<<12 00000000 00000000 01000000 00000000
// (b2&0x3f)<<6 00000000 00000000 00001110 00000000
// (b3&0x3f)    00000000 00000000 00000000 00101101
		
		// ch=  00000000 00000000 01001110 00101101
		
		int ch = ((b1&0xf)<<12)|((b2&0x3f)<<6)|(b3&0x3f);
		return (char)ch;
	}
	
	public static byte[] utf8(String str){
		return null;
	}
	public static byte[] utf8(char ch){
		int b1 = (ch>>>12)|0xe0;
		int b2 = (ch>>>6) & 0x3f | 0x80;
		int b3 = ch & 0x3f | 0x80;
		return new byte[]{(byte)b1,(byte)b2,(byte)b3};
	}
	
	
	
}



