# Java-Practice

## (20.10.26) Collections -> 원시 배열
```
answerList.stream()
            .mapToInt(Integer::intValue)
            .toArray();
```
- 스트림을 활용하여서 mapToInt로 변환후에 toArray()를 호출하면, 원시타입 배열로 쉽게 변경가능 (알고리즘 풀이시에 용이)
- Set을 쓰더라도 스트림을 뽑아내면 `sorted()`로 정렬일 가능하다!

## (20.09.26) JVM GC가 메모리 영역을 여러군데로 나누는 이유!
### Generational Collection Algorithm
- 메모리 영역을 나누어서, 해당 영역마다 적절한 알고리즘을 적용할 수 있기 때문이다.
- 크게 영(Young), 올드(Old)영역 2군데로 나뉘게 되는데, 
    - 영영역은 많은 객체들이 금방 사라지기 때문에 GC를 자주 수행한다. 연산이 비교적 빠 Mark-Sweep과 Copying 알고리즘을 염두할 수 있다.
    - 올드영역은 GC를 자주 수행하지 않지 않는다. 메모리를 효율적으로 사용하는 Mark-Compact-Sweep알고리즘을 생각해 볼 수 있겠다.
- 그리고 이 모든 것은 Weak Generation Hypothesis 가설을 기반으로 생각한다. (대부분 객체는 바로 사라지고, 올드 객체가 새로운 객체를 참조하는 일이 매우 적다.)
    - As shown in a professional research conducted by IBM, nearly 98% of the objects are short-lived.

### Young 영역
- 영영역은 다시 3군데로 나누어진다.

#### Eden 
- 새로운 오브젝트들은 Eden(에덴)영역에 할당된다. 그리고 거의 대부분의 객체들은 MinorGC이후로 사라지게 되고 살아남은 객체는 Survivor1(From)으로 넘어가게 된다. 
- 만약 Survivor에 담기지 못할정도로 크기가 크다면 바로 올드 영역으로 넘어간다.
    - 그러므로 크기가 너무 큰데, 금방 쓸모없게 되는 객체가 있다면 유의해야한다.

#### Survivor 1,2 (From, To)
- 에덴영역과 올드영역의 중간단계 역할을 한다.
- 만약 Survivor 영역이 없다면 매 마이너GC 마다 올드영역으로 객체들이 넘어가고, 올드영역이 너무 빨리 차오를것이다. 한두번의 마이너GC에서 살아남더라도 곧 사라질 객체가 많다.
- 그래서 서바이버 영역이 중간다리 역할을 하며, 16번의 마이너GC를 넘긴 객체만이 올드영역으로 넘어간다.
- 서바이버 영역을 나누둔 이유는 Copying알고리즘을 적용하기 위함이다. Mark-Sweep 알고리즘을 적용한다면 많은 MinorGC 때문에 메모리 조각화 문제가 발생 될것이다.
    - Eden영역과 서바이버1 영역의 마이너 GC이후에 서바이버2로 복사되어 넘어가고, 다음 마이너GC때는 Eden영역과 서바이버2 영역에 있던 객체들이 서바이버1로 넘어 갈 것이다. 
    - 너무 크면 올드영역으로 바로 넘어간다.

### Old 영역
- 올드영역은 힙메모리의 2/3를 차지한다.
- Mark Compact알고리즘을 수행한다.


