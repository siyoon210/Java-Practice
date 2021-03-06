# 넥스트스텝 TDD, Clean Code with Java의 리뷰 템플릿과 메시지들
- 메시지를 저장해두는 이유는 다음과 같다. 
    1. 리뷰이들은 비슷한 부분을 실수하는 경우가 많다.
    2. 리뷰이들에게 정확한 메시지를 전달하기 위해서 나도 한번 더 찾아보게 되는데 이를 공부하며 기록해두기 위해서이다.

### 리플렉션을 지양해야 하는 이유
```
리플렉션은 '컴파일 시점'에서 알기 어려운 정보를 다룰때 사용되어야 된다고 생각합니다. 이외에 다른 방법이 있다면 리플렉션보다 우선되어야 한다고 봐요. 🤔
제가 생각하는 리플렉션을 지양해야 하는 이유는 크게 2가지 정도입니다.

1. 리플렉션은 코드를 읽기가 어렵습니다. 가독성이 떨어지면 결국 유지보수성도 떨어지게 되겠죠?
2. 리플렉션은 컴파일 시점에 알 수 없는 에러가 런타임 시점에서 발생되는 위험성이 있습니다.
```

### 적절한 커밋 단위에 대해서
```
제가 생각하는 이상적인 커밋단위는 '가능한' 작게 입니다. 😁
'가능한'에 기준을 어디로 잡는지가 주관적일텐데요. **님이 이번 넥스트스텝 과정을 진행하시면서 커밋단위를 최대한 작게도 해보시고, 너무 작다 싶으면 그보다는 넓은 범위로 지정해서 연습해보시면 **님만의 기준이 생길꺼라고 생각합니다.

작은 커밋단위가 주는 장점은 크게 2가지 정도가 있다고 생각해요.

1. 작업한 로그로써 가치가 있습니다. 예전 코드들을 보면서 왜 이렇게 짰을까? 많이 고민하게 되는데요. 이럴때 당시에 커밋내역들을 보면 작업이 생각이 나기도 하고, 다른 개발자들도 내역만 꼼꼼히 본다면 보다 쉽게 이해할 수 있습니다.
2. 작업을 롤백해야할때 상세히 나눈 커밋로그들은 가장 효율적인 롤백시점을 찾을 수 있다고 생각해요.

커밋단위를 나누기 위해서 해당 커밋의 type을 달주는 것도 좋습니다. (테스트 코드용 커밋인지, 기능을 구현하기 위한 커밋인지, 리팩토링용 커밋인지 한눈에 구분할수가 있어요 👍 )
자세한 사항이 궁금하시면 아래와같은 커밋 가이드를 참고해주세요!
git 커밋 스타일 가이드

제가 이상적으로 생각하는 커밋단위를 실천한다면 TDD 사이클에서 한 사이클동안 3개 이상의 커밋단위가 나오게 됩니다. (이부분은 이해가 안되시면 일단 넘어가세요 ㅎㅎ TDD는 이후에 배우게됩니다.)
```

###  미션 요청사항과 관련은 없지만 언급하고 싶은 부분이 있을때
```
이 부분은 미션 요청사항이 아닌 한번 고민해보셨으면 좋은 부분에 대한 제 개인적 생각입니다. (이미 고려하셨을 수도 있지만 혹시 아니시더라도 편하게 읽어주세요. 😄 )
```

### 요구사항을 만족하지 못했을  
```
다만 기능적 요구사항에 대해서 검토해주셨으면 하는 사항이 있어서 변경요청드렸습니다.
```

### 정규표현식 Pattern 객체를 지양해야하는 이유
```
정규표현식을 사용하면 생성비용이 높은 Pattern 인스턴스 생성됩니다. 정규표현식보다 좀 더 적절한 방법은 없는지 고민해보시면 좋겠습니다.
```
```
Pattern 인스턴스는 생성비용이 높은 객체로 알려져있습니다. 인스턴스 변수나 상수로 만들어서 생성비용을 줄여보세요. 🙂
```

### static의 장점과 단점
```
기능을 static으로 제공하면 어떤 장점과 단점이 있을까요? 🤔
제가 생각하는 장점은 편리함입니다. 별도의 객체선언 없이 사용할수 있으니까요. (부가적으로 무의미한 객체생성을 막고 메모리를 아낄수도 있겠네요)
단점은 너무 강한 결합이라고 생각해요. 객체가 아니게되니 디자인 패턴을 적용하기도 어려워지고 결합도를 낮추는 고민을 해볼수 있는 기회가 없어집니다. 저는 static으로 제공할때는 정말로 이 강한 결합을 허용해도 될까? 고민하는 편입니다. 😁

(+ 부과설명을 드리자면 static 메서드가 non-static 메서드로 변한것만으로는 결합도의 차이를 느끼지 못하셨을 수 있습니다. non-static이 되었다는건 결합도를 낮추는 '초석'을 다진 행위입니다. 전략패턴과 같이 결합도를 낮추는 디자인 패턴을 고민해 볼 수 있는 상태가 되었다는 의미입니다. 😁)
```

