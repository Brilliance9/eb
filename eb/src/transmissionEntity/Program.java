package transmissionEntity;

public class Program {

	//GB/T 17975.1节目和节目元素描述符
		private int descriptor_tag2;
		private int descriptor_length2;
		//2  视频流描述符
		//视频流应用的的国标，1或2
		private int videoStandard;
		//GB/T 17975.2或GB/T 17191.2
		private int multiple_frame_rate_flag1;
		private int frame_rate_code1;
		private int MPEG_1_only_flag;
		private int constrained_parameter_flag;
		private int still_picture_flag;
		private int profile_and_level_indication;
		private int chroma_format1;
		private int frame_rate_extension_flag;
		private int reserved21;
		
		
		
		//3  音频流描述符
		private int descriptor_tag3;
		private int descriptor_length3;
		private int free_format_flag;
		private int ID;
		private int layer;
		private int variable_rate_audio_indicator;
		private int reserved31;
		
		//4 hierarchy_descriptor 层次流描述符
		private int descriptor_tag4;
		private int descriptor_length4;
		private int reserved41;
		private int hierarchy_type;
		private int reserved42;
		private int hierarchy_layer_index;
		private int reserved43;
		private int hierarchy_embedded_layer_index;
		private int reserved44;
		private int hierarchy_channel;
		
		//5 registration descriptor 登记描述符
		private int descriptor_tag5;
		private int descriptor_length5;
		private int format_identifier;
		private String additional_identification_info;
		
		//6 data stream alignment descriptor 数据流对齐描述符
		private int descriptor_tag6;
		private int descriptor_length6;
		private int alignment_type;
		
		//7 target_background_grid_descriptor 目标背景栅格
		private int descriptor_tag7;
		private int descriptor_length7;
		private int horizontal_size;
		private int vertical_size;
		private int aspect_ratio_information;
		
		//8 video_window-descniptor 视频窗描述符
		private int descriptor_tag8;
		private int descriptor_length8;
		private int horizontal_offset;
		private int vertical_offset;
		private int window_priority;
		
		//9 CA descriptor 条件接入描述符
		private int descriptor_tag9;
		private int descriptor_length9;
		private int CA_system_ID;
		private int reserved91;
		private int CA_PID;
		private String private_data_byte;
		
		//10 ISO_639_language_descriptor  ISO_639语言描述符
		private int descriptor_tag10;
		private int descriptor_length10;
		private String IS0_639_language_code;
		private int audio_type;
		
		//11 system clock descriptor 系统时钟描述
		private int descriptor_tag11;
		private int descriptor_length11;
		private int external_clock_reference_indicator;
		private int reserved111;
		private int clock_accuracy_integer;
		private int clock_accuracy_exponent;
		private int reserved112;
		
		//12 multiplex_buffer_utilization-descriptor 复用缓冲区应用描述符
		private int descriptor_tag12;
		private int descriptor_length12;
		private int bound_valid_flag;
		private int LTW_offset_lower_bound;
		private int reserved121;
		private int LTW_offset_upper_bound;
		
		//13 copyright_descriptor 版权描述符
		private int descriptor_tag13;
		private int descriptor_length13;
		private int copyright_identifier;
		private String additional_copyright_info;
		
		//14 最大比特率描述符
		private int descriptor_tag14;
		private int descriptor_length14;
		private int reserved141;
		private int maximum_bitrate;
		
		//15 专用数据指示符描述符
		private int descriptor_tag15;
		private int descriptor_length15;
		private int private_data_indicator;
		
		//16 平滑缓冲区描述符
		private int descriptor_tag16;
		private int descriptor_length16;
		private int reserved161;
		private int sb_leak_rate;
		private int reserved162;
		private int sb_size;
		
		//17 STD descriptor
		private int descriptor_tag17;
		private int descriptor_length17;
		private int reserved171;
		private int leak_valid_flag;
		
