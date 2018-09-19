import java.util.Scanner;
import java.util.Date;
class Foodlog {
	private String foodName;
	private String qty;
	private String date;
	private String time;
	public Foodlog() {

	}
	public Foodlog(String foodName, String qty,String date,String time) {
		this.foodName = foodName;
		this.qty = qty;
		this.date = date;
		this.time = time;
		//System.out.println(name);
		//System.out.println(qty);
		//this.date = date;
	}
	public String getFoodName() {
		return foodName;
	}
	public String getQuantity() {
		return qty;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String foodLog() {
		String str = "Date:"+getDate()+"\n"+"Time:"+getTime()+"\n"+"Name:"+getFoodName()+"\n"+"Quantity:"+getQuantity();
		return str;
	}
}
class Water {
	private String waterqty;
	private String date;
	private String time;
	public Water(String date,String time,String waterqty) {
		this.date = date;
		this.waterqty = waterqty;
		this.time = time;
	}
	public String getDate() {
		return date;
	}
	public String getWaterQty() {
		return waterqty;
	}
	public String getTime() {
		return time;
	}
	public String waterLog() {
		String str = "Date:"+getDate()+"\n" + "Time:"+getTime() +"Quantity:"+getWaterQty()+"ml";
		return str;
	}
}
class PhysicalActivities {
	private String actname;
	private String actdate;
	private String actstarttime;
	private String actendtime;
	private String notes;
	public PhysicalActivities(String actname,String notes, String actdate, String actendtime) {
		this.actname = actname;
		this.notes = notes;
		this.actdate = actdate;
		this.actendtime = actendtime;
	}
	public PhysicalActivities(String actname,String notes, String actdate, String actstarttime, String actendtime) {
		this.actname = actname;
		this.notes = notes;
		this.actdate = actdate;
		this.actstarttime = actstarttime;
		this.actendtime = actendtime;
	}
	public String getActivityName() {
		return actname;
	}
	public String getActivityDate() {
		return actdate;
	}
	public String getActivitystarttime() {
		return actstarttime;
	}
	public String getActivityendtime() {
		return actendtime;
	}
	public String getNotes() {
		return notes;
	}
	public String PhysicalActivitiesLog() {
		String str = "Name:"+getActivityName() +"\n"+"Notes:"+getNotes()+"\n"+"Date:"+getActivityDate()+"\n"+"Starttime:"+getActivitystarttime()+"\n"+"Endtime:"+getActivityendtime();
		return str;
	}
}
class Weight {
	private String kg;
	private String fat;
	private String date;
	public String time;
	public Weight(String date,String time, String kg, String fat) {
		this.date = date;
		this.time = time;
		this.kg=kg;
		this.fat = fat;
	}
	public String getKg() {
		return kg;
	}
	public String getFat() {
		return fat;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
	public String weightLog() {
		String str = "Date:"+getDate()+"\n"+"Time:"+getTime()+"\n"+"Weight:"+getKg()+"\n"+"Fat:"+getFat();
		return str;
	}
}
class Sleep {
	private String sleepstarttime;
	private String sleependtime;
	private String date;
	public Sleep(String date, String sleepstarttime,String sleependtime) {
		this.date = date;
		this.sleepstarttime = sleepstarttime;
		this.sleependtime = sleependtime;
	}
	public String getDate() {
		return date;
	}
	public String getSleepStarttime() {
		return sleepstarttime;
	}
	public String getSleepEndtime() {
		return sleependtime;
	}
	public String sleepLog() {
		String str = "Date:"+getDate()+"\n"+"Starttime:"+getSleepStarttime()+"\n"+"Endtime:"+getSleepEndtime();
		return str;
	}
}
class Fitbyte{
	private Foodlog[] food;
	private Water[] water;
	public PhysicalActivities[] phyact;
	public Weight[] weight;
	public Sleep[] sleep;
	private int foodsize = 0;
	private int watersize = 0;
	private int activitysize = 0;
	private int sleepsize = 0;
	private int weightsize = 0;
	Fitbyte() {
		food = new Foodlog[10];
		water = new Water[10];
		phyact = new PhysicalActivities[10];
		sleep = new Sleep[10];
		weight = new Weight[10];
	}
	public Foodlog[] getFood() {
		Foodlog[] f = new Foodlog[foodsize];
		for (int i = 0; i < foodsize; i++) {
			f[i] = food[i];
		}
		return f;
	}
	public Water[] getWater() {
		Water[] wa = new Water[watersize];
		for (int i = 0; i < watersize; i++) {
			wa[i] = water[i];
		}
		return wa;
	}
	public PhysicalActivities[] getPhysicalActivity() {
		PhysicalActivities[] p = new PhysicalActivities[activitysize];
		for (int i = 0; i < activitysize; i++) {
			p[i] = phyact[i];
		}
		return p;
	}
	public Sleep[] getSleep() {
		Sleep[] s = new Sleep[sleepsize];
		for(int i = 0; i < sleepsize; i++) {
			s[i] = sleep[i];
		}
		return s;
	}
	public Weight[] getWeight() {
		Weight[] w = new Weight[weightsize];
		for(int i = 0; i < weightsize; i++) {
			w[i] = weight[i];
		}
		return w;
	}
	public void addFood(Foodlog f) {
		food[foodsize++] = f;
	}
	public void addActivity(PhysicalActivities p) {
		phyact[activitysize++] = p;
	}
	public void addWater(Water wa) {
		water[watersize++] = wa;
	}
	public void addSleep(Sleep s) {
		sleep[sleepsize++] = s;
	}
	public void addWeight(Weight w) {
		weight[weightsize++] = w;
	}

}
public final class Solution {

