## GOF디자인 패턴

### 객체 생성 관련 디자인

#### 1. singleton 패턴
- 인스턴스를 오직 한개만 제공하는 클래스
  : 시스템 런타임, 환경 세팅에 대한 정보 등, 인스턴스가 여러개 일 때 문제가 생길 수 있는 경우가 있다. 인스턴스를 오직 한개만 만들어 제공하는 클래스가 필요하다.


---

#### 2. Factory method 패턴
- 구체적으로 어떤 인스턴스를 만들지는 서브 클래스가 정한다
  : 다양한 구현체 (Product)가 있고, 그중에는 특정한 구현체를 만들 수 있는 다양한 팩토리(Creator)를 제공할 수 있다.

- 장점 : 기존 코드를 건드리지 않고 새로운 인스턴스를 다른 방법으로 얼마든지 확장이 가능하다 -> product, creator를 Loose Coupling(느슨한 결합)
- 단점 : 역할을 나누다보니 Class가 늘어난다
```   
확장에 열려있고 변경에 닫혀있는 개체 지향 원칙 : 기존 코드를 변경하지 않고 기능을 확장할 수 있는지, 없는지

default 메소드 : 구현 클래스, 함수를 만들 수 있는 기능, 해당 인터페이스를 상속 받았을 때 해당 기능을 사용할 수 있게 한다.
              ( * 인터페이스에 추가된 private 메소드 )
```


---

#### 3. 추상 팩토리 ( Abstract factory ) 패턴 - client 중심
- Single-responsibility principle 단일 책임의 원칙 ( ShipPartsFactory 부분 )   
  : 모든 클래스는 하나의 책임만 가지며, 클래스는 그 책임을 완전히 캡슐화해야 함

- Open–closed principle 개방-폐쇄 원칙 ( WhiteshipFactory 부분 )   
  : 소프트웨어 개체는 확장에 대해 열려 있어야 하고, 수정에 대해서는 닫혀 있어야 한다

 
```
factory method 와 abstract factory의 차이점

1. 모양과 효과는 비슷하지만,
 : 둘 다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공한다.
 
2. 관점이 다르다
 1) 팩토리 메소드패턴은 "팩토리를 구현하는 방법 (inheritance)"에 초점을 둔다.
 2) 추상 팩토리 패턴은 "팩토리를 사용하는 방법 (composition)"에 초점을 둔다. 

3. 목적이 조금 다르다. 
 1) 팩토리 메소드 패턴은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것인 목적
 2) 추상 팩토리 패턴은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적
```


---

#### 4. Builder 패턴
- 동일한 프로세스를 거쳐 다양한 구성의 인스턴스를 만드는 방법   
  : (복잡한) 객체를 만드는 프로세스를 독립적으로 분리할 수 있다.
- 장점 : 데이터를 각각 검증할 수 있는 로직을 넣을 수 있고 디렉터를 사용한다면 인캡슐레이션까지 보장 받을 수 있다.
- 단점 : 
  1. 인스턴스를 먼저 만들어야 한다
  2. 단점은 구조가 복잡해질 수 있다. 

---

#### 5. ProtoType 패턴
- 기존 인스턴스를 복제하여 새로운 인스턴스를 만드는 방법   
 : 복제 기능을 갖추고 있는 기존 인스턴스를 프로토타입으로 사용해 새 인스턴스를 만들 수 있다    
   * Object가 제공하고 있는 clone 메소드를 사용하면 된다. (shallow copy 참조 값, deep copy 값 )
- 장점
  * 복잡한 객체를 만드는 과정을 숨길 수 있다.
  * 기존 객체를 복제하는 과정이 새 인스턴스를 만드는 것보다 비용(시간 또는 메모리)적인 면에서 효율적일 수 있다.
- 단점
  * 복제한 객체를 만드는 과정 자체가 복잡할 수 있다.(특히, 순환 참조가 있는 경우)

```
clone을 손쉽게 해주는 라이브러리 ( 리플렉션 이용 )
http://modelMapper.org
```
  
  
  
---
### 구조 관련 디자인 패턴

#### 1. Adapter 패턴
- 기존 코드를 클라이언트가 사용하는 인터페이스의 구현체로 바꿔주는 패턴
  * 클라이언트가 사용하는 인터페이스를 따르지 않는 기존 코드를 재사용할 수 있게 해준다.

