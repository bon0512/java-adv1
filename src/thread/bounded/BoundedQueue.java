package thread.bounded;

public interface BoundedQueue {
    void put(String data);
    String take();


    /**
     * BoundedQueue : 버퍼 역할을 하는 큐의 인터페이스이다.
     * put(data) : 버퍼에 데이터를 보관한다.(생산자 스레드가 호출하고 데이터를 생산한다.)
     * take() : 버퍼에 보관된 값을 가져가낟. (소바자 스레드가 호출하고, 데이터를 소비한다.)
     */

}