	private Solution() {

	}
	public static void main(String[] args) {
		Fitbyte fb = new Fitbyte();
		Scanner s = new Scanner(System.in);

		while(s.hasNext()) {
			String line = s.nextLine();
			String[] tokens = line.split(" ");
			// System.out.println(tokens[0]);
			// System.out.println(tokens[1]);
			switch(tokens[0]) {
				case "Food":
				String[] t = tokens[1].split(",");
				Foodlog fl = new Foodlog(t[0],t[1],t[2],t[3]);
				fb.addFood(fl);
				break;
				case "PhysicalActivity":
				String[] t1 = tokens[1].split(",");
				if(t1.length == 4) {
					PhysicalActivities a = new PhysicalActivities(t1[0],t1[1],t1[2],t1[3]);
					fb.addActivity(a);
				} else {
					PhysicalActivities a = new PhysicalActivities(t1[0],t1[1],t1[2],t1[3],t1[4]);
					fb.addActivity(a);
				}
				break;
				case "Water":
				String[] t2 = tokens[1].split(",");
				Water w = new Water(t2[0], t2[1], t2[2]);
				fb.addWater(w);
				break;
				case "Weight":
				String[] t3 = tokens[1].split(",");
				Weight wt = new Weight(t3[0],t3[1],t3[2],t3[3]);
				fb.addWeight(wt);
				break;
				case "Sleep":
				String[] t4 = tokens[1].split(",");
				Sleep sl = new Sleep(t4[0],t4[1],t4[2]);
				fb.addSleep(sl);
				break;
				case "Foodlog":
				Foodlog[] fo = fb.getFood();
				System.out.println("Food");
				for(int i = 0; i < fo.length; i++) {
					System.out.print(fo[i].foodLog());					
				}
				System.out.println("\n");
				break;
				case "Waterlog":
				Water[] wa = fb.getWater();
				System.out.println("Water");
				for(int i = 0; i < wa.length; i++) {
					// String poo = wa[i].WaterLog();
					// System.out.println(poo);
					System.out.print(wa[i].waterLog());
					System.out.println();
				}
				System.out.println();
				break;
				case "PhysicalActivitylog":
				PhysicalActivities[] ac = fb.getPhysicalActivity();
				System.out.println("PhysicalActivity");
				if(ac.length == 0) {
					System.out.println("None");
					// return;
				}
				else{
					for(int i = 0; i < ac.length; i++) {
						System.out.print(ac[i].PhysicalActivitiesLog());
						System.out.println();
					}
				}
				System.out.println();
				break;
				case "Sleeplog":
				Sleep[] sle = fb.getSleep();
				System.out.println("Sleep");
				for(int i = 0; i < sle.length; i++) {
					System.out.print(sle[i].sleepLog());
				}
				System.out.println("\n");
				break;
				case "Weightlog":
				Weight[] wei = fb.getWeight();
				System.out.println("Weight");
				for(int i = 0; i < wei.length; i++) {
					System.out.print(wei[i].weightLog());
				}
				System.out.println("\n");
				break;
				
			}
		}
	}
}