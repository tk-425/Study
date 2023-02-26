# PackageCloud Configuration
Add this to your `setting.xml` in `.m2` directory.

[PackageCloud Maven Wagon Info - beta](https://github.com/computology/maven-packagecloud-wagon)

```xml
<servers>
    <!-- Configuring the HTTP Wagon for Oracle -->
    <server>
        <id>maven.oracle.com</id>
        <username>user@email.com</username>
        <password>encrypt-password</password>
        <configuration>
            <basicAuthScope>
                <host>ANY</host>
                <port>ANY</port>
                <realm>OAM 11g</realm>
            </basicAuthScope>
            <httpConfiguration>
                <all>
                    <params>
                        <property>
                            <name>http.protocol.allow-circular-redirects</name>
                            <value>%b,true</value>
                        </property>
                    </params>
                </all>
            </httpConfiguration>
        </configuration>
    </server>

    <!-- Configuring PackageCloud -->
    <server>
        <id>packagecloud.release</id>
        <password>api-key</password>
    </server>
    <server>
        <id>packagecloud.snapshot</id>
        <password>api-key</password>
    </server>
</servers>
```

Add distribution management in `pom.xml` file.

`pom.xml`
```xml
<build>
    <extensions>
        <extension>
            <groupId>io.packagecloud.maven.wagon</groupId>
            <artifactId>maven-packagecloud-wagon</artifactId>
            <version>0.0.6</version>
        </extension>
    </extensions>
</build>

<distributionManagement>
    <!-- PackageCloud Snapshot Repository -->
    <snapshotRepository>
        <id>packagecloud.snapshot</id>
        <url>packagecloud+https://packagecloud.io/user_id/snapshot</url>
    </snapshotRepository>
    
    <!-- PackageCloud Release Repository -->
    <repository>
        <id>packagecloud.release</id>
        <url>packagecloud+https://packagecloud.io/user_id/release</url>
    </repository>
</distributionManagement>
```

<hr>

# Nexus Configuration
Add this to your `setting.xml` in `.m2` directory.

<i>Make sure to comment out the PackageCloud configuration.</i>

```xml
<servers>
    <!-- Nexus -->
    <server>
        <id>nexus-snapshot</id>
        <username>admin</username>
        <password>your-password</password>
    </server>
    <server>
        <id>nexus-release</id>
        <username>admin</username>
        <password>your-password</password>
    </server>
</servers>
```

Add distribution management in `pom.xml` file.

`pom.xml`
```xml
<distributionManagement>
    <!-- Nexus Snapshot Repository -->
    <snapshotRepository>
        <id>nexus-snapshot</id>
        <url>http://localhost:8081/repository/nexus-snapshot/</url>
    </snapshotRepository>
    
    <!-- Nexus Release Repository -->
    <repository>
        <id>nexus-release</id>
        <url>http://localhost:8081/repository/nexus-release/</url>
        <snapshots>
            <enabled>true</enabled>
        </snapshots>
    </repository>
</distributionManagement>
```