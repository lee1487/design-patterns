## GOF 패턴 

## 객체 생성 관련 디자인 패턴 

### 싱글톤 패턴 
```
1. 싱글톤 패턴 
  - 인스턴스를 오직 한개만 제공하는 클래스 
    - 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 
      경우가 있다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다.

싱글톤 구현1
1. 생성자를 private으로 만드는 이유? 
  - 외부에서 해당 인스턴스에 직접적인 접근을 막기 위해서이다.
2. getInstance() 메소드를 static으로 선언한 이유? 
  - static이 메모리에 미리 객체를 생성해 주기 때문에 별도로 외부에서 
    객체 생성을 할 필요가 없기 때문. 즉 외부에서 객체 생성을 막기 위해서이다.
3. getInstance()가 멀티쓰레드 환경에서 안전하지 않은 이유?
  - 동시에 두개의 쓰레드가 해당 메소드를 호출하게될 경우 하나의 쓰레드가 if문 
    안의 로직을 수행하며 새로운 객체를 생성하기 전에 다른 쓰레드가 if문을 
	통과해서 다시 객체를 생성할 수 있기 때문에 SingleTon이 깨지게 된다. 

싱글톤 구현2 
1. 자바의 동기화 블럭 처리 방법은?
  - Method에 synchronized 키워드를 사용해서 한번에 하나의 
    쓰레드만 접근하게 한다. 
2. getInstance() 메소드 동기화시 사용하는 락(lock)은 인스턴스의 락인가 클래스의 락인가? 그 이유는?
  - static 메서드에 동기화 블럭을 설정하면 클래스 단위로 락이 걸린다.
https://codingdog.tistory.com/entry/java-synchronized-%EB%9D%BD%EC%9D%B4-%EC%96%B4%EB%8A%90-%EB%8B%A8%EC%9C%84%EB%A1%9C-%EA%B1%B8%EB%A6%AC%EB%8A%94%EA%B0%80

싱글톤 구현3
1. 이른 초기화가 단점이 될 수도 있는 이유?
  - 클래스가 메모리에 할당되는 시점에 생성되므로 생성되는데 리소스가 많이 필요하거나 
    사용되지 않으면 불필요한 리소스 소모가 발생하기 때문이다. 
2. 만약에 생성자에서 checked 예외를 던진다면 이 코드를 어떻게 변경해야 될까요? 
  - 기본적으로 함수에서 checked exception을 던지면 함수를 호출하는 쪽에서 try-catch문으로 감싸야 한다.  
    하지만 예제처럼 변수를 초기화하는 과정에서는 try-catch문을 사용할 수 없다.  
	그럴경우 static {} 블록을 이용해서 instance를 초기화하면 되는데 이경우 final 키워드를 사용할 수 없다.
	
싱글톤 구현4
1. double check locking이라고 부르는 이유?
  - kecking을 두번 했기 때문.  두개의 쓰레드가 동시에 if문을 통과했다 하더라도 synchronized때문에 
    하나의 쓰레드만 안으로 들어갈 수 있다.  그리고 인스턴스를 생성하고 빠져나가는데 이때 다른 if문을 통과한 쓰레드가 
	synchronized로 들어오더라도 인스턴스가 이미 생성되있기 때문에 if문에서 튕겨나간다.
2. instacne 변수는 어떻게 정의해야 하는가? 그 이유는?
  - volatile 키워드를 사용해야 한다.
    인스턴스를 메인 메모리에 저장하고 읽기 때문에 값 불일치 문제를 해결할 수 있다.

싱글톤 구현5
1. 이 방법은 static final를 썼는데도 왜 지연 초기화(lazy initialization)라고 볼 수 있는가?
  - INSTANCE가 static final로 선언되어 있지만 
    해당 변수가 선언된 Setting5Holder 클래스는 getInstance() 함수가 호출될 때 로딩되기 때문에 지연 초기화로 볼 수 있다.
	

싱글톤 패턴 구현 깨트리는 방법1
1. 리플렉션에 대해서 설명하세요. 
  - 구체적인 클래스 타입을 알지 못해도, 그 클래스의 메서드, 타입, 변수들에 접근 할 수 있도록 해주는 자바 API 
2. setAccessible(true)를 사용하는 이유는? 
  - 기본 생성자는 이 예제에서 private로 선언되어 있다.  즉 외부에서는 호출할 수 없다는 것인데, 
    setAccessible(true)를 통해 Constructor<Settings5>타입으로 받은 constructor, 
	기본생성자를 사용가능하게해 newInstance()를 사용해 새로운 객체를 만들 수 있게하기 때문이다

싱글톤 패턴 구현 깨트리는 방법2
1. 자바의 직렬화 & 역직렬화에 대해 설명하세요.
  - 직렬화는 자바 시스템 내부에서 사용되는 Object 또는 Data를 외부의 자바 시스템에서도 사용할 수 있도록
    byte 형태로 데이터를 변환하는 기술이며 역직렬화는 byte로 변환된 Data를 원래대로 Object나 Data로 변환하는 기술이다
2. Serializable Id란 무엇이며 왜 쓰는가?
  - Serializable를 상속받는 경우 클래스의 버전관리를 위해 serialVersionUID를 사용한다.  
    이 serialVersionUID변수를 명시적으로 선언해 주지 않으면 컴파일러가 계산한 값을 부여하는데 
	Serializable Class 또는 Outer Class에 변경이 있으면 serialVersionUID값이 바뀌게 된다.  
	만약 Serialize할 때와 Deserialize할 때의 serialVersionUID 값이 다르면 
	InvalidClassExcepions가 발생하여 저장된 값을 객체로 Restore 할 수 없다
3. try-resource 블럭에 대해 설명하세요.
  - try-resource 블럭은 기존의 try-catch-final 블럭에서 사용하고 꼭 종료해줘야 하는 
    resource를 사용할 때 final 블럭에서 resource를 해제하는데, 
	try-resource 블럭을 사용하면 따로 명시적으로 resource를 해제해주지 않아도 자동으로 해제해 준다

싱글톤 (Singleton) 패턴 구현 방법 6
1. enum 타입의 인스턴스를 리플랙션을 만들 수 있는가?
  - enum 타입은 리플랙션을 할 수 없도록 막혀있어서 리플랙션에 안전하다.
2. enum으로 싱글톤 타입을 구현할 때의 단점은?
  - 인스턴스를 미리 생성해야하며 상속이 불가하다. 클래스가 메모리에 할당되는 시점에 인스턴스가 미리 만들어진다. 
    초기화 시점이 문제가 되지 않다면 가장 안전한 방법이다.
3. 직렬화 & 역직렬화 시에 별도로 구현해야 하는 메소드가 있는가?
  - enum 타입은 enum 클래스를 상속받게 되는데, enum 클래스는 Serializable을 
    이미 구현하고 있기 때문에 추가적인 구현이 필요 없다.
```

