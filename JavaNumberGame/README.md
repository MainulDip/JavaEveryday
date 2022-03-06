## Java Home Setup in Linux Workspace

```sh
# which java or whereis java
which java
#=>/usr/bin/java
ls -l /usr/bin/java
#=> lrwxrwxrwx 1 root root 22 Feb  3 21:38 /usr/bin/java -> /etc/alternatives/java
ls -l /etc/alternatives/java
#=> lrwxrwxrwx 1 root root 43 Feb  3 21:38 /etc/alternatives/java -> /usr/lib/jvm java-11-openjdk-amd64/bin/java 

# Or use this
readlink -f `which javac` | sed "s:/bin/javac::"
export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64/bin/java
```