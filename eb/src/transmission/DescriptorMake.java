package transmission;

import transmissionEntity.Descriptor1;
import transmissionEntity.Program;

public class DescriptorMake {
	
	public void CableDescriptorMake(Encapsulate enc,Descriptor1 des){
		enc.encInt(des.getDescriptor_tag(), 8);
		enc.encInt(des.getDescriptor_length(), 8);
		enc.DoubleEnc(enc, des.getFrequency(), 4, 4);
		enc.encInt(des.getReserved_future_use(), 12);
		enc.encInt(des.getFEC_outer(), 4);
		enc.encInt(des.getModulation(), 8);
		enc.DoubleEnc(enc, des.getSymbol_rate(), 3, 4);
		enc.encInt(des.getFEC_inner(), 4);
		Program pro = des.getProgram();
		
		ProgramMake(enc,pro);
	}

	public void ProgramMake(Encapsulate enc,Program pro){
//		switch(pro.getDescriptor_tag()){
//		case 2:make2(enc,pro);
//			break;
//		case 3:make3(enc,pro);
//			break;
//		case 4:make4(enc,pro);
//			break;
//		case 5:make5(enc,pro);
//			break;
//		case 6:make6(enc,pro);
//			break;
//		case 7:make7(enc,pro);
//			break;
//		case 8:make8(enc,pro);
//			break;
//		case 9:make9(enc,pro);
//			break;
//		case 10:make10(enc,pro);
//			break;
//		case 11:make11(enc,pro);
//			break;
//		case 12:make12(enc,pro);
//			break;
//		case 13:make13(enc,pro);
//			break;
//		case 14:make14(enc,pro);
//			break;
//		case 15:make15(enc,pro);
//			break;
//		case 16:make16(enc,pro);
//			break;
//		case 17:make17(enc,pro);
//			break;
//		case 18:make18(enc,pro);
//			break;
//		case 63:make63(enc,pro);
//			break;
//		default:;
//		
//		}
		
		make2(enc,pro);
		make3(enc,pro);
		make4(enc,pro);
		make5(enc,pro);
		make6(enc,pro);
		make7(enc,pro);
		make8(enc,pro);
		make9(enc,pro);
		make10(enc,pro);
		make11(enc,pro);
		make12(enc,pro);
		make13(enc,pro);
		make14(enc,pro);
		make15(enc,pro);
		make16(enc,pro);
		make17(enc,pro);
		make18(enc,pro);
		make63(enc,pro);
	}
	public void make2(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag2(), 8);
		enc.encInt(pro.getDescriptor_length2(), 8);
		enc.encInt(pro.getMultiple_frame_rate_flag1(), 1);
		enc.encInt(pro.getFrame_rate_code1(), 4);
		enc.encInt(pro.getMPEG_1_only_flag(), 1);
		enc.encInt(pro.getConstrained_parameter_flag(), 1);
		enc.encInt(pro.getStill_picture_flag(), 1);
		if(pro.getMPEG_1_only_flag()==0){
			enc.encInt(pro.getProfile_and_level_indication(), 8);
			enc.encInt(pro.getChroma_format1(), 2);
			enc.encInt(pro.getFrame_rate_extension_flag(), 1);
			enc.encInt(pro.getReserved21(), 5);
		}
	}
	public void make3(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag3(), 8);
		enc.encInt(pro.getDescriptor_length3(), 8);
		enc.encInt(pro.getFree_format_flag(), 1);
		enc.encInt(pro.getID(), 1);
		enc.encInt(pro.getLayer(), 2);
		enc.encInt(pro.getVariable_rate_audio_indicator(), 1);
		enc.encInt(pro.getReserved31(), 3);
	}
	public void make4(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag4(), 8);
		enc.encInt(pro.getDescriptor_length4(), 8);
		enc.encInt(pro.getReserved41(), 4);
		enc.encInt(pro.getHierarchy_type(), 4);
		enc.encInt(pro.getReserved42(), 2);
		enc.encInt(pro.getHierarchy_layer_index(), 6);
		enc.encInt(pro.getReserved43(), 2);
		enc.encInt(pro.getHierarchy_embedded_layer_index(), 6);
		enc.encInt(pro.getReserved44(), 2);
		enc.encInt(pro.getHierarchy_channel(), 6);
	}
	public void make5(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag5(), 8);
		enc.encInt(pro.getDescriptor_length5(), 8);
		enc.encInt(pro.getFormat_identifier(), 32);
		enc.ASCIIEnc(enc, pro.getAdditional_identification_info());
	}
	public void make6(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag6(), 8);
		enc.encInt(pro.getDescriptor_length6(), 8);
		enc.encInt(pro.getAlignment_type(), 8);
	}
	public void make7(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag7(), 8);
		enc.encInt(pro.getDescriptor_length7(), 8);
		enc.encInt(pro.getHorizontal_size(), 14);
		enc.encInt(pro.getVertical_size(), 14);
		enc.encInt(pro.getAspect_ratio_information(), 4);
		
	}
	public void make8(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag8(), 8);
		enc.encInt(pro.getDescriptor_length8(), 8);
		enc.encInt(pro.getHorizontal_offset(), 14);
		enc.encInt(pro.getVertical_offset(), 14);
		enc.encInt(pro.getWindow_priority(), 4);
	}
	public void make9(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag9(), 8);
		enc.encInt(pro.getDescriptor_length9(), 8);
		enc.encInt(pro.getCA_system_ID(), 16);
		enc.encInt(pro.getReserved91(), 3);
		enc.encInt(pro.getCA_PID(), 13);
		enc.ASCIIEnc(enc, pro.getPrivate_data_byte());
	}
	public void make10(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag10(), 8);
		enc.encInt(pro.getDescriptor_length10(), 8);
		enc.ASCIIEnc(enc, pro.getIS0_639_language_code());
		enc.encInt(pro.getAudio_type(),8);
		
	}
	public void make11(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag11(), 8);
		enc.encInt(pro.getDescriptor_length11(), 8);
		enc.encInt(pro.getExternal_clock_reference_indicator(), 1);
		enc.encInt(pro.getReserved111(), 1);
		enc.encInt(pro.getClock_accuracy_integer(), 6);
		enc.encInt(pro.getClock_accuracy_exponent(), 3);
		enc.encInt(pro.getReserved112(), 5);
	}
	public void make12(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag12(), 8);
		enc.encInt(pro.getDescriptor_length12(), 8);
		enc.encInt(pro.getBound_valid_flag(), 1);
		enc.encInt(pro.getLTW_offset_lower_bound(), 15);
		enc.encInt(pro.getReserved121(), 1);
		enc.encInt(pro.getLTW_offset_upper_bound(), 15);
	}
	public void make13(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag13(), 8);
		enc.encInt(pro.getDescriptor_length13(), 8);
		enc.encInt(pro.getCopyright_identifier(), 32);
		enc.ASCIIEnc(enc, pro.getAdditional_copyright_info());
	}
	public void make14(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag14(), 8);
		enc.encInt(pro.getDescriptor_length14(), 8);
		enc.encInt(pro.getReserved141(), 2);
		enc.encInt(pro.getMaximum_bitrate(), 22);
	}
	public void make15(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag15(), 8);
		enc.encInt(pro.getDescriptor_length15(), 8);
		enc.encInt(pro.getPrivate_data_indicator(), 32);
	}
	public void make16(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag16(), 8);
		enc.encInt(pro.getDescriptor_length16(), 8);
		enc.encInt(pro.getReserved161()	, 2);
		enc.encInt(pro.getSb_leak_rate(), 22);
		enc.encInt(pro.getReserved161()	, 2);
		enc.encInt(pro.getSb_size(), 22);
	}
	public void make17(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag17(), 8);
		enc.encInt(pro.getDescriptor_length17(), 8);
		enc.encInt(pro.getReserved171(), 7);
		enc.encInt(pro.getLeak_valid_flag(), 1);
	}
	public void make18(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag18(), 8);
		enc.encInt(pro.getDescriptor_length18(), 8);
		enc.encInt(pro.getClosed_gop_flag(), 1);
		enc.encInt(pro.getIdentical_gop_flag(), 1);
		enc.encInt(pro.getMax_gop_length(), 14);
	}
	public void make63(Encapsulate enc,Program pro){
		enc.encInt(pro.getDescriptor_tag63(), 8);
		enc.encInt(pro.getDescriptor_length63(), 8);
		enc.encInt(pro.getProfile_id(), 8);
		enc.encInt(pro.getLevel_id(), 8);
		enc.encInt(pro.getMultiple_frame_rate_flag2(), 1);
		enc.encInt(pro.getFrame_rate_code2(), 4);
		enc.encInt(pro.getAVS_still_present(), 1);
		enc.encInt(pro.getChroma_format2(), 2);
		enc.encInt(pro.getSample_precision(), 3);
		enc.encInt(pro.getReserved22(), 5);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
