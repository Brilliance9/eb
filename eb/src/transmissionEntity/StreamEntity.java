package transmissionEntity;

public class StreamEntity {

	private int stream_type;
	private int reserved1;
	private int elementary_PID;
	private int reserved2;
	private int ES_info_length;
	private Program program2;
	
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
	public Program getProgram2() {
		return program2;
	}
	public void setProgram2(Program program2) {
		this.program2 = program2;
	}
	@Override
	public String toString() {
		return "StreamEntity [stream_type=" + stream_type + ", reserved1=" + reserved1 + ", elementary_PID="
				+ elementary_PID + ", reserved2=" + reserved2 + ", ES_info_length=" + ES_info_length + ", program2="
				+ program2 + "]";
	}
	
}
