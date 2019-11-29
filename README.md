# Java-Practice
## (19.11.29) FACADE 패턴 (퍼사드 패턴)
- FACADE의 사전적 의미 : 1. (건물의) 정면 2. (실제와 다른) 표면, 허울
> 퍼사드는 클래스 라이브러리 같은 어떤 소프트웨어의 다른 커다란 코드 부분에 대한 간략화된 인터페이스를 제공하는 객체이다.

- 아래 Java 코드 예제는 사용자(you)가 퍼사드(컴퓨터)를 통해 컴퓨터 내부의 부품(CPU, HDD) 등을 접근한다는 내용의 추상적인 예제이다. (https://ko.wikipedia.org/wiki/퍼사드_패턴)
```
/* Complex parts */

class CPU {
	public void freeze() { ... }
	public void jump(long position) { ... }
	public void execute() { ... }
}

class Memory {
	public void load(long position, byte[] data) {
		...
	}
}

class HardDrive {
	public byte[] read(long lba, int size) {
		...
	}
}


class Computer {
	public void startComputer() {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
		cpu.freeze();
		memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
		cpu.jump(BOOT_ADDRESS);
		cpu.execute();
	}
}

/* Client */

class You {
	public static void main(String[] args) throws ParseException {
		Computer facade = /* grab a facade instance */;
		facade.startComputer();
	}
}
```

- 외부의 클라이언트에게 복잡하게 사용되고 있는 클래스들을 추상적으로 제공하는 관문과도 같은 역할을 한다.
- Q 클래스 수준의 '캡슐화'라고 봐도 무리가 없을까?

## (19.11.19) 패키지(default) 접근제어자를 가지고 있는 클래스
- 패키지(default) 접근제어자를 가지고 있는 클래스는 한 뎁스 더 깊은 곳에서 접근이 불가능하다. 즉, 정말 같은 패키지 안에 존재해야만 접근 가능하다.
- 연습예제 : AccessModifierTest.java

/* Façade */
## (19.11.07) SRP - Single Responsibility Principle (단일 책임 원칙)
    '변경되어야 하는 이유가 오직 하나뿐이여야한다.'
쉽게 생각했지만 가장 중요한 '변경되어야 하는 이유'에 대해서 깊게 생각해보지 않았다.
클린아키텍처 p66에는 다음과 같이 설명했다. 

    '하나의 모듈은 하나의, 오직 하나의 액터에 대해서만 책임져야 한다.'

액터란 동일한 방식으로 변경되기를 원하는 사용자 혹은 이해관계자 집단을 말한다. (즉 사용자가 하나인경우도 있지만 여럿일 수도 있다.)
예를들어, '스마트폰' 이라는 객체를 철수와 영희가 모두 사용하고 있다고 가정해보자.   
철수는 스마트폰을 영상 시청을 위해서 사용한다. 하지만 영희는 스마트폰을 전화통화를 위해서 사용한다.

```
class 스마트폰 implements 동영상플레이어, 전화 {
    ...
}
```

위의 스마트폰을 같이 사용하는 철수와 영희는 다른 방식으로 변경되기를 원할 수 있기 때문에, 철수와 영희는 별개의 액터다. 즉 위의 스마트폰은 SRP를 준수하고 있지 않다.

철수가 만약 영상 시청을 위해서 스마트폰의 액정크기를 15인치로 바꾼다면? 영희의 전화통화 요구사항에는 맞지 않는 변경이 된다.
그러므로 해당 스마트폰의 역할을 토대로 2개의 클래스(객체)로 변경되어야 SRP를 준수한다고 볼 수 있다.

만약 철수와 영희가 같은 요구사항으로써 스마트폰을 사용한다면 철수와 영희는 하나의 액터로 볼 수 있고, 이러한 경우는 SRP를 준수한다고 볼 수 있다.

## (19.11.01) Null로 비교연산하면 NPE가 발생할까?
- 동일성(==)비교는 NPE가 발생하지 않는다.
- null == null은 true다.
- 동등성(equals)비교
    - myObject.equals(null); 은 NPE가 발생하지 않는다.
    - 만약 myObject가 null이면 NPE가 발생한다.

## (19.10.31) UML 실전에선 이것만 쓴다. 11장
### 객체지향의 과잉 (OOverKill)
- 하나님클래스만 조심할게 아니라, 허깨비 클래스도 조심해야 한다.
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