		//18 IBP描述符
		private int descriptor_tag18;
		private int descriptor_length18;
		private int closed_gop_flag;
		private int identical_gop_flag;
		private int max_gop_length;
		
		//63 AVS Video descriptor
		//GB/T 20090.2
		private int descriptor_tag63;
		private int descriptor_length63;
		private int profile_id;
		private int level_id;
		private int multiple_frame_rate_flag2;
		private int frame_rate_code2;
		private int AVS_still_present;
		private int chroma_format2;
		private int sample_precision;
		private int reserved22;
		//
		//
		
		
		public Program(){
			this.reserved21=31;
			this.reserved22=31;
			this.reserved31=7;
			this.reserved41=15;
			this.reserved42=3;
			this.reserved43=3;
			this.reserved44=3;
			this.reserved91=7;
			this.reserved111=1;
			this.reserved112=31;
			this.reserved121=1;
			this.reserved141=3;
			this.reserved161=3;
			this.reserved162=3;
			this.reserved171=127;
			this.descriptor_tag2=2;
			this.descriptor_tag3=3;
			this.descriptor_tag4=4;
			this.descriptor_tag5=5;
			this.descriptor_tag6=6;
			this.descriptor_tag7=7;
			this.descriptor_tag8=8;
			this.descriptor_tag9=9;
			this.descriptor_tag10=10;
			this.descriptor_tag11=11;
			this.descriptor_tag12=12;
			this.descriptor_tag13=13;
			this.descriptor_tag14=14;
			this.descriptor_tag15=15;
			this.descriptor_tag16=16;
			this.descriptor_tag17=17;
			this.descriptor_tag18=18;
			this.descriptor_tag63=63;
		}
		public int getMultiple_frame_rate_flag1() {
			return multiple_frame_rate_flag1;
		}
		public void setMultiple_frame_rate_flag1(int multiple_frame_rate_flag1) {
			this.multiple_frame_rate_flag1 = multiple_frame_rate_flag1;
		}
		public int getFrame_rate_code1() {
			return frame_rate_code1;
		}
		public void setFrame_rate_code1(int frame_rate_code1) {
			this.frame_rate_code1 = frame_rate_code1;
		}
		public int getMPEG_1_only_flag() {
			return MPEG_1_only_flag;
		}
		public void setMPEG_1_only_flag(int mPEG_1_only_flag) {
			MPEG_1_only_flag = mPEG_1_only_flag;
		}
		public int getConstrained_parameter_flag() {
			return constrained_parameter_flag;
		}
		public void setConstrained_parameter_flag(int constrained_parameter_flag) {
			this.constrained_parameter_flag = constrained_parameter_flag;
		}
		public int getStill_picture_flag() {
			return still_picture_flag;
		}
		public void setStill_picture_flag(int still_picture_flag) {
			this.still_picture_flag = still_picture_flag;
		}
		public int getProfile_and_level_indication() {
			return profile_and_level_indication;
		}
		public void setProfile_and_level_indication(int profile_and_level_indication) {
			this.profile_and_level_indication = profile_and_level_indication;
		}
		public int getChroma_format1() {
			return chroma_format1;
		}
		public void setChroma_format1(int chroma_format1) {
			this.chroma_format1 = chroma_format1;
		}
		public int getFrame_rate_extension_flag() {
			return frame_rate_extension_flag;
		}
		public void setFrame_rate_extension_flag(int frame_rate_extension_flag) {
			this.frame_rate_extension_flag = frame_rate_extension_flag;
		}
		public int getReserved21() {
			return reserved21;
		}
		public void setReserved21(int reserved21) {
			this.reserved21 = reserved21;
		}
		public int getProfile_id() {
			return profile_id;
		}
		public void setProfile_id(int profile_id) {
			this.profile_id = profile_id;
		}
		public int getLevel_id() {
			return level_id;
		}
		public void setLevel_id(int level_id) {
			this.level_id = level_id;
		}
		public int getMultiple_frame_rate_flag2() {
			return multiple_frame_rate_flag2;
		}
		public void setMultiple_frame_rate_flag2(int multiple_frame_rate_flag2) {
			this.multiple_frame_rate_flag2 = multiple_frame_rate_flag2;
		}
		public int getFrame_rate_code2() {
			return frame_rate_code2;
		}
		public void setFrame_rate_code2(int frame_rate_code2) {
			this.frame_rate_code2 = frame_rate_code2;
		}
		public int getAVS_still_present() {
			return AVS_still_present;
		}
		public void setAVS_still_present(int aVS_still_present) {
			AVS_still_present = aVS_still_present;
		}
		public int getChroma_format2() {
			return chroma_format2;
		}
		public void setChroma_format2(int chroma_format2) {
			this.chroma_format2 = chroma_format2;
		}
		public int getSample_precision() {
			return sample_precision;
		}
		public void setSample_precision(int sample_precision) {
			this.sample_precision = sample_precision;
		}
		public int getReserved22() {
			return reserved22;
		}
		public void setReserved22(int reserved22) {
			this.reserved22 = reserved22;
		}
		public int getVideoStandard() {
			return videoStandard;
		}
		public void setVideoStandard(int videoStandard) {
			this.videoStandard = videoStandard;
		}
		public int getFree_format_flag() {
			return free_format_flag;
		}
		public void setFree_format_flag(int free_format_flag) {
			this.free_format_flag = free_format_flag;
		}
		public int getID() {
			return ID;
		}
		public void setID(int iD) {
			ID = iD;
		}
		public int getLayer() {
			return layer;
		}
		public void setLayer(int layer) {
			this.layer = layer;
		}
		public int getVariable_rate_audio_indicator() {
			return variable_rate_audio_indicator;
		}
		public void setVariable_rate_audio_indicator(int variable_rate_audio_indicator) {
			this.variable_rate_audio_indicator = variable_rate_audio_indicator;
		}
		public int getReserved31() {
			return reserved31;
		}
		public void setReserved31(int reserved31) {
			this.reserved31 = reserved31;
		}
		public int getReserved41() {
			return reserved41;
		}
		public void setReserved41(int reserved41) {
			this.reserved41 = reserved41;
		}
		public int getHierarchy_type() {
			return hierarchy_type;
		}
		public void setHierarchy_type(int hierarchy_type) {
			this.hierarchy_type = hierarchy_type;
		}
		public int getReserved42() {
			return reserved42;
		}
		public void setReserved42(int reserved42) {
			this.reserved42 = reserved42;
		}
		public int getHierarchy_layer_index() {
			return hierarchy_layer_index;
		}
		public void setHierarchy_layer_index(int hierarchy_layer_index) {
			this.hierarchy_layer_index = hierarchy_layer_index;
		}
		public int getReserved43() {
			return reserved43;
		}
		public void setReserved43(int reserved43) {
			this.reserved43 = reserved43;
		}
		public int getHierarchy_embedded_layer_index() {
			return hierarchy_embedded_layer_index;
		}
		public void setHierarchy_embedded_layer_index(int hierarchy_embedded_layer_index) {
			this.hierarchy_embedded_layer_index = hierarchy_embedded_layer_index;
		}
		public int getReserved44() {
			return reserved44;
		}
		public void setReserved44(int reserved44) {
			this.reserved44 = reserved44;
		}
		public int getHierarchy_channel() {
			return hierarchy_channel;
		}
		public void setHierarchy_channel(int hierarchy_channel) {
			this.hierarchy_channel = hierarchy_channel;
		}
		public int getFormat_identifier() {
			return format_identifier;
		}
		public void setFormat_identifier(int format_identifier) {
			this.format_identifier = format_identifier;
		}
		public String getAdditional_identification_info() {
			return additional_identification_info;
		}
		public void setAdditional_identification_info(String additional_identification_info) {
			this.additional_identification_info = additional_identification_info;
		}
		public int getAlignment_type() {
			return alignment_type;
		}
		public void setAlignment_type(int alignment_type) {
			this.alignment_type = alignment_type;
		}
		public int getHorizontal_size() {
			return horizontal_size;
		}
		public void setHorizontal_size(int horizontal_size) {
			this.horizontal_size = horizontal_size;
		}
		public int getVertical_size() {
			return vertical_size;
		}
		public void setVertical_size(int vertical_size) {
			this.vertical_size = vertical_size;
		}
		public int getAspect_ratio_information() {
			return aspect_ratio_information;
		}
		public void setAspect_ratio_information(int aspect_ratio_information) {
			this.aspect_ratio_information = aspect_ratio_information;
		}
		public int getHorizontal_offset() {
			return horizontal_offset;
		}
		public void setHorizontal_offset(int horizontal_offset) {
			this.horizontal_offset = horizontal_offset;
		}
		public int getVertical_offset() {
			return vertical_offset;
		}
		public void setVertical_offset(int vertical_offset) {
			this.vertical_offset = vertical_offset;
		}
		public int getWindow_priority() {
			return window_priority;
		}
		public void setWindow_priority(int window_priority) {
			this.window_priority = window_priority;
		}
		public int getCA_system_ID() {
			return CA_system_ID;
		}
		public void setCA_system_ID(int cA_system_ID) {
			CA_system_ID = cA_system_ID;
		}
		public int getReserved91() {
			return reserved91;
		}
		public void setReserved91(int reserved91) {
			this.reserved91 = reserved91;
		}
		public int getCA_PID() {
			return CA_PID;
		}
		public void setCA_PID(int cA_PID) {
			CA_PID = cA_PID;
		}
		public String getPrivate_data_byte() {
			return private_data_byte;
		}
		public void setPrivate_data_byte(String private_data_byte) {
			this.private_data_byte = private_data_byte;
		}
		public String getIS0_639_language_code() {
			return IS0_639_language_code;
		}
		public void setIS0_639_language_code(String iS0_639_language_code) {
			IS0_639_language_code = iS0_639_language_code;
		}
		public int getAudio_type() {
			return audio_type;
		}
		public void setAudio_type(int audio_type) {
			this.audio_type = audio_type;
		}
		public int getExternal_clock_reference_indicator() {
			return external_clock_reference_indicator;
		}
		public void setExternal_clock_reference_indicator(int external_clock_reference_indicator) {
			this.external_clock_reference_indicator = external_clock_reference_indicator;
		}
		public int getReserved111() {
			return reserved111;
		}
		public void setReserved111(int reserved111) {
			this.reserved111 = reserved111;
		}
		public int getClock_accuracy_integer() {
			return clock_accuracy_integer;
		}
		public void setClock_accuracy_integer(int clock_accuracy_integer) {
			this.clock_accuracy_integer = clock_accuracy_integer;
		}
		public int getClock_accuracy_exponent() {
			return clock_accuracy_exponent;
		}
		public void setClock_accuracy_exponent(int clock_accuracy_exponent) {
			this.clock_accuracy_exponent = clock_accuracy_exponent;
		}
		public int getReserved112() {
			return reserved112;
		}
		public void setReserved112(int reserved112) {
			this.reserved112 = reserved112;
		}
		public int getBound_valid_flag() {
			return bound_valid_flag;
		}
		public void setBound_valid_flag(int bound_valid_flag) {
			this.bound_valid_flag = bound_valid_flag;
		}
		public int getLTW_offset_lower_bound() {
			return LTW_offset_lower_bound;
		}
		public void setLTW_offset_lower_bound(int lTW_offset_lower_bound) {
			LTW_offset_lower_bound = lTW_offset_lower_bound;
		}
		public int getReserved121() {
			return reserved121;
		}
		public void setReserved121(int reserved121) {
			this.reserved121 = reserved121;
		}
		public int getLTW_offset_upper_bound() {
			return LTW_offset_upper_bound;
		}
		public void setLTW_offset_upper_bound(int lTW_offset_upper_bound) {
			LTW_offset_upper_bound = lTW_offset_upper_bound;
		}
		public int getCopyright_identifier() {
			return copyright_identifier;
		}
		public void setCopyright_identifier(int copyright_identifier) {
			this.copyright_identifier = copyright_identifier;
		}
		public String getAdditional_copyright_info() {
			return additional_copyright_info;
		}
		public void setAdditional_copyright_info(String additional_copyright_info) {
			this.additional_copyright_info = additional_copyright_info;
		}
		public int getReserved141() {
			return reserved141;
		}
		public void setReserved141(int reserved141) {
			this.reserved141 = reserved141;
		}
		public int getMaximum_bitrate() {
			return maximum_bitrate;
		}
		public void setMaximum_bitrate(int maximum_bitrate) {
			this.maximum_bitrate = maximum_bitrate;
		}
		public int getPrivate_data_indicator() {
			return private_data_indicator;
		}
		public void setPrivate_data_indicator(int private_data_indicator) {
			this.private_data_indicator = private_data_indicator;
		}
		public int getReserved161() {
			return reserved161;
		}
		public void setReserved161(int reserved161) {
			this.reserved161 = reserved161;
		}
		public int getSb_leak_rate() {
			return sb_leak_rate;
		}
		public void setSb_leak_rate(int sb_leak_rate) {
			this.sb_leak_rate = sb_leak_rate;
		}
		public int getReserved162() {
			return reserved162;
		}
		public void setReserved162(int reserved162) {
			this.reserved162 = reserved162;
		}
		public int getSb_size() {
			return sb_size;
		}
		public void setSb_size(int sb_size) {
			this.sb_size = sb_size;
		}
		public int getReserved171() {
			return reserved171;
		}
		public void setReserved171(int reserved171) {
			this.reserved171 = reserved171;
		}
		public int getLeak_valid_flag() {
			return leak_valid_flag;
		}
		public void setLeak_valid_flag(int leak_valid_flag) {
			this.leak_valid_flag = leak_valid_flag;
		}
		public int getClosed_gop_flag() {
			return closed_gop_flag;
		}
		public void setClosed_gop_flag(int closed_gop_flag) {
			this.closed_gop_flag = closed_gop_flag;
		}
		public int getIdentical_gop_flag() {
			return identical_gop_flag;
		}
		public void setIdentical_gop_flag(int identical_gop_flag) {
			this.identical_gop_flag = identical_gop_flag;
		}
		public int getMax_gop_length() {
			return max_gop_length;
		}
		public void setMax_gop_length(int max_gop_length) {
			this.max_gop_length = max_gop_length;
		}
		public int getDescriptor_tag2() {
			return descriptor_tag2;
		}
		public void setDescriptor_tag2(int descriptor_tag2) {
			this.descriptor_tag2 = descriptor_tag2;
		}
		public int getDescriptor_length2() {
			return descriptor_length2;
		}
		public void setDescriptor_length2(int descriptor_length2) {
			this.descriptor_length2 = descriptor_length2;
		}
		public int getDescriptor_tag3() {
			return descriptor_tag3;
		}
		public void setDescriptor_tag3(int descriptor_tag3) {
			this.descriptor_tag3 = descriptor_tag3;
		}
		public int getDescriptor_length3() {
			return descriptor_length3;
		}
		public void setDescriptor_length3(int descriptor_length3) {
			this.descriptor_length3 = descriptor_length3;
		}
		public int getDescriptor_tag4() {
			return descriptor_tag4;
		}
		public void setDescriptor_tag4(int descriptor_tag4) {
			this.descriptor_tag4 = descriptor_tag4;
		}
		public int getDescriptor_length4() {
			return descriptor_length4;
		}
		public void setDescriptor_length4(int descriptor_length4) {
			this.descriptor_length4 = descriptor_length4;
		}
		public int getDescriptor_tag5() {
			return descriptor_tag5;
		}
		public void setDescriptor_tag5(int descriptor_tag5) {
			this.descriptor_tag5 = descriptor_tag5;
		}
		public int getDescriptor_length5() {
			return descriptor_length5;
		}
		public void setDescriptor_length5(int descriptor_length5) {
			this.descriptor_length5 = descriptor_length5;
		}
		public int getDescriptor_tag6() {
			return descriptor_tag6;
		}
		public void setDescriptor_tag6(int descriptor_tag6) {
			this.descriptor_tag6 = descriptor_tag6;
		}
		public int getDescriptor_length6() {
			return descriptor_length6;
		}
		public void setDescriptor_length6(int descriptor_length6) {
			this.descriptor_length6 = descriptor_length6;
		}
		public int getDescriptor_tag7() {
			return descriptor_tag7;
		}
		public void setDescriptor_tag7(int descriptor_tag7) {
			this.descriptor_tag7 = descriptor_tag7;
		}
		public int getDescriptor_length7() {
			return descriptor_length7;
		}
		public void setDescriptor_length7(int descriptor_length7) {
			this.descriptor_length7 = descriptor_length7;
		}
		public int getDescriptor_tag8() {
			return descriptor_tag8;
		}
		public void setDescriptor_tag8(int descriptor_tag8) {
			this.descriptor_tag8 = descriptor_tag8;
		}
		public int getDescriptor_length8() {
			return descriptor_length8;
		}
		public void setDescriptor_length8(int descriptor_length8) {
			this.descriptor_length8 = descriptor_length8;
		}
		public int getDescriptor_tag9() {
			return descriptor_tag9;
		}
		public void setDescriptor_tag9(int descriptor_tag9) {
			this.descriptor_tag9 = descriptor_tag9;
		}
		public int getDescriptor_length9() {
			return descriptor_length9;
		}
		public void setDescriptor_length9(int descriptor_length9) {
			this.descriptor_length9 = descriptor_length9;
		}
		public int getDescriptor_tag10() {
			return descriptor_tag10;
		}
		public void setDescriptor_tag10(int descriptor_tag10) {
			this.descriptor_tag10 = descriptor_tag10;
		}
		public int getDescriptor_length10() {
			return descriptor_length10;
		}
		public void setDescriptor_length10(int descriptor_length10) {
			this.descriptor_length10 = descriptor_length10;
		}
		public int getDescriptor_tag11() {
			return descriptor_tag11;
		}
		public void setDescriptor_tag11(int descriptor_tag11) {
			this.descriptor_tag11 = descriptor_tag11;
		}
		public int getDescriptor_length11() {
			return descriptor_length11;
		}
		public void setDescriptor_length11(int descriptor_length11) {
			this.descriptor_length11 = descriptor_length11;
		}
		public int getDescriptor_tag12() {
			return descriptor_tag12;
		}
		public void setDescriptor_tag12(int descriptor_tag12) {
			this.descriptor_tag12 = descriptor_tag12;
		}
		public int getDescriptor_length12() {
			return descriptor_length12;
		}
		public void setDescriptor_length12(int descriptor_length12) {
			this.descriptor_length12 = descriptor_length12;
		}
		public int getDescriptor_tag13() {
			return descriptor_tag13;
		}
		public void setDescriptor_tag13(int descriptor_tag13) {
			this.descriptor_tag13 = descriptor_tag13;
		}
		public int getDescriptor_length13() {
			return descriptor_length13;
		}
		public void setDescriptor_length13(int descriptor_length13) {
			this.descriptor_length13 = descriptor_length13;
		}
		public int getDescriptor_tag14() {
			return descriptor_tag14;
		}
		public void setDescriptor_tag14(int descriptor_tag14) {
			this.descriptor_tag14 = descriptor_tag14;
		}
		public int getDescriptor_length14() {
			return descriptor_length14;
		}
		public void setDescriptor_length14(int descriptor_length14) {
			this.descriptor_length14 = descriptor_length14;
		}
		public int getDescriptor_tag15() {
			return descriptor_tag15;
		}
		public void setDescriptor_tag15(int descriptor_tag15) {
			this.descriptor_tag15 = descriptor_tag15;
		}
		public int getDescriptor_length15() {
			return descriptor_length15;
		}
		public void setDescriptor_length15(int descriptor_length15) {
			this.descriptor_length15 = descriptor_length15;
		}
		public int getDescriptor_tag16() {
			return descriptor_tag16;
		}
		public void setDescriptor_tag16(int descriptor_tag16) {
			this.descriptor_tag16 = descriptor_tag16;
		}
		public int getDescriptor_length16() {
			return descriptor_length16;
		}
		public void setDescriptor_length16(int descriptor_length16) {
			this.descriptor_length16 = descriptor_length16;
		}
		public int getDescriptor_tag17() {
			return descriptor_tag17;
		}
		public void setDescriptor_tag17(int descriptor_tag17) {
			this.descriptor_tag17 = descriptor_tag17;
		}
		public int getDescriptor_length17() {
			return descriptor_length17;
		}
		public void setDescriptor_length17(int descriptor_length17) {
			this.descriptor_length17 = descriptor_length17;
		}
		public int getDescriptor_tag18() {
			return descriptor_tag18;
		}
		public void setDescriptor_tag18(int descriptor_tag18) {
			this.descriptor_tag18 = descriptor_tag18;
		}
		public int getDescriptor_length18() {
			return descriptor_length18;
		}
		public void setDescriptor_length18(int descriptor_length18) {
			this.descriptor_length18 = descriptor_length18;
		}
		public int getDescriptor_tag63() {
			return descriptor_tag63;
		}
		public void setDescriptor_tag63(int descriptor_tag63) {
			this.descriptor_tag63 = descriptor_tag63;
		}
		public int getDescriptor_length63() {
			return descriptor_length63;
		}
		public void setDescriptor_length63(int descriptor_length63) {
			this.descriptor_length63 = descriptor_length63;
		}
		@Override
		public String toString() {
			return "Program [descriptor_tag2=" + descriptor_tag2 + ", descriptor_length2=" + descriptor_length2
					+ ", videoStandard=" + videoStandard + ", multiple_frame_rate_flag1=" + multiple_frame_rate_flag1
					+ ", frame_rate_code1=" + frame_rate_code1 + ", MPEG_1_only_flag=" + MPEG_1_only_flag
					+ ", constrained_parameter_flag=" + constrained_parameter_flag + ", still_picture_flag="
					+ still_picture_flag + ", profile_and_level_indication=" + profile_and_level_indication
					+ ", chroma_format1=" + chroma_format1 + ", frame_rate_extension_flag=" + frame_rate_extension_flag
					+ ", reserved21=" + reserved21 + ", descriptor_tag3=" + descriptor_tag3 + ", descriptor_length3="
					+ descriptor_length3 + ", free_format_flag=" + free_format_flag + ", ID=" + ID + ", layer=" + layer
					+ ", variable_rate_audio_indicator=" + variable_rate_audio_indicator + ", reserved31=" + reserved31
					+ ", descriptor_tag4=" + descriptor_tag4 + ", descriptor_length4=" + descriptor_length4
					+ ", reserved41=" + reserved41 + ", hierarchy_type=" + hierarchy_type + ", reserved42=" + reserved42
					+ ", hierarchy_layer_index=" + hierarchy_layer_index + ", reserved43=" + reserved43
					+ ", hierarchy_embedded_layer_index=" + hierarchy_embedded_layer_index + ", reserved44="
					+ reserved44 + ", hierarchy_channel=" + hierarchy_channel + ", descriptor_tag5=" + descriptor_tag5
					+ ", descriptor_length5=" + descriptor_length5 + ", format_identifier=" + format_identifier
					+ ", additional_identification_info=" + additional_identification_info + ", descriptor_tag6="
					+ descriptor_tag6 + ", descriptor_length6=" + descriptor_length6 + ", alignment_type="
					+ alignment_type + ", descriptor_tag7=" + descriptor_tag7 + ", descriptor_length7="
					+ descriptor_length7 + ", horizontal_size=" + horizontal_size + ", vertical_size=" + vertical_size
					+ ", aspect_ratio_information=" + aspect_ratio_information + ", descriptor_tag8=" + descriptor_tag8
					+ ", descriptor_length8=" + descriptor_length8 + ", horizontal_offset=" + horizontal_offset
					+ ", vertical_offset=" + vertical_offset + ", window_priority=" + window_priority
					+ ", descriptor_tag9=" + descriptor_tag9 + ", descriptor_length9=" + descriptor_length9
					+ ", CA_system_ID=" + CA_system_ID + ", reserved91=" + reserved91 + ", CA_PID=" + CA_PID
					+ ", private_data_byte=" + private_data_byte + ", descriptor_tag10=" + descriptor_tag10
					+ ", descriptor_length10=" + descriptor_length10 + ", IS0_639_language_code="
					+ IS0_639_language_code + ", audio_type=" + audio_type + ", descriptor_tag11=" + descriptor_tag11
					+ ", descriptor_length11=" + descriptor_length11 + ", external_clock_reference_indicator="
					+ external_clock_reference_indicator + ", reserved111=" + reserved111 + ", clock_accuracy_integer="
					+ clock_accuracy_integer + ", clock_accuracy_exponent=" + clock_accuracy_exponent + ", reserved112="
					+ reserved112 + ", descriptor_tag12=" + descriptor_tag12 + ", descriptor_length12="
					+ descriptor_length12 + ", bound_valid_flag=" + bound_valid_flag + ", LTW_offset_lower_bound="
					+ LTW_offset_lower_bound + ", reserved121=" + reserved121 + ", LTW_offset_upper_bound="
					+ LTW_offset_upper_bound + ", descriptor_tag13=" + descriptor_tag13 + ", descriptor_length13="
					+ descriptor_length13 + ", copyright_identifier=" + copyright_identifier
					+ ", additional_copyright_info=" + additional_copyright_info + ", descriptor_tag14="
					+ descriptor_tag14 + ", descriptor_length14=" + descriptor_length14 + ", reserved141=" + reserved141
					+ ", maximum_bitrate=" + maximum_bitrate + ", descriptor_tag15=" + descriptor_tag15
					+ ", descriptor_length15=" + descriptor_length15 + ", private_data_indicator="
					+ private_data_indicator + ", descriptor_tag16=" + descriptor_tag16 + ", descriptor_length16="
					+ descriptor_length16 + ", reserved161=" + reserved161 + ", sb_leak_rate=" + sb_leak_rate
					+ ", reserved162=" + reserved162 + ", sb_size=" + sb_size + ", descriptor_tag17=" + descriptor_tag17
					+ ", descriptor_length17=" + descriptor_length17 + ", reserved171=" + reserved171
					+ ", leak_valid_flag=" + leak_valid_flag + ", descriptor_tag18=" + descriptor_tag18
					+ ", descriptor_length18=" + descriptor_length18 + ", closed_gop_flag=" + closed_gop_flag
					+ ", identical_gop_flag=" + identical_gop_flag + ", max_gop_length=" + max_gop_length
					+ ", descriptor_tag63=" + descriptor_tag63 + ", descriptor_length63=" + descriptor_length63
					+ ", profile_id=" + profile_id + ", level_id=" + level_id + ", multiple_frame_rate_flag2="
					+ multiple_frame_rate_flag2 + ", frame_rate_code2=" + frame_rate_code2 + ", AVS_still_present="
					+ AVS_still_present + ", chroma_format2=" + chroma_format2 + ", sample_precision="
					+ sample_precision + ", reserved22=" + reserved22 + "]";
		}
		
}
