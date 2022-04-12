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