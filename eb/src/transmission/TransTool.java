package transmission;

public class TransTool {

	
	public byte[] bytes2bits(byte[] bytes) {
		byte[] bits = new byte[bytes.length*8];
		int cntbyte=0;
		for(int i=0;i<bytes.length;i++) {
			for(int j=0;j<8;j++) {
				bits[i*8+(7-j)] = (byte)((bytes[i]>>j)&1);
			}
		}
		return bits;
	}
	
	/*
	 * 将long类型数据转化为byte[]
	 * */
	 public byte[] Long2Bytes(Long lnum) {   
		byte[] bytes = new byte[8];
		int cnt=7;
		long num = lnum;
		while(cnt>=0) {
			bytes[cnt--]=(byte)num;
			num>>=8;
		}
		return bytes;
	}
	
	/* 将short转化为byte[]
	 * */
	public byte[] Short2Bytes(short num) {
		byte[] bytes = new byte[2];
		bytes[1]=(byte)num;
		bytes[0]=(byte)(num>>8);
		return bytes;
	}
	
	/*将byte类型数据转化为byte[]
	 * */
	public byte[] Byte2Bytes(byte num) {  
		byte[] bytes = new byte[1];
		bytes[0] = num;
		return bytes;
	}
	
	/*
	 * 将int类型数据转化为byte[]
	 * */
	public byte[] Int2Bytes(int num) {   
		byte[] bytes = new byte[4];
		int cnt=3;
		while(cnt>=0) {
			bytes[cnt--]=(byte)num;
			num>>=8;
		}
		return bytes;
	}
	public static void main(String[] args) {
		TransTool tt= new TransTool();
		byte[] bytes = tt.Int2Bytes(0);
		System.out.println(bytes.length);
	}
	
	

}