- 장점
  * 기존 코드를 변경하지 않고 원하는 인터페이스 구현체를  만들어 재사용할 수 있다.
  * 기존 코드가 하던 일과 특정 인터페이스 구현체로 변환하는 작업을 각기 다른 클래스로 분리하여 관리할 수 있다.
- 단점
  * 새 클래스가 생겨 복잡도가 증가할 수 있다. 경우에 따라서는 기존 코드가 해당 인터페이스를 구현하도록 수정하는 것이 좋은 선택이 될 수도 있다.
```
* 자바 
 - java.util.Arrays#asList(T..)
 - java.util.Collections#list, java.util.Collection#enumeration()
 - java.io.InputStreamReader(InputSream)
 - java.io.OutputStreamWriter(OutputStream)
* 스프링
 - HandlerAdpter : 우리가 작성하는 다양한 형태의 핸들러 코드를 스프링 MVC가 실행할 수 있는 형태로 변환해주는 어탭터용 인터페이스.
```


---
   
#### 2. Bridge 패턴
- 추상적인 것과 구체적인 것을 분리하여 연결하는 패턴
  * 하나의 계층 구조일 떄 보다 각기 나누었을 때 독립적인 계층 구조로 발전 시킬 수 있다.
  
- 장점
  * 추상적인 코드를 쿠체적인 코드 변경 없이도 독립적으로 확장할 수 있다.
  * 추상적인 코드와 구체적인 코드를 분리할 수 있다.
- 단점 
  * 계층 구조가 늘어나 복잡도가 증가할 수 있다.


---

#### 3. Composite 패턴
- 트리구조를 구성해야하는 제약
- 그룹 전체와 개별 객체를 동일하게 처리할 수 있는 패턴

  * 클라이언트 입장에서는 "전체"나 "부분"이나 모두 동일한 컴포넌트로 인식할 수 있는 계층 구조를 만든다 (Part-Whole Hierarchy)

- 장점
  * 복잡한 트리 구조를 편리하게 사용할 수 있다.
  * 다형성과 재귀를 활용할 수 있다.
  * 클라이언트 코드를 변경하지 않고 새로운 엘리먼트 타입을 추가할 수 있다.
- 단점
  * 트리를 만들어야 하기 때문에 (공통된 인터페이스를 정의해야 하기때문에) 지나치게 일반화 해야하는 경우도 생길 수 있다.
  

---

#### 4. Decorator 패턴
- 기존 코드를 변경하지 않고 부가 기능을 추가하는 패턴
  * 상속이 아닌 위임을 사용해서 보다 유연하게 (런타임에) 부가 기능을 추가하는 것도 가능하다.

- 장점
  * 새로운 클래스를 만들지 않고 기존 기능을 조합할 수 있다.
  * 컴파일 타임이 아닌 런타임에 동적으로 기능을 변경할 수 있다.
- 단점
  * 데코레이터를 조합하는 코드가 복잡할 수 있다.

  
--- 

#### 5. Facade 패턴
- 복잡한 서브 시스템 의존성을 최소화하는 방법
  * 클라이언트가 사용해야 하는 복잡한 서브 시스템 의존성을 간단한 인터페이스로 추상화 할 수 있다. 

- 장점
  * 서브 시스템에 대한 의존성을 한곳으로 모일 수 있다.
- 단점
  * 퍼사트 클래스가 서브 시스템에 대한 모든 의존성을 가지게 된다.


---

#### 6. Flyweight 패턴
- 객체를 가볍게 만들어 메모리 사용을 줄이는 패턴
  * 자주 변하는 속성(또는 외적인 속성, extrinsit)과 변하지 않는 속성(또는 내적인 속성, intrinsit)을
  분리하고 재사용하여 메모리 사용을 줄일 수 있다.

- 장점
  * 애플리케이션에서 사용하는 메모리를 줄일 수 있다.
- 단점
  * 코드의 복잡도가 증가한다.


---

#### 7. Proxy 패턴
- 특정 객체에 대한 접근을 제어하거나 기능을 추가할 수 있는 패턴.
  * 초기화 지연, 접근 제어, 로깅, 캐싱 등 다양하게 응용해 사용 할 수 있다.

- 장점
  * 기존 코드를 변경하지 않고 새로운 기능을 추가할 수 있다.
  * 기존 코드가 해야 하는 일만 유지할 수 있다.
  * 기능 추가 및 초기화 지연 등으로 다양하게 활용할 수 있다.
  
- 단점
  * 코드의 복잡도가 증가한다.


---
