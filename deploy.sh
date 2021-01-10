#!/bin/bash

REPOSITORY=/home/ec2-user/app/step1
PROJECT_NAME=springboot-start-project

cd $REPOSITORY/$PROJECT_NAME/

echo "> Git Pull"

git pull

echo "> Project Build Start"

./gradlew build

echo "> Move to step1 Directory"

cd $REPOSITORY

echo "> Copy Build files"

cp $REPOSITORY/$PROJECT_NAME/build/libs/*.jar $REPOSITORY/

echo "> Check Current Activated Application PID"

CURRENT_PID=$(pgrep -f ${PROJECT_NAME}.*.jar)

if [ -z "$CURRENT_PID" ]; then
  echo "> Not close any server that there is not Activated Application"
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 $CURRENT_PID
  sleep 5
fi

echo "> Deploy new Application"

JAR_NAME=$(ls -tr $REPOSITORY/ | grep jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,/home/ec2-user/app/application-oauth.properties \
  $REPOSITORY/$JAR_NAME 2>&1 &