### 무의미한 매직넘버 상수화
```
매직넘버를 왜 상수화 하는걸까요? 🤔
저는 의미를 알기 어려운 문자 리터럴를 알기 쉽게하기 위해서 사용하는 편입니다.
이런면에서 볼때 0 ZERO로 상수화 할필요는 없다고 생각해요.. 🙂
```

### 객체에 책임에 대해서
```
makeManualLotto를 View가 담당하는게 적절한걸까요? 🤔

저는 객체의 책임에 대해서 생각해볼때 해당 로직(책임)에 대한 변경 요구사항을 가정해보고, 그 부분이 자연스럽게 떠오르거나 이해가 되는지 고민해봅니다. 😁

수동 로또 구입하는 로직을 수정해주세요. 라는 요구사항을 받았을때 수정하는 개발자가 View에 해당 로직이 있을거라는게 예상되는 곳 일까요? 💭💭
```

```
Car, Racing 객체에서 콘솔 출력을 위한 상태와 메서드를 가지고 있네요.

저는 객체의 책임에 대해서 생각해볼때 해당 로직(책임)에 대한 변경 요구사항을 가정해보고 고민해봅니다. 😁

예를들어 출력시에 '-' 대신에 '='로 바꿔주세요. 라는 요구사항을 받았을때 수정하는 개발자는 출력과 관련한 로직이 View 객체에서 담당하고 있다고 생각하지 않을까요? 💭💭

혹은 콘솔에 출력하지 말고 HTML로 그려서 표현해주세요. 라는 요구사항을 받았을때 Car가 가지고 있는 콘솔 출력과 관련한 정보들은 전혀쓰지 않게 되니 Car의 책임이라고 보기 힘든것 같아요.
```

### 전략패턴 (인터페이스와 다수의 구현체)는 왜 쓰는 걸까
```
하나의 인터페이스와 여러 구현체가 가지는 장점은 무엇일까요? 🤔
저는 다형성을 통한 유연성이라고 생각합니다.

하지만 NumberGenerator를 의존하는 LottoStore는 이런 이점을 누리고 있지 못하고 있다고 생각합니다.
2개의 구현체에 대한 별개의 메서드가 각각 존재하기 때문이죠. NumberGenerator의 구현체가 하나가 더 늘어나면 LottoStore는 또다시 해당 구현체에 대한 대응 코드가 만들어져야합니다. 💭💭
```

### String + 연산
```
문자열을 붙이는 연산에서는 StringBuilder를 사용하길 권해드립니다.
String은 + 연산 이전에 문자열과 연산 이후의 연산 문자열이 각각 별개의 인스턴스로 존재합니다.
따라서 "----" 와 같은 문자열을 만드는 과정에서 ("", "-", "--", "---", "----") 5개의 인스턴스가 생기게 되어서 비효율적인 메모리 사용을 발생시킵니다.

혹시 아래 이슈들을 모르셨다면 한번 찾아보시길 권해드립니다. 😁
Q) StringBuilder, StringBuffer의 차이 (면접 단골질문이더라구요)
Q) 자바 1.5버전 이상부터는 String 연산을 컴파일러가 알아서 최적화하여 굳이 StringBuilder를 안써도 된다고 하던데...? 진짜 그럴까요? 그럼 언제 StringBuilder를 사용해야할까요?
```

### 메서드 이름은 동사
```
메서드 이름은 가능한 동사로 만들어 만들어주세요. 😄 

[자바 코딩 컨벤션](https://myeonguni.tistory.com/1596)
```

### @ParameterizedTest와 @NullAndEmptySource
```
@ParameterizedTest 와 @NullAndEmptySource 를 사용하면 하나의 단언문으로 만들수 있겠네요. 🙂
```

### 의존 방향에 대한 고민, 순환참조
```
저는 '의존'하다는 것은 의존하고 있는 객체가 변화할때 그 변화를 함께 감수하겠다. 라고 정의해요. 🙂
view가 변경될때 그 영향이 domain에 가는것은 불필요한 결합도라고 생각합니다.
```

