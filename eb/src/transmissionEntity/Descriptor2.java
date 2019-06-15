package transmissionEntity;

public class Descriptor2 {

	//GB/T 28161—2011中6.2.10.3的地面传送系统描述符
	private int descriptor_tag;
	private int descriptor_length;
	private double centre_frequency;
	private int FEC;
	private int modulation;
	private int number_of_subcarrier;
	private int frame_header_mode;
	private int interleaving_mode;
	private int other_frequency_flag;
	private int sfn_mfn_flag;
	private int reserved_future_use;
	private Program program;
	
	public Descriptor2(){
		this.descriptor_tag=90;
		this.reserved_future_use=3;
		this.descriptor_length=11;
	}
	public int getDescriptor_tag() {
		return descriptor_tag;
	}
	public void setDescriptor_tag(int descriptor_tag) {
		this.descriptor_tag = descriptor_tag;
	}
	public int getDescriptor_length() {
		return descriptor_length;
	}
	public void setDescriptor_length(int descriptor_length) {
		this.descriptor_length = descriptor_length;
	}
	public double getCentre_frequency() {
		return centre_frequency;
	}
	public void setCentre_frequency(double centre_frequency) {
		this.centre_frequency = centre_frequency;
	}
	public int getFEC() {
		return FEC;
	}
	public void setFEC(int fEC) {
		FEC = fEC;
	}
	public int getModulation() {
		return modulation;
	}
	public void setModulation(int modulation) {
		this.modulation = modulation;
	}
	public int getNumber_of_subcarrier() {
		return number_of_subcarrier;
	}
	public void setNumber_of_subcarrier(int number_of_subcarrier) {
		this.number_of_subcarrier = number_of_subcarrier;
	}
	public int getFrame_header_mode() {
		return frame_header_mode;
	}
	public void setFrame_header_mode(int frame_header_mode) {
		this.frame_header_mode = frame_header_mode;
	}
	public int getInterleaving_mode() {
		return interleaving_mode;
	}
	public void setInterleaving_mode(int interleaving_mode) {
		this.interleaving_mode = interleaving_mode;
	}
	public int getOther_frequency_flag() {
		return other_frequency_flag;
	}
	public void setOther_frequency_flag(int other_frequency_flag) {
		this.other_frequency_flag = other_frequency_flag;
	}
	public int getSfn_mfn_flag() {
		return sfn_mfn_flag;
	}
	public void setSfn_mfn_flag(int sfn_mfn_flag) {
		this.sfn_mfn_flag = sfn_mfn_flag;
	}
	public int getReserved_future_use() {
		return reserved_future_use;
	}
	public void setReserved_future_use(int reserved_future_use) {
		this.reserved_future_use = reserved_future_use;
	}
	public Program getProgram() {
		return program;
	}
	public void setProgram(Program program) {
		this.program = program;
	}
	@Override
	public String toString() {
		return "Descriptor2 [descriptor_tag=" + descriptor_tag + ", descriptor_length=" + descriptor_length
				+ ", centre_frequency=" + centre_frequency + ", FEC=" + FEC + ", modulation=" + modulation
				+ ", number_of_subcarrier=" + number_of_subcarrier + ", frame_header_mode=" + frame_header_mode
				+ ", interleaving_mode=" + interleaving_mode + ", other_frequency_flag=" + other_frequency_flag
				+ ", sfn_mfn_flag=" + sfn_mfn_flag + ", reserved_future_use=" + reserved_future_use + ", program="
				+ program + "]";
	}
	
}
