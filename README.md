# APK Verifier
[![N|Solid](http://blog.ahmetbutun.net/wp-content/uploads/2016/10/netas_logo.png)](http://www.netas.com.tr)

Android Package Verifier for Java Applications

# Example Usage 1
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
...
...
...
...

Path path = Paths.get("path/to/your/apk/file");

ByteBuffer buffer = ByteBuffer.wrap(Files.readAllBytes(path));

buffer.rewind();

DataSource dataSource = new ByteBufferDataSource(buffer);

ApkVerifier apkVerifier = new ApkVerifier();

Result result = apkVerifier.verify(dataSource, 20);

if (result.isVerified()) {
  ....
}
```

# Example Usage 2
```java
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
...
...
...
...

FileInputStream fin = new FileInputStream("path/to/your/apk/file");

FileChannel fc = fin.getChannel();

ByteBuffer buffer = ByteBuffer.allocate((int) fc.size());

fc.read(buffer);
buffer.rewind();

DataSource dataSource = new ByteBufferDataSource(buffer);

ApkVerifier apkVerifier = new ApkVerifier();

Result result = apkVerifier.verify(dataSource, 20);

if (result.isVerified()) {
  ....
}
```
