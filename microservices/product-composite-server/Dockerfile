FROM openjdk:11.0-jdk

EXPOSE 8080

RUN echo $PROFILE

ADD ./product-composite-web/build/libs/*.jar /m3o1/app.jar
COPY docker-entrypoint.sh /m3o1/entrypoint.sh

CMD ["/m3o1/entrypoint.sh"]