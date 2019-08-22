package veemos.server.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ModelRangeServiceSpec extends Specification {

    ModelRangeService modelRangeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ModelRange(...).save(flush: true, failOnError: true)
        //new ModelRange(...).save(flush: true, failOnError: true)
        //ModelRange modelRange = new ModelRange(...).save(flush: true, failOnError: true)
        //new ModelRange(...).save(flush: true, failOnError: true)
        //new ModelRange(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //modelRange.id
    }

    void "test get"() {
        setupData()

        expect:
        modelRangeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ModelRange> modelRangeList = modelRangeService.list(max: 2, offset: 2)

        then:
        modelRangeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        modelRangeService.count() == 5
    }

    void "test delete"() {
        Long modelRangeId = setupData()

        expect:
        modelRangeService.count() == 5

        when:
        modelRangeService.delete(modelRangeId)
        sessionFactory.currentSession.flush()

        then:
        modelRangeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ModelRange modelRange = new ModelRange()
        modelRangeService.save(modelRange)

        then:
        modelRange.id != null
    }
}
