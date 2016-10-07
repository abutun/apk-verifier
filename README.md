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

fc.close();
fin.close();
```
# Check APK Signature SHA1
```java
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import org.apache.commons.codec.digest.DigestUtils;
...
...
...
...

Result result = apkVerifier.verify(YOUR_DATA_SOURCE, YOUR_MIN_SDK_VERSION);

boolean valid = false;

if (result.isVerified()) {
	String signatureSha1 = "";

	for (X509Certificate certificate : result.getSignerCertificates()) {
		signatureSha1 = DigestUtils.sha1Hex(certificate.getEncoded());

		if (YOUR_APK_SIGNATURE_SHA1.equalsIgnoreCase(signatureSha1)) {
			valid = true;

			break;
		}
}
 
if(valid){
  ....
}
```
