public class Exam01{
	public static void main(String[] args){
		Ball b1 = new Ball();
		Ball b2 = b1;
		if(b1 == b2){
			System.out.println("b1과 b2는 같은 객체를 참조합니다.");
		}else{
			System.out.println("b1과 b2는 다른 객체를 참조합니다.");
		}
	}
}
