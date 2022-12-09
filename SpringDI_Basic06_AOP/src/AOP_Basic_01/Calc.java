package AOP_Basic_01;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class Calc {
/*
 간단한 사칙 연산 프로그램
 -주관심(업무) : 사칙연산(ADD, MUL) >> 기능 함수 구현
 -보조관심(공통관심) : 연산에 걸린 시간
 -log출력(console.log(red한 글자 출력))
 
 시간이 지나고 유지보수 시간
 변화... 100개의 함수 모두...100개의 함수를 찾아서 모두 수정
 */
	public int Add(int x, int y) {
		
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("타이머 시작");
		
		//주업무
		int result = x+y;
		
		sw.stop();
		log.info("타이머 종료");
		log.info("time Log Method : ADD");
		log.info("Time Log Method : " + sw.getTotalTimeMillis());
		
		return result;
	}
	
	public int Mul(int x, int y) {
		
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("타이머 시작");
		
		//주업무
		int result = x*y;
		
		sw.stop();
		log.info("타이머 종료");
		log.info("time Log Method : MUL");
		log.info("Time Log Method : " + sw.getTotalTimeMillis());
		
		return result;
	}
}
