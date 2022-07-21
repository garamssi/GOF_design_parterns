package me.whiteship.designpatterns._01_creational_patterns._01_singleton;

/**
 * synchronized 사용해서 동기화 처리
 */
public class Settings2 {

    private static Settings2 instance;

    private Settings2() { }


    /**
     * 이른 초기화를 사용할 경우 ( synchronized 제거 )
     * 미리 만들었을 때 길고 오래걸리고 메모리를 많이 사용한다고 가정했을 때
     * 쓰지 않으면 매우 불필요한 자원을 낭비하는 것이다.
     *
     *     private static final Setting INSTANCE = new Setting();
     *
     *     public static Settings1 getInstance() {
     *         return INSTANCE;
     *     }
     * */


    /**
     * synchronized 동기화 처리하는 방법때문에 성능에 문제가 될 수 있다.
     * lock을 가지고 있는 쓰레드만 접근하게하고 다 쓰면 lock 해제하는 매커니즘때문에 비용처리가 생긴다.
     * */
    public static synchronized Settings2 getInstance() {
        if (instance == null) {
            instance = new Settings2();
        }

        return instance;
    }

}