## (20.09.24) GC가 메모리를 관리하는 방법
### Mark-Sweep Algorithm
![Mark-Sweep Algorithm](https://miro.medium.com/max/1540/0*e1NY2bol0n3fQ-x-.png)
- 가장 일반적인 메모리 회수 방법으로 사용하지 않을 메모리를 Mark해두고, Sweep하여 비우는 알고리즘이다.
- 이 알고리즘은 메모리 조각화 문제가 있다. (memory fragmentation)
    - 작은 사이즈의 메모리 공간을 비우더라도, 이후에 큰 사이즈의 메모리를 차지해야 하는 정보가 있다면 사용이 불가능하다.
        - 하나의 정보는 하나의 블럭단위로 저장되어야 하기 때문이다. (We know that memory can be allocated only in contiguous form of blocks.) 
- 장점 : 알고리즘 연산이 간단하다.
- 단점 : 메모리 조각화문제가 발생한다.
        
### Copying Algorithm
![Copying Algorithm](https://miro.medium.com/max/1540/0*AG2dn5KoBr5HP_2L.png)
- Copying Algorithm은 Mark-Sweep Algorithm의 단점인 메모리 조각화 문제를 해결 할 수 있다.
- 메모리 영역을 2군데로 나누어두고, 한곳만을 사용하다가 이곳이 가득 차면, 사용하던 메모리 영역을 비우고 사용하지 않던 메모리 영역으로 객체들을 복사한다.
    - 마치 Young영역의 Survicor1,2같네!
    - 메모리 조각화 문제가 당연히 일어나지 않는다.
- 다만 메모리 영역을 반밖에 사용하지 못한다는 단점이 있다.
- 장점 : 메모리 조각화 문제가 발생되지 않는다.
- 단점 : 메모리를 2군데로 나누어서 활성화된 영역을 반밖에 사용하지 못한다.

### Mark-Compact Algorithm
![Mark-Compact Algorithm](https://miro.medium.com/max/1540/0*qIJFk4iNPBxe0Vsx.png)
- Mark-Sweep과 유사하게 행동하지만, 바로 메모리를 비우지 않고, 사용되고 있는 객체들을 메모리 빈공간없이 압축(Compact)하는 과정을 추가한다.
- Mark-Sweep처럼 메모리 조각화 문제를 발생시키지 않고, Copying Algorithm처럼 메모리를 반만 쓰는 문제는 없지만
- 압축하는 과정이 있기 떄문에 시간 성능상 Copying Algorithm보다 불리하다. 
- 장점 : 메모리 조각화 문제가 일어나지 않고, 메모리 영역 전체를 사용가능하다.
- 단점 : 연산이 복잡하다. (내 예상으론 Mark-Compact-Sweep < Copying < Mark-Sweap 순으로 빠를것으로 예상한다.)  

- https://medium.com/datadriveninvestor/how-does-garbage-collection-work-in-java-da8f75ec6899

## (20.09.22) GC가 Garbage를 찾는 방법
### Reference Counting Algorithm
1. 오브젝트가 참조되면 해당 오브젝트의 RC를 하나 증가시키고, 참조가 사라지면 RC를 하나 감소시킨다.
2. RC카운트가 0이 되면 Garbage로 판단한다.
- 이 알고리즘은 Stop-The-World(garbage를 찾는 과정) 없이 수행 할 수 있다. 참조가 0이 되는 순간을 바로 알 수 있으니까!
- 하지만 JVM은 이방식을 사용하지 않는다 왜냐!
    - 이 알고리즘은 객체 내부적으로 순환참조가 일어날때 RC가 0이 되지 않아 메모리 누수(leak)가 발생한다.
    ```
    class MyClass {
        Object instance;
    }
  
    public static void main(String[] args) {
        MyClass A = new MyClass();
        MyClass B = new MyClass();
  
        A.instance = B;
        B.instance = C;
  
        A = null;
        B = null;
    }
    ```
    - A가 참조했던 객체와 B가 참조했던 객체는 더 이상 사용되지 않아 Garbage처럼 보이지만, 여전히 A.instance는 B를 참조하고 있고 B.instance는 A를 참조하고 있게 된다. 순환적으로 참조하여 어느 한곳에서 먼저 참조를 해제할 수 없는 상태가 된다.

### Reachability Analysis Algorithm
'GC root'로 부터 참조를 그래프 탐색하여 도달 가능한 Object들은 여전히 사용하는 객체로 판단하고, 아니라면 Garbage로 판단하는 알고리즘

- 'GC root'는 무엇인가?
    1. 스택영역 (JVM, 네이티브 둘다)에서 (지역변수가) 참조하고 있는 객체! (지역변수가 아니라 이 객체가 root다)
    2. 메소드 영역(스태틱 영역)에서 static 요소들이 참조하고 있는 객체! (이 요소들이 아니라 객체가 root다!) 
    3. 메소드 영역(스태틱 영역)에서 상구가 참조하고 있는 객체!
    ```
        - Objects referenced in the virtual machine (VM) stack, that is the local variable table in the stack frame
        - Objects referenced by class static attributes in the method area
        - Objects referenced by constants in the method area
        - Objects referenced by JNI (the Native method) in the native method stack
    ```

- https://medium.com/datadriveninvestor/how-does-garbage-collection-work-in-java-da8f75ec6899

## (20.09.21) GC 기초
- GC를 구조를 이해하기 위해서 전제처럼 알고 있어야 할 가설이 있다. (Weak Generation Hypothesis)
    1. 대부분의 객체는 금방 접근 불가능한 (Unreachable) 상태가 된다.
    2. 오래된 객체에서 젊은 객체로의 참조는 아주 적게 존재한다.
- 그러므로, 만들어지지 얼마되지 않은 객체와 오래된 객체와의 관리적 분리가 필요한 것이다.
    - 크게 Young영역과 Old영역으로 나뉘게 되는 이유도 위의 가설에 기반하여 생각하면 아주 자연스럽다.
    - 영역이 나누어져 있으면 Young영역의 GC와 Old영역의 GC를 나누어서 할 수 있게 되며, 성능상에 이점도 얻을 수 있다.
        - Young영역의 GC를 Minor GC, Old 영역의 GC를 Major Gc(혹은 Full GC)라고 한다.

Q) 각 영역들을 옮겨 다니게 되면 객체의 참조값도 바꾸게 될까?
    A) 그렇다. (https://stackoverflow.com/questions/35548337/does-object-reference-change-after-gc/35548535#35548535)
 
- https://d2.naver.com/helloworld/1329

## (20.09.20) JVM 실행과정
1. JVM이 실행되면 부트스트랩 클래스로더를 생성하고 Object 클래스를 불러온다.
2. 익스텐션 클래스로더와 시스템(앱)클래스로더도 생성되고, 이제 필요한 클래스들은 참조되는 순간 동적으로 불러오게 된다.
3. public static void main() 메서드를 찾아서 main() 스택 쓰레드를 생성한다.
4. 메인 스택이 실행되고, 메인스택이 비워진다면 JVM은 실행이 끝난다.

- https://steady-snail.tistory.com/67#%EB%9F%B0%ED%83%80%EC%9E%84%20%EB%8D%B0%EC%9D%B4%ED%84%B0%20%EC%98%81%EC%97%AD(Runtime%20Data%20Area)
- https://d2.naver.com/helloworld/1230

## (20.09.19) 클래스로더
- **자바는 동적으로 클래스를 읽어온다. 즉, 런타임에 모든 코드가 JVM에 링크된다. 모든 클래스는 그 클래스가 참조되는 순간에 동적으로 JVM에 링크되며, 메모리에 로딩된다.**
- 이러한 행위를 해주는 것이 클래스 로더다
- 클래스로더는 최상위 bootstrap 클래스로더부터 Extension, App(System) 클래스로더로 내려온다.
    ![classloader](https://t1.daumcdn.net/cfile/tistory/267FDB50586B217223)
    - (이는 상속을 말하는게 아닌것같다. 개념적인 부모-자식인 것 같다. 스프링에도 이런 개념이있었는데.. )
    - 부트스트랩 클래스로더는 $JAVA_HOME/jre/lib 파일을 읽어온다. 
    - 익스텐션 클래스로더는 $JAVA_HOME/jre/lib/ext 파일을 읽어온다.
    - 이후 자식부터는 선언된 클래스패스에서 읽어온다.
    - 부트스트랩 클래스로더는 자바코드로 확인할수 없다. getClassLoader()를 하면 null로 반환되는데 이는 c로 구현되어 있기 때문이다.
        - JVM이 부트스트랩(bootstrap) 클래스로더를 생성하고, 그 다음에 가장 첫번째 클래스인 Object를 시스템에 읽어온다.
        - 그러므로 이후에 익스텐션 클래스로더, 앱 클래스로더는 자바코드로 확인이 가능하다.
    - 자식클래스로더가 부모클래스로더에게 클래스로딩을 일임하는 구조다. 최상위 부모클래스(부트스트랩) 부터 읽을수 없으면 다시 자식에게 알린다.
        - 최하단 자식클래스로더가 읽을 수 없다면 ClassNotFoundException을 발생시킨다.
    - 클래스들을 캐시처리를 해두어서 한번만 읽도록 한다. (Q 이미 스태틱(메소드)영역에 클래스가 존재하지 않나..?)
- 로드타임 동적 로딩(load-time dynamic loading)과 런타임 동적 로딩(run-time dynamic loading)
    - 말그대로 '로드타임'에 가져오는 경우가 있고, 코드상에서 명시되어 '런타임'에 가져오는 경우가 있다. (자바캔 참고)

- https://futurists.tistory.com/43
- https://javacan.tistory.com/entry/1
- https://stackoverflow.com/questions/1921238/getclass-getclassloader-is-null-why

## (20.09.17) JVM
- .java 파일을 .class로 변환하는건 자바 컴파일러가 진행한다.
- .class 파일을 구동되는 OS 특화된 언어로 변환하는건 JVM이 진행한다.

- JVM은 크게 3가지 구조로 되어있다.
    - 클래스로더
    - 메모리
    - 실행엔진
- 클래스로더는 .class 파일을 찾아서 읽고, 검증한후 바이트코드를 메모리에 적재시킨다.
- 메모리는 다시 5가지 영역으로 나뉜다.
    - 메소드영역  (스태틱영역이라고도 함)
        - 클래스정보들이 위치한다. 클래스 이름, 클래스 부모, 메소드 (인스턴스 메소드도 굳이 힙영역에 두지 않고 메소드영역에 존재한다), static 변수
        - 모든 쓰레드들이 공유한다.
    - 힙영역
        - 객체들이 위치한다.
        - 모든 쓰레드들이 공유한다.
    - 스택
        - 각 쓰레드마다 런타임스택이 생성된다.
    - PC
        - 현재 스택프레임을 가르키는 포인터
    - 네이티브 메소드 스택
        - JNI(java native interface)를 실행하는 별도의 메소드 스택
        - Q) 그럼 기존 스택이랑 어떻게 구분되지??
            - 기존 스택이 진행되다가, 네이티브 메소드가 나오면 해당 네이티브 메소드(c 로직)는 네이티브 스택에 쌓이면서 실행된다.
            - 네이티브 스택이 비워지면 다시 자바 함수를 (자바스택을) invoke 시킨다.
            - 즉 네이티브 스택은 스택의 도우미 역할만 한다.
            - https://www.artima.com/insidejvm/ed2/jvm9.html
- 실행엔진은 3가지가 있다.
    - 인터프리터
        - 인터프리터는 .class안의 바이트코드를 한줄씩 변환한다.
    - JIT컴파일러  
         - JIT컴파일러는 반복적으로 읽어드리는 바이트코드가 있다면 컴파일하여 인터프리터가 바로 실행할 수 있도록 도와준다.
    - GC
        - 가비지 컬렉터, 참조되고 있지 않은 인스턴스를 메모리에서 삭제한다.

## (20.09.10) TreeSet<T>, TreeMap<T>을 사용할려면 반드시 T타입의 Comparable<T>을 구현하라
- Tree 시리즈의 동등성검사는 Compare()로 진행된다. 즉 제대로 구현되지 않으면 입력된 데이터들을 모두 같은 인스턴스로 취급할 것이다. ID와 같은 값을 반드시 Compare메서드에 넣어서 구분시켜주자.

## (20.08.25) What are the advantages of streams over loops?
### 장점
- 좀더 선언적인 프로그래밍이 가능하여 코드가 '무엇'을 하는지 집중 할 수 있다.
### 단점
- 디버깅이 힘들다

- https://stackoverflow.com/questions/44180101/in-java-what-are-the-advantages-of-streams-over-loops

## (20.07.25)Arrays.fill()
- 배열의 같은 값을 채우는 메서드 (알고리즘 문제풀때 좋아!)
```
Integer[] integers = new Integer[10];
Arrays.fill(integers, 777);
```
예제코드 : practice.arraysfill

## (20.06.18) Java stream Peek연산
- forEach와 비슷하지만 forEach는 그 자체로 종단연산이고, Peek은 중간연산이다.
```
Arrays.stream(parse(split(s)))
        .peek(i -> {
            if (i < 0) {
                throw new RuntimeException();
            }
        })
        .reduce(0, Integer::sum);
```
예제코드 : onion-calculator 

## (20.04.18) 제네릭 메서드가 와일드카드와 다른점
### 제네릭 메서드의 장점
- 제네릭 메서드는 (메서드 내부에서) 컨테이너에서 get해온 경우 'add'할 수 있다.
- 하지만 와일드카드는 불가능하다.
- 반환타입으로 T 만을 명시할 수 있다.
- 반환값으로 명시하게 되면, 이미 메서드를 사용할떄 T를 추론할 수 있으므로, 반환값이 적절하게 나온다.

### 와일드카드의 장점
- 메서드 시그니처가 제네릭 메서드에 비해서 간단하다. (만약 같은 타입을 2번이상 여러번 쓴다면 반대로 제네릭 메서드가 깔끔하다.)
- 같은 ? 라도 다른 타입을 받을 수 있다. 
    `List<? extends Number> list, List<? extends Set<Number>> list2`
- 반환타입으로 ? 만을 명시할 수 없다. (List<?>는 가능)
- 반환값으로 명시하게 되면, 이미 메서드를 사용할떄 ?를 단정할 수 없으므로, 반환값에도 와일드카드가 그대로 달려서 나온다.


## (20.04.11) 제네릭 메서드 vs 와일드카드
- 기능적으로는 같다.
https://stackoverflow.com/questions/22860582/java-generics-wildcard-vs-type-parametere/22860768

### 제네릭 메서드와 와일드카드의 특징
- 타입 매개변수가 실체화되지 않는데, 예외적으로 제네릭 메서드와 와일드카드는 실체화 된다. (컴파일 이후로도 남아 있게 된다.)
- 실체화가 되기때문에 메소드 안에서 특정 인스턴스를 넣는걸 허용하지 않는다. 오로지 null만 넣을 수 있다.
    - 제네릭 메서드는 예외적으로 get해온 엘리먼트는 넣을 수 있다.
예제코드 : package practice.generics.wildcard;

## (20.04.03) 추상클래스도 인스턴스화가 불가능하지 않다.
- 추상클래스라도 abstract 메서드를 모두 정의하여 반환한다면 인스턴스로써 사용가능하다.
- 예제코드 package practice.mylist;

## (20.03.31) map.merge -> map.put(key, map.getOrDefault)
- map.merge(key, 1, (integer2, integer1) -> integer + 1) 보다는
- map.put(key, map.getOrDefault(key, 0) + 1); 가 깔끔한거 같다.
    - 부과적으로 putIfAbsent 등이랑 적용해보는것도 괜찮을 듯

## (20.03.30) 참조타입 배열 clone()시 주의할점
- 그냥 쓰지말자..
- 참조는 바뀌지만 요소들은 같은 참조를 사용해서 넘겨준다. 그래서 복사된 배열에서 요소를 바뀌면 원본의 요소 값도 바뀐다.
- 예제코드 package practice.clone;

## (20.03.30) BigInteger 는 불변 클래스로써 연산시 계속 새로운 인스턴스를 만들어 낸다.
- 연산 메서드마다 자신이 변하는게 아니라, 새로운(new) BigInteger 인스턴스를 만들어낸다.
- 이러한 이유를 음수양수만 바뀌는 negate() 함수는 원본 함수와 '숫자값' int배열은 같은 참조를 사용해도 전혀 문제가 없다!
    - BigInteger는 부호를 나타내는 필드와 절대값을 나타내는 숫자배열 필드로 나누어져 있다.

## (20.03.26) hashCode()
- 해시코드를 재정의 하지 않으면 논리적으로 완전히 같은 객체라도 서로 다른 무작위 해시코드를 뱉어낸다. (재정의하지 않더라도 같은 해시코드 정도는 뱉어낼 것이라고 오해하고 있었다.)
- 예제코드 package practice.hashcode;

## (20.03.21) Stream Parallel()
- stream 만 사용하면 병렬처리가 자동으로 되는줄 알았는데 아니었다. parallel()을 사용해야 병렬처리가 된가.
- 사용하지 않으면 순차처리가 된다.
- 예제코드 practice.stream.parallel

## (20.03.13) Optional 바르게 쓰기
- Java Optional 바르게쓰기 (http://homoefficio.github.io/2019/10/03/Java-Optional-%EB%B0%94%EB%A5%B4%EA%B2%8C-%EC%93%B0%EA%B8%B0/)
- 명심해야할점은 **"Optional" 객체는 비싼 객체다. Optional을 쓰기앞서 분명한 이점을 가지고 있는가?** 를 생각해보자.

## (20.01.27) Arrays.asList에 대한 고찰
- Arrays.asList를 사용하여 iterator remove()를 실행시키면 익셉션이 난다.
- 분명 Arrays.asList()에서 반환은 new ArrayList()인데, 왜 ArrayList의 인스턴스가 아닐까?
-> 이름이 같아서 혼동된 건데, Arrays.asList()는 java.util.Arrays$ArrayList 컬렉션의 리스트는 java.util.ArrayList다!

## (20.01.26) 리스트(컬렉션)를 순환하면서 요소를 안전하게 삭제하는 방법
- 리스트(컬렉션)를 순회하면서 요소를 삭제하게되면 인덱스가 뒤틀리게 되어 문제가 발생한다. (그래서 PAT할때 인덱스를 거꾸로 삭제하는 편법을 쓴곤 했었다.)
이런 문제로 안전하게 삭제하기 위해서 iterator의 remove()를 사용하거나 Collection.removeIf() 메소드를 사용한다. 

### 1. iterator의 remove()
- iterator에서 최근에 next로 꺼낸 요소를 실제 리스트에서 삭제한다.
```
final Iterator<Integer> iterator = list.iterator();

while (iterator.hasNext()) {
    final Integer next = iterator.next();
    if (next % 2 == 0) {
    iterator.remove();
    }
}
```

### 2. Collection.removeIf()
- 이터레이터 생성없이 한줄로 끝! 내부적으로 같은 로직을 사용하고 삭제되었다면 불린값으로 true를 리턴한다.
```
list.removeIf(next -> next % 2 == 0);
```

## (19.12.28) Map.putIfAbsent()

### vs Map.computeIfAbsent()
- computeIfAbsent와 putIfAbsent는 유사한 기능을 하지만 차이점이 존재한다.

1. computeIfAbsent는 function을 갖지만, putIfAbsent는 값(value)를 갖는다. (putIfAbsent의 메소드를 할당하면 일단 메소드는 실행된다. 실행 이후에 put할지 말지를 결정한다.)
2. computeIfAbsent는 실행되는 동시에 반환값도 실행된 값을 반환하지만, putIfAbsent는 반환값이 null을 리턴한다.

- 연습예제 : MapComputeIfAbsentTest.class
- 그럼 putIfAbsent에 장점이 뭐야..?
    - A) 메소드를 할당 할 수 있다

### vs Map.getOrDefault()
- If your goal is only to retrieve the value, then use getOrDefault. Else, if you want to set the value when it does not exist, use putIfAbsent.
- 기본값만 반환받고자 한다면 getOrDefault()를 사용하고, 값을 설정하고 싶다면 putIfAbsent()를 사용하자.
    - (20.03.31)에 활용 예제 추가

- 참고 : https://stackoverflow.com/questions/48183999/what-is-the-difference-between-putifabsent-and-computeifabsent-in-java-8-map

## (19.12.17) Map.computeIfAbsent()
- Map.containsKey() + Map.get()이라고 생각하면 된다.
- 만약에 해당 키값이 존재한다면, 해당 밸류를 바로 가져온다. 하지만 존재하지 않는다면 두번쨰 인자로 들어간 람다식을 실행하고 그 값을 반환한다.

### 방법1. containsKey()를 사용한 ~~찐따같은~~ 방법
```
if(map.containsKey("siyoon")) {
    return map.get("siyoon");
} else {
    int length = s.length();
    map.put("siyoon", length);
    return map.get("siyoon");
}
```

### 방법2. computeIfAbsent()를 사용한 우아한 방법
```
return map.computeIfAbsent("siyoon", s -> s.length()); //키값의 길이를 밸류로 저장하는 함수식 바로 할당
```
- 위 아래의 코드는 같은 일을 한다.

- **Map을 다룰 때 containsKey() 사용한다면 다른방법이 없는지 생각해보자**



## (19.12.16) Map.merge
- 맵에서 해당 키값이 존재하지 않는 경우와, 이미 존재하는 경우를 한줄로 처리하는 메소드
```
public V merge(K key,
               V value,
               BiFunction<? super V,? super V,? extends V> remappingFunction) /* 기존 V,, 새로운 V, 반환 V */
```
- https://docs.oracle.com/javase/8/docs/api/
- 연습예제 : MapMerge.class

## (19.12.13) EnumSet(EnumMap)의 순서는 입력순서인가, Enum에 명시된 순서인가
- EnumSet(EnumMap)의 순서는 **Enum**에 명시된 순서다.
- 즉, 요일 Enum에 월화수목금토일 순서대로 Enum에 명시되어 있다면 어떤 순서로 입력되었던간에 월화수목금토일 순서로 나온다
- 연습예제 : EnumSetSequenceTest.class

## (19.12.06) 멘탈 모델
> "그동안 UX 실무자들에게 있어서 멘탈모델 이라는 말은, 기존의 UI는 사용자의 멘탈모델과 맞지 않는다는 식으로, **사용자가 생각하고 있는 무언가를 적당히 에둘러 말하기 좋은 용어**였다고 생각한다."
- "멘탈모델을 만든다는 것은, 사람들이 하는 행동에 대해 그들과 이야기하고, 패턴을 찾고, 그 패턴을 모두 포괄하는 하나의 모델로 정리하는 일이다."
- 멘탈모델을 사용하는 이유
  - 디자인의 자신감: 서비스와 기능을 설계하는 지침이 됩니다.
  - 방향의 명확성: 사용자와 사업 측면에서 올바른 의사결정을 내릴 수 있게 합니다.
  - 전략의 영속성: 비전과 사업 기회가 오래 지속되도록 해줍니다
  
- 결론적으로 도메인 주도 설계와도 비슷한 맥락을 가지고 있는 것이구나. 책 '도메인 주도 설계란 무엇인가?' 앞부분에서 말하는 것은 멘탈모델에 기반한 설계를 설명했던 것같다. 반면에 같은 도메인 주도 설계 책이라도 'DDD Start!'는 방법론에 초점을 맞춘 책이였다.

## (19.12.01) 모델, 모델링
- 모델이란 '대상을 단순화 해서 표현한 것'
- 모델은 복잡성의 바다에서 길을 잃지 않고 중요한 문제에 집중할 수 있도록 필요한 지식만 재구상 한 것이다.
- 모델은 복잡성을 관리하기 위해 사용하는 기본적인 도구다.
- 참고자료 (객체지향의 사실과 오해 6장 185쪽)

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
