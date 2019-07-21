package transmissionEntity;

import transmission.Encapsulate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="我爱你";
		Encapsulate enc = new Encapsulate();
		enc.ASCIIEnc(enc, s);
		enc.encInt(0xc, 8);
		enc.printmsg();
		System.out.println(System.currentTimeMillis() / 1000);
	}

}