### 테스트 만을 위해서 접근제어자를 노출하는 경우
```
*** 테스트만을 위해서 public으로 노출되어있네요. 🤔
만약 해당 테스트가 반드시 필요한대 테스트만을 위해서 접근제어자를 풀어야 한다면 어떨까요? 😀
이런 경우라면 객체의 응집도가 낮다는 신호일 수도 있습니다. 테스트해야할 부분을 별도의 객체로 빼내라는 신호일 수도 있다는 말이죠!
```

### 상수만 모아둔 클래스
```
이 클래스에 대해서는 고민이 많이 되네요. 🤔
상수를 모아두는 측면에서는 기능적으로 도움이 되겠지만 클래스란 무엇인가?에 대해서 고민을 해보게 되었어요.
객체지향에서 클래스란 객체를 위한 '틀, 프로토타입, 분류...' 라고 생각했을때 이 클래스는 이런 의도로 씌여지는건 아니니까요.

만약 여러 객체에서 공유해야하는 상수라면 enum을 사용해서 제공하면 될것이고, 공유되지 않는 메세지는 사용되는 객체에서 선언하는것이 더 낫지 않을까 생각했습니다.
정답은 없는 영역 같습니다. 💭
```

### 타입은 인터페이스를 사용하는 것이 좋은 이유
```
타입을 유연하게 가져가는건 어떨까요? 🙂 List의 구현체를 이후에 LinkedList로 바뀌더라도 타입은 같으니 타입의 수정없이 변경할 수 있습니다!
```

### 어떤것을 테스트해야하나
```
domain 객체 혹은 service 레이어에 노출되어 있는 모든 public 메서드에 대해서 테스트 하는 것이 이상적이라고 생각합니다.
하나의 메서드라도 여러가지 시나리오가 발생할 수 있는데요. 예를들어 if문으로 2가지 시나리오가 발생한다던가, 예외가 발생되는 경우의 시나리오도 모두 테스트 할 수 있죠.

이런면에서 볼때 TDD는 적절한 테스트 커버리지를 만들어 낸다고 생각해요. 테스트코드를 먼저 작성하게 되면 해당 객체가 제공해야하는 pulbic한 기능을 미리 알수있습니다. 테스트를 먼저 작성한다라는건 해당 객체를 사용하는 사용자의 입장에서 생각해보게 되니까요.

TDD로 어떤 테스트를 작성해야하는지가 막막하다면 도메인 단위로 요구사항을 쭉 적어보세요. 적은 요구사항에 대해서 테스트코드를 작성해보고 구현해보는 겁니다.

그리고 의존관계의 가장 마지막이되는 객체(그래프 탐색 관점에서 리프가 되는 객체)부터 만드는 것이 좋습니다. 사다리게임에서는 Point객체, 로또에서는 LottoNumber 정도가 적당하겠네요..
요구사항을 적는것 조차 막막하시다면 적절한 리프 객체를 찾지 못하신걸 수 도 있습니다. 예를들어 Point 객체의 테스트 작성하기가 쉽지만, 이를 예측하지 못하고 Ladder부터 만들어야 한다면 어떨까요? 막막하겠죠? 🙂

만약에 public 메서드가 아닌 private 메서드를 테스트 해야한다고 생각한다면 어떻게 해아할까요?
이런 경우는 객체의 응집도가 떨어지는 것은 아닌지 의심해봐야합니다. 해당 기능이 테스트 해야할만큼 크다고 생각한다면 별도의 객체로 분리해야 된다는 말이죠. 🙂
```

### 의존하고 있는 객체를 테스트하고 싶은경우 (유닛테스트를 안한 경우)
```
LadderGame를 생성할 때 Lines가 제대로 생성되었는지 테스트를 할필요 없다고 생각해요.
Lines가 제대로 생성되는지는 Lines 생성테스트에서 하거나, 이것도 힘들다면 Line 테스트에서 하는것이 적절하다고 생각합니다.

이는 테스트 하고자 하는 객체를 '고립'시켜서 테스트하는 유닛테스트의 가치와도 부합하는 방식입니다.
LadderGame의 테스트에서는 LadderGame만을 테스트하고 협력하는 객체인 Lines의 생성은 테스트하지 않습니다. 만약 Lines의 생성과정이 LadderGame 생성과정에 영향을 주고 있다면 테스트 더블을 사용하여서 해당 영향을 제거해야 할 수 도 있습니다.
테스트 더블
```

