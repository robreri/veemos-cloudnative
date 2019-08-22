FROM gradle:jdk11 as builder
WORKDIR '/app'
COPY . .
CMD ["gradle", "assemble"]

FROM amazoncorretto:11
WORKDIR '/app'
COPY --from=builder /app/build/libs/veemos-server-grails-0.1.war .
CMD ["java", "-Dgrails.env=test","-jar", "veemos-server-grails-0.1.war"]
