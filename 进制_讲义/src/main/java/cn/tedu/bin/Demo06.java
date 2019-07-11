package cn.tedu.bin;

public class Demo06 {

	public static void main(String[] args) {
		//补码具有互补对称现象： ~n+1 = -n
		int i = 50;
		int n = ~i+1;
		System.out.println(Integer.toBinaryString(i));
		System.out.println(Integer.toBinaryString(~i));
		System.out.println(Integer.toBinaryString(~i+1));
		System.out.println(n);//-50
	}

}
