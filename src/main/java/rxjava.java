import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

/**
 * Created by darlingtld on 2015/8/23 0023.
 */
public class rxjava {
    public static void main(String[] args) {
        hello("lingda", "sara");
        Observable<String> myObservable = Observable.create(
                new Observable.OnSubscribe<String>() {
                    @Override
                    public void call(Subscriber<? super String> sub) {
                        sub.onNext("Hello, world!");
                        sub.onCompleted();
                    }
                }
        );

        Subscriber<String> mySubscriber = new Subscriber<String>() {
            @Override
            public void onNext(String s) {
                System.out.println(s);
            }

            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }
        };

        myObservable.subscribe(mySubscriber);

        /////////////////////////////////////////////////

        Observable<String> myObservable1 = Observable.just("Hello, world1!");
        Action1<String> onNextAction = s -> System.out.println(s);
        myObservable1.subscribe(onNextAction);

        Observable.just("Hello, world!").subscribe(s -> System.out.println(s));

//////////////////////////////////////////////////////////

        new rxjava().testRx();
    }

    public void testRx() {

        Observable.OnSubscribe<String> subscribeFunction = (s) -> asyncProcessingOnSubscribe(s);

        Observable createdObservable = Observable.create(subscribeFunction);

        createdObservable.subscribe(
                (incomingValue) -> System.out.println("incoming " + incomingValue),
                (error) -> System.out.println("Something went wrong " + ((Throwable) error).getMessage()),
                () -> System.out.println("This observable is finished")
        );

    }

    private void produceValuesAndAnError(Subscriber s) {
        Subscriber subscriber = s;

        try {
            for (int ii = 0; ii < 50; ii++) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext("Pushed value " + ii);
                }

                if (ii == 5) {
                    throw new Throwable("Something has gone wrong here");
                }
            }

            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        } catch (Throwable throwable) {
            subscriber.onError(throwable);
        }
    }

    private void asyncProcessingOnSubscribe(Subscriber s) {
        final Subscriber subscriber = s;
        Thread thread = new Thread(() -> produceSomeValues(subscriber));
        thread.start();
    }

    private void produceSomeValues(Subscriber subscriber) {
        for (int ii = 0; ii < 10; ii++) {
            if (!subscriber.isUnsubscribed()) {
                subscriber.onNext("Pushing value from async thread " + ii);
            }
        }
    }

    public static void hello(String... names) {
        Observable.from(names).subscribe(s -> {
            System.out.println("Hello " + s + "!");
        });
    }
}
