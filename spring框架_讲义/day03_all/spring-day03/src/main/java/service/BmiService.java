package service;
/**
 * 	模型：负责处理业务逻辑
 *
 */
public class BmiService {
	public String bmi(double height,double weight){
		String status = "正常";
		double bmi = 
				weight / height / height;
		if(bmi < 19){
			status = "过轻";
		}
		if(bmi > 25){
			status = "过重";
		}
		return status;
	}
}
