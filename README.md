# Springboot-start-project

## Spring Boot Study By

[![AWSSpringBoot](https://image.yes24.com/momo/TopCate2763/MidCate003/274966717.jpg)](http://www.kyobobook.co.kr/product/detailViewKor.laf?mallGb=KOR&ejkGb=KOR&barcode=9788965402602&orderClick=LA6)

## Gradle 버전 낮추는 방법

```bash
$ ./gradlew wrapper --gradle-version 4.10.2
```

## AWS 에서 OpenJDK 15 설치하기

1. OpenJDK 15 Download

```bash
$ wget https://download.java.net/java/GA/jdk15.0.1/51f4f36ad4ef43e39d0dfdbaf6549e32/9/GPL/openjdk-15.0.1_linux-x64_bin.tar.gz
```

2. OpenJDK 15 Install

```bash
$ tar xvf openjdk-15.0.1_linux-x64_bin.tar.gz
```

3. Move to `local`

```bash
$ sudo mv jdk-15.0.1/ /usr/local/
$ cd /usr/local/jdk-15.0.1/bin/
$ ./java -version
```

4. Setup profile

```bash
$ sudo vi /etc/profile
```
- add value in `/etc/profile`
```bash
export JAVA_HOME=/usr/local/jdk-15.0.1
export JRE_HOME=/usr/local/jdk-15.0.1/jre
export PATH=$PATH:/usr/local/jdk-15.0.1/bin
```

```bash
$ source /etc/profile
```

- check java version anywhere

```bash
$ java -version
```
