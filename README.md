# Java-Practice

## (19.10.31) UML 실전에선 이것만 쓴다. 11장
### 객체지향의 과잉 (OOverKill)
- 요구사항의 문제해결을 위해서 현실셰계와 클래스(객체)를 맹목적으로 1대1 매핑 시키지 말자. 어려운 도메인인 경우 이러한 설계가 나오겠지만 말랑말랑하게 생각하자.

### '연관'이란 메세지를 전달하기 위한 통로다.
11장에서 객체간의 연관을 '메시지'와 '알림'으로 계속해서 설명하고 있다. A라는 객체가 B라는 객체에게 무언갈 알려야 한다면, A->B의 연관관계가 나오는 것이다.
- "**연관은 객체들이 서로 메시지를 보내는 통도다.**" (p154)
- "따라서 UserInterface 객체가 제일 먼저 할 일은, ... **메시지를 보내** 준비가 되었는지 확인하는 일이다." (p155)
- "UserInterface 객체가 ... 시작(Start) **8메시지를 보내야 할 것이다.**" (p156)
- "따라서 ContainmentVessel은 HotWaterSource에 뜨거운 물을 그만 보내라고 **알릴 수 있어야 한다.**" (p157)


## (19.10.04) UML 실전에선 이것만 쓴다. 2장
![uml4java_p24_diagram](./img/UML4JAVA_p24.png)
- (22페이지~24페이지) ButtonDialerAdapter가 추가되어서 어떤 장점을 갖게 되었을까?
  1. ButtonDialerAdapter(이하 어댑터)가 없다면 Dialer가 어떤 Button들이 있고 어떤 기능과 매핑되어야 하는지 알고 있어야한다. (단일책임원칙 위반)
  2. 어댑터 없이 새로운 Button이 추가되어야 한다면 Dialer의 코드가 수정되어야 한다. (개방폐쇄원칙 위반)
  3. Button이 아니라 다른 방식으로 Dialer를 조작해야한다면, Dialer가 이에 대응 하는 코드가 삽입되어야 한다. 하지만 다른방식의 어댑터가 존재한다면 다이얼러의 수정없이 확장이 가능하다. (개방폐쇄원칙 준수)
- 연습 예제 : https://github.com/siyoon210/Java-Practice/tree/master/src/uml_for_java_programmers/p24_phone_exam
