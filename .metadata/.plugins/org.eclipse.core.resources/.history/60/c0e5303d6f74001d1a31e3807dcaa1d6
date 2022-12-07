package DI2;

public class NewRecordView {
	
	private NewRecord record; //포함관계(복합연관)


	//setter 함수를 통해서 필요한 객체의 주소를 받기
	//언젠가 주소가 필요하겠지 그럼 그때가 오면 setter함수를 통해서 사용
	public void setRecord(NewRecord record) {
		this.record = record;
	}
	
	/*
	 나는 니가 필요해
	 나는 너의 객체 주소가 필요해....
	 1. 생성자를 통해서 필요한 객체를 생성 or 주입 >> DI >> 복합, 집합
	 2. 함수(setter)를 통해서 필요한 객체를 주입 >> DI >> 집합 >> 필요
	 */
	
	public void Print() {
		System.out.println(record.total() + "/" + record.avg());
	}
}