### 팩토리 메소드(Factory method) 패턴
```
팩토리 메소드 패턴 
  - 구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다 
    - 다양한 구현체(Product)가 있고, 그중에서 특정한 구현체를 만들 수 있는 다양한 
	  팩토리(Creator)를 제공할 수 있다. 

팩토리 메소드 패턴 복습 
  - 팩토리 메소드 패턴을 적용했을 때의 장점은? 단점은? 
    - 팩토리 메서드 패턴의 장점으로는 지금까지 살펴봤던 모든 것으로, 기존 코드를 수정하지 않고 
	  새로운 인스턴스를 여러 방법으로 생성할 수 있는 "확장에 열려있고 변경에 닫혀있는 객체 지향 원칙"을 
	  만족하는 객체 생성 방법이다. 이러한 원칙을 만족하는 이유는 제품과 제품을 생성하는 팩토리가 
	  느슨한 결합구조를 가지기 때문이다. 그리고 이 모든 것을 가능케하는 핵심 개념은 추상화다.
	  반면 단점으로는 제품이 추가됨에 따라 제품을 생상하는 팩토리도 추가되므로 관리할 클래스가 선형적으로 증가한다
  - "확장에 열려있고 변경에 닫혀있는 객체 지향 원칙"을 설명하세요.
	- 개방 폐쇄 원칙은 기존 코드를 변경하지 않으면서(Close) 기능을 추가(Open)할 수 있도록 설계가 되어야 한다는 원칙입니다.
  - 자바 8에 추가된 default 메소드에 대해 설명하세요.
    - 디폴트 메서드를 이용하면 인터페이스의 기본 구현을 그대로 상속하므로 인터페이스에 자유롭게 새로운 메서드를 추가할 수 있게된다. 

실무에서는 어떻게 쓰이나? 
  - 단순한 팩토리 패턴 
    - 매개변수의 값에 따라 또는 메소드에 따라 각기 다른 인스턴스를 리턴하는 단순한 버전의 팩토리 패턴 
	- java.lang.Calendar 또는 java.lang.NumberFormat 
  - 스프링 BeanFactory 
    - Object 타입의 Product를 만드는 BeanFactory라는 Creator
```

