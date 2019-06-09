package transmissionEntity;

import java.util.Calendar;

public class EBMEntity {
	private int EBM_length;
	private int reserved1;
	private String EBM_id;
	private String EBM_original_network_id;
	private Calendar EBM_start_time;
	private Calendar EBM_end_time;
	private String EBM_type;
	private int EBM_class;
	private int EBM_level;
	private int EBM_resource_number;
	private int reserved2;
	private String[] EBM_resource_code;
	private int reserved3;
	private int details_channel_indicate;
	private int details_channel_network_id;
	private int details_channel_transport_stream_id;
	private int details_channel_program_number;
	private int reserved4;
	private int details_channel_PCR_PID;
	private int reserved5;
	private int details_channel_program_info_length;
	private Descriptor1 descriptor1;
	private int stream_info_length;
	private StreamEntity[] stream;
	
	public EBMEntity(){
		this.reserved1=15;
		this.reserved2=15;
		this.reserved3=127;
		this.reserved4=7;
		this.reserved5=15;
	}
	
	public int getEBM_length() {
		return EBM_length;
	}
	public void setEBM_length(int eBM_length) {
		EBM_length = eBM_length;
	}
	public int getReserved1() {
		return reserved1;
	}
	public void setReserved1(int reserved1) {
		this.reserved1 = reserved1;
	}
	public String getEBM_id() {
		return EBM_id;
	}
	public void setEBM_id(String eBM_id) {
		EBM_id = eBM_id;
	}
	public String getEBM_original_network_id() {
		return EBM_original_network_id;
	}
	public void setEBM_original_network_id(String eBM_original_network_id) {
		EBM_original_network_id = eBM_original_network_id;
	}
	public Calendar getEBM_start_time() {
		return EBM_start_time;
	}
	public void setEBM_start_time(Calendar eBM_start_time) {
		EBM_start_time = eBM_start_time;
	}
	public Calendar getEBM_end_time() {
		return EBM_end_time;
	}
	public void setEBM_end_time(Calendar eBM_end_time) {
		EBM_end_time = eBM_end_time;
	}
	public String getEBM_type() {
		return EBM_type;
	}
	public void setEBM_type(String eBM_type) {
		EBM_type = eBM_type;
	}
	public int getEBM_class() {
		return EBM_class;
	}
	public void setEBM_class(int eBM_class) {
		EBM_class = eBM_class;
	}
	public int getEBM_level() {
		return EBM_level;
	}
	public void setEBM_level(int eBM_level) {
		EBM_level = eBM_level;
	}
	public int getEBM_resource_number() {
		return EBM_resource_number;
	}
	public void setEBM_resource_number(int eBM_resource_number) {
		EBM_resource_number = eBM_resource_number;
	}
	public int getReserved2() {
		return reserved2;
	}
	public void setReserved2(int reserved2) {
		this.reserved2 = reserved2;
	}
	public String[] getEBM_resource_code() {
		return EBM_resource_code;
	}
	public void setEBM_resource_code(String[] eBM_resource_code) {
		EBM_resource_code = eBM_resource_code;
	}
	public int getReserved3() {
		return reserved3;
	}
	public void setReserved3(int reserved3) {
		this.reserved3 = reserved3;
	}
	public int getDetails_channel_indicate() {
		return details_channel_indicate;
	}
	public void setDetails_channel_indicate(int details_channel_indicate) {
		this.details_channel_indicate = details_channel_indicate;
	}
	public int getDetails_channel_network_id() {
		return details_channel_network_id;
	}
	public void setDetails_channel_network_id(int details_channel_network_id) {
		this.details_channel_network_id = details_channel_network_id;
	}
	public int getDetails_channel_transport_stream_id() {
		return details_channel_transport_stream_id;
	}
	public void setDetails_channel_transport_stream_id(int details_channel_transport_stream_id) {
		this.details_channel_transport_stream_id = details_channel_transport_stream_id;
	}
	public int getDetails_channel_program_number() {
		return details_channel_program_number;
	}
	public void setDetails_channel_program_number(int details_channel_program_number) {
		this.details_channel_program_number = details_channel_program_number;
	}
	public int getReserved4() {
		return reserved4;
	}
	public void setReserved4(int reserved4) {
		this.reserved4 = reserved4;
	}
	public int getDetails_channel_PCR_PID() {
		return details_channel_PCR_PID;
	}
	public void setDetails_channel_PCR_PID(int details_channel_PCR_PID) {
		this.details_channel_PCR_PID = details_channel_PCR_PID;
	}
	public int getReserved5() {
		return reserved5;
	}
	public void setReserved5(int reserved5) {
		this.reserved5 = reserved5;
	}
	public int getDetails_channel_program_info_length() {
		return details_channel_program_info_length;
	}
	public void setDetails_channel_program_info_length(int details_channel_program_info_length) {
		this.details_channel_program_info_length = details_channel_program_info_length;
	}
	
	public Descriptor1 getDescriptor1() {
		return descriptor1;
	}

	public void setDescriptor1(Descriptor1 descriptor1) {
		this.descriptor1 = descriptor1;
	}

	public int getStream_info_length() {
		return stream_info_length;
	}
	public void setStream_info_length(int stream_info_length) {
		this.stream_info_length = stream_info_length;
	}
	public StreamEntity[] getStream() {
		return stream;
	}
	public void setStream(StreamEntity[] stream) {
		this.stream = stream;
	}


}
