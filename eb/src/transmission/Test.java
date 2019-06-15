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
		int tt = 1;
		switch(tt){
		case 1:
			System.out.println(11);
			System.out.println(12);
			break;
		case 2:
			System.out.println(21);
			System.out.println(22);
			break;
		case 3:
			System.out.println(31);
			System.out.println(32);
			break;
			default:;
		}

	}

}
