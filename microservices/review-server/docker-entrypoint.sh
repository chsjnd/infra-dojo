#!/bin/bash

export JAVA_OPTS="-Dspring.profiles.active=${PROFILE} \
                  -Dspring.datasource.platform=${PROFILE} \
                  -XX:G1HeapRegionSize=8m \
                  -XX:+ParallelRefProcEnabled \
                  -XX:-ResizePLAB \
                  -XX:+UseThreadPriorities \
                  -XX:-UsePerfData \
                  -XX:+AlwaysPreTouch \
                  -XX:ParallelGCThreads=4 \
                  -XX:MaxGCPauseMillis=500 \
                  -XX:MetaspaceSize=192m"

exec java \
  ${JAVA_OPTS} \
  -jar /m3o1/app.jar
