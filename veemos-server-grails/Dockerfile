FROM gradle:jdk11 as builder
WORKDIR '/app/veemos-server-grails'
COPY . .
RUN gradle assemble

FROM amazoncorretto:11
WORKDIR '/app'
COPY --from=builder /app/veemos-server-grails/build/libs/veemos-server-grails-0.1.war veemos-server-grails-0.1.war
CMD ["java", "-Dgrails.env=test","-jar", "veemos-server-grails-0.1.war"]
