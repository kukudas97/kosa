package DI3;

public class Program {

   public static void main(String[] args) {
      //NewRecordView view = new NewRecordView(100, 50, 40);
      //view.Print();
	   
	   NewRecordView view = new NewRecordView();
	   //놀다가
	   //NewRecord객체가 필요하면
	   NewRecord record = new NewRecord();
	   view.setRecord(record); //의존객체의 주소가 주입(setter를 통해서)
	   
	   view.input();
	   
	   view.Print();
   }
}