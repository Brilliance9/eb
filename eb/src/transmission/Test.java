package transmission;

import servlet.TransmissionServlet;

public class Test {

	public static double[] String2doubles(String[] str){
		double[] ints = new double[str.length];
		for(int i=0;i<str.length;i++){
			if(str[i] != null && !str[i].equals("") && !str[i].equals("null")){
				ints[i]=Double.parseDouble(str[i]);
			}else{
				ints[i]=0;
			}
		}
		return ints;	
	}
	public static void main(String[] args) {
		String time="2019-01-02T03:04";
		String[] str=time.split("-");
		String year = str[0];
		String month = str[1];
		String[] s = str[2].split("T");
		String day = s[0];
		String[] ss = s[1].split(":");
		String hour = ss[0];
		String minute = ss[1];
		System.out.println(year);
		System.out.println(month);
		System.out.println(day);
		System.out.println(hour);
		System.out.println(minute);

	}

}
