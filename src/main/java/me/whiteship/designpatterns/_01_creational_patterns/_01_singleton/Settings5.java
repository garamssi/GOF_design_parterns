package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * Enum을 사용해서 싱글톤 만들기
 *
 * 리플렉션, 역직렬화( 파일로 불러올 때 캐스팅 )에 안전하다
 * 단점은  - 미리 만들어 두고 사용하기 때문에 비용이 낭비될 수 있다.
 *       - 상속을 사용하지 못한다. ( enum은 컴파일할 때 enum만 상속이 가능하다 )
 */
public enum Settings5 {

    INSTANCE;

}
