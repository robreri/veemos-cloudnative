# Building the veemos-server-grails container
docker build -t robreri/veemos-server-grails .

# Running the veemos-server-grails container
docker build -t robreri/veemos-server-grails .

# Using REST API

## Listing divisions
curl -i -H "Accept: application/json" 192.168.99.100:8080/division

## List division with ID 1
curl -i -H "Accept: application/json" 192.168.99.100:8080/division/1

## Create a division with name SMART
curl -i -X POST -H "Content-Type: application/json" -d '{"name":"SMART"}' 192.168.99.100:8080/division

## Delete a division with ID 2
curl -i -X DELETE 192.168.99.100:8080/division/2