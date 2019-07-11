package cn.tedu.bin;

public class Demo04 {

	public static void main(String[] args) {
		int min = Integer.MIN_VALUE;
		System.out.println(Integer.toBinaryString(min));
		int max = Integer.MAX_VALUE;
		System.out.println(Integer.toBinaryString(max));
		System.out.println(max);
		//利用16进制缩写 int 的最大值和最小值
		int n = 0x80000000;
		int m = 0x7fffffff;
	}

}
