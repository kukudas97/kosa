package DI;

public class NewRecordView {
	
	private NewRecord record; //포함관계(복합연관)
	public NewRecordView(int kor, int eng, int math) {
		record = new NewRecord(kor, eng, math);
	}
	
	public void Print() {
		System.out.println(record.total() + "/" + record.avg());
	}
}
