package tools;

public class MesDates {
	public String dateFRtoUS(String date) {
		String[] dateTab = date.split("/");
		String year = dateTab[0];
		String month = dateTab[1];
		String day = dateTab[2];
		String dated = year+"-"+month+"-"+day;
		return dated;
	}
	
	public String dateUStoFR(String date) {
		String[] dateTab = date.split("-");
		String year = dateTab[0];
		String month = dateTab[1];
		String day = dateTab[2];
		String dated = year+"/"+month+"/"+day;
		return dated;
	}
}
