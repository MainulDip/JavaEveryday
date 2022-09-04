package JavaLanguageTour.callbacks;

// Java program to illustrate Asynchronous callback

interface CallbackAsyncEventListener {

    // this can be any type of method
    void onGeekEvent();
}

class B2 {

    private CallbackAsyncEventListener mListener; // listener field

    // setting the listener
    public void registerOnGeekEventListener(CallbackAsyncEventListener mListener)
    {
        this.mListener = mListener;
    }

    // My Asynchronous task
    public void doGeekStuff()
    {

        // An Async task always executes in new thread
        new Thread(new Runnable() {
            public void run()
            {

                // perform any operation
                System.out.println("Performing operation in Asynchronous Task");

                // check if listener is registered.
                if (mListener != null) {

                    // invoke the callback method of class A
                    mListener.onGeekEvent();
                }
            }
        }).start();
    }

    // Driver Program
    public static void main(String[] args)
    {

        B2 obj = new B2();
        CallbackAsyncEventListener mListener = new A2();
        obj.registerOnGeekEventListener(mListener);
        obj.doGeekStuff();
    }
}

class A2 implements CallbackAsyncEventListener {

    @Override
    public void onGeekEvent()
    {
        System.out.println("Performing callback after Asynchronous Task");
        // perform some routine operation
    }
    // some class A methods
}

