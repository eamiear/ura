# maven 将项目打包成jar文件时，控制台输出以下错误：
```
No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?
```
当前环境没有可用编译器，可能运行在了JRE环境，应该通过JDK进行执行。

打开系统环境变量界面，在PATH中如果看到例如
```
C:\ProgramData\Oracle\Java\javapath;
```
的配置，将它修改为 `java` 安装路径，如
```
D:\programs\Java\jdk\bin;
```
