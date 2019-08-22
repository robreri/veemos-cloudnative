package veemos.server.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VehicleServiceSpec extends Specification {

    VehicleService vehicleService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Vehicle(...).save(flush: true, failOnError: true)
        //new Vehicle(...).save(flush: true, failOnError: true)
        //Vehicle vehicle = new Vehicle(...).save(flush: true, failOnError: true)
        //new Vehicle(...).save(flush: true, failOnError: true)
        //new Vehicle(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vehicle.id
    }

    void "test get"() {
        setupData()

        expect:
        vehicleService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Vehicle> vehicleList = vehicleService.list(max: 2, offset: 2)

        then:
        vehicleList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vehicleService.count() == 5
    }

    void "test delete"() {
        Long vehicleId = setupData()

        expect:
        vehicleService.count() == 5

        when:
        vehicleService.delete(vehicleId)
        sessionFactory.currentSession.flush()

        then:
        vehicleService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Vehicle vehicle = new Vehicle()
        vehicleService.save(vehicle)

        then:
        vehicle.id != null
    }
}
