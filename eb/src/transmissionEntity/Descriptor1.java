package transmissionEntity;

public class Descriptor1 {

	//GB/T 28161—2011中6.2.10.1的有线传送系统描述符
	private int descriptor_tag;
	private int descriptor_length;
	private float frequency;
	private int reserved_future_use;
	private int FEC_outer;
	private int modulation;
	private double symbol_rate;
	private int FEC_inner;
	
	private Program program;
	public Descriptor1(){
		this.reserved_future_use=4095;
		this.descriptor_tag=44;
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

	public float getFrequency() {
		return frequency;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	public int getReserved_future_use() {
		return reserved_future_use;
	}

	public void setReserved_future_use(int reserved_future_use) {
		this.reserved_future_use = reserved_future_use;
	}

	public int getFEC_outer() {
		return FEC_outer;
	}

	public void setFEC_outer(int fEC_outer) {
		FEC_outer = fEC_outer;
	}

	public int getModulation() {
		return modulation;
	}

	public void setModulation(int modulation) {
		this.modulation = modulation;
	}

	public double getSymbol_rate() {
		return symbol_rate;
	}

	public void setSymbol_rate(double symbol_rate) {
		this.symbol_rate = symbol_rate;
	}

	public int getFEC_inner() {
		return FEC_inner;
	}

	public void setFEC_inner(int fEC_inner) {
		FEC_inner = fEC_inner;
	}

	public Program getProgram() {
		return program;
	}

	public void setProgram(Program program) {
		this.program = program;
	}
	
}