### 추상 팩토리 패턴 
```
추상 팩토리 패턴 
  - 서로 관련있는 여러 객체를 만들어주는 인터페이스 
    - 구체적으로 어떤 클래스의 인스턴스를(concrete product)를 사용하는지 감출 수 있다.

추상 팩토리 패턴 구현 방법 
  - 클라이언트 코드에서 구체적인 클래스의 의존성을 제거한다. 

추상 팩토리 패턴 복습 
  - 팩토리 메소드 패턴과 굉장히 흡사한데 무엇이 다른건가. 
    - 모양과 효과는 비슷하지만...
	  - 둘다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공한다. 
	- 관점이 다르다 
	  - 팩토리 메소드 패턴은 "팩토리를 구현하는 방법(inheritance)"에 초점을 둔다. 
	  - 추상 팩토리 패턴은 "팩토리를 사용하는 방법(composition)"에 초점을 둔다.
	- 목적이 조금 다르다. 
	  - 팩토리 메소드 패턴은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적 
	  - 추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 
	    만들 수 있게 해주는 것이 목적.
```

### 빌더 패턴 
```
빌더(Builder) 패턴 
  - 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법 
    - (복잡한) 객체를 만든는 프로세스를 독립적으로 분리할 수 있다. 

빌더 패턴 구현 복습 
  - 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법 
    - 장점 
	  - 만들기 복잡한 객체를 순차적으로 만들 수 있다. 
	  - 복잡한 객체를 만드는 구체적인 과정을 숨길 수 있다. 
	  - 동일한 프로세스를 각기 다르게 구성된 객체를 만들 수도 있다. 
	  - 불완전한 객체를 사용하지 못하도록 방지할 수 있다. 
	- 단점 
	  - 원하는 객체를 만드려면 빌더부터 만들어야 한다. 
	  - 구조가 복잡해 진다.(트레이드 오프)
```

### 프로토타입 패턴 
```
프로토타입(Prototype) 패턴 
  - 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법 
    - 복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다.

프로토타입 패턴 구현 복습 
  - 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법 
    - 장점 
	  - 복잡한 객체를 만드는 과정을 숨길 수 있다. 
	  - 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용(시간 또는 메모리)적인 
	    면에서 효율적일 수도 있다. 
	  - 추상적인 타입을 리턴할 수 있다. 
	- 단점 
	  - 복제한 객체를 만드는 과정 자체가 복잡할 수 있다.(특히, 순환 참조가 있는 경우)
```

## 구조 관련 디자인 패턴 

### 어댑터 패턴 
```
어댑터(Adapter) 패턴 
  - 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴 
    - 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다. 
	
  - 장점 
    - 기존 코드를 변경하지 않고 원하는 인터페이스 구현체를 만들어 재사용할 수 있다. 
	- 기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 
	  분리하여 관리할 수 있다. 

  - 단점 
    - 새 클래스가 생겨  복잡도가 증가할 수 있다. 경우에 따라서는 기존 코드가 해당 
	  인터페이스를 구현하도록 수정하는 것이 좋은 선택이 될 수도 있다. 
```

### 브릿지 패턴
```
브릿지(Bridge) 패턴
  - 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴 
    - 하나의 계층 구조일 때 보다 각기 나누었을 때 독립적인 계층 구조로 발전 시킬 수 있다. 

  - 장점 
    - 추상적인 코드를 구체적인 코드 변경 없이도 독립적으로 확장할 수 있다. 
	- 추상적인 코드와 구체적인 코드를 분리할 수 있다. 
  - 단점 
    - 계층 구조가 늘어나 복잡도가 증가할 수 있다.
```

### 컴포짓 패턴 
```
컴포짓(Composite) 패턴 
  - 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴 
    - 클라이언트 입장에서는 '전체'나 '부분'이나 모두 동일한 컴포넌트로 인식할 수 있는 
	  계층 구조를 만든다.(Part-Whole Hierarchy)

  - 장점 
    - 복잡한 트리 구조를 편리하게 사용할 수 있다. 
	- 다형성과 재귀를 활용할 수 있다. 
	- 클라이언트 코드를 변경하지 않고 새로운 엘리먼트 타입을 추가할 수 있다. 
  - 단점 
    - 트리를 만들어야 하기 때문에(공통된 인터페이스를 정의해야 하기 때문에) 지나치게 
	  일반화 해야 하는 경우도 생길 수 있다. 
```