### Random한 값 테스트
```
CarTest에서 Car가 전진한 경우를 확인하는 테스트는 없네요.

Random하게 값이 설정되어서 이런 부분을 테스트로 단언하기가 힘든대요.
이렇게 예측하기 힘든 부분을 제거하고 제어할 수 있으면 테스트하기 수월해집니다.

지금은 Car에서 사용하는 Random 객체와 강한 결합이 되어 있는데요. 결합도를 낮추는 방법을 사용해보세요.
예를들어서 Random한 '값'을 외부에서 만들어서 넣어줄수도 있구요. 혹은 Random을 생성하는 객체를 외부에서 주입가능하도록 만들어 보세요.

테스트를 위한 Random 생성객체가 항상 9만 생성한다면 전진횟수와 자동차의 position이 같아야겠죠?

이를 구현하기위해서 2가지 키워드를 안내해드리겠습니다. 😄
전략 패턴, 테스트 더블

(이야기 해보고 싶으신 사항이 있으면 댓글 남겨주시거나 DM 주세요!!)
```

### @FunctionalInterface
```
@FunctionalInterface를 사용하면 메서드가 정말로 1개만 있는지 컴파일시에 확인해줍니다. 🙂
```

### 추상클래스 vs 인터페이스
```
추상클래스와 인터페이스 중에 어떤게 더 적합할지에 대해서 고민이신것 같네요.
자바8에서 인터페이스에 디펄트 메서드가 제공되면서 거의 차이점이 없어졌지만 추상클래스는 인터페이스가 제공할수 없는 다양한 접근제어자를 사용할 수 있고, 상속받은 클래스에게 기본적인 기능을 제공할 수 있습니다. 예를들어 템플렛 메서드 패턴과 같은 디자인 패턴은 추상클래스만이 제공할 수 있죠.
인터페이스는 이런 기능을 제공할 수 없지만 다중구현이 가능하여서 여러 타입으로 다형성을 사용할 수 있다는 장점이 있죠. 🙂
```

### 한 줄에 점을 하나만 찍는다.
```
마지막단계는 프로그래밍 요구사항이 정말 깐깐해요.
모든 경우에 지킬순 없겠지만 이번 미션에서 최대한 연습해보는건 어떨까요? 🙂

> 규칙 4: 한 줄에 점을 하나만 찍는다.

객체지향 생활 체조 원칙 규칙4를 지키기 위해서 저는 다음과 같은 방법들을 사용합니다.

1. 지역변수를 선언한다.
2. [디미터 법칙](https://woowacourse.github.io/javable/post/2020-06-02-law-of-demeter/)을 준수하고 기능을 제공한다.
특히 일급컬렉션이나 래퍼클래스인 경우 본래의 value를 노출하지 않고 최대한 기능을 제공하도록 고민해보세요. 예를들어 frames.getFrames()을 제공하지 않고 Frames 일급컬렉션을 그대로 제공하고 사용되는 기능을 만드는건 어떤가요? 🙂
```

### 일급컬렉션 Iterable 예제

```
일급컬렉션을 선언했으니 getter로 value를 노출하지 않고 가능한 일급컬렉션만을 사용해보도록 연습해보실 권합니다. 🙂

DeleteHistoryRepository.saveAll() 메서드에서 인자로 받는건 Iterable 인터페이스를 구현한 객체입니다. DeleteHistories에서 Iterable 인터페이스를 구현해보세요!

public class DeleteHistories implements Iterable<DeleteHistory> {
    private final List<DeleteHistory> value;

    // ...

    @Override
    public Iterator<DeleteHistory> iterator() {
        return value.iterator();
    }
}
```

### actual과 expected가 같은 테스트
```
생성로직 검증에서 actual과 expected가 항상 같은 값이니 항상 통과하는 테스트가 됩니다. 어떤 경우에도 통과하는 테스트가 많아진다면 오히려 테스트에 대한 신뢰성이 떨어지지 않을까요?

이런 경우 2가지 생각을 해볼 수 있겠습니다.

1. 생성후에 상태를 확인할수 없는 경우에 테스트가 꼭 필요할까? (이미 의존하고 있는 LadderLineTest에서 다 진행하지 않았을까?)
2. 생성하는 동안에 어떠한 예외사항도 발생하지 않는 경우를 단언하고 싶다면 아래와 같이 표현할 것 같습니다.

assertThatCode(() -> new Ladder(ladderLines))
                .doesNotThrowAnyException();
```

