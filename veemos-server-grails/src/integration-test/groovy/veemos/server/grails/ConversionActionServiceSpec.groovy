package veemos.server.grails

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ConversionActionServiceSpec extends Specification {

    ConversionActionService conversionActionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ConversionAction(...).save(flush: true, failOnError: true)
        //new ConversionAction(...).save(flush: true, failOnError: true)
        //ConversionAction conversionAction = new ConversionAction(...).save(flush: true, failOnError: true)
        //new ConversionAction(...).save(flush: true, failOnError: true)
        //new ConversionAction(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //conversionAction.id
    }

    void "test get"() {
        setupData()

        expect:
        conversionActionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ConversionAction> conversionActionList = conversionActionService.list(max: 2, offset: 2)

        then:
        conversionActionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        conversionActionService.count() == 5
    }

    void "test delete"() {
        Long conversionActionId = setupData()

        expect:
        conversionActionService.count() == 5

        when:
        conversionActionService.delete(conversionActionId)
        sessionFactory.currentSession.flush()

        then:
        conversionActionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ConversionAction conversionAction = new ConversionAction()
        conversionActionService.save(conversionAction)

        then:
        conversionAction.id != null
    }
}