### 데코레이터 패턴 
```
데코레이더(Decorator) 패턴 
  - 기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴 
    - 상속이 아닌 위임을 사용해서 보다 유연하게(런타임에) 부가 기능을 추가하는 것도 가능하다. 

  - 장점 
    - 새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다. 
	- 컴파일 타임이 아닌 런타임에 동적으로 기능을 변경할 수 있다. 
  - 단점 
    - 데코레이터를 조합하는 코드가 복잡할 수 있다. 
```

### 퍼사드 패턴 
```
퍼사드(Facade) 패턴 
  - 복잡한 서브 시스템 의존성을 최소화하는 방법. 
    - 클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화 할 수 있다. 

  - 장점
    - 서브 시스템에 대한 의존성을 한곳으로 모을 수 있다. 
  - 단점 
    - 퍼사드 클래스가 서브 시스템에 대한 모든 의존성을 가지게 된다.
```

### 플라이웨이트 패턴 
```
플라이웨이트(Flyweight) 패턴 
  - 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴 
    - 자주 변하는 속성(또는 외적인 속성, extrinsit)과 변하지 않는 
	  속성(또는 내적인 속성, intrinsit)을 분리하고 재사용하여 메모리 사용을 줄일 수 있다. 

  - 장점 
    - 애플리케이션에서 사용하는 메모리를 줄일 수 있다. 
  - 단점 
    - 코드의 복잡도가 증가한다.
```

### 프록시 패턴 
```
프록시(Proxy) 패턴 
  - 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴 
    - 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용해 사용 할 수 있다. 

  - 장점 
    - 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다. 
	- 기존 코드가 해야 하는 일만 유지할 수 있다. 
	- 기능 추가 및 초기화 지연 등으로 다양하게 활용할 수 있다. 
  - 단점 
    - 코드의 복잡도가 증가한다.
```

### 책임 연쇄 패턴 
```
책임 연쇄 패턴(Chain-of-Responsibility) 패턴 
  - 요청을 보내는 쪽(sender)과 요청을 처리하는 쪽(receiver)을 분리하는 패턴 
    - 핸들러 체인을 사용해서 요청을 처리한다. 

  - 장점 
    - 클라이언트 코드를 변경하지 않고 새로운 핸들러를 체인에 추가할 수 있다. 
	- 각각의 체인은 자신이 해야하는 일만 한다. 
	- 체인을 다양한 방법으로 구성할 수 있다. 

  - 단점 
    - 디버깅이 조금 어렵다. 
```

### 커맨드 패턴 
```
커맨드(Command) 패턴 
  - 요청을 캡슐화 하여 호출자(invoker)와 수신자(receiver)를 분리하는 패턴 
    - 요청을 처리하는 방법이 바뀌더라도, 호출자의 코드는 변경되지 않는다.
  
  - 장점 
    - 기존 코드를 변경하지 않고 새로운 커맨드를 만들 수 있다. 
    - 수신자의 코드가 변경되어도 호출자의 코드는 변경되지 않는다.	
	- 커맨드 객체를 로깅, DB에 저장, 네트워크로 전송 하는 등 다양한 방법으로 
	  활용할 수도 있다. 

  - 단점 
    - 코드가 복잡하고 클래스가 많아진다.
```

### 인터프리터 패턴 
```
인터프리터(Interpreter) 패턴
  - 자주 등장하는 문제를 간단한 언어로 정의하고 재사용하는 패턴 
    - 반복되는 문제 패턴을 언어 또는 문법으로 정의하고 확장할 수 있다. 

  - 장점 
    - 자주 등장하는 문제 패턴을 언어와 문법으로 정의할 수 있다. 
	- 기존 코드를 변경하지 않고 새로운 Expression을 추가할 수 있다. 

  - 단점 
    - 복잡한 문법을 표현하려면 Expression과 Parser가 복잡해진다.
```

### 이터레이터 패턴 
```
이터레이터(Iterator) 패턴
  - 집합 객체 내부 구조를 노출시키지 않고 순회 하는 방법을 제공하는 패턴 
    - 집합 객체를 순회하는 클라이언트 코드를 변경하지 않고 다양한 순회 방법을 
	  제공할 수 있다. 
	
  - 장점 
    - 집합 객체가 가지고 있는 객체들에 손쉽게 접근할 수 있다. 
	- 일관된 인터페이스를 사용해 여러 형태의 집합 구조를 순회할 수 있다. 
	
  - 단점 
    - 클래스가 늘어나고 복잡도가 증가한다. 
```

