Add this to your `setting.xml` in `.m2` directory.

```xml
<servers>
    <!-- Configuring the HTTP Wagon for Oracle -->
    <server>
        <id>maven.oracle.com</id>
        <username>tk4982@live.com</username>
        <password>{acmCE7fMAboH3bDx/WYcMwf1D6P5e+KseG8e7c9vsR0=}</password>
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
        <password>2ae062fa2fb4b77df8e851048bae355347598a83cb5eedfa</password>
    </server>
    <server>
        <id>packagecloud.snapshot</id>
        <password>2ae062fa2fb4b77df8e851048bae355347598a83cb5eedfa</password>
    </server>
</servers>
```