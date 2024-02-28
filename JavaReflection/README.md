### Overviews:
Java Reflection allows to inspect/read & modify members of classes, interfaces, fields and methods at `runtime`. Like we can read all the available class/interface members (methods/props) at runtime.   

* Reflection is a language's ability to inspect and dynamically call classes, methods, attributes, etc. at runtime. Its like reflection on the mirror of itself

* Reflection is a key mechanism to allow an application or framework to work with code that might not have even been written yet! Like Spring, which uses reflection to create its beans, and for its heavy use of proxies

https://stackoverflow.com/questions/37628/what-is-reflection-and-why-is-it-useful

* reflective operations have slower performance than their non-reflective counterparts and should be avoided in sections of code which are called frequently in performance-sensitive applications.

### Annotation + Reflection (Spring Framework's Magic):
In Spring `@Controller` annotation on a class makes it possible to take controller specific features form the framework. Behind the scene with the use of reflection, framework will scan classes and whatever class has the @controller annotation will receive controller specific features.

* maybe that's why spring boot is slower compared to Quarkus in most of the benchmark. As Quarkus claims to avoid reflection as much as possible.

https://beknazarsuranchiyev.medium.com/reflection-annotations-the-powerful-combination-fc404142595b