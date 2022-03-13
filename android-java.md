## Android With Java:
This is a personalized overview of the core android development concepts and terms with some practical walk through.

### Adding Click Listener:
> Button extends TextView and TextView extends View, so in root button is a View

```java
// add click listener adding a onClick function from the activity.xml to activity.java
// Or set click listener programatically by passing View.OnClickListener interface
Button btnClickMe = findViewById(R.id.btnClickMe);
btnClickMe.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        System.out.println("Hello Console");
        Toast.makeText(MainActivity.this, "Hello Toast", Toast.LENGTH_SHORT).show();
    }
});

// Or by implementing View.OnClickListener interface to the activity and overriding the method and setting the click listener on that method by

btnClickMe.setOnClickListener(this);

// and

@Override
public void onClick(View view) {
    switch (view.getId()){
        case R.id.btnClickMe:
            System.out.println("Priting from interface override");
            break;
        default:
            System.out.println("Printing from default case");
            break;
    }
}
```
> Every UI Element is a view (extending from View) like TextView, EditText ect.

> Different Listeners: type element.setListener and wait/look for IDE suggessions. Like setLongClickListener and ..dragListener etc.

