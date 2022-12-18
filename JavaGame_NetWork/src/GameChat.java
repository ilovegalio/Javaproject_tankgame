//import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.*;

//import javax.swing.*;


public class GameChat implements Serializable {
	// 메시지 타입 정의
		// 1개의 메시지 종류 필드와 3개의 String형 필드.
		// NO_ACT는 무시할 수 있는 Dummy 메시지. 디버깅용 등으로 사용하기 위해 만들어 놓음
		// (1) 클라이언트가 보내는 메시지 형식
		//	- LOGIN  : CLIENT 로그인.
		//		메시지 포맷 : LOGIN, "송신자", "", ""
		//	- LOGOUT : CLIENT 로그아웃.
		//		메시지 포맷 : LOGOUT, "송신자", "", ""
		// 	- CLIENT_MSG : 서버에게 보내는  대화 .
		// 		메시지포맷  : CLIENT_MSG, "송신자", "수신자", "내용"
		// (2) 서버가 보내는 메시지 형식
		// 	- LOGIN_FAILURE  : 로그인 실패
		//		메시지 포맷 : LOGIN_FAILURE, "", "", "로그인 실패 원인"
		// 	- SERVER_MSG : 클라이언트에게 원격으로 보내는 대화 
		//		메시지포맷  : SERVER_MSG, "송신자", "", "내용" 
		// 	- LOGIN_LIST : 현재 로그인한 사용자 리스트.
		//		메시지 포맷 : LOGIN_LIST, "", "", "/로 구분된 사용자 리스트"
		public enum MsgType {NO_ACT, LOGIN, LOGOUT, CLIENT_MSG, LOGIN_FAILURE, SERVER_MSG, LOGIN_LIST, GAME_INFO, GAME_START, NOT_ENOUGH_USER};
		public static final String ALL = "전체";	 // 사용자 명 중 자신을 제외한 모든 로그인되어 있는
												 // 사용자를 나타내는 식별문
		private MsgType type;
		private String sender;
		private String receiver;
		private String contents;
		
		public ArrayList<Integer> icon = new ArrayList<Integer>();
		public int animalNum; 		// 동물 식별 번호
		public int i,score, turnNum, firstTurnNum;// i=피라미드 버튼 인덱스 , score = 점수 , turnNum = 턴 정보 , firstTurnNum = 첫번째 차례의 턴 정보
		public String NextUser;		// 다음 차례에 진행할 유저 이름
		public boolean userCheck;	// 자기 차례인지 확인하는 변수
		public boolean turnAble;	// false = 차례 진행 불가, true = 차례 진행 가능
		
		public GameChat() {
			this(MsgType.NO_ACT, "", "");
		}
		
		public GameChat(MsgType t){
			type = t;
		}
		
		public GameChat(MsgType t, String sID, String mesg) {
			type = t;
			sender = sID;
			contents = mesg;
		}
		
		public GameChat(MsgType t, int turnNum, int firstTurnNum){
			type = t;
			this.turnNum = turnNum;
			this.firstTurnNum = firstTurnNum;
		}
		public GameChat(MsgType t, int i, int animalNum, int score, String sender, int turnNum, boolean turnAble) {
			type = t;
			this.i = i;
			this.animalNum = animalNum;
			this.score = score;
			this.sender = sender;
			this.turnNum = turnNum;
			this.turnAble = turnAble;
		}
		
		public GameChat(MsgType t, int i, int animalNum, int score, String sender, int turnNum, String NextUser, boolean turnAble) {
			type = t;
			this.i = i;
			this.animalNum = animalNum;
			this.score = score;
			this.sender = sender;
			this.turnNum = turnNum;
			this.NextUser = NextUser;
			this.turnAble = turnAble;
		}
		
		public GameChat(MsgType t, ArrayList<Integer> icon, int turnNum, int firstTurnNum, String NextUser){
			type = t;
			this.icon = icon;
			this.turnNum = turnNum;
			this.firstTurnNum = firstTurnNum;
			this.NextUser = NextUser;
		}
		
		public void setType (MsgType t) {
			type = t;
		}
		public MsgType getType() {
			return type;
		}

		public void setSender (String id) {
			sender = id;
		}
		public String getSender() {
			return sender;
		}
		
		public void setReceiver (String id) {
			receiver = id;
		}
		public String getReceiver() {
			return receiver;
		}
		
		public void setContents (String mesg) {
			contents = mesg;
		}
		public String getContents() {
			return contents;
		}
		
		public String toString() {
			return ("메시지 종류 : " + type + "\n" +
					"송신자         : " + sender + "\n" +
					"수신자         : " + receiver + "\n" +
					"메시지 내용 : " + contents + "\n");
		}
}