### 중재자 패턴 
```
중재자(Mediator) 패턴 
  - 여러 객체들이 소통하는 방법을 캡슐화하는 패턴 
    - 여러 컴포넌트간의 결합도를 중재자를 통해 낮출 수 있다. 
	
  - 장점 
    - 컴포넌트 코드를 변경하지 않고 새로운 중재자를 만들어 사용할 수 있다. 
	- 각각의 컴포넌트 코드를 보다 간결하게 유지할 수 있다. 

  - 단점 
    - 중재자 역할을 하는 클래스의 복잡도와 결합도가 증가한다.
```

### 메멘토 패턴 
```
메멘토(Memento) 패턴
  - 캡슐화를 유지하면서 객체 내부 상태를 외부에 저장하는 방법 
    - 객체 상태를 외부에 저장했다가 해당 상태로 다시 복구할 수 있다. 
	
  - 장점 
    - 캡슐화를 지키면서 상태 객체 상태 스냅샷을 만들 수 있다. 
	- 객체 상태를 저장하고 또는 복원하는 역할을 CareTaker에게 위임할 수 있다.
	- 객체 상태가 바뀌어도 클라이언트 코드는 변경되지 않는다. 

  - 단점 
    - 많은 정보를 저장하는 Mementor를 자주 생성하는 경우 메모리 사용량에 
	  많은 영향을 줄 수 있다. 
```

### 옵저버 패턴 
```
옵저버(Observer) 패턴 
  - 다수의 객체가 특정 객체 상태 변화를 감지하고 알림을 받는 패턴 
    - 발행(publish)-구독(subscribe) 패턴을 구현할 수 있다. 

  - 장점 
    - 상태를 변경하는 객채(publisher)와 변경을 감지하는 객체(subscriber)의 관계를 
	  느슨하게 유지할 수 있다. 
	- Subject의 상태 변경을 주기적으로 조회하지 않고 자동으로 감지 할 수 있다. 
	- 런타임에 옵저버를 추가하거나 제거할 수 있다. 
  
  - 단점 
    - 복잡도가 증가한다. 
	- 다수의 Observer 객체를 등록 이후 해지하지 않으면 memory leak이 발생할 수도 있다. 
```

### 상태 패턴 
```
상태(State) 패턴 
  - 객체 내부 상태 변경에 따라 객체의 행동이 달라지는 패턴 
    - 상태에 특화된 행동들을 분리해 낼 수 있으며, 새로운 행동을 추가하더라도 
	  다른 행동에 영향을 주지 않는다. 

  - 장점 
    - 상태에 따른 동작을 개별 클래스로 옮겨서 관리할 수 있다. 
	- 기존의 특정 상태에 따른 동작을 변경하지 않고 새로운 상태에 따른 동작을 추가할 수 있다. 
	- 코드 복잡도를 줄일 수 있다.

  - 단점 
    - 복잡도가 증가한다.
```

### 전략 패턴 
```
전략(Strategy) 패턴 
  - 여러 알고리즘을 캡슐화 하고 상호 교환을 가능하게 만드는 패턴 
    - 컨텍스트에서 사용할 알고리즘을 클라이언트가 선택한다.

  - 장점 
    - 새로운 전략을 추가하더라도 기존 코드를 변경하지 않는다. 
	- 상속 대신 위임을 사용할 수 있다. 
	- 런타임에 전략을 변경할 수 있다. 

  - 단점 
    - 복잡도가 증가한다. 
	- 클라이언트 코드가 구체적인 전략을 알아야 한다.
```

### 템플릿 메소드 패턴 
```
템플릿 메소드(Template method) 패턴 
  - 알고리즘 구조를 서브 클래스가 확장할 수 있도록 템플릿으로 제공하는 방법 
    - 추상 클래스는 템플릿을 제공하고 하위 클래스는 구체적인 알고리즘을 제공한다. 

템플릿 콜백(Template-Callback) 패턴 
  - 콜백으로 상속 대신 위임을 사용하는 템플릿 패턴 
    - 상속 대신 익명 내부 클래스 또는 람다 표현식을 활용할 수 있다.

  - 장점 
    - 템플릿 코드를 재사용하고 중복 코드를 줄일 수 있다. 
	- 템플릿 코드를 변경하지 않고 상속을 받아서 구체적인 알고리즘만 변경할 수 있다. 

  - 단점 
    - 리스코프 치환 원칙을 위반할 수도 있다. 
	- 알고리즘 구조가 복잡할 수록 템플릿을 유지하기 어려워진다.
```

### 방문자 패턴 
```
방문자(Visitor) 패턴 
  - 기존 코드를 변경하지 않고 새로운 기능을 추가하는 방법 
    - 더블 디스패치(Double Dispatch)를 활용할 수 있다.
```
