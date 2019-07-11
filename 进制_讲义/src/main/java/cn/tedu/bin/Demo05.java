package cn.tedu.bin;

public class Demo05 {

	public static void main(String[] args) {
		int i = -1;
		int n = -4;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(n));
		
		for(i=-50; i<=50; i++){
			System.out.println(Integer.toBinaryString(i));
		}
	}

}
