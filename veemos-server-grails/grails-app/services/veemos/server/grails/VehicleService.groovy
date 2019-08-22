package veemos.server.grails

import grails.gorm.services.Service

@Service(Vehicle)
interface VehicleService {

    Vehicle get(Serializable id)

    List<Vehicle> list(Map args)

    Long count()

    void delete(Serializable id)

    Vehicle save(Vehicle vehicle)

}