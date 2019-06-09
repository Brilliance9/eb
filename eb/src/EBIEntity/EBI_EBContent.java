package EBIEntity;

import java.util.Arrays;

/*
 * 应急广播内容
 */
public class EBI_EBContent {
	private String Language;
	private String LanguageCode;
	private String CodeSet;
	private String Headline;
	private String EventDescription;
	private String ProgramNum;
	private String Signer;
	private Attachment Attachments[];

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getLanguageCode() {
		return LanguageCode;
	}

	public void setLanguageCode(String languageCode) {
		LanguageCode = languageCode;
	}

	public String getCodeSet() {
		return CodeSet;
	}

	public void setCodeSet(String codeSet) {
		CodeSet = codeSet;
	}

	public String getHeadline() {
		return Headline;
	}

	public void setHeadline(String headline) {
		Headline = headline;
	}

	public String getEventDescription() {
		return EventDescription;
	}

	public void setEventDescription(String eventDescription) {
		EventDescription = eventDescription;
	}

	public String getProgramNum() {
		return ProgramNum;
	}

	public void setProgramNum(String programNum) {
		ProgramNum = programNum;
	}

	public String getSigner() {
		return Signer;
	}

	public void setSigner(String signer) {
		Signer = signer;
	}

	public Attachment[] getAttachments() {
		return Attachments;
	}

	public void setAttachments(Attachment[] attachments) {
		Attachments = attachments;
	}

	@Override
	public String toString() {
		return "EBI_EBContent [Language=" + Language + ", LanguageCode=" + LanguageCode + ", CodeSet=" + CodeSet
				+ ", Headline=" + Headline + ", EventDescription=" + EventDescription + ", ProgramNum=" + ProgramNum
				+ ", Signer=" + Signer + ", Attachments=" + Arrays.toString(Attachments) + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Attachment att[]=new Attachment[3];
		for(int i=0;i<3;i++){
			att[i]= new Attachment();
		}
		att[0].setAttName("first");
		att[1].setAttName("second");
		att[2].setAttName("thrid");
		EBI_EBContent ebc=new EBI_EBContent();
		ebc.setAttachments(att);
		System.out.print(ebc.toString());

	}

}
