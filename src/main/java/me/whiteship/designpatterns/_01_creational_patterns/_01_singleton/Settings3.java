package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * double checked locking
 * 체크를 두번 했기 때문에 안전
 * 필요에 의해 생성되는 장점 -> 하지만 복잡하다
 */
public class Settings3 {


    /**
     * volatile 자바 1.5 이상의 버전에서 사용되는 키워드
     * volatile 사용하려면 메모리를 다루는 방법을 파악해야 정확하게 사용할 수 있다.
     * */
    private static volatile Settings3 instance;

    private Settings3() { }

    public static Settings3 getInstance() {
        if (instance == null) {
            synchronized (Settings3.class) {
                if (instance == null) {
                    instance = new Settings3();
                }
            }
        }

        return instance;
    }

}
