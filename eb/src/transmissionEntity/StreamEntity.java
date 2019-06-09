package transmissionEntity;

public class StreamEntity {

	private int stream_type;
	private int reserved1;
	private int elementary_PID;
	private int reserved2;
	private int ES_info_length;
	private Program descrpitor2;
	
	public StreamEntity(){
		this.reserved1=7;
		this.reserved2=15;
	}
	public int getStream_type() {
		return stream_type;
	}
	public void setStream_type(int stream_type) {
		this.stream_type = stream_type;
	}
	public int getReserved1() {
		return reserved1;
	}
	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}
	public int getElementary_PID() {
		return elementary_PID;
	}
	public void setElementary_PID(int elementary_PID) {
		this.elementary_PID = elementary_PID;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public int getES_info_length() {
		return ES_info_length;
	}
	public void setES_info_length(int eS_info_length) {
		ES_info_length = eS_info_length;
	}
	public Program getDescrpitor2() {
		return descrpitor2;
	}
	public void setDescrpitor2(Program descrpitor2) {
		this.descrpitor2 = descrpitor2;
	}
	
}