### 객체지향적인 설계
```
해당 설계가 객체지향적인지 아닌지에 대해서 고민이 있으신것 같네요. 👍
먼저 그에대한 정의가 필요할 것 같습니다. 만약 누군가 객체지향적인 설계가 무엇인가요? 라고 묻는다면 어떻게 대답하실 건가요?
음.. 객체지향이라는 패러다임에 많은 의견이 있겠지만 저는 이렇게 대답할 것 같아요. 🙂
응집도 높은 객체들이 낮은 결합도로 적절하게 협력하는 설계가 객체지향적인 설계라고 생각합니다.

생성에 대한 응집도라는 면에서 생각해 본다면, '수동 로또'와 '자동 로또' 라는 객체를 별개로 만들어서 생성로직에 대한 응집도를 높이고 Lottos에서는 '수동로또'와 '자동로또'를 필드로 갖게 해 협력하게 한다면 제 생각에 대한 베스트 설계라고 느껴지네요.

다만, 지금 고민하시는 생성자냐 메서드냐는 해당 정의로써는 대답하기 어려운 이슈 같습니다. 🙂
```

### getter setter
```
먼저 getter와 setter를 왜 지양해야 하는지에 대해서 생각해보셨으면 좋겠습니다. ㅎㅎ
getter는 캡슐화를 저해시킵니다. 캡슐화가 저해된다면 적절한 협력을 하지 못하게 되고 유지보수성이 떨어지게 돼요

예를들어 User(유저)라는 도메인이 있습니다. 유저는 Job(직업)이라는 상태를 갖고 있고 Job이 null이면 무직자라고 판단하고 있다고 가정할게요.

// 유저가 무직자인지 확인한다.
if(user.getJob() == null) {
        ...    
}
if(user.isUnemployed()) {
   ...
}
외부에서 해당 로직을 구현한 2가지 케이스입니다. 위에는 getter로 구현되어 있고 아래는 getter없이 해당 데이터를 사용하는 쪽에게 적절한 메서드를 제공했습니다. 일단 코드가독성도 아래가 훨씬 좋다고 느껴지시지 않나요?
하지만 더 강력한 건 구체적인 로직이 숨겨졌다는 점입니다!! 적절한 협력!!

만약 앞으로 job은 null이 될수없다 다만 Job이 UNEMPLOYED인 경우를 무직자라고 한다.라는 요구사항이 발생되었는데,
무직자를 확인하는 로직이 1000곳이면 어떻게 될까요? getter로 기능을 제공한 경우는 1000줄을 바꿔야 하지만 아래처럼 기능을 제공한 경우는 단 한줄로 요구사항에 대응 할 수 있습니다. 이게 getter를 지양하고 기능을 제공해야 하는 이유라고 생각해요. 🙂

근데,, 이런 경우가 아니고 정말로 getter가 필요한 경우도 있어요. 해당 정보를 정말로 'get' 해야 하는 경우라면 제공할 수 있다고 생각합니다. 간혹 getter를 객체 정보에 불변성을 위해서 지양해야되는 경우도 있는데요. 이런 경우는 해당 정보를 그대로 노출시키지않고 복사하여 새로 생성한 데이터를 건내주는 방법을 사용합니다.
```

### 중복된 로직을 상속을 통해서 없애야할까?
```
(이 의견은 많은 의견이 있고 저의 주관적 의견이 많이 들어있다는 점을 미리 말씀드리겠습니다.)

중복로직이 생겼으니 이를 상속으로 묶어서 중복처리를 해야할까라는 고민을 하시는것 같은데요. 🙂
저는 중복로직을 없애기 위해서 상속을 절대로 사용하지 않습니다. 상속과 구현은 오로지 '다형성'을 사용하기 위한 도구로 접근합니다.

왜냐하면 상속은 정말로 강한 의존을 야기시키기 때문이에요.
상위 로직을 바꾸게 되면 이를 상속한 자식클래스들에게 모두 영향을 주게되고, 상속은 한번 붙기 시작하면 이를 제거하는것이 정말로 힘들어요.

비슷한 로직이 생긴다면 이는 상속보다는 조립을 통해서 약한 결합을 사용하구요.
부모클래스에 중복로직을 모아둔다면 주목적은 '다형성' 사용이고, 이 목적에 부합하는 로직을 모아두는 편입니다. (무분별하게 중복로직을 올리지 않도록 노력한다는 말이에요. 예를들어 템플릿 메서드 패턴을 구현하고 이를 보조하는 로직정도를 생각하시면 좋을것 같습니다.)
```

### 패키지명
```
패키지명의 카멜케이스는 컨벤션에 어긋나요. bowling_refactor 이나 bowlingrefactor로 써주세요.
```

### 줄바꿈
```
System.lineSeparator()를 사용하면 OS마다 다른 줄바꿈 코드를 반영해줍니다.
```

### instanceOf
```
다형성을 활용하는 코드를 작성할때 instanceof 키워드를 사용하고 싶다면 구린냄새(?)를 경고하는 것 일 수 있습니다! 😄

State 들이 보너스 피치가 가능한지 확인하고 boolean 을 반환하는 메서드를 선언하는건 어떤가요?
```
