package tw.org.iii.myreview;

public class Rev024_TWid2 {

	public static void main(String[] args) throws Exception {
		Rev024_TWid2_class id1 = new Rev024_TWid2_class();
		System.out.println(id1.getId());
		
		// test a valid id number?
		String a1 = "A123456789";
		System.out.println("Test number = " + a1);
		
		//	test number length
		if (a1.length() == 10) {
			System.out.println("Test number length OK");
		}else {
			System.out.println("Test number length NG");
		}
		
		System.out.println(Rev024_TWid2_class.checkId("A123456780"));
		
		Rev024_TWid2_class id6 = Rev024_TWid2_class.createId("A123456789");
		System.out.println("id6.getId() : " + id6.getId());
		
		Rev024_TWid2_class id2 = new Rev024_TWid2_class(13, true);
		System.out.println("id2 : " + Rev024_TWid2_class.checkId(id2.getId()));
		
	}

}
